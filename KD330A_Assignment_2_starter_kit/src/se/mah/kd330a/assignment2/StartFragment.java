package se.mah.kd330a.assignment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class StartFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.startfragment,container,false);
		v.setOnClickListener(new OnClickListener() {  //here we use an anonymous inner class for the button listener
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getFragmentManager();  //swap fragments se MainActivity for description
			    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				TravelPlannerFragment fragment = new TravelPlannerFragment();
				fragmentTransaction.replace(R.id.activity_main, fragment);
				fragmentTransaction.commit();
			}
		});
		return v;
	}
}
