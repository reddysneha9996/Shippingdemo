package com.demo.shipping.model;

public class Address {
    private String companyName;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String countryCode;
    private String state;
    private String postalCode;
    private String attention;
    private String email;
    private String phone;
    private String instructions;
    private boolean residential;
    private boolean notify;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public boolean isResidential() {
		return residential;
	}
	public void setResidential(boolean residential) {
		this.residential = residential;
	}
	public boolean isNotify() {
		return notify;
	}
	public void setNotify(boolean notify) {
		this.notify = notify;
	}
	@Override
	public String toString() {
		return "Address [companyName=" + companyName + ", streetAddress=" + streetAddress + ", streetAddress2="
				+ streetAddress2 + ", city=" + city + ", countryCode=" + countryCode + ", state=" + state
				+ ", postalCode=" + postalCode + ", attention=" + attention + ", email=" + email + ", phone=" + phone
				+ ", instructions=" + instructions + ", residential=" + residential + ", notify=" + notify + "]";
	}
	
	
}

