package com.entlogics.hotelbookingsystem.dto;

import java.util.List;

//this is Hotel Information DTO Class with properties of Hotel, list of integers for getting IDs of rooms,customers,employees,bookings,service & getters and setters
public class HotelInformationDTO {

	// Defining the fields
	private int hotel_id;

	private String hotel_name;

	private String hotel_location;

	private String hotel_phone;

	private int hotel_rating;

	private String hotel_email;

	private boolean pet_friendly;

	private List<Integer> rooms;

	private List<Integer> employees;

	private List<Integer> customers;

	private List<Integer> bookings;

	private List<Integer> services;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public String getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public int getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(int i) {
		this.hotel_rating = i;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public boolean isPet_friendly() {
		return pet_friendly;
	}

	public void setPet_friendly(boolean pet_friendly) {
		this.pet_friendly = pet_friendly;
	}

	public List<Integer> getRooms() {
		return rooms;
	}

	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}

	public List<Integer> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Integer> employees) {
		this.employees = employees;
	}

	public List<Integer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Integer> customers) {
		this.customers = customers;
	}

	public List<Integer> getBookings() {
		return bookings;
	}

	public void setBookings(List<Integer> bookings) {
		this.bookings = bookings;
	}

	public List<Integer> getServices() {
		return services;
	}

	public void setServices(List<Integer> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "HotelInformationDTO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location="
				+ hotel_location + ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email="
				+ hotel_email + ", pet_friendly=" + pet_friendly + "]";
	}
}
