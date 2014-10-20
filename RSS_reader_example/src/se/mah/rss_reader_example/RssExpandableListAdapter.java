package se.mah.rss_reader_example;

import java.util.Date;
import java.util.List;


import se.mah.rssreader.model.RSSItem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class RssExpandableListAdapter extends BaseExpandableListAdapter {
	private static final String TAG = "RssExpandableListAdapter";
	private final Context context;
	private final List<RSSItem> rssList;
	private Date dt; 
	
	public RssExpandableListAdapter(Context context, int resource, List<RSSItem> objects) {
		this.context = context;
		rssList = objects;
	}
	
	@Override
	public int getGroupCount() {
		return rssList.size();
	}


	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}


	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}


	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}


	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return groupPosition;
	}


	@Override
	public boolean hasStableIds() {
		return false;
	}

	//Main
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		//Check date if new day add dayXML
		if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = inflater.inflate(R.layout.group_view, null);
	        }
		 //Get the textviews
		 TextView title_tv = (TextView)convertView.findViewById(R.id.title);
		 TextView creator_tv = (TextView)convertView.findViewById(R.id.creator);
		 //Match with Item and add info
		 RSSItem rssItem = rssList.get(groupPosition);
		 title_tv.setText(rssItem.getTitle());
		 creator_tv.setText(rssItem.getCreator());
		return convertView;
	}


	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_view, null);
        }
		TextView description_tv = (TextView)convertView.findViewById(R.id.description);
		RSSItem rssItem = rssList.get(groupPosition);
		description_tv.setText(rssItem.getDescription()); 
		return convertView;
	}


	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
