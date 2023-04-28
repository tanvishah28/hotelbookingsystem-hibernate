package com.entlogics.hotelbookingsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.entlogics.hotelbookingsystem.service.IHotelService;

// crossOrigin annotation declares origin as * that means any origin can access the resources on this origin
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class HotelController {

	// create logger object
	private static final Logger logger = LogManager.getLogger(HotelController.class);

	// injecting hotel service dependency using field injection
	@Autowired
	private IHotelService hotelService;

	// this method gets list of hotels - returning JSON output
	@RequestMapping(value = "/hotels", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<HotelDTO> getListofHotels(@RequestParam(value = "hotel_name", required = false) String hotel_name) {

		logger.info("Inside HotelController - getListofHotels()");
		
		// declaring & initializing boolean variable to true
		Boolean isSearch = true;
		
		// checking whether RequestParam is empty or null , if yes then set isSearch to false
		if(hotel_name == " " || hotel_name == null) {
			isSearch = false;
		}

		// calling Service method to get list of hotels
		List<HotelDTO> hotelList = hotelService.getAllHotels(isSearch, hotel_name);

		// returning the hotelList
		return hotelList;
	}

	// this method maps the request for adding new hotel - /hotels Taking JSON input
	@RequestMapping(value = "/hotels", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public String addNewHotel(@RequestBody Hotel hotel) {

		logger.info("Inside HotelController - addNewHotel()");

		logger.info("Printing hotel object in the HotelController addNewHotel(): " + hotel);

		// call Service method addNewHotel()
		boolean isAdded = hotelService.addNewHotel(hotel);
		String added = String.valueOf(isAdded);

		return added;
	}

	// this method gets details of one Hotel - returning JSON
	@RequestMapping(value = "/hotels/{hotel-id}", method = RequestMethod.GET)
	@ResponseBody
	public HotelInformationDTO getOneHotel(@PathVariable("hotel-id") int hotelId, Model theModel) {

		logger.info("Inside HotelController - getOneHotel()");

		// using Service object to call DAO method to get details of a single hotel
		HotelInformationDTO hotelInfoDTO = hotelService.getHotelInformation(hotelId);
		
		// using service object to call JPA DAO method to get info of one hotel
//		HotelInformationDTO hotelInfoDTO = hotelService.getOneHotelInfoJpa(hotelId);

		logger.info("Inside HotelController - getOneHotel() Hotel object : " + hotelInfoDTO);

		// adding hotel to the model
		// theModel.addAttribute("hotel", hotel);
		return hotelInfoDTO;
	}

	// this method edits a hotel record
	@RequestMapping(value = "/hotels/{hotel-id}", method = RequestMethod.PUT, consumes = { "application/json" })
	@ResponseBody
	public String editNewHotel(@PathVariable("hotel-id") int hotelId, @RequestBody Hotel hotel) {

		logger.info("Inside HotelController - editNewHotel() " + hotelId);

		logger.info("Inside HotelController - editNewHotel() " + hotel);

		// getting the request body & creating Hotel object
		Hotel h = hotel;

		// creating boolean variable & passing hotelId & hotel object to HotelService
		// method
		boolean isEdited = hotelService.editAHotel(hotelId, h);

		// converting value of isEdited (boolean) to String & passing it to "edited"
		String edited = String.valueOf(isEdited);

		return edited;
	}

	// this method deletes a hotel record
	@RequestMapping(value = "/hotels/{hotel_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - deleteOneHotel() Hotel ID: " + hotelId);

		// using Service object to call DAO method to delete a hotel
		boolean isDeleted = hotelService.deleteAHotel(hotelId);
		String deletedHotel = String.valueOf(isDeleted);

		return deletedHotel;
	}

	// this method gets one customer of a hotel - GET request
	@RequestMapping(value = "/hotels/{hotel_id}/customers/{customer_id}", method = RequestMethod.GET)
	@ResponseBody
	public CustomerInformationDTO getOneCustomerOfOneHotel(@PathVariable("hotel_id") int hotelId,
			@PathVariable("customer_id") int customerId, Model theModel) {

		logger.info("Inside HotelController - getOneCustomerOfOneHotel()");

		// using Service object to call DAO method
		CustomerInformationDTO customerInfoDTO = hotelService.getCustomerInformation(hotelId, customerId);

		return customerInfoDTO;
	}

	// this method gets list of customers of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/customers", method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseBody
	public List<CustomerDTO> getCustomersOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - getCustomersOfOneHotel() , hotel id: " + hotelId);

		// using Service object to call DAO method to get list of customers
		List<CustomerDTO> customerList = hotelService.getCustomersOfAHotel(hotelId);

		return customerList;
	}

	// this method gets list of employees of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDTO> getEmployeesOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - getEmployeesOfOneHotel() , hotel id: " + hotelId);

		// using Service object to call DAO method to get list of employees
		List<EmployeeDTO> employeeList = hotelService.getEmployeesOfAHotel(hotelId);

		// returning list of employees of type EmployeeDTO
		return employeeList;
	}

	// this method gets list of rooms of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/rooms", method = RequestMethod.GET)
	@ResponseBody
	public List<RoomDTO> getRoomsOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - getRoomsOfOneHotel() , hotel id: " + hotelId);

		// using Service object to call DAO method to get list of rooms
		List<RoomDTO> roomList = hotelService.getRoomsOfAHotel(hotelId);

		// returning list of rooms of type RoomDTO
		return roomList;
	}

	// this method gets list of bookings of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/bookings", method = RequestMethod.GET)
	@ResponseBody
	public List<BookingDTO> getBookingsOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - getBookingsOfAHotel(), hotel id: " + hotelId);

		// using service object to call DAO method to get list of bookings
		List<BookingDTO> bookingList = hotelService.getBookingsOfAHotel(hotelId);

		// returning list of bookings of type BookingDTO
		return bookingList;
	}

	// this method gets list of services of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/services", method = RequestMethod.GET)
	@ResponseBody
	public List<ServiceDTO> getServicesOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside HotelController - getServicesOfOneHotel(), hotel id: " + hotelId);

		// using service object to call DAO method to get list of services
		List<ServiceDTO> serviceList = hotelService.getServicesOfAHotel(hotelId);

		logger.info("Inside HotelController - getServicesOfOneHotel() ServiceList: " + serviceList);

		// returning list of services
		return serviceList;
	}

	// this method returns information of one Room object of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/rooms/{room_id}", method = RequestMethod.GET)
	@ResponseBody
	public RoomInformationDTO getOneRoomOfOneHotel(@PathVariable("hotel_id") int hotelId,
			@PathVariable("room_id") int roomId) {

		logger.info("Inside HotelController - getOneRoomOfOneHotel()");

		// using Service object to call DAO method
		RoomInformationDTO roomInfoDTO = hotelService.getRoomInformation(hotelId, roomId);

		// returning Object of RoomInformationDTO
		return roomInfoDTO;
	}

	// this method adds a new room to a hotel and returns a string indicating
	// whether successful or not
	@RequestMapping(value = "/hotels/{hotel_id}/rooms", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public String addNewRoomToOneHotel(@PathVariable("hotel_id") int hotelId, @RequestBody Room room) {

		logger.info("Inside HotelController - addNewRoomToOneHotel()");

		// call Service method addNewHotel()
		boolean isAdded = hotelService.addNewRoomToAHotel(hotelId, room);
		String added = String.valueOf(isAdded);

		logger.info("Printing room object in the HotelController addNewRoomToOneHotel(): " + room);

		return added;
	}

	// this method edits a room of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/rooms/{room_id}", method = RequestMethod.PUT, consumes = {
			"application/json" })
	@ResponseBody
	public String editRoomOfOneHotel(@PathVariable("hotel_id") int hotelId, @PathVariable("room_id") int roomId,
			@RequestBody Room room) {

		logger.info("Inside HotelController - editRoomOfOneHotel(), hotel ID: " + hotelId + " room ID: " + roomId);

		// getting the request body & creating Room object
		Room r = room;

		// creating boolean variable & passing hotelId, roomId & room object to
		// HotelService method
		boolean isEdited = hotelService.editARoomOfAHotel(hotelId, roomId, r);

		logger.info("Inside HotelController - editRoomOfOneHotel() request body room: " + r);

		// converting value of isEdited (boolean) to String & passing it to "edited"
		String edited = String.valueOf(isEdited);

		return edited;
	}

	// this method deletes a room of a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/rooms/{room_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRoomOfOneHotel(@PathVariable("hotel_id") int hotelId, @PathVariable("room_id") int roomId) {

		logger.info("Inside HotelController - deleteRoomOfOneHotel() Hotel ID: " + hotelId + " Room ID: " + roomId);

		// using Service object to call DAO method to delete a room of a hotel
		boolean isDeleted = hotelService.deleteARoomOfAHotel(hotelId, roomId);

		// converting value of isDeleted (boolean) to String & passing it to
		// "deletedRoomOfAHotel"
		String deletedRoomOfAHotel = String.valueOf(isDeleted);

		return deletedRoomOfAHotel;
	}

	// this method maps the request for linking a customer to a hotel
	// no need to use "consumes" if using @RequestBody and @ResponseBody . It will
	// take default JSON value.
	@RequestMapping(value = "/hotels/{hotel_id}/customers", method = RequestMethod.POST)
	@ResponseBody
	public String linkCustomerToOneHotel(@PathVariable("hotel_id") int hotelId, @RequestBody Customer customer) {

		logger.info("Inside HotelController - linkCustomerToOneHotel()");

		logger.info("Printing customer object in the HotelController linkCustomerToOneHotel(): " + customer);

		// call Service method linkCustomerToAHotel() and pass hotelId & customer object
		// to it
		boolean isLinked = hotelService.linkCustomerToAHotel(hotelId, customer);

		// converting the boolean isLinked to String
		String linked = String.valueOf(isLinked);

		// returning string (whether successfully linked or not - expect true or false)
		return linked;
	}

	// this method maps the request for linking services to a hotel
	@RequestMapping(value = "/hotels/{hotel_id}/services", method = RequestMethod.POST)
	@ResponseBody
	public String linkServicesToOneHotel(@PathVariable("hotel_id") int hotelId, @RequestBody LinkServiceDTO service) {

		logger.info("Inside HotelController - linkServicesToOneHotel()");

		logger.info("Printing servicedto object in the HotelController linkServicesToOneHotel(): " + service);

		// call Service method linkServicesToAHotel() and pass hotelId & service object to it
		boolean isLinked = hotelService.linkServicesToAHotel(hotelId, service);

		// converting the boolean isLinked to String
		String linked = String.valueOf(isLinked);

		// returning string (whether successfully linked or not - expect true or false)
		return linked;
	}
}
