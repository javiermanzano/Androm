package com.androm.sql;


import java.util.List;

import android.R.string;

import com.androm.table.ColumnDefinition;
import com.androm.table.ColumnModifier;
import com.androm.utils.*;
import com.google.common.collect.Lists;



/**
 * 
 * From this class you could create a sql statement to create a table
 * 
 * @author javiermanzanomorilla
 *
 */
public class PersistenceModule {
	
	private static PersistenceModule INSTANCE = null;
	
	private PersistenceModule() { }
	
	public static PersistenceModule getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersistenceModule();
		}
		return INSTANCE;
	}


	/**
	 * Create the statme from a given class list
	 * @param classes Classes list to be persisted
	 * @return SQL statements to create the tables
	 */
	public List<String> createTableFrom(List<Class<?>> classes) {
		List<String> statements = Lists.newArrayList();
		for (Class<?> clazz : classes) {
			statements.add(createTableFrom(clazz));
		}
		return statements;
	}

	/**
	 * Create the statement from a given class
	 * @param clazz Class to be persisted
	 * @return SQL statements to create the table
	 * 
	 */
	// TODO
	public String createTableFrom(Class<?> clazz) {
		StringBuilder sb =new StringBuilder();
		String clazzName = clazz.getSimpleName();
		List<ColumnDefinition> columnDefinitions = ClassUtils.getColumnsDefinition(clazz);

		sb.append("CREATE TABLE " + clazzName + "(");
		for (ColumnDefinition columnDefinition : columnDefinitions) {
			sb.append(columnDefinition.getName() + " " + columnDefinition.getType().toString());
			if (columnDefinition.hasModifiers()) {
				for (ColumnModifier modifier : columnDefinition.getModifiers()) {
					sb.append(" " + modifier.getModifierName());
				}
			}
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(");");

		return sb.toString();
	}
	

}
