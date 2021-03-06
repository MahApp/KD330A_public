package se.mah.kd330a.assignment4.adapters;

import se.mah.kd330a.assignment4.ChatMessage;
import se.mah.kd330a.assignment4.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OtherChatAdapter implements ChatAdapterDelegate {

    @Override
    public View getView(int position, View convertView, ViewGroup parent,
	    LayoutInflater inflater, Object item) {

	ViewHolder holder = null;

	if (convertView == null) {
	    convertView = inflater.inflate(R.layout.message_row_other, parent,
		    false);

	    holder = new ViewHolder();

	    holder.name = (TextView) convertView
		    .findViewById(R.id.message_row_other_name);
	    holder.message = (TextView) convertView
		    .findViewById(R.id.message_row_other_message);
	    holder.time = (TextView) convertView
		    .findViewById(R.id.message_row_other_time);

	    convertView.setTag(holder);
	} else {
	    holder = (ViewHolder) convertView.getTag();
	}

	// This should be safe since we did a check previously!
	ChatMessage message = (ChatMessage) item;

	holder.name.setText(message.getName());
	holder.message.setText(message.getMessage());
	holder.time.setText(message.getTime());

	return convertView;
    }

}
