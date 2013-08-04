package com.zafaralam.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class WeatherIconView  extends TextView{
	
	private Paint outlineColor;
	private String[] iconCodes;
	private int[] colors;
	//private Typeface typeface;

	public WeatherIconView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	public WeatherIconView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public WeatherIconView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}
	
	protected void init(){
		setFocusable(true);
		//typeface = Typeface.createFromAsset(getAssets(), "iconvault_forecastfont.ttf");
		outlineColor = new Paint(Paint.ANTI_ALIAS_FLAG);
		this.iconCodes = new String[]{
				"\uf113"
		};
		
		this.setTextSize(getResources().getDimension(R.dimen.textsize));
		
		this.colors = new int[] {R.color.Yellow};
		
	}

	public Paint getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Paint outlineColor) {
		this.outlineColor = outlineColor;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		//super.onDraw(canvas);
		for(int i=0;i<this.iconCodes.length;i++){
			outlineColor.setColor(this.colors[i]);
			this.setText(this.iconCodes[i]);
			this.setTextColor(colors[i]);
			//canvas.drawText(this.iconCodes[i], 0, 0, outlineColor);
		}
		
		canvas.save();
		super.onDraw(canvas);
		canvas.restore();
	}
	
	public void changeWeatherIcon(String[] iconCode,int[] colors)
	{
		
	}
}
