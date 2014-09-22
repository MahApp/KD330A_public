package se.mah.kd330a.assignment4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.mah.kd330a.assignment4.adapters.ChatAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends Activity {

    Firebase mFirebase = new Firebase("https://kd330a.firebaseio.com/");

    EditText message;

    // TODO: You need to set your name here!
    String name = "Ante";
    // TODO: You need to set your name here!

    List<ChatMessage> messages;

    ChatAdapter mAdapter;

    // Used to format the date
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    ChatListener mChatListener = new ChatListener();

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	list = (ListView) findViewById(R.id.list);

	message = (EditText) findViewById(R.id.message);

	Button send = (Button) findViewById(R.id.send);
	send.setOnClickListener(new SendMessage());

	messages = new ArrayList<ChatMessage>();

	mAdapter = new ChatAdapter(this, messages);

	list.setAdapter(mAdapter);

	mFirebase.child("messages").addChildEventListener(mChatListener);

    }

    public String getName() {
	return name;
    }

    @Override
    protected void onDestroy() {
	mFirebase.child("messages").removeEventListener(mChatListener);
	super.onDestroy();
    }

    /**
     * This listener handles the "send" task
     * 
     * @author ksango
     * 
     */
    private class SendMessage implements OnClickListener {
	@Override
	public void onClick(View v) {
	    if (name == null) {
		// Make sure you've added a name!
		Toast.makeText(
			MainActivity.this,
			"You need to enter your name in code, look for \"String name = null\"",
			Toast.LENGTH_SHORT).show();
	    } else {
		// Send a message
		mFirebase.child("messages").push().setValue(composeMessage());
	    }
	}
    }

    /**
     * Method that composes a new message.
     * 
     * @return the new message
     */
    private Map<String, Object> composeMessage() {
	Map<String, Object> map = new HashMap<String, Object>();

	map.put("name", name);
	map.put("message", message.getText().toString());
	map.put("time", sdf.format(Calendar.getInstance().getTime()));

	return map;
    }

    private class ChatListener implements ChildEventListener {

	@Override
	public void onCancelled(FirebaseError snapshot) {
	}

	@Override
	public void onChildAdded(DataSnapshot snapshot, String s) {
	    ChatMessage msg = snapshot.getValue(ChatMessage.class);
	    messages.add(msg);
	    mAdapter.notifyDataSetChanged();
	}

	@Override
	public void onChildChanged(DataSnapshot snapshot, String s) {
	}

	@Override
	public void onChildMoved(DataSnapshot snapshot, String s) {
	}

	@Override
	public void onChildRemoved(DataSnapshot snapshot) {
	}

    }
}
