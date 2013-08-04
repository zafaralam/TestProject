package com.zafaralam.test;

import com.zafaralam.test.FeedReaderContract.FeedEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FeedReaderDbHelper extends SQLiteOpenHelper{

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "FeedReader.db";
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
		    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
		    FeedEntry._ID + " INTEGER PRIMARY KEY," +
		    FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
		    FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
		    // Any other options for the CREATE command
		    " )";

		private static final String SQL_DELETE_ENTRIES =
		    "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
	
	
	public FeedReaderDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_ENTRIES);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
		
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		onUpgrade(db, oldVersion, newVersion);
	}
	
	
	

}
