package com.tech.entity;

import java.sql.Timestamp;

public class Post {
	private int pid, categoryid, userid;
	private String content, photo, title;
	private Timestamp time;

	public Post() {
		super();
	}

	public Post(int pid, int categoryid, int userid, String content, String photo, String title, Timestamp time) {
		super();
		this.pid = pid;
		this.categoryid = categoryid;
		this.userid = userid;
		this.content = content;
		this.photo = photo;
		this.title = title;
		this.time = time;
	}

	public Post(int categoryid, int userid, String content, String photo, String title) {
		super();
		this.categoryid = categoryid;
		this.userid = userid;
		this.content = content;
		this.photo = photo;
		this.title = title;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("Post [pid=%s, categoryid=%s, userid=%s, content=%s, photo=%s, title=%s, time=%s]", pid,
				categoryid, userid, content, photo, title, time);
	}

}
