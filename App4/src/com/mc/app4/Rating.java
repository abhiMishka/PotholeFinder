package com.mc.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends Activity {
	
	private RatingBar rate1;
	private static float rating1;
	private ImageButton rate_button;
	
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rating);
		rate1 = (RatingBar) findViewById(R.id.ratingBar1);
		rate_button = (ImageButton) findViewById (R.id.imageButton1);
		
		rate_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rating1 = rate1.getRating();
				//Toast.makeText(Activity6.this, Float.toString(getrate()), Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				/*
				Intent returnIntent = new Intent();
     	        returnIntent.putExtra("result",rating1);
     	        setResult(RESULT_OK,returnIntent); 	    
     	        finish();
				*/
				
                	Intent a3 = new Intent ("android.intent.action.UPLOADACTIVITY");
                	startActivity(a3);
                
		        
			}
		});
		
	}
	public static float getrate(){
		//String ratew = String.valueOf(rating1);
		return rating1;
	}

}
