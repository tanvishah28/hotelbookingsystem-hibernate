package com.entlogics.hotelbookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entlogics.hotelbookingsystem.dao.IHotelDAO;
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
import com.entlogics.hotelbookingsystem.entity.Booking;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Hotel_Customer;
import com.entlogics.hotelbookingsystem.entity.Hotel_Service;
import com.entlogics.hotelbookingsystem.entity.Room;

// this class implements Hotel Service Interface & has implementation for all hotel api endpoints

@Service
public class HotelServiceImpl implements IHotelService {

	// create logger object
	private static final Logger logger = LogManager.getLogger(HotelServiceImpl.class);

	// injecting Hotel DAO using field injection
	@Autowired
	private IHotelDAO hotelDAO;

	// this method will create transaction & return list of hotels method to DAO
	@Override
	@Transactional
	public List<HotelDTO> getAllHotels(Boolean isSearch, String hotel_name) {

		List<Object[]> hotelList = hotelDAO.getAllHotels(isSearch, hotel_name);
		List<HotelDTO> hotelDtoList = new ArrayList<>();

		for (Object[] h : hotelList) {
			HotelDTO hotelDto = new HotelDTO();

			// setting the values of each h[] to hoteldto properties
			hotelDto.setHotel_id((int) h[0]);
			hotelDto.setHotel_name((String) h[1]);
			hotelDto.setHotel_location((String) h[2]);
			hotelDto.setHotel_phone((String) h[3]);
			hotelDto.setHotel_rating((int) h[4]);
			hotelDto.setHotel_email((String) h[5]);
			hotelDto.setPet_friendly((boolean) h[6]);

			hotelDtoList.add(hotelDto);
		}
		return hotelDtoList;
	}

	// this method will create transaction & return addNewHotel method to DAO
	@Override
	@Transactional
	public boolean addNewHotel(Hotel h) {

		logger.info("Inside Hotel Service addNewHotel()");

		return hotelDAO.addNewHotel(h);
	}

	// this method will create transaction & return getHotelInformation method to
	// DAO
	@Override
	@Transactional
	public HotelInformationDTO getHotelInformation(int hotelId) {

		logger.info("Inside Hotel Service getHotelInformation()");

		// creating hotel object & getting a single hotel
		Hotel hotel = hotelDAO.getHotelInformation(hotelId);

		// Creating object of hotel information dto
		HotelInformationDTO hotelInfoDTO = new HotelInformationDTO();

		// setting the Hotel properties
		hotelInfoDTO.setHotel_id(hotel.getHotel_id());
		hotelInfoDTO.setHotel_name(hotel.getHotel_name());
		hotelInfoDTO.setHotel_location(hotel.getHotel_location());
		hotelInfoDTO.setHotel_phone(hotel.getHotel_phone());
		hotelInfoDTO.setHotel_rating(hotel.getHotel_rating());
		hotelInfoDTO.setHotel_email(hotel.getHotel_email());
		hotelInfoDTO.setPet_friendly(hotel.isPet_friendly());

		// creating list of Integer for room ids & iterating through getRooms to add Id
		// to the list
		List<Integer> roomIdsList = new ArrayList<>();

		for (Room r : hotel.getRooms()) {
			roomIdsList.add(r.getRoom_id());
		}

		// creating list of Integer for emp ids & iterating through getEmployees to add
		// Id to the list
		List<Integer> empIdsList = new ArrayList<>();

		for (Employee e : hotel.getEmployees()) {
			empIdsList.add(e.getEmp_id());
		}

		// creating list of Integer for customer ids & iterating through getCustomers to
		// add Id to the list
		List<Integer> customerIdsList = new ArrayList<>();
		for (Hotel_Customer c : hotel.getCustomers()) {
			customerIdsList.add(c.getCustomer().getCustomer_id());
		}

		// creating list of Integer for booking ids & iterating through getBookings to
		// add Id to the list
		List<Integer> bookingIdsList = new ArrayList<>();
		for (Booking b : hotel.getBookings()) {
			bookingIdsList.add(b.getBooking_id());
		}

		// creating list of Integer for service ids & iterating through getServices to
		// add Id to the list
		List<Integer> serviceIdsList = new ArrayList<>();
		for (Hotel_Service s : hotel.getServices()) {
			serviceIdsList.add(s.getService().getService_id());
		}

		// setting list of integer (IDs) for each setter respectively - Rooms,
		// Employees, Customers, Bookings, Service
		hotelInfoDTO.setRooms(roomIdsList);
		hotelInfoDTO.setEmployees(empIdsList);
		hotelInfoDTO.setCustomers(customerIdsList);
		hotelInfoDTO.setBookings(bookingIdsList);
		hotelInfoDTO.setServices(serviceIdsList);

		logger.info("Inside Hotel Service getHotelInformation() hotelInfoDTO: " + hotelInfoDTO);

		// returning hotelInformationDTO object
		return hotelInfoDTO;
	}

