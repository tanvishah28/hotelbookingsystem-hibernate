package com.entlogics.hotelbookingsystem.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.LinkServiceDTO;
import com.entlogics.hotelbookingsystem.dto.RoomInformationDTO;
import com.entlogics.hotelbookingsystem.dto.ServiceDTO;
import com.entlogics.hotelbookingsystem.entity.Booking;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;
import com.entlogics.hotelbookingsystem.entity.Service;

// this class implements the HotelDAO interface & has the implementation methods of all hotel api endpoints

@Repository
public class HotelDAOImpl implements IHotelDAO {

	// inject the session factory - field injection
	@Autowired
	private SessionFactory sessionFactory;

	// injecting EntityManager
	@PersistenceContext
//	@Autowired
	private EntityManager entityManager;

	// creating session variable of type Session for getting physical connection
	private Session session;

	// create logger object
	private static final Logger logger = LogManager.getLogger(HotelDAOImpl.class);

	// returns a list of Hotel objects from DB
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllHotels(Boolean isSearch, String hotel_name) {

		logger.info("Inside getAllHotels() in DAO");

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// Creating a list of type hotel
		// List<Hotel> listHotel = new ArrayList<>();

		// creating list of arrays of Object and getting the result of query as a list
		List<Object[]> listHotel = new ArrayList<>();

		// checking if isSearch is false then execute the query to return all hotels
		// otherwise return hotel with the hotel_name specified in RequestParam
		if (isSearch == false) {

			// create UnTypedQuery for returning list of hotels
			Query theQuery = session.createQuery(
					"select h.hotel_id, h.hotel_name, h.hotel_location, h.hotel_phone, h.hotel_rating, h.hotel_email, h.pet_friendly from Hotel h");

			listHotel = theQuery.getResultList();
		} else {

			// creating native Query to get hotel which is passed as RequestParam
			listHotel = session.createNativeQuery(
					"SELECT hotel_id, hotel_name, hotel_location, hotel_phone, hotel_rating, hotel_email, pet_friendly FROM hotel where hotel_name LIKE '%"
							+ hotel_name + "%'")
					.getResultList();
		}

		logger.info("Inside getAllHotels() in DAO :" + listHotel);

		// return the hotelList
		return listHotel;
	}

