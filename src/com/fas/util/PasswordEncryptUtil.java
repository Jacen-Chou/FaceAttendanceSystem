package com.fas.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.naming.NamingException;

import com.fas.dao.StudentDao;
import com.fas.vo.Student;

public class PasswordEncryptUtil {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String salt = getStringRandom(5);
//		String password = "147258";
//		// test = SHA512("hello world!");
//		String encrypt = SHA512((SHA512(password, "SHA-512") + salt), "SHA-512");
//		System.out.println(salt);
//		System.out.println(encrypt);
	}

	/**
	 * 字符串 SHA 加密
	 * 
	 * @param strSourceText
	 * @return
	 */
	public static String SHA512(String strText) {
		//返回值
		String strResult = "";

		//是否是有效字符串
		if (strText != null && strText.length() > 0) {
			try {
				//SHA加密开始
				//创建加密对象，并传入加密类型
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				//传入要加密的字符串
				messageDigest.update(strText.getBytes());
				//得到 byte类型结果
				byte byteBuffer[] = messageDigest.digest();

				//将byte转换为string
				StringBuffer strHexString = new StringBuffer();
				//遍历byte buffer
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if (hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				//得到返回结果
				strResult = strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}

}
