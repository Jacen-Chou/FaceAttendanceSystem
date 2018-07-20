package com.fas.vo;

import java.sql.Time;
import java.util.Date;

public class Attendance {
	
	private String id;
	private String name;
	private Date date; 
	private Time time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//重写toString方法，否则输出的是com.fas.vo.Attendance@******
		//即每个Java类自带的toString()方法的具体内容：getClass().getName() + '@' + Integer.toHexString(hashCode())
		String a = id+"  "+name+"  "+date+"  "+time;
		return a;
		
	}
	
	
	

}