	// adds a new hotel object to the db
	@Override
	public boolean addNewHotel(Hotel h) {

		logger.info("Inside HotelDAO addNewHotel()");

		// a boolean object indicating the success/failure of adding new hotel
		boolean isSuccess = false;

		logger.info("Printing hotel object in the HotelDAO addNewHotel()" + h);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// save the hotel using session
		session.save(h);

		// set isSuccess to true after successfully saving hotel
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	// edits a hotel object in the db
	@Override
	public boolean editAHotel(int hotelId, Hotel h) {

		logger.info("Inside HotelDAO editAHotel()");

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// Creating hotel variable & storing hotel information in it
		Hotel hotel = session.get(Hotel.class, hotelId);

		// getting the hotel object from controller & setting the values of hotel
		hotel.setHotel_name(h.getHotel_name());
		hotel.setHotel_location(h.getHotel_location());
		hotel.setHotel_phone(h.getHotel_phone());
		hotel.setHotel_email(h.getHotel_email());
		hotel.setHotel_rating(h.getHotel_rating());
		hotel.setPet_friendly(h.isPet_friendly());

		logger.info("Hotel in editAHotel() DAO: " + hotel);

		// session.update(hotel);
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	// deletes a hotel from the db
	@Override
	public boolean deleteAHotel(int hotelId) {

		logger.info("Inside HotelDAO deleteAHotel()" + hotelId);

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		session.createQuery("delete from Hotel h where h.hotel_id=" + hotelId).executeUpdate();

		isSuccess = true;

		return isSuccess;
	}

	// gets one hotel object (single row of a table) from db
	@Override
	public Hotel getHotelInformation(int hotelId) {

		logger.info("Inside HotelDAO getHotelInformation(): " + hotelId);

		// creating hotel object (variable)
		Hotel hotel;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting hotel information
		hotel = session.get(Hotel.class, hotelId);

		logger.info("Inside getHotelInformation DAO, hotel object: " + hotel);

		// logger.info("Inside DAO getHotelInformation() Hotel: " + hotel);
		// returning hotel object with bookings, services, customers, employees
		return hotel;
	}

	// this method gets only basic hotel information of one hotel
	@Override
	public Hotel getOneHotelInfo(int hotelId) {

		logger.info("Inside HotelDAO getOneHotelInfo(): " + hotelId);

		// creating hotel (variable)
		Hotel hotel;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting hotel information
		hotel = session.get(Hotel.class, hotelId);

		logger.info("Inside HotelDAO getOneHotelInfo(): " + hotel);

		// returning only hotel properties
		return hotel;
	}

	// this methods gets single customer of a hotel from db
	@Override
	public Customer getCustomerInformation(int hotelId, int customerId) {

		logger.info("Inside HotelDAO getCustomerInformation(), hotel id: " + hotelId + " customer id: " + customerId);

		Customer customer;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting customer information
		customer = session.get(Customer.class, customerId);

		logger.info("Inside getCustomerInformation DAO, customer object: " + customer);

		// create a list of bookings and get list of bookings of a customer using
		// getBookings
		List<Booking> listBooking = customer.getBookings();

		// iterate over the list of bookings to lazy load the booking object
		for (Booking b : listBooking) {

			// print booking id using booking object
			logger.info("Inside DAO getCustomerInformation() Booking id: " + b.getBooking_id());

			// using b get bill id of the customer
			b.getBill().getBill_id();

			// print bill id
			logger.info("Inside DAO getCustomerInformation() Bill id: " + b.getBill().getBill_id());
		}

		// returning customer object
		return customer;
	}

	// this method gets all customers of a hotel
//	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomersOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getCustomersOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create list of Customer
		List<Customer> customerList = new ArrayList<>();

		// create query to get all distinct customer of a hotel
		customerList = session
				.createQuery("select distinct c from Customer c join c.hotels h where h.hotel.hotel_id=" + hotelId)
				.getResultList();

		logger.info("Inside HotelDAO getCustomersOfAHotel() " + customerList);

		return customerList;
	}

	// this method gets all employees of a hotel
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getEmployeesOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create list of employee
		List<Employee> employeeList = new ArrayList<>();

		// create query to get all distinct employees of a hotel
		employeeList = session
				.createQuery("select distinct e from Employee e join e.hotel h where h.hotel_id=" + hotelId)
				.getResultList();

		logger.info("Inside HotelDAO getEmployeesOfAHotel() Employee: " + employeeList);

		return employeeList;
	}

	// this method gets all rooms of a hotel
	@Override
	public List<Room> getRoomsOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getRoomsOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create list of type Room
		List<Room> roomList = new ArrayList<>();

		// create query to get all distinct rooms of a hotel
		roomList = session.createQuery("select distinct r from Room r join r.hotel h where h.hotel_id=" + hotelId)
				.getResultList();

		logger.info("Inside HotelDAO getRoomsOfAHotel() Room: " + roomList);

		return roomList;
	}

	// this method gets all bookings of a hotel
	@SuppressWarnings("unchecked")
	@Override
	public List<BookingDTO> getBookingsOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getBookingsOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create List of type Booking
		 List<Booking> bookingList = new ArrayList<>();

		// create query to get all bookings of a hotel - HQL
		bookingList = session.createQuery("from Booking b WHERE b.hotel.hotel_id=" + hotelId).getResultList();

		// creating native query to type Booking to get all booking details
		/*
		 * Query<Booking> theQuery = session.createNativeQuery(
		 * "Select distinct b.booking_id, b.booking_dateTime, b.booking_amt, b.check_in_DateTime, b.check_out_DateTime, b.no_of_adults, b.no_of_child, \r\n"
		 * +
		 * "b.booking_status, b.hotel_id, b.customer_id, b.bill_id, b.room_id, b.emp_id from booking b where b.hotel_id ="
		 * + hotelId, Booking.class);
		 */

		// creating List of type booking & getting result from theQuery
