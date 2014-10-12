package com.example.kd330a_assignment_5_starter.adapters;

import java.sql.Date;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kd330a_assignment_5_starter.R;
import com.example.kd330a_assignment_5_starter.data.ChatMessage;

public class MyChatAdapter implements ChatAdapterDelegate {

	@Override
	public View getView(int position, View convertView, ViewGroup parent,
			LayoutInflater inflater, Object item) {

		ViewHolder holder = null;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.message_row_me, parent,
					false);

			holder = new ViewHolder();

			holder.name = (TextView) convertView
					.findViewById(R.id.message_row_me_name);
			holder.message = (TextView) convertView
					.findViewById(R.id.message_row_me_message);
			holder.time = (TextView) convertView
					.findViewById(R.id.message_row_me_time);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// This should be safe since we did a check previously!
		ChatMessage message = (ChatMessage) item;

		holder.name.setText(message.getName());
		
		holder.message.setText(message.getMessage());

		Date time = new Date(message.getTime());
		holder.time.setText(sdf.format(time));

		return convertView;
	}

}
