package com.entlogics.hotelbookingsystem.dao;

import java.util.List;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem.dto.LinkServiceDTO;
import com.entlogics.hotelbookingsystem.dto.RoomInformationDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;

// interface for Hotel DAO having method declaration for all hotel api endpoints
public interface IHotelDAO {

	public List<Object[]> getAllHotels(Boolean isSearch, String hotel_name);

	public boolean addNewHotel(Hotel h);
	
	public boolean editAHotel(int hotelId, Hotel h);

	public boolean deleteAHotel(int hotelId);
	
	public Hotel getHotelInformation(int hotelId);

	public Hotel getOneHotelInfo(int hotelId);

	public Customer getCustomerInformation(int hotelId, int customerId);

	public List<Customer> getCustomersOfAHotel(int hotelId);

	public List<Employee> getEmployeesOfAHotel(int hotelId);

	public List<Room> getRoomsOfAHotel(int hotelId);

	public List<ServiceDTO> getServicesOfAHotel(int hotelId);

	public List<BookingDTO> getBookingsOfAHotel(int hotelId);

	public RoomInformationDTO getRoomInformation(int hotelId, int roomId);

	public boolean addNewRoomToAHotel(int hotelId,Room r);

	public boolean editARoomOfAHotel(int hotelId, int roomId, Room r);

	public boolean deleteARoomOfAHotel(int hotelId, int roomId);
	
	public boolean linkCustomerToAHotel(int hotelId, Customer c);
	
	public boolean linkServicesToAHotel(int hotelId, LinkServiceDTO s);

	public Hotel getOneHotelInfoJpa(int hotelId);
}
