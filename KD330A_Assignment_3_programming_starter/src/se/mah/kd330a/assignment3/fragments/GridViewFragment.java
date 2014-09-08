package se.mah.kd330a.assignment3.fragments;

import se.mah.kd330a.assignment3.CelestialBody;
import se.mah.kd330a.assignment3.R;
import se.mah.kd330a.assignment3.adapters.MyGridAdapter;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GridViewFragment extends Fragment {

	private GridView grid;

	private MyGridAdapter adapter;

	private CelestialBody[] data = new CelestialBody[] {
//			new CelestialBody("Ariel", R.drawable.ariel),
			// TODO: Add more
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_gridview, container,
				false);

		// TODO

		return root;
	}
}
