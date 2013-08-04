package com.zafaralam.test;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btnClosePopup;
	Button btnCreatePopup;
	TextView tvCustomFont;
	TextView vIconView;
	TextView vIconView1;
	TextView vIconView2;
	TextView vIconView3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		tvCustomFont = (TextView) findViewById(R.id.textView1);
		vIconView = (TextView) findViewById(R.id.vIconView);
		vIconView1 = (TextView) findViewById(R.id.vIconView1);
		vIconView2 = (TextView) findViewById(R.id.vIconView2);
		vIconView3 = (TextView) findViewById(R.id.vIconView3);
		
		/*
		GPSTracker gps = new GPSTracker(getApplicationContext());
		
		if(gps.canGetLocation){
			tvCustomFont.setText("Lat: " + gps.getLatitude() + "\n" + "Lng: " + gps.getLongitude());
		}else
		{
			tvCustomFont.setText("Loaction Not available.");
		}
		*/
		//For pie chart activity.
		 /*Resources res = getResources();

	        setContentView(R.layout.main);
	        final PieChart pie = (PieChart) this.findViewById(R.id.Pie);
	        pie.addItem("Agamemnon", 2, res.getColor(R.color.seafoam));
	        pie.addItem("Bocephus", 3.5f, res.getColor(R.color.chartreuse));
	        pie.addItem("Calliope", 2.5f, res.getColor(R.color.emerald));
	        pie.addItem("Daedalus", 3, res.getColor(R.color.bluegrass));
	        pie.addItem("Euripides", 1, res.getColor(R.color.turquoise));
	        pie.addItem("Ganymede", 3, res.getColor(R.color.slate));

	        ((Button) findViewById(R.id.Reset)).setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	                pie.setCurrentItem(0);
	            }
	        });*/
	        
				
		//Typeface font = Typeface.createFromAsset(getAssets(), "meteocons-webfont.ttf");
		Typeface font = Typeface.createFromAsset(getAssets(), "iconvault_forecastfont.ttf");
		vIconView.setTypeface(font);
		vIconView.setText(R.string.base_cloud);
		vIconView.setTextColor(getResources().getColor((android.R.color.darker_gray)));
		
		vIconView1.setTypeface(font);
		vIconView1.setText(R.string.drizzle);
		vIconView1.setTextColor(getResources().getColor((android.R.color.holo_blue_dark)));
		
		vIconView2.setTypeface(font);
		vIconView2.setText(R.string.sunny);//"\uf101"
		vIconView2.setTextColor(getResources().getColor((android.R.color.holo_orange_dark)));
		
//		vIconView.setTextSize(getResources().getDimension(R.dimen.textsize));
		vIconView3.setTypeface(font);
		vIconView3.setText("\uf100 \uf101 \uf102 \uf103  \uf104  \uf105  \uf106  \uf107" +
				" \uf108  \uf109  \uf110  \uf111  \uf112  \uf113  \uf114  \uf115 \uf10a \uf10b \uf10c \uf10d \uf10e \uf10f");
		vIconView3.setTypeface(font);
		btnCreatePopup = (Button) findViewById(R.id.button1);
		btnCreatePopup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initiatePopupWindow();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private PopupWindow pwindo;

	private void initiatePopupWindow() {
		try {
			
			DisplayMetrics metrics = getResources().getDisplayMetrics();
			int width = metrics.widthPixels;
			int height = metrics.heightPixels;
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) MainActivity.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.screen_popup,
					(ViewGroup) findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout,  width, height, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

			btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
			btnClosePopup.setOnClickListener(cancel_button_click_listener);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private OnClickListener cancel_button_click_listener = new OnClickListener() {
		public void onClick(View v) {
			pwindo.dismiss();

		}
	};

}
