package se.mah.k3.swipe_example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentFoodMenuDay extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.food_menu_list, container,false);
		TextView tv = (TextView) rootView.findViewById(R.id.textView1);
		int idForThisFragment = this.getArguments().getInt("swipe_fragment_number");
		tv.setText("This is SwipeFragment: "+idForThisFragment);
		return rootView;
	}

}
