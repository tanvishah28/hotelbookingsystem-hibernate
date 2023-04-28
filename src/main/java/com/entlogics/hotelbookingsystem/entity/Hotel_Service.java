package com.entlogics.hotelbookingsystem.entity;

import java.math.BigDecimal;

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

//This entity class maps to hotel_service table in hoteldb using hibernate 

@Entity
@Table(name="hotel_service")
public class Hotel_Service {

	// Defining the fields & annotate the fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotel_service_id")
	private int hotel_service_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="service_id")
	private Service service;
	
	@Column(name="service_price")
	private BigDecimal service_price;

	public int getHotel_service_id() {
		return hotel_service_id;
	}

	public void setHotel_service_id(int hotel_service_id) {
		this.hotel_service_id = hotel_service_id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public BigDecimal getService_price() {
		return service_price;
	}

	public void setService_price(BigDecimal service_price) {
		this.service_price = service_price;
	}

	@Override
	public String toString() {
		return "Hotel_Service [hotel_service_id=" + hotel_service_id + ", service_price=" + service_price + "]";
	}
}
