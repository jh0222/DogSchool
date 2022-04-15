package com.ds.m1;

import java.sql.Date;

public class comment {
	private int c_no;
	private int c_mp_no;
	private String c_tid;
	private String c_uid;
	private String c_uname;
	private String c_txt;
	private String c_writer;
	private Date c_date;
	
	public comment() {
		// TODO Auto-generated constructor stub
	}

	public comment(int c_no, int c_mp_no, String c_tid, String c_uid, String c_uname, String c_txt, String c_writer,
			Date c_date) {
		super();
		this.c_no = c_no;
		this.c_mp_no = c_mp_no;
		this.c_tid = c_tid;
		this.c_uid = c_uid;
		this.c_uname = c_uname;
		this.c_txt = c_txt;
		this.c_writer = c_writer;
		this.c_date = c_date;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getC_mp_no() {
		return c_mp_no;
	}

	public void setC_mp_no(int c_mp_no) {
		this.c_mp_no = c_mp_no;
	}

	public String getC_tid() {
		return c_tid;
	}

	public void setC_tid(String c_tid) {
		this.c_tid = c_tid;
	}

	public String getC_uid() {
		return c_uid;
	}

	public void setC_uid(String c_uid) {
		this.c_uid = c_uid;
	}

	public String getC_uname() {
		return c_uname;
	}

	public void setC_uname(String c_uname) {
		this.c_uname = c_uname;
	}

	public String getC_txt() {
		return c_txt;
	}

	public void setC_txt(String c_txt) {
		this.c_txt = c_txt;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	
	
	
	
}
