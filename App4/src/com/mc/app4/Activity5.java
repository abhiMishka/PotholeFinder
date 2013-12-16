package com.mc.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity5 extends Activity {
	
	private static String note1;
	private ImageButton note_button;
	EditText et1;
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page5);
		et1 = (EditText) findViewById (R.id.editText1);
		
		note_button = (ImageButton) findViewById (R.id.imageButton1);
		note_button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				note1 = et1.getText().toString();
				// TODO Auto-generated method stub
				//Toast.makeText(Activity5.this, getnotes(), Toast.LENGTH_SHORT).show();
				if (MainActivity.DummySectionFragment2.rating == true) {
                	Intent a2 = new Intent ("android.intent.action.ACTIVITY6");
                	startActivity(a2);
                }
                else {
                	Intent a3 = new Intent ("android.intent.action.UPLOADACTIVITY");
                	startActivity(a3);
                }
			}
		});
	}
	public static String getnotes(){
		return note1;
	}
	
}
