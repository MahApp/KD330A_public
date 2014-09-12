package com.example.kd330a_assignment_3_ui_key;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	private FragmentController mFragmentController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mFragmentController = new FragmentController(this);

		if (savedInstanceState == null) {
			mFragmentController.showJourneyPlanner("80000", "93070");
		}
	}
}
