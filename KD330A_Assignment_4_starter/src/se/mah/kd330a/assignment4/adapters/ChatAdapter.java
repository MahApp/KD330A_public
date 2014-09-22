package se.mah.kd330a.assignment4.adapters;

import java.util.List;

import se.mah.kd330a.assignment4.ChatMessage;
import se.mah.kd330a.assignment4.MainActivity;
import se.mah.kd330a.assignment4.R;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ChatAdapter extends ArrayAdapter<ChatMessage> {

    private LayoutInflater mLayoutInflater;

    private LongSparseArray<ChatAdapterDelegate> mDelegates;

    private MainActivity activity;

    public ChatAdapter(MainActivity activity, List<ChatMessage> data) {
	super(activity, R.layout.message_row, data);
	mLayoutInflater = LayoutInflater.from(activity);
	this.activity = activity;

	initDelegates();
    }

    private void initDelegates() {
	mDelegates = new LongSparseArray<ChatAdapterDelegate>();

	mDelegates.put(0, new MyChatAdapter());
	mDelegates.put(1, new OtherChatAdapter());
    }

    @Override
    public int getItemViewType(int position) {
	ChatMessage item = getItem(position);

	if (item.getName().equals(activity.getName())) {
	    return 0;
	} else {
	    return 1;
	}
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
	ChatAdapterDelegate adapter = mDelegates.get(getItemViewType(position));

	if (adapter != null) {
	    convertView = adapter.getView(position, convertView, parent,
		    mLayoutInflater, getItem(position));
	}

	return convertView;
    }

}
