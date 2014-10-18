package se.mah.rss_reader_example;

import java.util.ArrayList;
import java.util.List;

import se.mah.rssreader.controller.RSSCallback;
import se.mah.rssreader.controller.RefreshRSS;
import se.mah.rssreader.model.FeedManager;
import se.mah.rssreader.model.RSSItem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class FragmentNews extends Fragment implements RSSCallback,OnRefreshListener{

	private final static String TAG = "FragmentNews";
	private SwipeRefreshLayout 	swipeRefreshLayout;	
	private BaseExpandableListAdapter 	adapter;
	private List<RSSItem> 		rssList;
	private FeedManager 		fm; 
	

	   @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.rss_listview, container,false);
			//Create the Expandable List Adapter and get the RSS feed
			rssList = new ArrayList<RSSItem>();
			fm = new FeedManager(getActivity());
			if (fm.getFeed()!=null){
				rssList.addAll(fm.getFeed().getItems());
				Log.i(TAG, "Number of items i feed: "+rssList.size());
			}
		    adapter = new RssExpandableListAdapter(getActivity(),R.layout.group_view, rssList);
		    //Connect the Adapter and the Expandable ListView
			ExpandableListView expLv = (ExpandableListView)rootView.findViewById(R.id.explistview);
			expLv.setAdapter(adapter);
			//Fix the swipe with colors and Listener
			swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container_home);
			swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_dark, android.R.color.holo_blue_light, android.R.color.holo_blue_bright, android.R.color.darker_gray);
			swipeRefreshLayout.setOnRefreshListener(this); //Will call the onRefresh method below when activated 
			return rootView;
		}

		@Override
		public void onRefresh() { //Called when onRefresh is started by "Pull to refresh"
			RefreshRSS refresh = new RefreshRSS(this,getActivity()); //Will call onRefreshCompleted() when finished 
			refresh.execute();
		}
		
		@Override
		public void onRSSRefreshCompleted() { //This is called when a RSSFeed is downloaded.
			Log.i(TAG,"RefreshRSS completed");
			//All done new feed collected so refresh the current view and stop refresh animation
			swipeRefreshLayout.setRefreshing(false);
			//Ok get the new items and add them to an empty list
			rssList.clear();
			rssList.addAll(fm.getFeed().getItems());
			adapter.notifyDataSetChanged(); //update the list by telling it changed
		}
}
