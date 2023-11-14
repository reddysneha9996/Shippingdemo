package com.demo.shipping.model;

import java.util.List;

public class ShippingRequest {
    private Address from;
    private Address to;
    private String packageType;
    private String unitOfMeasurement;
    private List<String> serviceOptions;
    private String shipDate;
    private String insuranceType;
    private List<LineItem> lineItems;
    
	public Address getFrom() {
		return from;
	}
	public void setFrom(Address from) {
		this.from = from;
	}
	public Address getTo() {
		return to;
	}
	public void setTo(Address to) {
		this.to = to;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
	public List<String> getServiceOptions() {
		return serviceOptions;
	}
	public void setServiceOptions(List<String> serviceOptions) {
		this.serviceOptions = serviceOptions;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	@Override
	public String toString() {
		return "ShippingRequest [from=" + from + ", to=" + to + ", packageType=" + packageType + ", unitOfMeasurement="
				+ unitOfMeasurement + ", serviceOptions=" + serviceOptions + ", shipDate=" + shipDate
				+ ", insuranceType=" + insuranceType + "]";
	}
	
	
}
