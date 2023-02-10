package com.jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Scanner;

import com.jdbc.database.impls.VehicleImpl;

class Customer implements VehicleImpl {

	public void checkIn() {

	}

	public void valetParkingList() {

	}

	public void searchForVehicle() {

	}

	public void checkOut() {

	}

}

public class CustomerDb {

	public static void main(String[] args) throws ClassNotFoundException {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String userName = "root";
			String password = "1234";
			String url = "jdbc:mysql://Localhost:3306/my";
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("DataBase Connection Established Succesfully...");

			stmt = conn.createStatement();
			// String cQuery = "create table VehicleInfo (Id int primary key,vehicleNo int
			// unique, "
			// + "vehicleType varchar(255) not null,vehicleModel varchar(255) not null,"
			// + "phoneNo varchar(255) unique,customerName varchar(255) not null, time
			// Time)";
			//
			// stmt.execute(cQuery);
			// System.out.println("Table is Created Successfully...");

			String insertQuery = "insert into VehicleInfo values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(insertQuery);
			//
			 Scanner sc = new Scanner(System.in);
			// System.out.println("Enter row limit");
			// int setRowLimit = sc.nextInt();
			// for (int i = 1; i <= setRowLimit; i++) {
			// System.out.println("Enter Id");
			// ps.setInt(1, sc.nextInt());
			// System.out.println("Enter VehicleNo");
			// ps.setInt(2, sc.nextInt());
			// System.out.println("Enter VehicleType");
			// ps.setString(3, sc.next());
			// System.out.println("Enter VehicleModel");
			// ps.setString(4, sc.next());
			// System.out.println("Enter PhoneNo");
			// ps.setString(5, sc.next());
			// System.out.println("Enter CustomerNo");
			// ps.setString(6, sc.next());
			// System.out.println("Enter time");
			// ps.setTime(7, new Time((int) sc.nextLong()));
			// ps.executeUpdate();
			// }
			// System.out.println("Values are Inserted Successfully...");

			System.out.println("DataBase Table Format:");
			String sQuery = "Select * from VehicleInfo";
			rs = ps.executeQuery(sQuery);
			System.out.println("Id"+"\t"+"VNo"+"\t"+"VType"+"\t"+"VModel"+"\t"+"PhoneNum"+"\t"+"CustName"+"\t"+"Time"+"\t");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));

			}
			
			String bVno="Select * from VehicleInfo where VehicleNo =?";
		
			System.out.println("Enter VehicleNo:");
		
			rs=ps.executeQuery(bVno);

			System.out.println(rs.getInt(0));

		} catch (SQLException e) {

			System.out.println(e.getSQLState());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					System.out.println(e2.getSQLState());
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e3) {
					System.out.println(e3.getSQLState());
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(e.getSQLState());
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getSQLState());
				}
			}
		}

	}

}
