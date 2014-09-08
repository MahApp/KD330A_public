package se.mah.kd330a.assignment3.fragments;

import se.mah.kd330a.assignment3.CelestialBody;
import se.mah.kd330a.assignment3.R;
import se.mah.kd330a.assignment3.adapters.MyListAdapter;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListViewFragment extends Fragment {

	private ListView list;

	private MyListAdapter adapter;

	private CelestialBody[] data = new CelestialBody[] {
//			new CelestialBody("Earth", R.drawable.earth),
			// TODO: Add more
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_listview, container,
				false);

		// ??

		return root;
	}
}
