package com.androm.dao;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.androm.sql.PersistenceModule;
import com.androm.utils.ClassUtils;
import com.androm.utils.PackageUtils;
import com.google.common.collect.Lists;

public class SimpleDao {

	/** Helper for Database creating, upgrading and deleting handling */
	private AndromOpenHelper andromHelper;

	
	/**
	 * Constructor to use with a list of packages to explore
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 * @param packages Packages list to explore
	 */
	public SimpleDao(Context context, String name, int version, String... packages) {
		List<Class<?>> classes = PackageUtils.getClasses(packages);
		andromHelper = new AndromOpenHelper(context, classes, name, version);
	}


	/**
	 * Constructor to use with a List of classes
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 * @param classes Classes to persist
	 */
	public SimpleDao(Context context, String name, int version, List<Class<?>> classesToPersist) {
		andromHelper = new AndromOpenHelper(context, classesToPersist, name,  version);
	}
	
	/**
	 * Simple constructor
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 */
	public SimpleDao(Context context, String name, int version) {
		andromHelper = new AndromOpenHelper(context, name, null, version);
	}

	
	/**
	 * Get the database
	 * @return database
	 */
	public SQLiteDatabase getDatabase() {
		return andromHelper.getWritableDatabase();
	}
	

	

}
