package com.ds.login;

public class UAccount {
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_phonenumber;
	private String u_gender;
	
	public UAccount() {
		// TODO Auto-generated constructor stub
	}

	public UAccount(String u_id, String u_pw, String u_name, String u_phonenumber, String u_gender) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_phonenumber = u_phonenumber;
		this.u_gender = u_gender;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_phonenumber() {
		return u_phonenumber;
	}

	public void setU_phonenumber(String u_phonenumber) {
		this.u_phonenumber = u_phonenumber;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	
}
