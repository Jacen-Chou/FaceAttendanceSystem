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
	 * �ַ��� SHA ����
	 * 
	 * @param strSourceText
	 * @return
	 */
	public static String SHA512(String strText) {
		//����ֵ
		String strResult = "";

		//�Ƿ�����Ч�ַ���
		if (strText != null && strText.length() > 0) {
			try {
				//SHA���ܿ�ʼ
				//�������ܶ��󣬲������������
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
				//����Ҫ���ܵ��ַ���
				messageDigest.update(strText.getBytes());
				//�õ� byte���ͽ��
				byte byteBuffer[] = messageDigest.digest();

				//��byteת��Ϊstring
				StringBuffer strHexString = new StringBuffer();
				//����byte buffer
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if (hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				//�õ����ؽ��
				strResult = strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}

}
