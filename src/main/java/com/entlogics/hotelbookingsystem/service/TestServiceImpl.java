package com.entlogics.hotelbookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entlogics.hotelbookingsystem.dao.ITestDAO;
import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerInformationDTO;
import com.entlogics.hotelbookingsystem.dto.EmployeeDTO;
import com.entlogics.hotelbookingsystem.dto.HotelDTO;
import com.entlogics.hotelbookingsystem.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem.dto.RoomDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Booking;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Hotel_Customer;
import com.entlogics.hotelbookingsystem.entity.Hotel_Service;
import com.entlogics.hotelbookingsystem.entity.Room;

@Service
public class TestServiceImpl implements ITestService {

	// create logger object
	private static final Logger logger = LogManager.getLogger(TestServiceImpl.class);

	// injecting Hotel DAO using field injection
	@Autowired
	private ITestDAO testDAO;

	@Override
	@Transactional(readOnly = true)
	public List<HotelDTO> getAllHotels() {
		// creating hotel list and returning hotelList from DAO
//		List<Hotel> hotelList = testDAO.getAllHotels();

		// getting Hotel object type in a list of object[]
		List<Object[]> hotelList = testDAO.getAllHotels();

		logger.info("Inside TestService getAllHotels() hotelList: " + hotelList);

		// creating hotel dto list
		List<HotelDTO> hotelDtoList = new ArrayList<>();

		// iterating through hotelList and extracting each object[]
		for (Object[] h : hotelList) {

			// creating object of HotelDTO
			HotelDTO hotelDto = new HotelDTO();
//			hoteldto.setHotel_id(h.getHotel_id());
//			hoteldto.setHotel_name(h.getHotel_name());
//			hoteldto.setHotel_location(h.getHotel_location());
//			hoteldto.setHotel_phone(h.getHotel_phone());
//			hoteldto.setHotel_rating(h.getHotel_rating());
//			hoteldto.setHotel_email(h.getHotel_email());
//			hoteldto.setPet_friendly(h.isPet_friendly());

			// setting the values of each h[] to hoteldto properties
			hotelDto.setHotel_id((int) h[0]);
			hotelDto.setHotel_name((String) h[1]);
			hotelDto.setHotel_location((String) h[2]);
			hotelDto.setHotel_phone((String) h[3]);
			hotelDto.setHotel_rating((int) h[4]);
			hotelDto.setHotel_email((String) h[5]);
			hotelDto.setPet_friendly((boolean) h[6]);

			// adding hotelDto object to Hotel DTO list
			hotelDtoList.add(hotelDto);
		}
		logger.info("Inside TestService getAllHotels() hotelDtoList: " + hotelDtoList);

		// returning hotelDtoList
		return hotelDtoList;
	}

	@Override
	public HotelInformationDTO getHotelInformation(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel getOneHotelInfo(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerInformationDTO getCustomerInformation(int hotelId, int customerId) {
		logger.info("Inside TestService getCustomerInformation()");

		// creating customer object & getting a single customer info
		Customer customer = testDAO.getCustomerInformation(hotelId, customerId);

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
		List<Integer> bookingIds = new ArrayList<>();

		for (Booking b : customer.getBookings()) {
			bookingIds.add(b.getBooking_id());
		}

		// creating list of Integer for bill ids & iterating through getBookings to add
		// Id to the list
		List<Integer> billIds = new ArrayList<>();

		for (Booking b : customer.getBookings()) {
			billIds.add(b.getBill().getBill_id());
		}

		// setting list of integer (IDs) for each setter respectively - Bookings & Bills
		customerInfoDTO.setBookings(bookingIds);
		customerInfoDTO.setBills(billIds);

		logger.info("Inside TestService getCustomerInformation() customerInfoDTO: " + customerInfoDTO);

		return customerInfoDTO;
	}

	// test service method that will create transaction & set customer values in
	// customer dto & return list of customers
	@Override
	@Transactional
	public List<CustomerDTO> getCustomersOfAHotel(int hotelId) {
		logger.info("Inside Test Service getCustomersOfAHotel()");

		// creating list of type customer & getting customer details from DAO
		List<Customer> customer = testDAO.getCustomersOfAHotel(hotelId);

		// creating list of type customer DTO
		List<CustomerDTO> customerDTO = new ArrayList<>();

		// iterating through list of customers & setting properties of customer in
		// customer dto
		for (Customer c : customer) {
			// creating Object of CustomerDTO
			CustomerDTO customerdto = new CustomerDTO();

			// setting values of customerdto properties
			customerdto.setCustomer_id(c.getCustomer_id());
			customerdto.setCustomer_name(c.getCustomer_name());
			customerdto.setCustomer_address(c.getCustomer_address());
			customerdto.setCustomer_phone(c.getCustomer_phone());
			customerdto.setCustomer_email(c.getCustomer_email());
			customerdto.setPreferences(c.getPreferences());
			customerdto.setSpecial_needs(c.getSpecial_needs());

			// adding customerdto obj to customerDTO list
			customerDTO.add(customerdto);
		}
		logger.info("Inside Test Service getCustomersOfAHotel() customerDTO: " + customerDTO);
		return customerDTO;
	}

	@Override
	public List<EmployeeDTO> getEmployeesOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceDTO> getServicesOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomDTO> getRoomsOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	// test service method that will create transaction & return dao
	// getBookingsOfAHotel
	@Override
	@Transactional
	public List<BookingDTO> getBookingsOfAHotel(int hotelId) {
		logger.info("Inside Test Service getBookingsOfAHotel()");

		return testDAO.getBookingsOfAHotel(hotelId);
	}

	@Override
//	@Transactional(readOnly = true)
	@Transactional
	public HotelInformationDTO testingTransaction(int hotelId) {

		logger.info("Inside Test Service testingTransaction()");

		// creating hotel object & getting a single hotel
		Hotel hotel = testDAO.testingTransaction(hotelId);

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
		List<Integer> roomIds = new ArrayList<>();

		for (Room r : hotel.getRooms()) {
			roomIds.add(r.getRoom_id());
		}

		// creating list of Integer for emp ids & iterating through getEmployees to add
		// Id to the list
		List<Integer> empIds = new ArrayList<>();

		for (Employee e : hotel.getEmployees()) {
			empIds.add(e.getEmp_id());
		}

		// creating list of Integer for customer ids & iterating through getCustomers to
		// add Id to the list
		List<Integer> customerIds = new ArrayList<>();
		for (Hotel_Customer c : hotel.getCustomers()) {
			customerIds.add(c.getCustomer().getCustomer_id());
		}

		// creating list of Integer for booking ids & iterating through getBookings to
		// add Id to the list
		List<Integer> bookingIds = new ArrayList<>();
		for (Booking b : hotel.getBookings()) {
			bookingIds.add(b.getBooking_id());
		}

		// creating list of Integer for service ids & iterating through getServices to
		// add Id to the list
		List<Integer> serviceIds = new ArrayList<>();
		for (Hotel_Service s : hotel.getServices()) {
			serviceIds.add(s.getService().getService_id());
		}

		// setting list of integer (IDs) for each setter respectively - Rooms,
		// Employees, Customers, Bookings, Service
		hotelInfoDTO.setRooms(roomIds);
		hotelInfoDTO.setEmployees(empIds);
		hotelInfoDTO.setCustomers(customerIds);
		hotelInfoDTO.setBookings(bookingIds);
		hotelInfoDTO.setServices(serviceIds);

		logger.info("Inside Test Service testingTransaction() hotelInfoDTO: " + hotelInfoDTO);

		return hotelInfoDTO;
	}

}
