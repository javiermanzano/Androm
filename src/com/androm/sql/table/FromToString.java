package com.androm.sql.table;

/**
 * All the columns  annotated with ToStringColumn must extend this interface
 * @author jmanzano
 *
 */
public interface FromToString<T> {
	
	public T fromToString(String toString);

}
