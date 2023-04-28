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

//This entity class maps to customer table in hoteldb using hibernate 

@Entity
@Table(name = "customer")
public class Customer {

	// Defining the fields & annotate the fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customer_id;

	@Column(name = "customer_name")
	private String customer_name;

	@Column(name = "customer_address")
	private String customer_address;

	@Column(name = "customer_phone")
	private String customer_phone;

	@Column(name = "customer_email")
	private String customer_email;

	@Column(name = "preferences")
	private String preferences;

	@Column(name = "special_needs")
	private String special_needs;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	List<Booking> bookings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	List<Hotel_Customer> hotels;

	// no-arg constructor

	public Customer() {
	}

	// Parameterized Constructor for Customer class

	public Customer(String customer_name, String customer_address) {
		this.customer_name = customer_name;
		this.customer_address = customer_address;
	}

	// Generated Setters and getters

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public String getSpecial_needs() {
		return special_needs;
	}

	public void setSpecial_needs(String special_needs) {
		this.special_needs = special_needs;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Hotel_Customer> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel_Customer> hotels) {
		this.hotels = hotels;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_phone=" + customer_phone + ", customer_email=" + customer_email
				+ ", preferences=" + preferences + ", special_needs=" + special_needs + "]";
	}
}
