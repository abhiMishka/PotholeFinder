package com.mc.app4;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ShowMap_Activity extends Activity {
	private GoogleMap googleMap;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Parse.initialize(this, "uFwoSCU42NKWz1hxvQHqPjrCxxJdkXcREOYsAEyu", "KjJIMTP5UY32FVo6yTw1ONk9Icl40DO7fSIuEPVk");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

        
        func();
        Thread timer = new Thread() {
			public void run(){
				try{
					sleep(5000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.start(); 
       // Toast.makeText(ShowMap_Activity.this, crdnts.toString(), Toast.LENGTH_SHORT).show();
        
        setContentView(R.layout.page_map);
        
        try {
            // Loading map
            initializeMap(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initializeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
         // latitude and longitude
            
            
            double latitude = 28.5462562;
            double longitude = 77.2731559;
            int i;
            
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.getUiSettings().setRotateGesturesEnabled(true);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(7).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            for (i=0;i<crdnts.size();i++) {
            
            //create marker
            drawMarker(new LatLng(crdnts.get(i).get(0), crdnts.get(i).get(1)));
           // MarkerOptions marker  = new MarkerOptions().position(new LatLng(crdnts.get(i).get(1), crdnts.get(i).get(1)));
           // marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            //CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(14).build();
            //CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(crdnts.get(i).get(0), crdnts.get(i).get(1))).zoom(14).build();
            //googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            // adding marker
          //  googleMap.addMarker(marker);
            }
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }
    }
    
    public void drawMarker (LatLng point) {
    	// Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();
        // Setting latitude and longitude for the marker
        markerOptions.position(point);
        // Adding marker on the Google Map
        googleMap.addMarker(markerOptions);
    }
    public static ArrayList<ArrayList<Double>> crdnts = new ArrayList();
    public ArrayList<ArrayList<Double>> func () {
    	
    	// TODO Auto-generated method stub
    			 ParseQuery<ParseObject> query = ParseQuery.getQuery("ImageUpload");
    		        query.whereContains("ImageName", "IMG");
    		        //Toast.makeText(MainActivity.this, "Hi",    						Toast.LENGTH_SHORT).show();
    		      //  query.
    		        //query.findInBackground(callback)
    		        query.findInBackground(new FindCallback<ParseObject>() {
    		        int k=0;
    		        
    		        String[] parse;
    		        	String c;
    		        	 Double lat=0.0;
    		        	 Double lng=0.0;
    					public void done(List<ParseObject> objects,
    							com.parse.ParseException e) {
    						// TODO Auto-generated method stub
    						 if (e == null) {
    							   // String Coordinate= query.get
    							// while(objects.listIterator().nextIndex()!=-1){
    								// c=c+objects.get(k-1).getString("Coordinates")  + "Coordinates" + "\n";
    								 //Toast.makeText(MainActivity.this, objects.size(),
    								//			Toast.LENGTH_LONG).show();
    							//	 k++;
    							// }
    							 crdnts.clear();
    								 for(int z=0;z<objects.size()-1;z++){
    									 c=c+objects.get(z).getString("Coordinates")  + "Coordinates" + "\n";
    									 parse=c.split("\"");
    									 for(int i=0;i<parse.length;i++){
    								            if(parse[i].toString().equals("Lat")){
    								                  lat=Double.parseDouble(parse[i+2].toString());
    								            }
    								            else if(parse[i].toString().equals("Lng")){
    								                lng=Double.parseDouble(parse[i+2].toString());
    								            }
    								            //double lat=Double.parseDouble(line1.substring(8, 16));
    								       // double lng=Double.parseDouble(line2.substring(7, 15));
    								            
    								        }
    									// String line1=c.split(",")[0];
    								    //   String line2=c.split(",")[1];
    									// lat=Double.parseDouble(objects.get(z).getString("Coordinates").substring(8, 17));
    								     //lng=Double.parseDouble(objects.get(z).getString("Coordinates").substring(7, 15));
    								     crdnts.add(new ArrayList<Double>());
    								     crdnts.get(z).add(lat);
    								     crdnts.get(z).add(lng);
    								     
    								 }
    			                    //Log.d("Coordinates", "Retrieved " + objects.get(0).getString("Coordinates") + "Coordinates");
    			                    //for(int i=0;i)
    			                    
    			                   // Toast.makeText(MainActivity.this, "Coordinates " + "Retrieved " + objects.get(2).getString("Coordinates") + "Coordinates",    										Toast.LENGTH_SHORT).show();
    			                    //Toast.makeText(MainActivity.this, crdnts.toString(),    										Toast.LENGTH_LONG).show();
    			                  //  Log.d("Coordinates", "Retrieved " + c);
    			                    
    			                } else {
    			                   // Log.d("Coordinates", "Error: " + e.getMessage());
    			                    Toast.makeText(ShowMap_Activity.this, "Check your internet connectivity",Toast.LENGTH_SHORT).show();
    			                }
    						
    					}
    		        });
    		        
    		        return crdnts;
    		}
    	
    
 
    @Override
    protected void onResume() {
        super.onResume();
        initializeMap();
    }
}
