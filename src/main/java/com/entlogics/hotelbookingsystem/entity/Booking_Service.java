package com.entlogics.hotelbookingsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//This entity class maps to booking_service table in hoteldb using hibernate 

@Entity
@Table(name = "booking_service")
public class Booking_Service {

	// Defining the fields & annotate the fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_service_id")
	private int booking_service_id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "booking_id")
	private Booking booking;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "hotel_service_id")
	private Hotel_Service hotel_service;

	@Column(name = "rating")
	private float service_rating;
	
	// getters & setters

	public int getBooking_service_id() {
		return booking_service_id;
	}

	public void setBooking_service_id(int booking_service_id) {
		this.booking_service_id = booking_service_id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Hotel_Service getHotel_service() {
		return hotel_service;
	}

	public void setHotel_service(Hotel_Service hotel_service) {
		this.hotel_service = hotel_service;
	}

	public float getService_rating() {
		return service_rating;
	}

	public void setService_rating(float service_rating) {
		this.service_rating = service_rating;
	}

	@Override
	public String toString() {
		return "Booking_Service [booking_service_id=" + booking_service_id + ", service_rating=" + service_rating + "]";
	}
}
