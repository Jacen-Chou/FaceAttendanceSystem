package com.fas.vo;

import java.util.Random;

import com.fas.util.GetStringRandom;
import com.fas.util.PasswordEncryptUtil;

public class Student {
	
	private String stuId;
	private String stuName;
	private String stuPassword;
	private String stuEmail;
	private String stuData;
	private String stuSalt;
	
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
		String salt = GetStringRandom.getStringRandom(5);
		String encrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(stuPassword, "SHA-512") + salt), "SHA-512");
		setStuSalt(salt);
		this.stuPassword = encrypt;
	}
	public void setStuPassword_encrypt(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuData() {
		return stuData;
	}
	public void setStuData(String stuData) {
		this.stuData = stuData;
	}

}
