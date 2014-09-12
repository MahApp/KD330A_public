package com.example.kd330a_assignment_3_ui_key;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kd330a_assignment_3_ui_key.model.Journey;
import com.example.kd330a_assignment_3_ui_key.model.JourneyListAdapter;
import com.example.kd330a_assignment_3_ui_key.parser.Constants;
import com.example.kd330a_assignment_3_ui_key.parser.Parser;

public class JourneyPlannerFragment extends Fragment {

	private final static String ARG_START = "startStation";
	private final static String ARG_END = "endStation";

	private String start, end;

	private TextView startStation, endStation;

	private ListView mListView;

	private JourneyListAdapter mAdapter;

	private ArrayList<Journey> journeys = new ArrayList<Journey>();

	public static JourneyPlannerFragment newInstance(String start, String end) {
		JourneyPlannerFragment fragment = new JourneyPlannerFragment();
		Bundle args = new Bundle();
		args.putString(ARG_START, start);
		args.putString(ARG_END, end);
		fragment.setArguments(args);
		return fragment;
	}

	public JourneyPlannerFragment() {
		// Required
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			start = getArguments().getString(ARG_START);
			end = getArguments().getString(ARG_END);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_listview, container,
				false);

		startStation = (TextView) root.findViewById(R.id.startstation);
		startStation.setText(start);

		endStation = (TextView) root.findViewById(R.id.endstation);
		endStation.setText(end);

		mListView = (ListView) root.findViewById(R.id.journeys);
		mAdapter = new JourneyListAdapter(inflater.getContext(), journeys);
		mListView.setAdapter(mAdapter);

		new SearchJourneys().execute(Constants.getURL(start, end, 20));
		
		return root;
	}

	/**
	 * Async search function.
	 * 
	 * @author ksango
	 * 
	 */
	private class SearchJourneys extends
			AsyncTask<String, Integer, ArrayList<Journey>> {

		@Override
		protected ArrayList<Journey> doInBackground(String... params) {
			Log.d("test", "running search");
			return Parser.getJourneys(params[0]);
		}

		@Override
		protected void onPostExecute(ArrayList<Journey> result) {
			journeys.clear();
			journeys.addAll(result);
			
			for( Journey j : journeys){
				Log.d("test", j.toString());
			}
			mAdapter.notifyDataSetChanged();
		}

	}
}
