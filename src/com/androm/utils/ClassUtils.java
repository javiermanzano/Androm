package com.androm.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.androm.table.ColumnDefinition;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ClassUtils {
	
	public static List<ColumnDefinition> getColumnsDefinition(Class clazz) {
		ArrayList<Field> fields = Lists.newArrayList(clazz.getDeclaredFields());
		return Lists.newArrayList(Collections2.transform(fields, new Function<Field, ColumnDefinition>() {

			@Override
			public ColumnDefinition apply(Field field) {
				return new ColumnDefinition(field.getType(), field.getName(), Lists.newArrayList(field.getAnnotations()));
			}
		}));
	}

}
