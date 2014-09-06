package se.mah.kd330a.assignment2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//We add the fragment from code it can also be added from xml if it is static
		setContentView(R.layout.activity_main);//Add the layout to the Activity with room for our fragments.
		FragmentManager fragmentManager = getFragmentManager(); //Get the FragmentManager that handles all fragments
	    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //Ask the fragmentmanager for a FragmentTransaction so we can change fragments
		StartFragment fragment = new StartFragment();  //Create a new fragment
		fragmentTransaction.replace(R.id.activity_main, fragment); //Prepare to replace whatever fragment there is in the main layout with our new fragment
		fragmentTransaction.commit(); //Actually perform the transaction
	}

}
