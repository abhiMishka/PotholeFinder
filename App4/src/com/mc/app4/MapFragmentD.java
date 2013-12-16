package com.mc.app4;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragmentD extends SupportMapFragment {

    GoogleMap mapView;
    Double latitude, longitude;
    @Override
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
    }

    @Override
    public View onCreateView(LayoutInflater mInflater, ViewGroup arg1,
            Bundle arg2) {
        return super.onCreateView(mInflater, arg1, arg2);
    }

    @Override
    public void onInflate(Activity arg0, AttributeSet arg1, Bundle arg2) {
        super.onInflate(arg0, arg1, arg2);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        latitude = MainActivity.DummySectionFragment1.lat;
        longitude = MainActivity.DummySectionFragment1.lon;
        
        mapView = getMap();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.draggable(true);
        markerOptions.position(new LatLng(latitude, longitude));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
        mapView.addMarker(markerOptions);
        
        
        mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mapView.setMyLocationEnabled(true);
        mapView.getUiSettings().setCompassEnabled(true);
        mapView.getUiSettings().setMyLocationButtonEnabled(true);
        mapView.getUiSettings().setRotateGesturesEnabled(true);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(7).build();
        mapView.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
       // drawMarker(new LatLng(latitude, longitude));
        
        MarkerOptions marker  = new MarkerOptions().position(new LatLng(latitude, longitude));
        // marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
         
         
        mapView.addMarker(marker);
     // Creating an instance of MarkerOptions
        //MarkerOptions markerOptions = new MarkerOptions();
        // Setting latitude and longitude for the marker
        //markerOptions.position(point);
        // Adding marker on the Google Map
       // mapView.addMarker(markerOptions);
        
        
    }
}