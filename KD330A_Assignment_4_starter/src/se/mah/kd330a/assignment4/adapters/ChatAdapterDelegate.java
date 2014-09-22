package se.mah.kd330a.assignment4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public interface ChatAdapterDelegate {
    public View getView(int position, View convertView, ViewGroup parent,
	    LayoutInflater inflater, Object item);

    static class ViewHolder {
	TextView name;
	TextView message;
	TextView time;
    }
}
