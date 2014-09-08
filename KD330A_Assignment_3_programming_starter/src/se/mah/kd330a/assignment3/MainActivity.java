package se.mah.kd330a.assignment3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private FragmentController mFragmentController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mFragmentController = new FragmentController(getFragmentManager());
	}

	@Override
	protected void onResume() {
		super.onResume();

		mFragmentController.inflateListViewFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_listview:
			mFragmentController.inflateListViewFragment();
			return true;

		case R.id.action_gridview:
			mFragmentController.inflateGridViewFragment();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}

	}
}
