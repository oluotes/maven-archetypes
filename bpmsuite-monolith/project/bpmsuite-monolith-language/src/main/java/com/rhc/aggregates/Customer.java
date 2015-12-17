package com.rhc.aggregates;

import java.io.Serializable;

import com.rhc.entities.Address;

public class Customer implements Serializable{

	private String firstName;
	private String lastName;
	private Address address;
	
	public Customer (String firstname, String lastname){
		this.firstName=firstname;
		this.lastName=lastname;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}

	
}
