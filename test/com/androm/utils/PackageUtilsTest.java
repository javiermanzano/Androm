package com.androm.utils;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class PackageUtilsTest {

	public static final String SIMPLE_PACKAGE = "com.androm.mock.simple";
	
	public static final String COMPLEX_PACKAGE = "com.androm.mock.complex";
	
	@Test
	public void testGetClassesFromSimplePackage() {
		List<Class<?>> classes = PackageUtils.getClasses(SIMPLE_PACKAGE);
		assertEquals(4, classes.size());
		
		List<String> classesNames = transformToClassesNames(classes); 
		assertEquals("Contact", classesNames.get(0));
		assertEquals("Product", classesNames.get(1));
		assertEquals("SuperSimpleProduct", classesNames.get(2));
		assertEquals("Team", classesNames.get(3));
	}
	
	@Test
	public void testGetClassesFromComplexPackage() {
		List<Class<?>> classes = PackageUtils.getClasses(COMPLEX_PACKAGE);
		assertEquals(2, classes.size());
		
		List<String> classesNames = transformToClassesNames(classes);
		assertEquals("ProductInfo", classesNames.get(0));
		assertEquals("Order", classesNames.get(1));
	}
	
	@Test
	public void testGetClassesFromPackagesList() {
		List<Class<?>> classes = PackageUtils.getClasses(SIMPLE_PACKAGE, COMPLEX_PACKAGE);
		assertEquals(6, classes.size());
		
		List<String> classesNames = transformToClassesNames(classes);
		assertEquals("Contact", classesNames.get(0));
		assertEquals("Product", classesNames.get(1));
		assertEquals("SuperSimpleProduct", classesNames.get(2));
		assertEquals("Team", classesNames.get(3));
		assertEquals("ProductInfo", classesNames.get(4));
		assertEquals("Order", classesNames.get(5));
	}
	
	@Test
	// TODO
	public void testGetClassesFromPackageWithTransient() {
		
	}
	
	private List<String> transformToClassesNames(List<Class<?>> classes) {
		return Lists.newArrayList(Collections2.transform(classes, new Function<Class<?>, String>() {
			
			@Override
			public String apply(Class<?> clazz) {
				return clazz.getSimpleName();
			};
		}));
	}
	
}
