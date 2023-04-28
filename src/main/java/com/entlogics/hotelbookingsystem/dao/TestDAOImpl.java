package com.entlogics.hotelbookingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Booking;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;

@Repository
//@Component
public class TestDAOImpl implements ITestDAO {

	// inject the session factory - field injection
	@Autowired
	private SessionFactory sessionFactory;

	// creating session variable of type Session for getting physical connection
	private Session session;

	// create logger object
	private static final Logger logger = LogManager.getLogger(TestDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllHotels() {
		logger.info("Inside TestDAO getAllHotels() in DAO");

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// this TypedQuery will give error of "Cannot create TypedQuery for query with
		// more than one return using requested result type"
//		Query<Hotel> theQuery = session.createQuery(
//				"select h.hotel_id, h.hotel_name, h.hotel_location, h.hotel_phone, h.hotel_rating, h.hotel_email, h.pet_friendly from Hotel h",
//				Hotel.class);

		// create UnTypedQuery for returning list of hotels
		Query theQuery = session.createQuery(
				"select h.hotel_id, h.hotel_name, h.hotel_location, h.hotel_phone, h.hotel_rating, h.hotel_email, h.pet_friendly from Hotel h");

		// creating list of arrays of Object and getting the result of query as a list
		List<Object[]> listHotel = (List<Object[]>) theQuery.getResultList();

		// create a query - TypedQuery
//		Query<Hotel> theQuery = session.createQuery("from Hotel", Hotel.class);

		// execute the query & get result list
//		List<Hotel> listHotel = theQuery.getResultList();

		logger.info("Inside TestDAO getAllHotels() in DAO :" + listHotel);

		// return the List
		return listHotel;
	}

	@Override
	public Hotel getHotelInformation(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerInformation(int hotelId, int customerId) {
		logger.info("Inside TestDAO getCustomerInformation(), hotel id: " + hotelId + " customer id: " + customerId);

		Customer customer;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting customer information
		customer = session.get(Customer.class, customerId);

		logger.info("Inside getCustomerInformation TestDAO, customer object: " + customer);

		// create a list of bookings and get list of bookings of a customer using
		// getBookings
		List<Booking> listBooking = customer.getBookings();

		// iterate over the list of bookings to lazy load the booking object
		for (Booking b : listBooking) {

			// print booking id using booking object
			logger.info("Inside TestDAO getCustomerInformation() Booking id: " + b.getBooking_id());

			// using b get bill id of the customer
			b.getBill().getBill_id();

			// print bill id
			logger.info("Inside TestDAO getCustomerInformation() Bill id: " + b.getBill().getBill_id());
		}

		// returning customer object
		return customer;
	}

	// return list of customers of a hotel
	@Override
	public List<Customer> getCustomersOfAHotel(int hotelId) {
		logger.info("Inside TestDAO getCustomersOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// creating typed query to get all distinct customer of a hotel
		Query<Customer> customerQuery = session.createQuery(
				"select distinct c from Customer c join c.hotels h where h.hotel.hotel_id=" + hotelId, Customer.class);

		// create list of Customer & get list of results from the Query object
		List<Customer> customerList = customerQuery.getResultList();

		logger.info("Inside TestDAO getCustomersOfAHotel() " + customerList);

		return customerList;
	}

	@Override
	public List<Employee> getEmployeesOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getRoomsOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceDTO> getServicesOfAHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookingDTO> getBookingsOfAHotel(int hotelId) {
		logger.info("Inside TestDAO getBookingsOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create List of type Booking
		List<Booking> bookingList = new ArrayList<>();

		// create query to get all bookings of a hotel - HQL
		bookingList = session.createQuery("from Booking b WHERE b.hotel.hotel_id=" + hotelId).getResultList();

		// create query to get all distinct bookings of a hotel - tried using HQL
//		Query<Booking> bookingQuery = session.createQuery(
//				"select distinct b.booking_id, b.booking_dateTime, b.booking_amt, b.check_in_DateTime, b.check_out_DateTime, b.no_of_adults, b.no_of_child,b.booking_status,h.hotel_id,c.customer_id,r.room_id,e.emp_id,bi.bill_id from Booking b JOIN b.hotel h JOIN b.customer c JOIN b.room r JOIN b.employee e JOIN b.bill bi WHERE h.hotel_id="
//						+ hotelId, Booking.class);
//		
//		List<Booking> bookingList = (List<Booking>)bookingQuery.getResultList();

		logger.info("Inside TestDAO getBookingsOfAHotel() booking: " + bookingList);

		// creating & initializing list of type BookingDTO
		List<BookingDTO> bookingDTO = new ArrayList<>();

		// iterating through booking list to get each booking object
		for (Booking book : bookingList) {

			// Creating object of booking dto
			BookingDTO bookingdto = new BookingDTO();

			// setting the booking properties
			bookingdto.setBooking_id(book.getBooking_id());
			bookingdto.setBooking_dateTime(book.getBooking_dateTime());
			bookingdto.setBooking_amt(book.getBooking_amt());
			bookingdto.setCheck_in_DateTime(book.getCheck_in_DateTime());
			bookingdto.setCheck_out_DateTime(book.getCheck_out_DateTime());
			bookingdto.setNo_of_adults(book.getNo_of_adults());
			bookingdto.setNo_of_child(book.getNo_of_child());
			bookingdto.setBooking_status(book.getBooking_status());
			bookingdto.setHotel_id(book.getHotel().getHotel_id());
			bookingdto.setCustomer_id(book.getCustomer().getCustomer_id());
			bookingdto.setRoom_id(book.getRoom().getRoom_id());
			bookingdto.setEmployee_id(book.getEmployee().getEmp_id());
			bookingdto.setBill_id(book.getBill().getBill_id());

			// tried HQL query to get service ids for bookings
			List<Integer> serviceQuery = session.createQuery(
					"select s.service_id from Booking bo JOIN bo.services bs JOIN bs.hotel_service hs JOIN hs.service s WHERE bo.booking_id="
							+ book.getBooking_id())
					.getResultList();

			// setting service id list in bookingdto object
			bookingdto.setServices(serviceQuery);

			logger.info("Inside TestDAO getBookingsOfAHotel() serviceQuery: " + serviceQuery);
//			logger.info("Inside TestDAO getBookingsOfAHotel() serviceQuery: " + serviceList);

			// adding bookingdto object to bookingDTO list
			bookingDTO.add(bookingdto);
		}

		logger.info("Inside TestDAO getBookingsOfAHotel() bookingdto: " + bookingDTO);
		logger.info("Inside TestDAO getBookingsOfAHotel() booking: " + bookingList);

		return bookingDTO;
	}

	@Override
	public Hotel testingTransaction(int hotelId) {
		logger.info("Inside TestDAO testingTransaction(): " + hotelId);

		// creating hotel (variable)
		Hotel hotel;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting hotel information
		hotel = session.get(Hotel.class, hotelId);
		
		// trying to write to db - when readOnly is true.. it will not save to DB
		hotel.setHotel_location("Mumbai");
		session.save(hotel);

		logger.info("Inside TestDAO testingTransaction(): " + hotel);
		
//		hotel.setHotel_name("ITC");

		// returning only hotel properties
		return hotel;
	}
}
