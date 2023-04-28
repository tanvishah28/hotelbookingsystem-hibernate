package com.entlogics.hotelbookingsystem.dao;

import java.util.List;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;

public interface ITestDAO {

	public List<Object[]> getAllHotels();

	public Hotel getHotelInformation(int hotelId);

	public Customer getCustomerInformation(int hotelId, int customerId);

	public List<Customer> getCustomersOfAHotel(int hotelId);

	public List<Employee> getEmployeesOfAHotel(int hotelId);

	public List<Room> getRoomsOfAHotel(int hotelId);

	public List<ServiceDTO> getServicesOfAHotel(int hotelId);

	public List<BookingDTO> getBookingsOfAHotel(int hotelId);

	public Hotel testingTransaction(int hotelId);
}
