package com.androm.dao;

import org.junit.Test;

import com.xtremelabs.robolectric.Robolectric;

public class SimpleDaoTest {

	@Test
	public void testSimpleDaoWithClasses() {
		new SimpleDao(Robolectric.application, "name", 2);
	}
}
