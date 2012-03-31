package com.androm.mock.simple;


public class SuperSimpleProduct  {

	/** name */
	private String name;
	
	/** price */
	private Double price;

	/** description */
	private String description;
	
	
	public SuperSimpleProduct (String name, Double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
