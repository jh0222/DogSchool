package com.ds.m3;

import java.util.Date;

	public class applyBean {
		private String a_id;
		private String a_name;
		private String a_gender;
		private Date a_start;
		private Date a_end;
		private int a_age;
		private String a_tname;
		private String a_img;
		private int a_agree;
		
	 public applyBean() {
		// TODO Auto-generated constructor stub
	}
	
	public applyBean(String a_id, String a_name, String a_gender, Date a_start, Date a_end, int a_age, String a_tname,
			String a_img, int a_agree) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_gender = a_gender;
		this.a_start = a_start;
		this.a_end = a_end;
		this.a_age = a_age;
		this.a_tname = a_tname;
		this.a_img = a_img;
		this.a_agree = a_agree;
	}
	
	public String getA_id() {
		return a_id;
	}
	
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	
	public String getA_name() {
		return a_name;
	}
	
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	
	public String getA_gender() {
		return a_gender;
	}
	
	public void setA_gender(String a_gender) {
		this.a_gender = a_gender;
	}
	
	public Date getA_start() {
		return a_start;
	}
	
	public void setA_start(Date a_start) {
		this.a_start = a_start;
	}
	
	public Date getA_end() {
		return a_end;
	}
	
	public void setA_end(Date a_end) {
		this.a_end = a_end;
	}
	
	public int getA_age() {
		return a_age;
	}
	
	public void setA_age(int a_age) {
		this.a_age = a_age;
	}
	
	public String getA_tname() {
		return a_tname;
	}
	
	public void setA_tname(String a_tname) {
		this.a_tname = a_tname;
	}
	
	public String getA_img() {
		return a_img;
	}
	
	public void setA_img(String a_img) {
		this.a_img = a_img;
	}
	
	public int getA_agree() {
		return a_agree;
	}
	
	public void setA_agree(int a_agree) {
		this.a_agree = a_agree;
	}
		
		
	
	
}
