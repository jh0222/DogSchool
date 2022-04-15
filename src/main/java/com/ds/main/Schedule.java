package com.ds.main;

public class Schedule {
	private String mon;
	private String tue;
	private String wed;
	private String thur;
	private String fri;
	private String sat;
	private String sun;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(String mon, String tue, String wed, String thur, String fri, String sat, String sun) {
		super();
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thur = thur;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public String getThur() {
		return thur;
	}

	public void setThur(String thur) {
		this.thur = thur;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}
	
}
