package com.example.kd330a_assignment_5_starter.adapters;

import java.text.SimpleDateFormat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public interface ChatAdapterDelegate {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	public View getView(int position, View convertView, ViewGroup parent,
			LayoutInflater inflater, Object item);

	static class ViewHolder {
		TextView name;
		TextView message;
		TextView time;
	}
}
