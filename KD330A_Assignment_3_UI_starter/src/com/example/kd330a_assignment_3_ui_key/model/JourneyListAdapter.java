package com.example.kd330a_assignment_3_ui_key.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kd330a_assignment_3_ui_key.R;

public class JourneyListAdapter extends ArrayAdapter<Journey> {

	private LayoutInflater mLayoutInflater;

	public JourneyListAdapter(Context context, ArrayList<Journey> data) {
		super(context, R.layout.listview_row, data);

		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.listview_row,
					parent, false);

			holder = new ViewHolder();

			holder.departure = (TextView) convertView
					.findViewById(R.id.departure);
			holder.arrival = (TextView) convertView.findViewById(R.id.arrival);
			holder.type = (ImageView) convertView.findViewById(R.id.type);
			holder.changes = (TextView) convertView.findViewById(R.id.changes);
			holder.duration = (TextView) convertView
					.findViewById(R.id.duration);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm",
				Locale.getDefault());

		Journey journey = getItem(position);

		holder.departure
				.setText(sdf.format(journey.getDepDateTime().getTime()));
		holder.arrival.setText(sdf.format(journey.getArrDateTime().getTime()));

		if (journey.getLineTypeName().equals("Öresundståg")) {
			holder.type.setImageResource(R.drawable.ic_type_oresundstag);
		} else if (journey.getLineTypeName().equals("Pågatåg")) {
			holder.type.setImageResource(R.drawable.ic_type_pagatag);
		} else if (journey.getLineTypeName().equals("Regionsbuss")) {
			holder.type.setImageResource(R.drawable.ic_type_regionsbuss);
		} else if (journey.getLineTypeName().equals("Stadsbuss")) {
			holder.type.setImageResource(R.drawable.ic_type_stadsbuss);
		} else {
			holder.type.setImageResource(R.drawable.ic_launcher);
		}

		holder.changes.setText(journey.getNoOfChanges());

		holder.duration.setText(journey.getTravelMinutes());

		return convertView;
	}

	private class ViewHolder {
		TextView departure;
		TextView arrival;
		ImageView type;
		TextView changes;
		TextView duration;
	}
}
