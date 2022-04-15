package com.ds.login;

public class TAccount {
	private String t_id;
	private String t_pw;
	private String t_name;
	private String t_phonenumber;
	private String t_gender;
	private String t_text;
	
	public TAccount() {
		// TODO Auto-generated constructor stub
	}

	public TAccount(String t_id, String t_pw, String t_name, String t_phonenumber, String t_gender, String t_text) {
		super();
		this.t_id = t_id;
		this.t_pw = t_pw;
		this.t_name = t_name;
		this.t_phonenumber = t_phonenumber;
		this.t_gender = t_gender;
		this.t_text = t_text;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_pw() {
		return t_pw;
	}

	public void setT_pw(String t_pw) {
		this.t_pw = t_pw;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_phonenumber() {
		return t_phonenumber;
	}

	public void setT_phonenumber(String t_phonenumber) {
		this.t_phonenumber = t_phonenumber;
	}

	public String getT_gender() {
		return t_gender;
	}

	public void setT_gender(String t_gender) {
		this.t_gender = t_gender;
	}

	public String getT_text() {
		return t_text;
	}

	public void setT_text(String t_text) {
		this.t_text = t_text;
	}
	
	
}
