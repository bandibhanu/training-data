package com.cg.rest.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String flatNo;
	private String name;
	private String street;
	private String city;
	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", name=" + name + ", street=" + street + ", city=" + city + ", pinCode="
				+ pinCode + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	private String pinCode;

	
}
