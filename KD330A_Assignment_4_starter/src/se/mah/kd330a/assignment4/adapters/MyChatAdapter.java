package se.mah.kd330a.assignment4.adapters;

import se.mah.kd330a.assignment4.ChatMessage;
import se.mah.kd330a.assignment4.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TextView.BufferType;

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
	String text = message.getMessage();
	text = text.replace("(uu)", "Uppsala Universitet");
	SpannableString spannableString = new SpannableString(text);
	if (text.contains(":)")){
		Log.i("MyChatAdapter"," Found :)");
		ImageSpan is = new ImageSpan(parent.getContext(), R.drawable.ic_launcher);
		spannableString.setSpan(is, text.indexOf(":)"), text.indexOf(":)")+2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
	}
	
	
	holder.name.setText(message.getName());
	holder.message.setText(spannableString);
	holder.time.setText(message.getTime());

	return convertView;
    }
}
