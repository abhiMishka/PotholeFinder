package com.mc.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity1 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page1);
		
		//Button b1, b2;
		ImageButton b1, b2;
		b1 = (ImageButton) findViewById (R.id.imageButton1);
		b2 = (ImageButton) findViewById (R.id.imageButton2);
		
		b1.setOnClickListener(new View.OnClickListener() {
			 
            public void onClick(View arg0) {
                //Starting a new Intent
            	
                Intent nextScreen = new Intent("android.intent.action.SHOWMAP_ACTIVITY");
                startActivity(nextScreen);
                /*
            	Intent nextScreen = new Intent("android.intent.action.IMAGE_ACTIVITY");
                startActivity(nextScreen);
                */
            }
        });
		
		b2.setOnClickListener(new View.OnClickListener() {
			 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent("android.intent.action.MAINACTIVITY");
            	//Intent nextScreen = new Intent("android.intent.action.FBLOGIN");
                startActivity(nextScreen); 
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
