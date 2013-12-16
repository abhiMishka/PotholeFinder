package com.mc.app4;

import java.io.ByteArrayOutputStream;


import java.io.IOException;


import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TakePhoto extends Activity implements OnClickListener{
	
	
	private Camera camera;
	private ImageButton photoButton;
	private ParseFile photoFile;
	private SurfaceView surfaceView;
	static byte[] scaledData ;
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.imagepage);
	    
	    // Add your initialization code here
		Parse.initialize(this, "uFwoSCU42NKWz1hxvQHqPjrCxxJdkXcREOYsAEyu", "KjJIMTP5UY32FVo6yTw1ONk9Icl40DO7fSIuEPVk");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	    
	 //   photoButton = (ImageButton) v.findViewById(R.id.);
	     photoButton = (ImageButton) findViewById(R.id.imageButton1);
        photoButton.setOnClickListener(this);
        
        if (camera == null) {
            try {
                    camera = Camera.open();
                    photoButton.setEnabled(true);
            } catch (Exception e) {
                    Log.e("AAAA", "No camera with exception: " + e.getMessage());
                    photoButton.setEnabled(false);
                    Toast.makeText(TakePhoto.this, "No camera detected",
                                    Toast.LENGTH_LONG).show();
            }
    }
        
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    if (camera == null)
                            return;
                    camera.takePicture(new Camera.ShutterCallback() {

                            @Override
                            public void onShutter() {
                                    // nothing to do
                            }

                    }, null, new Camera.PictureCallback() {

                            @Override
                            public void onPictureTaken(byte[] data, Camera camera) {
                                    saveScaledPhoto(data);
                            }

                    });

            }
            private void saveScaledPhoto(byte[] data) {

                // Resize photo from camera byte array
                Bitmap pothole = BitmapFactory.decodeByteArray(data, 0, data.length);
                Bitmap mealImageScaled = Bitmap.createScaledBitmap(pothole, 200, 200*pothole.getHeight() / pothole.getWidth(), false);

                // Override Android default landscape orientation and save portrait
                Matrix m = new Matrix();
                m.postRotate(90);
                Bitmap rotatedScaledMealImage = Bitmap.createBitmap(mealImageScaled, 0,
                                0, mealImageScaled.getWidth(), mealImageScaled.getHeight(),
                                m, true);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                rotatedScaledMealImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                	//Collections.
                scaledData = stream.toByteArray();
                
                
                
                
                if (MainActivity.DummySectionFragment2.noting == true) {
                	Intent a1 = new Intent ("android.intent.action.ACTIVITY5");
                	startActivity(a1);
                }
                else if (MainActivity.DummySectionFragment2.rating == true) {
                	Intent a2 = new Intent ("android.intent.action.ACTIVITY6");
                	startActivity(a2);
                }
                else {
                	Intent a3 = new Intent ("android.intent.action.UPLOADACTIVITY");
                	startActivity(a3);
                }
    	 }
    	 
    });
    
        
        surfaceView = (SurfaceView) findViewById(R.id.camera_surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(new Callback() {

                public void surfaceCreated(SurfaceHolder holder) {
                        try {
                                if (camera != null) {
                                        camera.setDisplayOrientation(90);
                                        camera.setPreviewDisplay(holder);
                                        camera.startPreview();
                                }
                        } catch (IOException e) {
                                Log.e("SurfaceView", "Error setting up preview", e);
                        }
                }

                public void surfaceChanged(SurfaceHolder holder, int format,
                                int width, int height) {
                        // nothing to do here
                }

                public void surfaceDestroyed(SurfaceHolder holder) {
                        // nothing here
                }

        });
}
	 
	 public static byte[] getimage () {
		 return scaledData;
	 }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}