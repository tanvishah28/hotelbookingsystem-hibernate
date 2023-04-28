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

//This entity class maps to service table in hoteldb using hibernate 

@Entity
@Table(name = "service")
public class Service {

	// Defining the fields & annotate the fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private int service_id;

	@Column(name = "service_name")
	private String service_name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
	List<Hotel_Service> hotels;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel_service", cascade = CascadeType.ALL)
	List<Booking_Service> bookings;

	// no-arg constructor

	public Service() {
		super();
	}

	// Constructor for Customer class

	public Service(String service_name) {
		super();
		this.service_name = service_name;
	}

	// Generated Setters and getters

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public List<Hotel_Service> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel_Service> hotels) {
		this.hotels = hotels;
	}

	public List<Booking_Service> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking_Service> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", service_name=" + service_name + "]";
	}
}
