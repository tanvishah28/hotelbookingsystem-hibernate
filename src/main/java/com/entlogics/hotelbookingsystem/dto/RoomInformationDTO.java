package com.entlogics.hotelbookingsystem.dto;

import java.util.List;

//this is Room Information DTO Class with properties of Room
public class RoomInformationDTO {

	private int room_id;

	private String room_type;

	private float room_price;

	private int room_no;

	private int floor_no;

	private String area_of_room;

	private String occupancy_details;

	private int hotel_id;
	
	private List<Integer> bookings;

	// getters & setters
	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public float getRoom_price() {
		return room_price;
	}

	public void setRoom_price(float room_price) {
		this.room_price = room_price;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}

	public String getArea_of_room() {
		return area_of_room;
	}

	public void setArea_of_room(String area_of_room) {
		this.area_of_room = area_of_room;
	}

	public String getOccupancy_details() {
		return occupancy_details;
	}

	public void setOccupancy_details(String occupancy_details) {
		this.occupancy_details = occupancy_details;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public List<Integer> getBookings() {
		return bookings;
	}

	public void setBookings(List<Integer> bookings) {
		this.bookings = bookings;
	}

	// toString() for all properties
	@Override
	public String toString() {
		return "RoomInformationDTO [room_id=" + room_id + ", room_type=" + room_type + ", room_price=" + room_price
				+ ", room_no=" + room_no + ", floor_no=" + floor_no + ", area_of_room=" + area_of_room
				+ ", occupancy_details=" + occupancy_details + ", hotel_id=" + hotel_id + "]";
	}
}
