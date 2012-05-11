package com.androm.dao;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.androm.sql.PersistenceModule;
import com.google.common.collect.Lists;

/**
 * Helper for Androm database
 * 
 * @author jmanzano
 */
public class AndromOpenHelper extends SQLiteOpenHelper {
	
	/** Persistence module to help with table creation */
	private PersistenceModule persistenceModule = PersistenceModule
			.getInstance();

	/** Classes that are being persisted */
	private static List<Class<?>> classes = Lists.newArrayList();
	
	public AndromOpenHelper(Context context, List<Class<?>> classes, String name, int version) {
		super(context, name, null, version);
		this.classes = classes;
	}

	public AndromOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	/**
	 * Create the tables from the classes retrieved
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {
		List<String> statements = persistenceModule.createTableFrom(classes);
		for (String sql : statements) {
			database.execSQL(sql);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {

	}
	
	public List<Class<?>> getClasses() {
		return classes;
	}

}