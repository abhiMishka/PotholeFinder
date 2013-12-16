package com.mc.app4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends Activity {
	
	public String mnc,mcc,cid,lac;
	public String sendline;
	public TextView tv1;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        GsmCellLocation cellLocation = (GsmCellLocation)telephonyManager.getCellLocation();
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        String networkOperator = telephonyManager.getNetworkOperator();
         mcc = networkOperator.substring(0, 3);
         mnc = networkOperator.substring(3);

         cid=Integer.toString(cellLocation.getCid());
         lac = Integer.toString(cellLocation.getLac());
         
      // TODO Auto-generated method stub
 		//Toast.makeText(this,"mcc : " +mcc +"\nmnc : " +mnc +"\ncid : " +cid +"\nlac : " +lac, Toast.LENGTH_SHORT).show();
 		 String urlParameters = "{\"cellid\":" +"\""+cid +"\"" +","+"\"mcc\":" +"\""+mcc +"\""+","+"\"mnc\":" +"\""+mnc +"\""+","+"\"lac\":" +"\""+lac +"\""+"}";
 		 try{
 	        URL url = new URL("http://togathertogetherservice.cloudapp.net/geocodecellid");
 	      //  Toast.makeText(this,"Here 1", Toast.LENGTH_SHORT).show();
 	        URLConnection conn = url.openConnection();

 	        conn.setDoOutput(true);

 	        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
 	       // Toast.makeText(this,"Here 2", Toast.LENGTH_SHORT).show();
 	        writer.write(urlParameters);
 	        writer.flush();
 	      //  Toast.makeText(this,"Here 1", Toast.LENGTH_SHORT).show();
 	                // line;
 	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 	        line=reader.readLine();
 	        //  while ((line = reader.readLine()) != null) {
 	        //     System.out.println(line);
 	        // }
 	        
 	        writer.close();
 	        reader.close();
 	        //Toast.makeText(this,line, Toast.LENGTH_SHORT).show();
 	       //Toast.makeText(this,"Hello", Toast.LENGTH_SHORT).show();
 	        
 	        Intent returnIntent = new Intent();
 	        returnIntent.putExtra("result",line);
 	        setResult(RESULT_OK,returnIntent); 	    
 	        finish();
 	        
 	        
 			}catch(IOException e){
 	//			Toast.makeText(this,"Check your internet connection", Toast.LENGTH_SHORT).show();
 			} 
    }
	
	public static String line;
	
	public static String getCoordinates(){
		return line;
	}
	
	//public void onClick(View arg0) {
	//	}	

}
