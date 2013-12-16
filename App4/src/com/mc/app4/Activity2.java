package com.mc.app4;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity2 extends Activity implements OnClickListener {
	
	private static final String TAG = "CallCamera";
	 private static final int CAPTURE_IMAGE_ACTIVITY_REQ = 0;

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.page7);	       
	         
	         ImageButton cameraButton = (ImageButton) findViewById(R.id.imageButton1);
	         cameraButton.setOnClickListener(this);
	    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		  Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = getOutputPhotoFile();
        fileUri = Uri.fromFile(getOutputPhotoFile());
        i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQ );
	}
	
	 private void dispatchTakePictureIntent(int actionCode) {
	        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        startActivityForResult(takePictureIntent, actionCode);
	    }
	 
	 private static String imagePath;
	private static String imageName;
	 private File getOutputPhotoFile() {
	        File directory = new File(Environment.getExternalStoragePublicDirectory(
	                Environment.DIRECTORY_PICTURES), "potholeFinder");
	        if (!directory.exists()) {
	            if (!directory.mkdirs()) {
	                Log.e(TAG, "Failed to create storage directory.");
	                return null;
	            }
	        }
	        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss", Locale.UK).format(new Date(0));
	        imagePath=directory.getPath() + File.separator + "IMG_" + timeStamp + ".jpg";
	        
	        imageName="IMG_" + timeStamp + ".png";
	        
	        return new File(directory.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
	    }
	 
	 public static String getImagePath(){
		 return imagePath;
	 }
	 
	 public static String getImageName(){
		 return imageName;
	 }

	 Uri fileUri = null;
	
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQ) {
	            if (resultCode == RESULT_OK) {
	                Uri photoUri = null;
	                if (data == null) {
	                    // A known bug here! The image should have saved in fileUri
	                    Toast.makeText(this, "Image saved successfully",
	                            Toast.LENGTH_LONG).show();
	                //    Toast.makeText(clickphoto.this, "Image path : " +imagePath,
	         		//			Toast.LENGTH_SHORT).show();
	                    
	                    photoUri = fileUri;
	                    /*
	                    Thread timer = new Thread() {
	            			public void run(){
	            				try{
	            					sleep(2000);
	            				}
	            				catch (InterruptedException e) {
	            					e.printStackTrace();
	            				}
	            				finally{
	            					//Starting a new Intent
	        	              		Intent nextScreen = new Intent(getApplicationContext(), uploadPhoto.class);            
	        	              		startActivity(nextScreen);
	            				}
	            			}
	            		};
	            		timer.start(); 
	            		*/
	                } else {
	                    photoUri = data.getData();
	                    Toast.makeText(this, "Image saved successfully in: " + data.getData(), Toast.LENGTH_LONG).show();
	                    
	                    Intent returnIntent = new Intent();
	         	        returnIntent.putExtra("result",data);
	         	        setResult(RESULT_OK,returnIntent); 	    
	         	        finish();
	         	        
	                    /*
	                    Thread timer = new Thread() {
	            			public void run(){
	            				try{
	            					sleep(2000);
	            				}
	            				catch (InterruptedException e) {
	            					e.printStackTrace();
	            				}
	            				finally{
	            					//Starting a new Intent
	        	              		Intent nextScreen = new Intent(getApplicationContext(), uploadPhoto.class);            
	        	              		startActivity(nextScreen);
	            				}
	            			}
	            		};
	            		timer.start(); 
	                  */
	                }
	                // showPhoto(photoUri);
	            } else if (resultCode == RESULT_CANCELED) {
	                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
	            } else {
	                Toast.makeText(this, "Callout for image capture failed!",
	                        Toast.LENGTH_LONG).show();
	            }
	        }
	    }
}