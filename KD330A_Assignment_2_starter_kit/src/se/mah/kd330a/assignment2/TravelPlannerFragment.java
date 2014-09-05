package se.mah.kd330a.assignment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

public class TravelPlannerFragment extends Fragment {
	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.travelplannerfragment, container,false);
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("TravelPlannerFragment","onClick");
				FragmentManager fragmentManager = getFragmentManager();
			    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				StartFragment fragment = new StartFragment();
				fragmentTransaction.replace(R.id.activity_main, fragment);
				fragmentTransaction.commit();	
			}
		});
		return v;
	}
}
