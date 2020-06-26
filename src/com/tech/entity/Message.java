package com.tech.entity;

public class Message {
	private String type;
	private String message;
	private String cssClass;

	public Message(String type, String message, String cssClass) {
		super();
		this.type = type;
		this.message = message;
		this.cssClass = cssClass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
