package se.mah.k3.swipe_example;

import java.util.Locale;

import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.ActionBar;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity  {

//	private String[] mPlanetTitles  = {"Tabbed Frame","Other"};;
//    private DrawerLayout mDrawerLayout;
//    private ListView mDrawerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.content_frame, new FragmentFoodMenyDayPager());
			ft.commit();
		}
		
//	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//	        mDrawerList = (ListView) findViewById(R.id.left_drawer);
//	        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//	                R.layout.drawer_list_item, mPlanetTitles));
//	        // Set the list's click listener
//	        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
