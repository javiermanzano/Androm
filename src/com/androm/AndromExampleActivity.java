package com.androm;

import com.androm.mock.simple.Contact;
import com.androm.mock.simple.Product;
import com.androm.mock.simple.SuperSimpleProduct;
import com.androm.openhelper.AndromHandler;
import com.google.common.collect.Lists;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class AndromExampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		AndromHandler andromHandler = new AndromHandler(
				getApplicationContext(), "DATABASE", 1, Lists.newArrayList(
						Product.class, Contact.class, SuperSimpleProduct.class));
		SQLiteDatabase database = andromHandler.getDatabase();
	}
}