package com.example.kd330a_assignment_5_starter.fragments;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.kd330a_assignment_5_starter.R;
import com.example.kd330a_assignment_5_starter.adapters.ChatAdapter;
import com.example.kd330a_assignment_5_starter.data.ChatMessage;

public class ChatFragment extends Fragment {

	private static final String TAG = "ChatFragment";

	private ArrayList<ChatMessage> messages = new ArrayList<ChatMessage>();

	private ChatAdapter adapter;

	private OnMessageSentListener messageSentListener;

	private String group, name;

	private EditText message;

	private ListView listview;

	public ChatFragment(String group, String name) {
		this.name = name;
		this.group = group;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// TODO: Write code here
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_chat, container, false);

		message = (EditText) root.findViewById(R.id.fragment_chat_text);

		listview = (ListView) root.findViewById(R.id.fragment_chat_list);

		adapter = new ChatAdapter(getActivity(), messages, name);
		listview.setAdapter(adapter);

		Button send = (Button) root.findViewById(R.id.fragment_chat_send);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				long now = Calendar.getInstance().getTimeInMillis();
				ChatMessage msg = new ChatMessage(name, message.getText()
						.toString(), now);
				messageSentListener.onNewMessageSent(msg, group);
			}
		});

		return root;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			messageSentListener = (OnMessageSentListener) activity;
		} catch (Exception e) {
			Log.e(TAG, "Activity must implement OnMessageSentListener");
		}
	}

	public void addMessage(ChatMessage message) {
		messages.add(message);
		adapter.notifyDataSetChanged();
	}

	public interface OnMessageSentListener {
		public void onNewMessageSent(ChatMessage message, String group);
	}

}
