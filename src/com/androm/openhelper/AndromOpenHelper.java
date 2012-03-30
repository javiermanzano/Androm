package com.androm.openhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AndromOpenHelper extends SQLiteOpenHelper {


	/**
	 * Constructor to use with a list of packages to explore
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 * @param packages Packages list to explore
	 */
	public AndromOpenHelper(Context context, String name, int version, String... packages) {
		super(context, name, null, version);
	}
	
	/**
	 * Simple constructor
	 * @param context Application context
	 * @param name Database name
	 * @param version Database version
	 */
	public AndromOpenHelper(Context context, String name, int version) {
		super(context, name, null, version);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
