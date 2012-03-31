package com.androm.sql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.androm.mock.complex.ProductInfo;
import com.androm.mock.simple.Product;
import com.androm.mock.simple.SuperSimpleProduct;


public class AndromHelperTest {
	
	private PersistenceModule table = PersistenceModule.getInstance();
	
	@Test
	public void testSuperSimpleTableCreation() {
		String sql = table.createTableFrom(SuperSimpleProduct.class);
		assertEquals("CREATE TABLE SuperSimpleProduct(name TEXT,price REAL,description TEXT);", sql);
	}
	
	@Test
	public void testSimpleTableCreation() {
		String sql = table.createTableFrom(Product.class);
		assertEquals("CREATE TABLE Product(name TEXT NOT NULL ,price REAL NOT NULL,description TEXT);", sql);
	}

	public void testComplexTableCreation() {
		String sql = table.createTableFrom(ProductInfo.class);
		assertEquals("CREATE TABLE", sql);
	}

}
