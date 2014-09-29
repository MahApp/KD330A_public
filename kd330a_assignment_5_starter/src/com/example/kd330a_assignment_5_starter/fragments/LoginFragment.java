package com.example.kd330a_assignment_5_starter.fragments;

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

import com.example.kd330a_assignment_5_starter.R;

public class LoginFragment extends Fragment {

	private static final String TAG = "LoginFragment";

	private EditText name, group;

	private OnLoginListener mLoginListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// TODO: Write code here
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mLoginListener = (OnLoginListener) activity;
		} catch (Exception e) {
			Log.e(TAG, "Activity must implement OnLoginListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_login, container, false);

		name = (EditText) root.findViewById(R.id.fragment_login_name);
		group = (EditText) root.findViewById(R.id.fragment_login_group);

		Button login = (Button) root.findViewById(R.id.fragment_login_start);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mLoginListener.onLogin(name.getText().toString(), group
						.getText().toString());
			}
		});

		return root;
	}

	public interface OnLoginListener {
		public void onLogin(String name, String group);
	}
}
