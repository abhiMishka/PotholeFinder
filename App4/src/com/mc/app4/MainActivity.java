package com.mc.app4;

import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	private String[] tabs = { "Location", "Add Data"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		//actionBar = getActionBar();
 
		mViewPager.setAdapter(mSectionsPagerAdapter);
		actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		/*for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
		}*/
		
		// Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			
			/*Fragment fragment1 = new DummySectionFragment1();
			Fragment fragment2 = new DummySectionFragment2();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment1.ARG_SECTION_NUMBER, position + 1);
			args.putInt(DummySectionFragment2.ARG_SECTION_NUMBER, position + 2);
			fragment1.setArguments(args);
			fragment2.setArguments(args);
			return fragment1;*/
			
			switch(position) {
				case 0: 
					return new DummySectionFragment1();
					
				case 1:
					return new DummySectionFragment2();						
			}
			return null;					
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}


	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
		
	public static class DummySectionFragment1 extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment1() {
		}
		//TextView tv1, tv2;
		TextView t1, t2;
		GoogleMap mapView;
	    com.google.android.gms.maps.Projection projection;
	    //TextView t1, t2;
	    //public static double lat, lon;
		//Button b1;

		public static double lat, lon;
		Button b1;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.location, container, false);
			t1 = (TextView) rootView.findViewById(R.id.textView1);			
			t2 = (TextView) rootView.findViewById(R.id.textView2);	
			Intent a1 = new Intent ("android.intent.action.ACTIVITY4");
			startActivityForResult(a1, 1);
					
	        /*
			//FragmentTransaction mt = getSupportFragmentManager().beginTransaction();
	        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
	        SupportMapFragment mFRaFragment = new MapFragmentD();
	        mTransaction.add(R.id.mainl, mFRaFragment);
	        mTransaction.commit();

	        try {
	            MapsInitializer.initialize(this);
	        } catch (GooglePlayServicesNotAvailableException e) {
	            e.printStackTrace();
	        }
			*/
			//Intent iq = new Intent ("android.intent.action.CURRENTMAP");
			//startActivity(iq);			
			
	    
		    return rootView;
			//return null;
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
	
	public static class DummySectionFragment2 extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment2() {
		}
		CheckBox image, notes, rates;
		ImageButton ib1; 
		static boolean rating, noting, images;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.options, container, false);
			image = (CheckBox) rootView.findViewById (R.id.checkBox1);
			notes = (CheckBox) rootView.findViewById (R.id.checkBox2);
			rates = (CheckBox) rootView.findViewById (R.id.checkBox3);
			ib1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
			
			ib1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					noting = false;
					rating = false;
					images = false;
					int num;
					if (notes.isChecked()) {
						noting = true;
					}
					if (rates.isChecked()) {
						rating = true;
					}
					if (image.isChecked()) {
						images = true;
					}
					Intent in3 = new Intent ("android.intent.action.ACTIVITY6"); //rates
					Intent in2 = new Intent ("android.intent.action.ACTIVITY5"); //notes
					Intent in1 = new Intent ("android.intent.action.ACTIVITY2"); //images
					Intent inimage = new Intent ("android.intent.action.IMAGE_ACTIVITY");
					if (image.isChecked()) {
						startActivity (inimage);
					}
					else if (notes.isChecked()) {
						startActivity (in2);
					}
					else if (rates.isChecked()) {
						startActivity (in3);
					}
					else {
						Intent a3 = new Intent ("android.intent.action.UPLOADACTIVITY");
	                	startActivity(a3);
					}
					/*
					if (rates.isChecked() && notes.isChecked() && image.isChecked()) {
						startActivity (in3);
						startActivity (in2);
						startActivity (in1);
					}
					else if (rates.isChecked() && notes.isChecked()==false && image.isChecked()==false) {
						startActivity (in3);
					}
					else if (rates.isChecked()==false && notes.isChecked() && image.isChecked()==false) {
						startActivity (in2);
					}
					else if (rates.isChecked()==false && notes.isChecked()==false && image.isChecked()) {
						startActivity (in1);
					}
					else if (rates.isChecked() && notes.isChecked() && image.isChecked()==false) {
						startActivity (in3);
						startActivity (in2);
					}
					else if (rates.isChecked() && notes.isChecked()==false && image.isChecked()) {
						startActivity (in3);
						startActivity (in1);
					}
					else if (rates.isChecked()==false && notes.isChecked() && image.isChecked()) {
						startActivity (in2);
						startActivity (in1);
					}
					
					Intent r = new Intent("android.intent.action.UPLOADACTIVITY");
			        startActivity(r);
			        */
				}
			});			
			return rootView;
		}
		/*
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			if (requestCode == 1) {
				if(resultCode == RESULT_OK){
					
					Bitmap picture = (Bitmap) data.getExtras().get("data");
			        
					/*
					// get the URI of the image that the user selected.
	                Uri picturePath = data.getData();           
	                System.out.println(picturePath);        
	                Intent intent = new Intent(this, ImageInformationActivity.class);
	                intent.putExtra("IMAGE_FILENAME", picturePath.toString());
					 */
	                //intent.putExtra("uri", pass);
	                // start the intent.
	                //startActivity(intent);
	                
					//String result=data.getStringExtra("result");
					//String res = result;
						//Intent result = data.getIntent("result");
						//Intent res = data.get		
		/*
				}
			}
			if (requestCode == 2) {
				if(resultCode == RESULT_OK){
					String result=data.getStringExtra("result");
					String noteres = result;				
			        
				}
			}
			if (requestCode == 3) {
				if(resultCode == RESULT_OK){
					String result=data.getStringExtra("result");
					double rateres = Double.parseDouble(result);				
			        //Intent r = new Intent("android.intent.action.UPLOADACTIVITY");
			        //startActivity(r);
				}
			}
		}
		*/
	}


}
