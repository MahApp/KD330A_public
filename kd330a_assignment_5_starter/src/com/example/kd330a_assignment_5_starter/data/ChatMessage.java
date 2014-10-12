package com.example.kd330a_assignment_5_starter.data;

import java.util.HashMap;
import java.util.Map;

import com.shaded.fasterxml.jackson.annotation.JsonIgnore;

public class ChatMessage {

	private String name;
	private String message;
	private long time;

	public ChatMessage() {
		// Required by firebase
	}

	public ChatMessage(String name, String message, long time) {
		super();
		this.name = name;
		this.message = message;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	public Object getMap() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", name);
		map.put("message", message);
		map.put("time", time);

		return map;
	}

}
