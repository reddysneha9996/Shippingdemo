package com.demo.shipping.model;

public class LineItem {
    private double length;
    private double width;
    private double height;
    private double weight;
    private DeclaredValue declaredValue;
    private String description;
    private String nmfcCode;
    private String freightClass;
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public DeclaredValue getDeclaredValue() {
		return declaredValue;
	}
	public void setDeclaredValue(DeclaredValue declaredValue) {
		this.declaredValue = declaredValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNmfcCode() {
		return nmfcCode;
	}
	public void setNmfcCode(String nmfcCode) {
		this.nmfcCode = nmfcCode;
	}
	public String getFreightClass() {
		return freightClass;
	}
	public void setFreightClass(String freightClass) {
		this.freightClass = freightClass;
	}
}
