package se.mah.rss_reader_example;

import java.util.List;


import se.mah.rssreader.model.RSSItem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RssArrayAdapter extends ArrayAdapter<RSSItem> {
	private static final String TAG = "RssArrayAdapter";
	private final Context context;
	private final List<RSSItem> rssList;
	public RssArrayAdapter(Context context, int resource, List<RSSItem> objects) {
		super(context, resource,  objects);
		this.context = context;
		rssList = objects;
	}
	
	
	@Override  //This is called for every new row that we will show.
	public View getView(int position, View convertView, ViewGroup parent) {
		 LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    View rowView = inflater.inflate(R.layout.row_view, parent, false);  //Should be reused instead.....
			    TextView title_tw = (TextView)rowView.findViewById(R.id.title);
			    TextView description_tw = (TextView)rowView.findViewById(R.id.description);
			    RSSItem rssItem = rssList.get(position);
			    title_tw.setText(rssItem.getTitle());
			    description_tw.setText(rssItem.getDescription());
	      return rowView;
	}
}
