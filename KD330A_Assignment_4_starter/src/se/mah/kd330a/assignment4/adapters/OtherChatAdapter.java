package se.mah.kd330a.assignment4.adapters;

import se.mah.kd330a.assignment4.ChatMessage;
import se.mah.kd330a.assignment4.R;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
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
	String text = message.getMessage();
	text = text.replace("(uu)", "Uppsala Universitet");
	text = text.replace("(lu)", "Lunds Universitet");
	SpannableString spannableString = new SpannableString(text);
	if (text.contains(":)")){
		Log.i("MyChatAdapter"," Found :)");
		ImageSpan is = new ImageSpan(parent.getContext(), R.drawable.ic_launcher);
		spannableString.setSpan(is, text.indexOf(":)"), text.indexOf(":)")+2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
	}
	if (text.contains(":(")){
		Log.i("MyChatAdapter"," Found :(");
		ImageSpan is = new ImageSpan(parent.getContext(), R.drawable.ic_launcher);
		spannableString.setSpan(is, text.indexOf(":("), text.indexOf(":(")+2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
	}
	holder.time.setText(message.getTime());

	return convertView;
    }

}