	// this method will create transaction & return deleteAHotel method to DAO
	@Override
	@Transactional
	public boolean deleteAHotel(int hotelId) {

		logger.info("Inside Hotel Service deleteAHotel()");

		return hotelDAO.deleteAHotel(hotelId);
	}

	// this method will create transaction & return edit hotel method to DAO
	@Override
	@Transactional
	public boolean editAHotel(int hotelId, Hotel h) {

		logger.info("Inside Hotel Service editAHotel()");

		return hotelDAO.editAHotel(hotelId, h);
	}

	// this method will create transaction & return One hotel method to DAO
	@Override
	@Transactional
	public Hotel getOneHotelInfo(int hotelId) {

		logger.info("Inside Hotel Service getOneHotelInfo()");

		return hotelDAO.getOneHotelInfo(hotelId);
	}

	// this method will create transaction & return one customer of a hotel method
	// to DAO
	@Override
	@Transactional
	public CustomerInformationDTO getCustomerInformation(int hotelId, int customerId) {

		logger.info("Inside Hotel Service getCustomerInformation()");

		// creating customer object & getting a single customer info
		Customer customer = hotelDAO.getCustomerInformation(hotelId, customerId);

		// Creating object of customer information dto
		CustomerInformationDTO customerInfoDTO = new CustomerInformationDTO();

		// setting the customer properties
		customerInfoDTO.setCustomer_id(customer.getCustomer_id());
		customerInfoDTO.setCustomer_name(customer.getCustomer_name());
		customerInfoDTO.setCustomer_address(customer.getCustomer_address());
		customerInfoDTO.setCustomer_phone(customer.getCustomer_phone());
		customerInfoDTO.setCustomer_email(customer.getCustomer_email());
		customerInfoDTO.setPreferences(customer.getPreferences());
		customerInfoDTO.setSpecial_needs(customer.getSpecial_needs());

		// creating list of Integer for booking ids & iterating through getBookings to
		// add Id to the list
		List<Integer> bookingIdsList = new ArrayList<>();

		for (Booking b : customer.getBookings()) {
			bookingIdsList.add(b.getBooking_id());
		}

		// creating list of Integer for bill ids & iterating through getBookings to add
		// Id to the list
		List<Integer> billIdsList = new ArrayList<>();

		for (Booking b : customer.getBookings()) {
			billIdsList.add(b.getBill().getBill_id());
		}

		// setting list of integer (IDs) for each setter respectively - Bookings & Bills
		customerInfoDTO.setBookings(bookingIdsList);
		customerInfoDTO.setBills(billIdsList);

		logger.info("Inside Hotel Service getCustomerInformation() customerInfoDTO: " + customerInfoDTO);

		return customerInfoDTO;
	}

	// this method will create transaction & return list of customers of a hotel
	// method to DAO
	@Override
	@Transactional
	public List<CustomerDTO> getCustomersOfAHotel(int hotelId) {

		logger.info("Inside Hotel Service getCustomersOfAHotel()");

		// creating list of type customer & getting customer details from DAO
		List<Customer> customerList = hotelDAO.getCustomersOfAHotel(hotelId);

		// creating list of type customer DTO
		List<CustomerDTO> customerDTOList = new ArrayList<>();

		// iterating through list of customers & setting properties of customer in
		// customer dto
		for (Customer c : customerList) {
			// creating Object of CustomerDTO
			CustomerDTO customerDto = new CustomerDTO();

			// setting values of customerdto properties
			customerDto.setCustomer_id(c.getCustomer_id());
			customerDto.setCustomer_name(c.getCustomer_name());
			customerDto.setCustomer_address(c.getCustomer_address());
			customerDto.setCustomer_phone(c.getCustomer_phone());
			customerDto.setCustomer_email(c.getCustomer_email());
			customerDto.setPreferences(c.getPreferences());
			customerDto.setSpecial_needs(c.getSpecial_needs());

			// adding customerdto obj to customerDTO list
			customerDTOList.add(customerDto);
		}
		logger.info("Inside Hotel Service getCustomersOfAHotel() customerDTO: " + customerDTOList);
		return customerDTOList;
	}

