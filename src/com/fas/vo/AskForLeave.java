package com.fas.vo;

import java.util.Date;

public class AskForLeave {
	
	private String stuid;
	private String teaid;
	private Date date;
	private int numberOfDays;
	private String reason;
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getTeaid() {
		return teaid;
	}
	public void setTeaid(String teaid) {
		this.teaid = teaid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
