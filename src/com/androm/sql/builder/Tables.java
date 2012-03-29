package com.androm.sql.builder;

import java.util.List;

import com.androm.table.ColumnDefinition;
import com.androm.utils.ClassUtils;
import com.google.common.collect.Lists;

/**
 * @author jmanzano
 *
 */
public class Tables {
	
	/** Column's name */
	List<ColumnDefinition> columns = Lists.newArrayList();
	
	public Tables createTable(Class<?> clazz) {
		columns = ClassUtils.getColumnsDefinition(clazz);
		return null;
	}
		
	

	
}
