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

public class TravelPlannerFragment extends Fragment implements OnClickListener{  //here we let the class implement an OnClickLister interface
	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.travelplannerfragment, container,false);  //Here we find the view 
		v.setOnClickListener(this); //And tells it to listen for clicks that will end up in the OnClick method.
		return v;
	}

	@Override
	public void onClick(View v) {  //implements forces us to have this method
		Log.i("TravelPlannerFragment","onClick");
		FragmentManager fragmentManager = getFragmentManager();
	    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		StartFragment fragment = new StartFragment();
		fragmentTransaction.replace(R.id.activity_main, fragment);
		fragmentTransaction.commit();	
	}
	
	 
}
