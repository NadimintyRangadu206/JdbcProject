package com.jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

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
			String cQuery = "create table VehicleInfo (Id int primary key,vehicleNo int unique, "
					+ "vehicleType varchar(255) not null,vehicleModel varchar(255) not null,"
					+ "phoneNo varchar(255) unique,customerName varchar(255) not null, time Time)";

			stmt.execute(cQuery);
			System.out.println("Table is Created Successfully...");
			
			String insertQuery="insert into VehicleInfo values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(insertQuery);
		
				ps.setInt(1,2);
				ps.setInt(2,202);
				ps.setString(3, "car");
				ps.setString(4, "c20");
				ps.setString(5, "77686765655");
				ps.setString(6, "tomy");
				ps.setTimestamp(7, new Timestamp(23124L));
			
			
			ps.executeUpdate();
			
			System.out.println("Values are Inserted Successfully...");
			
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
		}

	}

}
