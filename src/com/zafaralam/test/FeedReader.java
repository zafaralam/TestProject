package com.zafaralam.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FeedReader {
	
	private Context context;
	private FeedReaderDbHelper mDbHelper;
	
	
	public FeedReader(Context context) {
		super();
		this.context = context;
		mDbHelper = new FeedReaderDbHelper(this.context);
	}
	
	public long insert(String table,String nullColumnHack,ContentValues values){
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		
		long newRowId;
		newRowId = db.insert(table, nullColumnHack, values);
		
		return newRowId;
	}
	
	public Cursor query(String table,String[] projection,String selection,String[] selectionArgs,
			String groupBy,String having,String sortOrder){
		
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		
		Cursor cursor;
		cursor = db.query(
			    table,  			// The table to query
			    projection,         // The columns to return
			    selection,          // The columns for the WHERE clause
			    selectionArgs,      // The values for the WHERE clause
			    groupBy,            // don't group the rows
			    having,             // don't filter by row groups
			    sortOrder           // The sort order
			    );
		return cursor;
	}
	
	public int delete(String table,String whereClause, String[] whereArgs){
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		
		int count;
		count = db.delete(table, whereClause, whereArgs);
		
		return count;
	}
	
	public int update(String table, ContentValues values,String whereClause,String[] whereArgs){
		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		
		int count;
		count = db.update(table, values, whereClause, whereArgs);
		
		return count;
	}
	

}
