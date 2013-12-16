package com.mc.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity3 extends Activity {
	
	private CheckBox image_check, note_check, rate_check;
	private ImageButton ok_button;
	
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		image_check = (CheckBox) findViewById(R.id.checkBox1);
		note_check = (CheckBox) findViewById(R.id.checkBox2);
		rate_check = (CheckBox) findViewById(R.id.checkBox3);
		ok_button = (ImageButton) findViewById(R.id.imageButton1);
	    
		ok_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				if (image_check.isChecked()) {
		        	Intent a1 = new Intent ("android.intent.action.ACTIVITY2");
		        	startActivity(a1);
		        }
				*/
		        if (note_check.isChecked()) {
		        	Toast.makeText(Activity3.this,"Here 1", Toast.LENGTH_SHORT).show();
		        	
		        	//Intent a2 = new Intent ("android.intent.action.ACTIVITY5");
		        	//startActivity(a2);
		        }
		        /*
		        if (rate_check.isChecked()) {
		        	Intent a3 = new Intent ("android.intent.action.ACTIVITY6");
		        	startActivity(a3);
		        }
		        */
			}
		});   
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
