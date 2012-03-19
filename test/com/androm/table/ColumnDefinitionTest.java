package com.androm.table;

import org.junit.Test;

public class ColumnDefinitionTest {
	
	@Test
	public void testColumnDef() {
		ColumnDefinition columnDefinition = new ColumnDefinition(String.class, "nombre", null);
		System.out.println(columnDefinition);
	}

}
