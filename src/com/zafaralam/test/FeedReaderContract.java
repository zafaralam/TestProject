package com.zafaralam.test;

import android.provider.BaseColumns;

public final class FeedReaderContract {
	
	public FeedReaderContract () {}
	
	
	/*Below is a subclass that defines the column names*/
	public static abstract class FeedEntry implements BaseColumns {
		public static final String TABLE_NAME = "entry";
		public static final String COLUMN_NAME_ENTRY_ID = "entryid";
		public static final String COLUMN_NAME_TITLE = "title";
		public static final String COLUMN_NAME_SUBTITLE = "subtitle";
	}
}
