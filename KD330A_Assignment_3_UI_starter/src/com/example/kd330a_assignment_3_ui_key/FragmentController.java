package com.example.kd330a_assignment_3_ui_key;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class FragmentController {

	private FragmentManager mFragmentManager;
	
	public FragmentController(Activity act){
		mFragmentManager = act.getFragmentManager();
	}
	
	public void showJourneyPlanner(String start, String end){
		JourneyPlannerFragment fragment = JourneyPlannerFragment.newInstance(start, end);
		showFragment(fragment, "journey", false);
	}
	
	private void showFragment(Fragment fragment, String tag, boolean backStack){
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		
		transaction.replace(R.id.container, fragment, tag);
		
		if( backStack )
			transaction.addToBackStack(tag);
		
		transaction.commit();
	}
}
