package com.example.kd330a_assignment_5_starter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.kd330a_assignment_5_starter.fragments.ChatFragment;
import com.example.kd330a_assignment_5_starter.fragments.LoginFragment;

public class FragmentController {

	private FragmentManager mFragmentManager;

	private String currentFragmentTag;

	public FragmentController(FragmentManager manager) {
		mFragmentManager = manager;
	}

	public void showLoginFragment() {
		LoginFragment loginFragment = new LoginFragment();
		showFragment(loginFragment, "login", false);
	}

	public void showChatFragment(String group, String name) {
		ChatFragment chatFragment = new ChatFragment(group, name);
		showFragment(chatFragment, "chat", true);
	}

	private void showFragment(Fragment fragment, String tag, boolean backstack) {
		FragmentTransaction transaction = mFragmentManager.beginTransaction();

		transaction.replace(R.id.container, fragment, tag);

		if (backstack)
			transaction.addToBackStack(tag);

		currentFragmentTag = tag;

		transaction.commit();
	}

	public Fragment getCurrentFragment() {
		return mFragmentManager.findFragmentByTag(currentFragmentTag);
	}
}
