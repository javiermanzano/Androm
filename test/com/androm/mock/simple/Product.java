package com.androm.mock.simple;

import com.androm.annotations.Default;
import com.androm.annotations.NotNull;

public class Product {

	/** name */
	@NotNull
	@Default(value="defaultName")
	private String name;
	
	/** price */
	@NotNull
	private Double price;
	

	/** description */
	private String description;
	
	
	public Product(String name, Double price, String description) {
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
