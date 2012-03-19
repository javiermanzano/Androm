package com.androm.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.androm.mock.simple.Product;
import com.androm.table.ColumnDefinition;
import com.androm.table.ColumnModifier;
import com.androm.table.ColumnType;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ClassUtilsTest {

	@Test
	public void testProductCreateTable() {
		List<ColumnDefinition> definitions = ClassUtils
				.getColumnsDefinition(Product.class);
		ColumnDefinition col1 = definitions.get(0);
		ColumnDefinition col2 = definitions.get(1);
		ColumnDefinition col3 = definitions.get(2);
		assertEquals("name", col1.getName());
		assertEquals(ColumnType.TEXT, col1.getType());
		assertEquals(Lists.newArrayList(ColumnModifier.NOT_NULL, ColumnModifier.DEFAULT), col1.getModifiers());

		assertEquals("price", col2.getName());
		assertEquals(ColumnType.REAL, col2.getType());
		assertEquals(Lists.newArrayList(ColumnModifier.NOT_NULL), col2.getModifiers());

		assertEquals("description", col3.getName());
		assertEquals(ColumnType.TEXT, col3.getType());
		assertEquals(Lists.newArrayList(), col3.getModifiers());
	}

	private List<String> getColumnsName(List<ColumnDefinition> colsDef) {
		return Lists.newArrayList(Collections2.transform(colsDef,
				new Function<ColumnDefinition, String>() {

					@Override
					public String apply(ColumnDefinition colDef) {
						return colDef.getName();
					}
				}));
	}

}
