package com.jdbc.database.impls;

import java.sql.SQLException;

public interface VehicleFunc {

	public void checkIn() throws ClassNotFoundException, SQLException;

	public void valetParkingList() throws ClassNotFoundException;

	public void searchForVehicle() throws ClassNotFoundException, SQLException;

	public void checkOut();
}
