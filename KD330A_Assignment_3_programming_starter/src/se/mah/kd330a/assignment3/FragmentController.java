package se.mah.kd330a.assignment3;

import se.mah.kd330a.assignment3.fragments.GridViewFragment;
import se.mah.kd330a.assignment3.fragments.ListViewFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Controls all the fragments in the UI.
 * 
 * @author ksango
 * 
 */
public class FragmentController {

	private FragmentManager mFragmentManager;

	public FragmentController(FragmentManager fragmentManager) {
		mFragmentManager = fragmentManager;
	}

	public void inflateListViewFragment() {
		ListViewFragment fragment = new ListViewFragment();
		showFragment(fragment, "listview");
	}

	public void inflateGridViewFragment() {
		GridViewFragment fragment = new GridViewFragment();
		showFragment(fragment, "gridview");
	}

	/**
	 * Show the fragment, this adds the fragment to the backstack as well
	 * 
	 * @param fragment
	 *            the fragment to show
	 * @param tag
	 *            the tag of the fragment
	 */
	private void showFragment(Fragment fragment, String tag) {
		showFragment(fragment, tag, true);
	}

	/**
	 * Show the fragment
	 * 
	 * @param fragment
	 *            the fragment to show
	 * @param tag
	 *            the tag of the fragment
	 * @param backstack
	 *            if it should be added to history
	 */
	private void showFragment(Fragment fragment, String tag, boolean backstack) {
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		transaction.replace(R.id.container, fragment, tag);
		if (backstack)
			transaction.addToBackStack(tag);
		transaction.commit();
	}
}
