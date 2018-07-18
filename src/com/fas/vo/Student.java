package com.fas.vo;

import java.util.Random;

import com.fas.util.GetStringRandom;
import com.fas.util.PasswordEncryptUtil;

public class Student {
	
	private String stuId;
	private String stuName;
	private String stuPassword;
	private String stuEmail;
	private String stuSalt;
	private String stuFaceIsRegistered;
	
	public String getStuSalt() {
		return stuSalt;
	}
	public void setStuSalt(String stuSalt) {
		this.stuSalt = stuSalt;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuFaceIsRegistered() {
		return stuFaceIsRegistered;
	}
	public void setStuFaceIsRegistered(String stuIsRegistered) {
		this.stuFaceIsRegistered = stuIsRegistered;
	}

}
