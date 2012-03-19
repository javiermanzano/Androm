package com.androm.table;

import java.util.Date;
import java.util.Map;

import com.androm.annotations.Default;
import com.androm.annotations.NotNull;
import com.androm.annotations.PrimaryKey;
import com.androm.exception.UnsupportedColumnTypeException;
import com.androm.exception.UnsupportedModifierException;
import com.google.common.collect.Maps;

public class TableMapper {

	private static Map<Class, ColumnType> columnMapper;
	
	private static Map<Class, ColumnModifier> modifierMapper;
	
	private static TableMapper INSTANCE;
	
	static {
		columnMapper = Maps.newHashMap();
		columnMapper.put(String.class, ColumnType.TEXT);
		columnMapper.put(Integer.class, ColumnType.INTEGER);
		columnMapper.put(Double.class, ColumnType.REAL);
		columnMapper.put(Float.class, ColumnType.REAL);
		columnMapper.put(Boolean.class, ColumnType.INTEGER);
		columnMapper.put(Date.class, ColumnType.TEXT);
		modifierMapper = Maps.newHashMap();
		modifierMapper.put(NotNull.class, ColumnModifier.NOT_NULL);
		modifierMapper.put(PrimaryKey.class, ColumnModifier.PRIMARY_KEY);
		modifierMapper.put(Default.class, ColumnModifier.DEFAULT);
	}
	
	
	private TableMapper() { }
	
	public static TableMapper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TableMapper();
		}
		return INSTANCE;
	}
	
	public ColumnType toColumnType(Class clazz) {
		ColumnType type = columnMapper.get(clazz);
		if (type == null) {
			throw new UnsupportedColumnTypeException();
		}
		return type;
	}
	
	public ColumnModifier toModifier(Class annotation) {
		ColumnModifier modifier = modifierMapper.get(annotation);
		if (modifier == null) {
			throw new UnsupportedModifierException();
		}
		return modifier;
		
	}
}
