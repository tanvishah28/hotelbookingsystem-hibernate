package com.entlogics.hotelbookingsystem.dto;

// this is Hotel Data Transfer Object (DTO) Class with just properties of Hotel & getters and setters
public class HotelDTO {

	// Defining the fields
	private int hotel_id;

	private String hotel_name;

	private String hotel_location;

	private String hotel_phone;

	private int hotel_rating;

	private String hotel_email;

	private boolean pet_friendly;

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

	@Override
	public String toString() {
		return "HotelDTO [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email=" + hotel_email
				+ ", pet_friendly=" + pet_friendly + "]";
	}
}
