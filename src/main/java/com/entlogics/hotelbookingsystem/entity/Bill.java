package com.entlogics.hotelbookingsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This entity class maps to bill table in hoteldb using hibernate 

@Entity
@Table(name="bill")
public class Bill {

	// Defining the fields & annotate the fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_id")
	private int bill_id;

	@Column(name="bill_number")
	private int bill_number;

	@Column(name="bill_amt")
	private float bill_amt;

	@Column(name="bill_DateTime")
	private Date bill_dateTime;

	@Column(name="discount")
	private String discount;

	@Column(name="bill_reward_points")
	private int bill_reward_points;
	
	//enum bill_status { PAID, NOT_PAID, PARTIALLY_PAID; }

	@Column(name="bill_status")
	@Enumerated(EnumType.STRING)
	private Bill_Status bill_status;
	
//	enum payment_method {	CASH, DEBIT, CREDIT; }
	
	@Column(name="payment_method")
	@Enumerated(EnumType.STRING)
	private Payment_Method payment_method;

	// no-arg constructor
	
	public Bill() {
		super();
	}

	// Constructor for Bill entity
	public Bill(int bill_number, float bill_amt) {
		super();
		this.bill_number = bill_number;
		this.bill_amt = bill_amt;
	}

	// Generated getters and setters

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public float getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(float bill_amt) {
		this.bill_amt = bill_amt;
	}

	public Date getBill_dateTime() {
		return bill_dateTime;
	}

	public void setBill_dateTime(Date bill_dateTime) {
		this.bill_dateTime = bill_dateTime;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getBill_reward_points() {
		return bill_reward_points;
	}

	public void setBill_reward_points(int bill_reward_points) {
		this.bill_reward_points = bill_reward_points;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", bill_number=" + bill_number + ", bill_amt=" + bill_amt
				+ ", bill_dateTime=" + bill_dateTime + ", discount=" + discount + ", bill_reward_points="
				+ bill_reward_points + "]";
	}
}
