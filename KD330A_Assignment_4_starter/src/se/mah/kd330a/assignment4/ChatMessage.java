package se.mah.kd330a.assignment4;

/**
 * A chat message.
 * 
 * @author ksango
 * 
 */
public class ChatMessage {

    private String name;
    private String message;
    private String time;

    public ChatMessage() {
	// Required by Firebase
    }

    public ChatMessage(String sender, String message, String time) {
	super();
	this.name = sender;
	this.message = message;
	this.time = time;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }

}
