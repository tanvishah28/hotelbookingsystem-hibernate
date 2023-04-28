package com.entlogics.hotelbookingsystem.dto;

import java.sql.Date;
import java.util.List;

import com.entlogics.hotelbookingsystem.entity.Booking_Status;
import com.fasterxml.jackson.annotation.JsonFormat;

//this is Booking Data Transfer Object (DTO) Class with just properties of Booking & getters and setters
public class BookingDTO {

	private int booking_id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date booking_dateTime;

	private double booking_amt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date check_in_DateTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date check_out_DateTime;

	private Integer no_of_adults;

	private Integer no_of_child;

	private Booking_Status booking_status;
	
	private int hotel_id;

	private int customer_id;
	
	private String customer_name;

	private int room_id;
	
	private int room_no;

	private int employee_id;
	
	private String emp_name;

	private int bill_id;
	
	private List<Integer> services;

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBooking_dateTime() {
		return booking_dateTime;
	}

	public void setBooking_dateTime(Date booking_dateTime) {
		this.booking_dateTime = booking_dateTime;
	}

	public double getBooking_amt() {
		return booking_amt;
	}

	public void setBooking_amt(double booking_amt) {
		this.booking_amt = booking_amt;
	}

	public Date getCheck_in_DateTime() {
		return check_in_DateTime;
	}

	public void setCheck_in_DateTime(Date check_in_DateTime) {
		this.check_in_DateTime = check_in_DateTime;
	}

	public Date getCheck_out_DateTime() {
		return check_out_DateTime;
	}

	public void setCheck_out_DateTime(Date check_out_DateTime) {
		this.check_out_DateTime = check_out_DateTime;
	}

	public Integer getNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(Integer no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public Integer getNo_of_child() {
		return no_of_child;
	}

	public void setNo_of_child(Integer no_of_child) {
		this.no_of_child = no_of_child;
	}

	public Booking_Status getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(Booking_Status booking_status) {
		this.booking_status = booking_status;
	}

	public List<Integer> getServices() {
		return services;
	}

	public void setServices(List<Integer> services) {
		this.services = services;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		return "BookingDTO [booking_id=" + booking_id + ", booking_dateTime=" + booking_dateTime + ", booking_amt="
				+ booking_amt + ", check_in_DateTime=" + check_in_DateTime + ", check_out_DateTime="
				+ check_out_DateTime + ", no_of_adults=" + no_of_adults + ", no_of_child=" + no_of_child
				+ ", booking_status=" + booking_status + ", hotel_id=" + hotel_id + ", customer_id=" + customer_id
				+ ", customer_name=" + customer_name + ", room_id=" + room_id + ", room_no=" + room_no
				+ ", employee_id=" + employee_id + ", emp_name=" + emp_name + ", bill_id=" + bill_id + "]";
	}	
}
