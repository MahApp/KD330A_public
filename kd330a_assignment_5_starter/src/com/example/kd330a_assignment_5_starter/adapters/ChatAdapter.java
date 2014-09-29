package com.example.kd330a_assignment_5_starter.adapters;

import java.util.List;

import android.content.Context;
import android.support.v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.kd330a_assignment_5_starter.R;
import com.example.kd330a_assignment_5_starter.data.ChatMessage;

public class ChatAdapter extends ArrayAdapter<ChatMessage> {

	private LayoutInflater mLayoutInflater;

	private LongSparseArray<ChatAdapterDelegate> mDelegates;

	private String name;

	public ChatAdapter(Context context, List<ChatMessage> data, String name) {
		super(context, R.layout.message_row, data);
		mLayoutInflater = LayoutInflater.from(context);

		initDelegates();

		this.name = name;
	}

	@Override
	public int getViewTypeCount() {
		return mDelegates.size();
	}

	private void initDelegates() {
		mDelegates = new LongSparseArray<ChatAdapterDelegate>();

		mDelegates.put(0, new MyChatAdapter());
		mDelegates.put(1, new OtherChatAdapter());
	}

	@Override
	public int getItemViewType(int position) {
		ChatMessage item = getItem(position);

		if (item.getName().equals(name)) {
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
