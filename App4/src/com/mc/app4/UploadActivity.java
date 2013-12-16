package com.mc.app4;

import java.io.ByteArrayOutputStream;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class UploadActivity extends Activity implements OnClickListener {
	
	private ParseFile photoFile;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_upload);
       
        // Add your initialization code here
		Parse.initialize(this, "uFwoSCU42NKWz1hxvQHqPjrCxxJdkXcREOYsAEyu", "KjJIMTP5UY32FVo6yTw1ONk9Icl40DO7fSIuEPVk");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

         ImageButton sendButton = (ImageButton) findViewById(R.id.imageButton1);
         sendButton.setOnClickListener(this);
    }


	@Override
		public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		// Locate the image in res > drawable-hdpi
				//String pathName=clickPhoto.getImagePath();
				//String pathName=Activity2.getImagePath();
				//String imageName=Activity2.getImageName();
				String line=Activity4.getCoordinates();
				String noteret = Activity5.getnotes();
				float rateret = Activity6.getrate();
				//Bitmap bitmap = BitmapFactory.decodeFile(pathName);
						//decodeResource(getResources(),
					//	R.drawable.androidbegin);
				// Convert it to byte
				//ByteArrayOutputStream stream = new ByteArrayOutputStream();
				// Compress image to lower quality scale 1 - 100
				//bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
				//byte[] image = stream.toByteArray();

				// Create the ParseFile
				//ParseFile file = new ParseFile(imageName, image);
				
				// Upload the image into Parse Cloud
				//file.saveInBackground();

				// Create a New Class called "ImageUpload" in Parse
				ParseObject imgupload = new ParseObject("ImageUpload");
				
				// Create a column named "ImageName" and set the string
				//imgupload.put("ImageName", imageName);
				
				// Create a column named "ImageFile" and insert the image
				//imgupload.put("ImageFile", file);
				
				
				imgupload.put("Coordinates", line);
				if (MainActivity.DummySectionFragment2.rating == true) {
				imgupload.put("Rating", rateret);
				}
				if (MainActivity.DummySectionFragment2.noting == true) {
				imgupload.put("Comment", noteret);
				}
				
				if (MainActivity.DummySectionFragment2.images == true) {
					
				
				//ParseObject imgupload = new ParseObject("ImageUpload");
                photoFile = new ParseFile("pothole.jpg", Image_activity.getimage());
                
                imgupload.put("ImageFile", photoFile);
                //imgupload.saveInBackground();
				
				// Create the class and the columns
				imgupload.saveInBackground();
				}
				// Show a simple toast message
				//Toast.makeText(UploadActivity.this, "Image Uploaded",
					//	Toast.LENGTH_SHORT).show();
				
				//Starting a new Intent
          		Intent nextScreen = new Intent(getApplicationContext(), thankYou.class);            
          		startActivity(nextScreen);	
		}
	

}
