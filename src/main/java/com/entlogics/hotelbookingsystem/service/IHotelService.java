package com.entlogics.hotelbookingsystem.service;

import java.util.List;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerInformationDTO;
import com.entlogics.hotelbookingsystem.dto.EmployeeDTO;
import com.entlogics.hotelbookingsystem.dto.HotelDTO;
import com.entlogics.hotelbookingsystem.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem.dto.LinkServiceDTO;
import com.entlogics.hotelbookingsystem.dto.RoomDTO;
import com.entlogics.hotelbookingsystem.dto.RoomInformationDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;

//interface for Hotel Service layer having method declaration for all hotel api endpoints
public interface IHotelService {

	public List<HotelDTO> getAllHotels(Boolean isSearch, String hotel_name);

	public boolean addNewHotel(Hotel h);

	public HotelInformationDTO getHotelInformation(int hotelId);

	public boolean deleteAHotel(int hotelId);

	public boolean editAHotel(int hotelId, Hotel h);
	
	public Hotel getOneHotelInfo(int hotelId);
	
	public CustomerInformationDTO getCustomerInformation(int hotelId, int customerId);
	
	public List<CustomerDTO> getCustomersOfAHotel(int hotelId);
	
	public List<EmployeeDTO> getEmployeesOfAHotel(int hotelId);
	
	public List<ServiceDTO> getServicesOfAHotel(int hotelId);
	
	public List<RoomDTO> getRoomsOfAHotel(int hotelId);
	
	public List<BookingDTO> getBookingsOfAHotel(int hotelId);
	
	public RoomInformationDTO getRoomInformation(int hotelId, int roomId);
	
	public boolean addNewRoomToAHotel(int hotelId,Room r);
	
	public boolean editARoomOfAHotel(int hotelId,int roomId, Room r);
	
	public boolean deleteARoomOfAHotel(int hotelId,int roomId);
	
	public boolean linkCustomerToAHotel(int hotelId, Customer c);
	
	public boolean linkServicesToAHotel(int hotelId, LinkServiceDTO s);
	
	public HotelInformationDTO getOneHotelInfoJpa(int hotelId);
}
