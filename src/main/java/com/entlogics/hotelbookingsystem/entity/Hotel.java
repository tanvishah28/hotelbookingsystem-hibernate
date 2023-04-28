package com.entlogics.hotelbookingsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This entity class maps to hotel table in hoteldb using hibernate 

@Entity
@Table(name = "hotel")
public class Hotel {

	// Defining the fields & annotate the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private int hotel_id;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "hotel_location")
	private String hotel_location;

	@Column(name = "hotel_phone")
	private String hotel_phone;

	@Column(name = "hotel_rating")
	private int hotel_rating;

	@Column(name = "hotel_email")
	private String hotel_email;

	@Column(name = "pet_friendly")
	private boolean pet_friendly;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Hotel_Customer> customers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Room> rooms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Employee> employees;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade =  CascadeType.ALL)
	List<Booking> bookings;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Hotel_Service> services;

	// no-arg constructor

	public Hotel() {
	}

	// Constructor for Hotel class

	public Hotel(String hotel_name, String hotel_location) {
		this.hotel_name = hotel_name;
		this.hotel_location = hotel_location;
	}

	// Generated Setters and getters

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

	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Hotel_Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Hotel_Customer> customers) {
		this.customers = customers;
	}

	public List<Hotel_Service> getServices() {
		return services;
	}

	public void setServices(List<Hotel_Service> services) {
		this.services = services;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email=" + hotel_email
				+ ", pet_friendly=" + pet_friendly + "]";
	}
}
