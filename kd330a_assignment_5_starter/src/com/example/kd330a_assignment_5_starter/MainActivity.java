package com.example.kd330a_assignment_5_starter;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kd330a_assignment_5_starter.data.ChatMessage;
import com.example.kd330a_assignment_5_starter.fragments.ChatFragment;
import com.example.kd330a_assignment_5_starter.fragments.ChatFragment.OnMessageSentListener;
import com.example.kd330a_assignment_5_starter.fragments.LoginFragment.OnLoginListener;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends Activity implements OnLoginListener,
		OnMessageSentListener {

	private int NOTIF = 1;

	private NotificationManagerCompat notificationManagerCompat;

	protected static final String TAG = null;

	private Firebase mFirebase;

	private FragmentController mController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mController = new FragmentController(getFragmentManager());

		mFirebase = new Firebase("https://kd330a.firebaseio.com");

		notificationManagerCompat = NotificationManagerCompat.from(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mController.showLoginFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private ChildEventListener chatListener = new ChildEventListener() {

		@Override
		public void onChildRemoved(DataSnapshot data) {
		}

		@Override
		public void onChildMoved(DataSnapshot data, String s) {
		}

		@Override
		public void onChildChanged(DataSnapshot data, String s) {
		}

		@Override
		public void onChildAdded(DataSnapshot data, String s) {
			try {
				ChatMessage message = data.getValue(ChatMessage.class);
				ChatFragment chat = (ChatFragment) mController
						.getCurrentFragment();
				chat.addMessage(message);

				// TODO: Make sure to only show this message for notifications
				// AFTER you log in
				// Hint: Use the "message.getTime()" value
				showNotification(
						message.getName() + " wrote " + message.getMessage(),
						message.getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onCancelled(FirebaseError e) {
			Log.e(TAG, e.getMessage());
		}
	};

	@Override
	public void onLogin(String name, String group) {
		if (!(name != null && name.length() > 0)
				|| !(group != null && group.length() > 0)) {
			Toast.makeText(MainActivity.this, R.string.app_name,
					Toast.LENGTH_SHORT).show();
		} else {
			// Send "join" message
			long now = Calendar.getInstance().getTimeInMillis();
			ChatMessage message = new ChatMessage(name, name
					+ " just joined the group.", now);
			mFirebase.child(group).push().setValue(message);
			// Register listener
			mFirebase.child(group).addChildEventListener(chatListener);
			// Change to chat fragment
			mController.showChatFragment(group, name);

			// TODO: Maybe write something here? But what??
		}
	}

	@Override
	public void onNewMessageSent(ChatMessage message, String group) {
		mFirebase.child(group).push().setValue(message.getMap());
	}

	// TODO: Alter this method to display an inbox style notification instead!
	public void showNotification(String newMessage, long when) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("MAH Chat").setContentText(newMessage)
				.setWhen(when);

		notificationManagerCompat.notify(NOTIF, mBuilder.build());
	}
}
