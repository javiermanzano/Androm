package com.androm.mock.complex.subpackage;

import java.util.List;
import com.androm.mock.complex.ProductInfo;

public class Order {

	private List<ProductInfo> productsInfo;
	
	private long id;

	public List<ProductInfo> getProductsInfo() {
		return productsInfo;
	}

	public void setProductsInfo(List<ProductInfo> productsInfo) {
		this.productsInfo = productsInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
}
