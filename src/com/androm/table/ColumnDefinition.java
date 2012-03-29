package com.androm.table;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import android.provider.SyncStateContract.Columns;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 
 * Column definition with its class, name and modifiers
 * 
 * @author jmanzano
 * 
 */
public class ColumnDefinition {

	/** Column's class */
	private ColumnType type;

	/** Column's name */
	private String name;

	/** Column's modifier */
	private List<ColumnModifier> modifiers = Lists.newArrayList();
	
	public ColumnDefinition(ColumnType type, String name, List<ColumnModifier> modifiers) {
		this.type = type;
		this.name = name;
		this.modifiers = modifiers;
	}
	
	public ColumnDefinition(Class clazz, String name, List<Annotation> annotations) {
		final TableMapper mapper = TableMapper.getInstance();
		this.type = mapper.toColumnType(clazz);
		this.name = name;
		this.modifiers = Lists.newArrayList(Collections2.transform(annotations, new Function<Annotation, ColumnModifier>() {
			@Override
			public ColumnModifier apply(Annotation annotation) {
				return mapper.toModifier(annotation.annotationType());
			}
		}));
		
	}
	
	public boolean hasModifiers() {
		return modifiers.size() != 0;
	}
	
	public ColumnType getType() {
		return type;
	}

	public void setType(ColumnType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ColumnModifier> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<ColumnModifier> modifiers) {
		this.modifiers = modifiers;
	}

	
	@Override
	public String toString() {
		return type + " " + name + " (" + modifiers + ")";
	}
}
