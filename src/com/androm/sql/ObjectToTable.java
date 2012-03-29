package com.androm.sql;


import java.util.List;

import com.androm.table.ColumnDefinition;
import com.androm.table.ColumnModifier;
import com.androm.utils.*;



/**
 * 
 * From this class you could create a sql statement to create a table
 * 
 * @author javiermanzanomorilla
 *
 */
public class ObjectToTable {
	
	private static ObjectToTable INSTANCE = null;
	
	private ObjectToTable() { }
	
	public static ObjectToTable getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ObjectToTable();
		}
		return INSTANCE;
	}
	

	/**
	 * Create the statement from a given class
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
