package com.ds.login;

public class Account {
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_phonenumber;
	private String u_gender;
	private String t_id;
	private String t_pw;
	private String t_name;
	private String t_phonenumber;
	private String t_gender;
	private String t_text;
	private String r_id;
	private String r_pw;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String u_id, String u_pw, String u_name, String u_phonenumber, String u_gender, String t_id,
			String t_pw, String t_name, String t_phonenumber, String t_gender, String t_text, String r_id,
			String r_pw) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_phonenumber = u_phonenumber;
		this.u_gender = u_gender;
		this.t_id = t_id;
		this.t_pw = t_pw;
		this.t_name = t_name;
		this.t_phonenumber = t_phonenumber;
		this.t_gender = t_gender;
		this.t_text = t_text;
		this.r_id = r_id;
		this.r_pw = r_pw;
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

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_pw() {
		return r_pw;
	}

	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	
}
