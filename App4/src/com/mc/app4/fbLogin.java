package com.mc.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

public class fbLogin extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fblogin);
		
		 Button cameraButton = (Button) findViewById(R.id.button1);
         cameraButton.setOnClickListener(this);
		 // start Facebook Login
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 Session.openActiveSession(this, true, new Session.StatusCallback() {

			    // callback when session changes state
			    @Override
			    public void call(Session session, SessionState state, Exception exception) {

			    	if (session.isOpened()) {
			    		// make request to the /me API
			    		Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

			    		  // callback after Graph API response with user object
			    		  @Override
			    		  public void onCompleted(GraphUser user, Response response) {
			    			  if (user != null) {
			    					
			    				// MainActivity.message=user.getName();
			    				 Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
			                  		startActivity(nextScreen);
			    				  
			    				}
			    		  }
			    		});
			    	}
			    	
			    }
			  });
		
	}

}