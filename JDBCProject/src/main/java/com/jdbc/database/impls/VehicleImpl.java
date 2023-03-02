package com.jdbc.database.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

import com.jdbc.database.table.VehicleInfo;
import com.mysql.cj.jdbc.DatabaseMetaData;

public class VehicleImpl implements VehicleFunc {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void checkIn() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String userName = "root";
			String password = "1234";
			String url = "jdbc:mysql://Localhost:3306/my";
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("DataBase Connection is Stablished...");

			java.sql.DatabaseMetaData dmd = conn.getMetaData(); // which is using, when the table is exit or not
			ResultSet rs = dmd.getTables(null, null, "VehicleInfo", null);

			if (rs.next()) {
				System.out.println("Table is exist!...");
			} else {
				String cQuery = "create table VehicleInfo (vehicleNo int primary key,vehicleType varchar(255) not null,"
						+ " vechicleModel varchar(255) not null,phoneNo varchar(255) unique, customerName varchar(255),"
						+ "time Time unique)";

				stmt = conn.createStatement();
				stmt.execute(cQuery);
				System.out.println("Table is Created Successfully....");
			}

			String insertQuery = "insert into VehicleInfo values(?,?,?,?,?,?)";

			ps = conn.prepareStatement(insertQuery);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter row limit");
			int setRowLimit = sc.nextInt();

			for (int i = 1; i <= setRowLimit; i++) {
				System.out.println("Enter VehicleNo");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter VehicleType");
				ps.setString(2, sc.next());
				System.out.println("Enter VehicleModel");
				ps.setString(3, sc.next());
				System.out.println("Enter PhoneNo");
				ps.setString(4, sc.next());
				System.out.println("Enter CustomerName");
				ps.setString(5, sc.next());
				System.out.println("Enter time");
				ps.setTime(6, new Time((int) sc.nextLong()));
				ps.executeUpdate();
			}
			System.out.println("Values are Inserted Successfully...");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}

		}
	}

	public void valetParkingList() throws ClassNotFoundException

	{

		System.out.println("Retrieving data from DataBase");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String userName = "root";
			String password = "1234";
			String url = "jdbc:mysql://Localhost:3306/my";
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("DataBase Connection is Stablished...");
			System.out.println("DataBase Table Format:");
			String sQuery = "Select * from VehicleInfo";
			ps = conn.prepareStatement(sQuery);
			rs = ps.executeQuery();
			System.out.println("VNo" + "\t" + "VType" + "\t" + "VModel" + "\t" + "PhoneNum" + "\t" + "CustName" + "\t"
					+ "Time" + "\t");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}

		}
	}

	public void searchForVehicle() throws ClassNotFoundException, SQLException {

		String searchQuery = "Select * from VehicleInfo where vehicleNo=?;";
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my", "root", "1234");
				PreparedStatement ps = conn.prepareStatement(searchQuery);

				Scanner sc = new Scanner(System.in);) {

			System.out.println("Enter a VehicleNO:");

			ps.setInt(1, sc.nextInt());
			ResultSet rs = ps.executeQuery();
			System.out.println("VNo" + "\t" + "VType" + "\t" + "VModel" + "\t" + "PhoneNum" + "\t" + "CustName" + "\t"
					+ "Time" + "\t");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
		}

	}

	public void checkOut() {

	}

	

}
