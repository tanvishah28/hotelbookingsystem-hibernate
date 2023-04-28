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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



//This entity class maps to hotel_customer table in hoteldb using hibernate 

@Entity
@Table(name="hotel_customer")
public class Hotel_Customer {

	// Defining the fields & annotate the fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hotel_customer_id")
	private int hotel_customer_id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="customer_type")
	private String customer_type;
	
	@Column(name="customer_reward_points")
	private double customer_reward_points;
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}

	public double getCustomer_reward_points() {
		return customer_reward_points;
	}

	public void setCustomer_reward_points(double customer_reward_points) {
		this.customer_reward_points = customer_reward_points;
	}

	@Override
	public String toString() {
		return "Hotel_Customer [hotel_customer_id=" + hotel_customer_id + ", customer_type=" + customer_type
				+ ", customer_reward_points=" + customer_reward_points + "]";
	}
}
