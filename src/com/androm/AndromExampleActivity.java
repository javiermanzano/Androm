package com.androm;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.androm.dao.SimpleDao;
import com.androm.mock.simple.Contact;
import com.androm.mock.simple.Product;
import com.androm.mock.simple.SuperSimpleProduct;
import com.google.common.collect.Lists;

public class AndromExampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SimpleDao andromHandler = new SimpleDao(
				getApplicationContext(),  Lists.newArrayList(
						Product.class, Contact.class, SuperSimpleProduct.class), "DATABASE", 1);
		SQLiteDatabase database = andromHandler.getDatabase();
	}
}