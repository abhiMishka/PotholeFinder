/*
package com.mc.app4;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TextView;

public class Currentmap extends FragmentActivity {
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.page3);
        
        
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if(resultCode == RESULT_OK){
				String result=data.getStringExtra("result");
				String res = result;
				//String res = "\"Lat\":\"23.567\",\"Lon\":\"76.543\"";
		        System.out.println (res);
		        String arr1[], arr2[], arr3[], arr4[], arr5[], arr6[], arr7[];
		        arr1 = res.split(",");
		        arr2 = arr1[0].split(":");
		        arr3 = arr2[0].split("\"");
		        arr4 = arr2[1].split("\"");
		        arr5 = arr1[1].split(":");
		        arr6 = arr5[0].split("\"");
		        arr7 = arr5[1].split("\"");
				t1.setText(arr4[1]);
				t2.setText(arr7[1]);
				lat = Double.parseDouble(arr4[1]);
				lon = Double.parseDouble(arr7[1]);
				
			}
		}				
	}

}
*/