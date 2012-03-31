package com.androm.utils;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class PackageUtilsTest {

	
	@Test
	public void testGetClassesFromSimplePackage() {
		List<Class<?>> classes = PackageUtils.getClasses("com.androm.mock.simple");
		assertEquals(4, classes.size());
		
		List<String> classesNames = transformToClassesNames(classes); 
		assertEquals("Contact", classesNames.get(0));
		assertEquals("Product", classesNames.get(1));
		assertEquals("SuperSimpleProduct", classesNames.get(2));
		assertEquals("Team", classesNames.get(3));
	}
	
	@Test
	public void testGetClassesFromComplexPackage() {
		List<Class<?>> classes = PackageUtils.getClasses("com.androm.mock.complex");
		assertEquals(2, classes.size());
		
		List<String> classesNames = transformToClassesNames(classes);
		
		assertEquals("ProductInfo", classesNames.get(0));
		assertEquals("Order", classesNames.get(1));
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
