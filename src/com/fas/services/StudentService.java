package com.fas.services;

import com.fas.dao.StudentDao;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Student;

public class StudentService {

	public String AndroidRegisterService(String id, String name, String password, String email) {

		Student s = new Student();
		StudentDao stuDao = new StudentDao();

		s = stuDao.queryStuById(id);
		if (s.getStuId() == null) {
			// 当前用户id不存在
			s.setStuId(id);
			s.setStuName(name);
			s.setStuPassword(password);
			s.setStuEmail(email);
			stuDao.insertStu(s);
			return "success";
		} else {
			return "id already exists.";
		}

	}
	
	public String AndroidLoginService(String id, String password) {

		Student s = new Student();
		StudentDao stuDao = new StudentDao();
		s = stuDao.queryStuById(id);

		String salt = s.getStuSalt();
		String password_encrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(password, "SHA-512") + salt),
				"SHA-512");

		if (id.equals(s.getStuId()) && password_encrypt.equals(s.getStuPassword())) {
			return "success";
		} else {
			return "fail";
		}

	}

}
