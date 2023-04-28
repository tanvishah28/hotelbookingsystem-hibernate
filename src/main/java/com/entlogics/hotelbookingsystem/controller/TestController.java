package com.entlogics.hotelbookingsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entlogics.hotelbookingsystem.dto.BookingDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerDTO;
import com.entlogics.hotelbookingsystem.dto.CustomerInformationDTO;
import com.entlogics.hotelbookingsystem.dto.HotelDTO;
import com.entlogics.hotelbookingsystem.dto.HotelInformationDTO;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.service.ITestService;

@Controller
public class TestController {

	// create logger object
	private static final Logger logger = LogManager.getLogger(TestController.class);

	// injecting hotel service dependency using field injection
	@Autowired
	private ITestService testService;

	// this method gets list of customers of a hotel
	@RequestMapping(value = "/test/hotels/{hotel_id}/customers", method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseBody
	public List<CustomerDTO> getCustomersOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside TestController - getCustomersOfOneHotel() , hotel id: " + hotelId);

		// using Service object to call DAO method to get list of customers
		List<CustomerDTO> customerList = testService.getCustomersOfAHotel(hotelId);

		return customerList;
	}

	// this method gets list of bookings of a hotel
	@RequestMapping(value = "/test/hotels/{hotel_id}/bookings", method = RequestMethod.GET)
	@ResponseBody
	public List<BookingDTO> getBookingsOfOneHotel(@PathVariable("hotel_id") int hotelId) {

		logger.info("Inside TestController - getBookingsOfAHotel(), hotel id: " + hotelId);

		// using service object to call DAO method to get list of bookings
		List<BookingDTO> bookingList = testService.getBookingsOfAHotel(hotelId);

		return bookingList;
	}

	// this method gets list of hotels
	@RequestMapping(value = "/test/hotels", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<HotelDTO> getListofHotels() {

		logger.info("Inside TestController - getListofHotels()");

		// calling Service method to get list of hotels
		List<HotelDTO> hotelList = testService.getAllHotels();

		return hotelList;
	}

	// this method gets one customer of a hotel - GET request
	@RequestMapping(value = "/test/hotels/{hotel_id}/customers/{customer_id}", method = RequestMethod.GET)
	@ResponseBody
	public CustomerInformationDTO getOneCustomerOfOneHotel(@PathVariable("hotel_id") int hotelId,
			@PathVariable("customer_id") int customerId, Model theModel) {

		logger.info("Inside TestController - getOneCustomerOfOneHotel()");

		// using Service object to call DAO method
		CustomerInformationDTO customerInfoDTO = testService.getCustomerInformation(hotelId, customerId);

		return customerInfoDTO;
	}
	
	// Testing @transactional's readOnly
	@RequestMapping(value = "/test/hotels/{hotel_id}/transaction", method = RequestMethod.GET)
	@ResponseBody
	public HotelInformationDTO testTransactions(@PathVariable("hotel_id") int hotelId) {
		
		logger.info("Inside TestController - testTransactions()");
		
		HotelInformationDTO hotelInfoDTO = testService.testingTransaction(hotelId);
		
		return hotelInfoDTO;
	}
}