	// this method will create transaction & return list of employees of a hotel
	@Override
	@Transactional
	public List<EmployeeDTO> getEmployeesOfAHotel(int hotelId) {

		logger.info("Inside Hotel Service getEmployeesOfAHotel()");

		// creating list of type employee & getting employee details from DAO
		List<Employee> employee = hotelDAO.getEmployeesOfAHotel(hotelId);

		// creating list of type employee DTO
		List<EmployeeDTO> employeeDTO = new ArrayList<>();

		// iterating through list of employees & setting properties of employee in
		// employee dto
		for (Employee e : employee) {

			// creating Object of EmployeeDTO
			EmployeeDTO employeedto = new EmployeeDTO();

			// Setting values of employeedto properties
			employeedto.setEmp_id(e.getEmp_id());
			employeedto.setEmp_name(e.getEmp_name());
			employeedto.setEmp_salary(e.getEmp_salary());
			employeedto.setEmp_phone(e.getEmp_phone());
			employeedto.setEmp_address(e.getEmp_address());
			employeedto.setEmp_email(e.getEmp_email());
			employeedto.setJoining_date(e.getJoining_date());

			// adding employeedto obj to employeeDTO list
			employeeDTO.add(employeedto);
		}

		logger.info("Inside Hotel Service getEmployeesOfAHotel() employeeDTO: " + employeeDTO);
		return employeeDTO;
	}

	// this method will create transaction & return list of rooms of a hotel
	@Override
	@Transactional
	public List<RoomDTO> getRoomsOfAHotel(int hotelId) {

		logger.info("Inside Hotel Service getRoomsOfAHotel()");

		// creating list of type room & getting room details from DAO
		List<Room> room = hotelDAO.getRoomsOfAHotel(hotelId);

		// creating list of type room DTO
		List<RoomDTO> roomDTO = new ArrayList<>();

		// iterating through list of rooms & setting properties of room in room dto
		for (Room r : room) {

			// creating Object of RoomDTO
			RoomDTO roomdto = new RoomDTO();

			// Setting values of roomdto properties
			roomdto.setRoom_id(r.getRoom_id());
			roomdto.setRoom_type(r.getRoom_type());
			roomdto.setRoom_price(r.getRoom_price());
			roomdto.setRoom_no(r.getRoom_no());
			roomdto.setFloor_no(r.getFloor_no());
			roomdto.setArea_of_room(r.getArea_of_room());
			roomdto.setOccupancy_details(r.getOccupancy_details());

			// adding roomdto obj to roomDTO list
			roomDTO.add(roomdto);
		}

		logger.info("Inside Hotel Service getRoomsOfAHotel() roomDTO: " + roomDTO);
		return roomDTO;
	}

	// this method will create transaction & return list of bookings of a hotel
	@Override
	@Transactional
	public List<BookingDTO> getBookingsOfAHotel(int hotelId) {

		logger.info("Inside Hotel Service getBookingsOfAHotel()");

		return hotelDAO.getBookingsOfAHotel(hotelId);
	}

	// this method will create transaction & return list of services of a hotel
	@Override
	@Transactional
	public List<ServiceDTO> getServicesOfAHotel(int hotelId) {

		logger.info("Inside Hotel Service getServicesOfAHotel()");

		return hotelDAO.getServicesOfAHotel(hotelId);
	}

	// this method will create transaction & return a room of a hotel
	@Override
	@Transactional
	public RoomInformationDTO getRoomInformation(int hotelId, int roomId) {
		logger.info("Inside Hotel Service getRoomInformation()");

		return hotelDAO.getRoomInformation(hotelId, roomId);
	}

	// this method will create transaction & add a new room to a hotel
	@Override
	@Transactional
	public boolean addNewRoomToAHotel(int hotelId, Room r) {
		logger.info("Inside Hotel Service addNewRoomToOneHotel()");

		return hotelDAO.addNewRoomToAHotel(hotelId, r);
	}

