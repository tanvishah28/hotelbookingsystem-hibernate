package com.entlogics.hotelbookingsystem.service;

import java.util.List;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerInformationDTO;
import com.entlogics.hotelbookingsystem.dto.EmployeeDTO;
import com.entlogics.hotelbookingsystem.dto.HotelDTO;
import com.entlogics.hotelbookingsystem.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem.dto.RoomDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Hotel;

public interface ITestService {

	public List<HotelDTO> getAllHotels();

	public HotelInformationDTO getHotelInformation(int hotelId);

	public Hotel getOneHotelInfo(int hotelId);

	public CustomerInformationDTO getCustomerInformation(int hotelId, int customerId);

	public List<CustomerDTO> getCustomersOfAHotel(int hotelId);

	public List<EmployeeDTO> getEmployeesOfAHotel(int hotelId);

	public List<ServiceDTO> getServicesOfAHotel(int hotelId);

	public List<RoomDTO> getRoomsOfAHotel(int hotelId);

	public List<BookingDTO> getBookingsOfAHotel(int hotelId);
	
	public HotelInformationDTO testingTransaction(int hotelId);
}
