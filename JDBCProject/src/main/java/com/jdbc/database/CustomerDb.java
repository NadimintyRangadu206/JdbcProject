package com.jdbc.database;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.database.impls.VehicleImpl;

public class CustomerDb {

	public void db() {
		System.out.println("1:" + "checkIn()");
		System.out.println("2:" + "valetParkingList()");
		System.out.println("3:" + "searchForVehicle()");
		System.out.println("4:" + "checkOut()");
	}

	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int no = sc.nextInt();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerDb cb = new CustomerDb();

		VehicleImpl vi = new VehicleImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Case:");
		int cases = sc.nextInt();
		switch (cases) {

		case 1:

			
			
			cb.db();

			System.out.println("Enter method number ");
			int methodNo = sc.nextInt();
			switch (methodNo) {

			case 1:
				vi.checkIn();
				System.out.println("Enter a number");
				switch (sc.nextInt()) {
				case 1:
					cb.db();
					System.out.println("Again select the Method Number..");
					switch (sc.nextInt()) {
					case 1:
						vi.checkIn();
						break;
					case 2:
						vi.valetParkingList();
						break;
					case 3:
						vi.searchForVehicle();
						break;
					case 4:
						vi.checkOut();
						break;
					default:
						System.out.println("No matched Method Number...");
						break;
					}
					break;
				}

				break;
			case 2:
				vi.valetParkingList();
				System.out.println("Enter a number");
				switch (sc.nextInt()) {
				case 1:
					cb.db();
					System.out.println("Again select the Method Number..");
					switch (sc.nextInt()) {
					case 1:
						vi.checkIn();
						break;
					case 2:
						vi.valetParkingList();
						break;
					case 3:
						vi.searchForVehicle();
						break;
					case 4:
						vi.checkOut();
						break;
					default:
						System.out.println("No matched Method Number...");
						break;
					}

					break;
				}
				break;
			case 3:
				vi.searchForVehicle();
				System.out.println("Enter a number");
				switch (sc.nextInt()) {
				case 1:
					cb.db();
					System.out.println("Again select the Method Number..");
					switch (sc.nextInt()) {
					case 1:
						vi.checkIn();
						break;
					case 2:
						vi.valetParkingList();
						break;
					case 3:
						vi.searchForVehicle();
						break;
					case 4:
						vi.checkOut();
						break;
					default:
						System.out.println("No matched Method Number...");
						break;
					}

					break;
				}
				break;
			case 4:
				vi.checkOut();
				System.out.println("Enter a number");
				switch (sc.nextInt()) {
				case 1:
					cb.db();
					System.out.println("Again select the Method Number..");
					switch (sc.nextInt()) {
					case 1:
						vi.checkIn();
						break;
					case 2:
						vi.valetParkingList();
						break;
					case 3:
						vi.searchForVehicle();
						break;
					case 4:
						vi.checkOut();
						break;
					default:
						System.out.println("No matched Method Number...");
						break;
					}

					break;
				}
				break;
			default:
				System.out.println("MethodNo is Not Match!...");
			}
			break;
		default:
			System.out.println("No Cases are not found!....");

		}
	}

}