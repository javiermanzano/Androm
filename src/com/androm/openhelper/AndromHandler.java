package com.androm.openhelper;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.androm.sql.PersistenceModule;
import com.androm.utils.ClassUtils;
import com.androm.utils.PackageUtils;
import com.google.common.collect.Lists;

public class AndromHandler {

	/** Helper for Database creating, upgrading and deleting handling */
	private AndromOpenHelper andromHelper;

	/** Classes that are being persisted */
	private static List<Class<?>> classes = Lists.newArrayList();
	
	/** Persistence module to help with table creation */
	private static PersistenceModule persistenceModule = PersistenceModule.getInstance();

	/**
	 * Constructor to use with a list of packages to explore
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 * @param packages Packages list to explore
	 */
	public AndromHandler(Context context, String name, int version, String... packages) {
		classes = PackageUtils.getClasses(packages);
		andromHelper = new AndromOpenHelper(context, name, null, version);
	}


	/**
	 * Constructor to use with a List of classes
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 * @param classes Classes to persist
	 */
	public AndromHandler(Context context, String name, int version, List<Class<?>> classesToPersist) {
		classes = Lists.newArrayList(classesToPersist);
		andromHelper = new AndromOpenHelper(context, name, null, version);
	}
	
	/**
	 * Simple constructor
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 */
	public AndromHandler(Context context, String name, int version) {
		andromHelper = new AndromOpenHelper(context, name, null, version);
	}

	
	/**
	 * Get the database
	 * @return database
	 */
	public SQLiteDatabase getDatabase() {
		return andromHelper.getWritableDatabase();
	}
	

	/**
	 * Helper for Androm database
	 * 
	 * @author jmanzano
	 */
	private static class AndromOpenHelper extends SQLiteOpenHelper {
		
		public AndromOpenHelper(Context context, String name, int version) {
			super(context, name, null, version);
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
		
		
	}

}