	// this method will create transaction & edit a room of a hotel
	@Override
	@Transactional
	public boolean editARoomOfAHotel(int hotelId, int roomId, Room r) {
		logger.info("Inside Hotel Service editRoomOfOneHotel(), room object: " + r);

		return hotelDAO.editARoomOfAHotel(hotelId, roomId, r);
	}

	// this method will create transaction & delete a room of a hotel
	@Override
	@Transactional
	public boolean deleteARoomOfAHotel(int hotelId, int roomId) {
		logger.info("Inside Hotel Service deleteRoomOfOneHotel()");

		return hotelDAO.deleteARoomOfAHotel(hotelId, roomId);
	}

	// this method will create transaction & link customer to hotel
	@Override
	@Transactional
	public boolean linkCustomerToAHotel(int hotelId, Customer c) {

		logger.info("Inside Hotel Service linkCustomerToAHotel()");

		return hotelDAO.linkCustomerToAHotel(hotelId, c);
	}

	// this method will create transaction & link services to hotel
	@Override
	@Transactional
	public boolean linkServicesToAHotel(int hotelId, LinkServiceDTO s) {

		logger.info("Inside Hotel Service linkServicesToAHotel()");

		return hotelDAO.linkServicesToAHotel(hotelId, s);
	}

	// this is a JPA service method to get one hotel information
	@Override
	@Transactional
	public HotelInformationDTO getOneHotelInfoJpa(int hotelId) {
		
		logger.info("Inside Hotel Service getOneHotelInfoJpa()");

		// creating hotel object & getting a single hotel
		Hotel hotel = hotelDAO.getOneHotelInfoJpa(hotelId);

		// Creating object of hotel information dto
		HotelInformationDTO hotelInfoDTO = new HotelInformationDTO();

		// setting the Hotel properties
		hotelInfoDTO.setHotel_id(hotel.getHotel_id());
		hotelInfoDTO.setHotel_name(hotel.getHotel_name());
		hotelInfoDTO.setHotel_location(hotel.getHotel_location());
		hotelInfoDTO.setHotel_phone(hotel.getHotel_phone());
		hotelInfoDTO.setHotel_rating(hotel.getHotel_rating());
		hotelInfoDTO.setHotel_email(hotel.getHotel_email());
		hotelInfoDTO.setPet_friendly(hotel.isPet_friendly());

		// creating list of Integer for room ids & iterating through getRooms to add Id
		// to the list
		List<Integer> roomIdsList = new ArrayList<>();

		for (Room r : hotel.getRooms()) {
			roomIdsList.add(r.getRoom_id());
		}

		// creating list of Integer for emp ids & iterating through getEmployees to add
		// Id to the list
		List<Integer> empIdsList = new ArrayList<>();

		for (Employee e : hotel.getEmployees()) {
			empIdsList.add(e.getEmp_id());
		}

		// creating list of Integer for customer ids & iterating through getCustomers to
		// add Id to the list
		List<Integer> customerIdsList = new ArrayList<>();
		for (Hotel_Customer c : hotel.getCustomers()) {
			customerIdsList.add(c.getCustomer().getCustomer_id());
		}

		// creating list of Integer for booking ids & iterating through getBookings to
		// add Id to the list
		List<Integer> bookingIdsList = new ArrayList<>();
		for (Booking b : hotel.getBookings()) {
			bookingIdsList.add(b.getBooking_id());
		}

		// creating list of Integer for service ids & iterating through getServices to
		// add Id to the list
		List<Integer> serviceIdsList = new ArrayList<>();
		for (Hotel_Service s : hotel.getServices()) {
			serviceIdsList.add(s.getService().getService_id());
		}

		// setting list of integer (IDs) for each setter respectively - Rooms,
		// Employees, Customers, Bookings, Service
		hotelInfoDTO.setRooms(roomIdsList);
		hotelInfoDTO.setEmployees(empIdsList);
		hotelInfoDTO.setCustomers(customerIdsList);
		hotelInfoDTO.setBookings(bookingIdsList);
		hotelInfoDTO.setServices(serviceIdsList);

		logger.info("Inside Hotel Service getOneHotelInfoJpa() hotelInfoDTO: " + hotelInfoDTO);

		// returning hotelInformationDTO object
		return hotelInfoDTO;
	}
}
