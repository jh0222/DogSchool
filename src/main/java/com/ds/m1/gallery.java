package com.ds.m1;

import java.sql.Date;

public class gallery {
	private int g_no;
	private String g_title;
	private String g_img;
	private String g_tid;
	private String g_uid;
	private String g_uname;
	private Date g_date;
		
	public gallery() {
		// TODO Auto-generated constructor stub
	}

	public gallery(int g_no, String g_title, String g_img, String g_tid, String g_uid, String g_uname, Date g_date) {
		super();
		this.g_no = g_no;
		this.g_title = g_title;
		this.g_img = g_img;
		this.g_tid = g_tid;
		this.g_uid = g_uid;
		this.g_uname = g_uname;
		this.g_date = g_date;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_img() {
		return g_img;
	}

	public void setG_img(String g_img) {
		this.g_img = g_img;
	}

	public String getG_tid() {
		return g_tid;
	}

	public void setG_tid(String g_tid) {
		this.g_tid = g_tid;
	}

	public String getG_uid() {
		return g_uid;
	}

	public void setG_uid(String g_uid) {
		this.g_uid = g_uid;
	}

	public String getG_uname() {
		return g_uname;
	}

	public void setG_uname(String g_uname) {
		this.g_uname = g_uname;
	}

	public Date getG_date() {
		return g_date;
	}

	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}
	
	
}