//		List<Booking> bookingList = theQuery.getResultList();

		logger.info("Inside HotelDAO getBookingsOfAHotel() booking: " + bookingList);

		// creating & initializing list of type BookingDTO
		List<BookingDTO> bookingDTOList = new ArrayList<>();

		// iterating through booking list to get each booking object
		for (Booking book : bookingList) {

			// Creating object of booking dto
			BookingDTO bookingDto = new BookingDTO();

			// setting the booking properties
			bookingDto.setBooking_id(book.getBooking_id());
			bookingDto.setBooking_dateTime(book.getBooking_dateTime());
			bookingDto.setBooking_amt(book.getBooking_amt());
			bookingDto.setCheck_in_DateTime(book.getCheck_in_DateTime());
			bookingDto.setCheck_out_DateTime(book.getCheck_out_DateTime());
			bookingDto.setNo_of_adults(book.getNo_of_adults());
			bookingDto.setNo_of_child(book.getNo_of_child());
			bookingDto.setBooking_status(book.getBooking_status());
			bookingDto.setHotel_id(book.getHotel().getHotel_id());
			bookingDto.setCustomer_id(book.getCustomer().getCustomer_id());
			bookingDto.setCustomer_name(book.getCustomer().getCustomer_name());		
			bookingDto.setRoom_id(book.getRoom().getRoom_id());
			bookingDto.setRoom_no(book.getRoom().getRoom_no());
			bookingDto.setEmployee_id(book.getEmployee().getEmp_id());
			bookingDto.setEmp_name(book.getEmployee().getEmp_name());
			bookingDto.setBill_id(book.getBill().getBill_id());

			// HQL query to get service ids for bookings
			List<Integer> serviceQuery = session.createQuery(
					"select s.service_id from Booking bo JOIN bo.services bs JOIN bs.hotel_service hs JOIN hs.service s WHERE bo.booking_id="
							+ book.getBooking_id())
					.getResultList();
			
			bookingDto.setServices(serviceQuery);

			// creating native query to type Integer to get service ids
			/*
			 * Query<Integer> serviceQuery = session.createNativeQuery(
			 * "select service.service_id from service JOIN hotel_service on hotel_service.service_id = service.service_id JOIN booking_service on hotel_service.hotel_service_id = booking_service.hotel_service_id JOIN booking on booking.booking_id = booking_service.booking_id WHERE booking.booking_id ="
			 * + book.getBooking_id());
			 */

			// Creating list of Integer & getting result from serviceQuery
//			List<Integer> serviceList = serviceQuery.getResultList();

			// setting service id list in bookingDto object
//			bookingDto.setServices(serviceList);

			logger.info("Inside HotelDAO getBookingsOfAHotel() serviceQuery: " + serviceQuery);
//			logger.info("Inside HotelDAO getBookingsOfAHotel() serviceQuery: " + serviceList);

			// adding bookingDto object to bookingDTO list
			bookingDTOList.add(bookingDto);
		}

		logger.info("Inside HotelDAO getBookingsOfAHotel() bookingDTOList: " + bookingDTOList);
		logger.info("Inside HotelDAO getBookingsOfAHotel() booking: " + bookingList);

		// returning list of bookingDTO
		return bookingDTOList;
	}

	// this method gets all services of a hotel
	@Override
	public List<ServiceDTO> getServicesOfAHotel(int hotelId) {

		logger.info("Inside HotelDAO getServicesOfAHotel(), hotel id: " + hotelId);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create List of type Service
		// List<Service> serviceList = new ArrayList<>();

		// create HQL query to get all distinct services of a hotel
		/*
		 * serviceList = session.createQuery(
		 * "select distinct s.service_id, s.service_name, h.service_price from Service s JOIN s.hotels h where h.hotel.hotel_id="
		 * + hotelId) .getResultList();
		 */

		// creating native query to get service id & names
		Query<Service> theQuery = session.createNativeQuery(
				"SELECT service.service_id, service.service_name FROM service JOIN hotel_service on service.service_id \r\n"
						+ "= hotel_service.service_id where hotel_service.hotel_id =" + hotelId,
				Service.class);

		// creating a list of type Service & getting result from theQuery
		List<Service> serviceList = theQuery.getResultList();

		logger.info("Inside HotelDAO getServicesOfAHotel() service: " + serviceList);

		// creating a list of type ServiceDTO
		List<ServiceDTO> serviceDTOList = new ArrayList<>();

		for (com.entlogics.hotelbookingsystem.entity.Service s : serviceList) {

			// Creating object of service dto
			ServiceDTO serviceDto = new ServiceDTO();

			// setting properties of service
			serviceDto.setService_id(s.getService_id());
			serviceDto.setService_name(s.getService_name());

			// creating native query to get service price from hotel_service
			Query servicepriceQuery = session.createNativeQuery(
					"SELECT hotel_service.service_price FROM hotel_service JOIN service on hotel_service.service_id = service.service_id WHERE \r\n"
							+ "service.service_id =" + s.getService_id() + " AND hotel_service.hotel_id =" + hotelId);

			// casting query to BigDecimal and getting single result from the query
			BigDecimal servicePrice = (BigDecimal) servicepriceQuery.getSingleResult();

			// setting service price value in service dto
			serviceDto.setService_price(servicePrice);

			// adding serviceDto object to serviceDTO list
			serviceDTOList.add(serviceDto);
		}

		logger.info("Inside Hotel Service getServicesOfAHotel() serviceDTO: " + serviceDTOList);

		// returning serviceDTO list
		return serviceDTOList;
	}

	// returns information of one room of a hotel
	@Override
	public RoomInformationDTO getRoomInformation(int hotelId, int roomId) {
		logger.info("Inside HotelDAO getRoomInformation(), hotel id: " + hotelId + " room id: " + roomId);

		// creating room variable
		Room room;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// getting room information
		room = session.get(Room.class, roomId);

		logger.info("Inside getCustomerInformation DAO, room object: " + room);

		// creating object of room information dto
		RoomInformationDTO roomInfoDTO = new RoomInformationDTO();

		// setting the room properties
		roomInfoDTO.setRoom_id(room.getRoom_id());
		roomInfoDTO.setRoom_type(room.getRoom_type());
		roomInfoDTO.setRoom_price(room.getRoom_price());
		roomInfoDTO.setRoom_no(room.getRoom_no());
		roomInfoDTO.setFloor_no(room.getFloor_no());
		roomInfoDTO.setArea_of_room(room.getArea_of_room());
		roomInfoDTO.setOccupancy_details(room.getOccupancy_details());
		roomInfoDTO.setHotel_id(room.getHotel().getHotel_id());

		// Query to get booking ids for a room
		List<Integer> bookingIdQuery = session
				.createQuery("select b.booking_id FROM Booking b WHERE b.room.room_id=" + roomId).getResultList();

		// setting booking id list in bookingdto object
		roomInfoDTO.setBookings(bookingIdQuery);

		logger.info("Inside getCustomerInformation DAO, bookingIdQuery: " + bookingIdQuery);

		logger.info("Inside getCustomerInformation DAO, roomInfoDto: " + roomInfoDTO);

		// returning roomInfoDTO object
		return roomInfoDTO;
	}

	// adds a new room to a hotel & returns boolean value whether successful or not
	@Override
	public boolean addNewRoomToAHotel(int hotelId, Room r) {
		logger.info("Inside HotelDAO addNewRoomToAHotel()");

		// a boolean object indicating the success/failure of adding new room to a hotel
		boolean isSuccess = false;

		logger.info("Printing room object in the HotelDAO addNewRoomToAHotel()" + r);

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		String room_type = r.getRoom_type();
		float room_price = r.getRoom_price();
		int room_no = r.getRoom_no();
		int floor_no = r.getFloor_no();
		String area_of_room = r.getArea_of_room();
		String occupancy_details = r.getOccupancy_details();
		int hotel_id = hotelId;

		// NativeQuery for inserting room
		Query addRoomQuery = session.createNativeQuery(
				"INSERT INTO room (room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES \r\n"
						+ "(?,?,?,?,?,?,?)");

		// setting parameters
		addRoomQuery.setParameter(0, room_no);
		addRoomQuery.setParameter(1, room_type);
		addRoomQuery.setParameter(2, room_price);
		addRoomQuery.setParameter(3, floor_no);
		addRoomQuery.setParameter(4, area_of_room);
		addRoomQuery.setParameter(5, occupancy_details);
		addRoomQuery.setParameter(6, hotel_id);

		addRoomQuery.executeUpdate();

		logger.info("Inside HotelDAO addNewRoomToAHotel: " + addRoomQuery);

		// save the room using session
		// session.save(r);

//		logger.info("Printing room_type in HotelDAO addNewRoomToAHotel: " + room_type);

		// trying HQL insert without using values & setting parameters
//		Query addQuery = session.createQuery(
//				"insert into Room (room_type, room_price, room_no, floor_no, area_of_room, occupancy_details, hotel.hotel_id)");
//		
//		addQuery.setParameter(0, room_type);
//		addQuery.setParameter(1, room_price);
//		addQuery.setParameter(2, room_no);
//		addQuery.setParameter(3, floor_no);
//		addQuery.setParameter(4, area_of_room);
//		addQuery.setParameter(5, occupancy_details);
//		addQuery.setParameter(6, hotel_id);
//		
//		addQuery.executeUpdate();

		// HQL query to insert - not supported in Hibernate 5.2
//		Query addQuery = session.createQuery("insert into Room (room_type, room_price, room_no, floor_no, area_of_room, occupancy_details, hotel.hotel_id) "
//				+ "values("+ room_type +"," + room_price + "," + room_no + "," + floor_no + "," + area_of_room
//				+ "," + occupancy_details + "," + hotel_id + ")");
//		
//		int result = addQuery.executeUpdate();

//		logger.info("Number of records inserted result :" + result);

		// set isSuccess to true after successfully saving room
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	// edits a room of a hotel & returns boolean value whether successful or not
	@Override
	public boolean editARoomOfAHotel(int hotelId, int roomId, Room r) {
		logger.info("Inside HotelDAO editARoomOfAHotel()");

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		logger.info("Inside HotelDAO editARoomOfAHotel() room: " + r);

		// storing properties of room in different variables
		String room_type = r.getRoom_type();
		float room_price = r.getRoom_price();
		int room_no = r.getRoom_no();
		int floor_no = r.getFloor_no();
		String area_of_room = r.getArea_of_room();
		String occupancy_details = r.getOccupancy_details();
		int hotel_id = hotelId;

		logger.info("Inside HotelDAO editARoomOfAHotel() hotel id: " + hotel_id);

		// Query to update room information
		Query editRoomQuery = session.createQuery(
				"update Room set room_type=:room_type, room_price=:room_price, room_no=:room_no,floor_no=:floor_no,area_of_room=:area_of_room,occupancy_details=:occupancy_details,hotel.hotel_id=:hotel_id where hotel.hotel_id="
						+ hotelId + " AND room_id=" + roomId);

		// setting parameters to the variable values
		editRoomQuery.setParameter("room_type", room_type);
		editRoomQuery.setParameter("room_price", room_price);
		editRoomQuery.setParameter("room_no", room_no);
		editRoomQuery.setParameter("floor_no", floor_no);
		editRoomQuery.setParameter("area_of_room", area_of_room);
		editRoomQuery.setParameter("occupancy_details", occupancy_details);
		editRoomQuery.setParameter("hotel_id", hotel_id);

		// executing the update on query
		editRoomQuery.executeUpdate();

		// setting isSuccess to true
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	// deletes a room of a hotel & returns boolean value whether successful or not
	@Override
	public boolean deleteARoomOfAHotel(int hotelId, int roomId) {
		logger.info("Inside HotelDAO deleteARoomOfAHotel()" + hotelId + roomId);

		// declaring boolean variable to track the status of method execution
		boolean isSuccess = false;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// create a Query to delete a room of a hotel
		session.createQuery("delete from Room r where r.hotel.hotel_id=" + hotelId + "AND r.room_id=" + roomId)
				.executeUpdate();

		// setting isSuccess to true
		isSuccess = true;

		logger.info("Inside HotelDAO deleteARoomOfAHotel() Successfully deleted");

		// returning boolean isSuccess
		return isSuccess;
	}

	// links a customer to a hotel & returns boolean value indicating whether
	// successful or not
	@Override
	public boolean linkCustomerToAHotel(int hotelId, Customer c) {

		logger.info("Inside HotelDAO linkCustomerToAHotel()");

		// a boolean object indicating the success/failure of linking customer to a
		// hotel
		boolean isSuccess = false;

		logger.info("Printing customer object in the HotelDAO linkCustomerToAHotel()" + c);

		// storing the customer id from customer object
		int customer_id = c.getCustomer_id();

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

//		Hotel_Customer hotelCustomer = new Hotel_Customer();

		// NativeQuery for linking customer to a hotel
		Query linkCustomerQuery = session
				.createNativeQuery("INSERT INTO hotel_customer (hotel_id, customer_id) VALUES (?,?)");

		// setting parameters
		linkCustomerQuery.setParameter(0, hotelId);
		linkCustomerQuery.setParameter(1, customer_id);

		linkCustomerQuery.executeUpdate();

		// set isSuccess to true after successfully saving
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	// links services to a hotel & returns boolean value indicating whether
	// successful or not
	@Override
	public boolean linkServicesToAHotel(int hotelId, LinkServiceDTO s) {
		logger.info("Inside HotelDAO linkServicesToAHotel()");

		// a boolean object indicating the success/failure of linking services to a
		// hotel
		boolean isSuccess = false;

		logger.info("Printing customer object in the HotelDAO linkServicesToAHotel()" + s);

		// storing the service id from service object in array of int
		int[] arr_service_id = s.getService_id();

		// declaring variable i
		int i;

		// get the current hibernate session
		session = sessionFactory.getCurrentSession();

		// using for loop to loop over the array till the length of array & set the
		// values for service_id & hotel_id
		for (i = 0; i < arr_service_id.length; i++) {

			// NativeQuery for linking customer to a hotel
			Query linkServiceQuery = session
					.createNativeQuery("INSERT INTO hotel_service (hotel_id, service_id) VALUES (?,?)");

			// setting parameters
			linkServiceQuery.setParameter(0, hotelId);
			linkServiceQuery.setParameter(1, arr_service_id[i]);

			linkServiceQuery.executeUpdate();
		}

		// set isSuccess to true after successfully saving
		isSuccess = true;

		// Send a success message back to Controller
		return isSuccess;
	}

	@Override
	public Hotel getOneHotelInfoJpa(int hotelId) {
		logger.info("Inside HotelDAO JPA getOneHotelInfoJpa(): " + hotelId);

		// creating hotel object (variable)
		Hotel hotel;

		// getting hotel information
		hotel = entityManager.find(Hotel.class, hotelId);

		logger.info("Inside getOneHotelInfoJpa DAO, hotel object: " + hotel);

		// returning hotel object with bookings, services, customers, employees
		return hotel;
	}
}
