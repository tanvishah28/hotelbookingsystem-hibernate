package com.entlogics.hotelbookingsystem.dto;

import java.util.Arrays;

//this LinkService DTO has service_id property of service entity & getters and setters
public class LinkServiceDTO {

	// define the fields
	private int[] service_id;

	public int[] getService_id() {
		return service_id;
	}

	public void setService_id(int[] service_id) {
		this.service_id = service_id;
	}

	@Override
	public String toString() {
		return "LinkServiceDTO [service_id=" + Arrays.toString(service_id) + "]";
	}
}
