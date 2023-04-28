package com.entlogics.hotelbookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.service.IHotelService;

// this Controller class loads the form for adding new hotel & editing a hotel
@Controller
public class HotelLoadFormController {

	// injecting hotel service dependency using field injection
	@Autowired
	private IHotelService hotelService;

	@RequestMapping("/hotels/addHotelForm")
	public String addHotelForm() {
		return "add-hotel";
	}

	// this method gets one hotel details & passes it to edit hotel form
	@RequestMapping("/hotels/{hotel_id}/editHotelForm")
	public String editHotelForm(@PathVariable("hotel_id") int hotelId, Model theModel) {

		// fetch one hotel details & populate the form
		Hotel hotel = hotelService.getOneHotelInfo(hotelId);

		// add hotel to the model
		theModel.addAttribute("hotel", hotel);

		return "edit-hotel";
	}
}
