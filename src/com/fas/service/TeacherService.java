package com.fas.service;

import com.fas.dao.StudentDao;
import com.fas.dao.TeacherDao;
import com.fas.util.GetStringRandom;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Student;
import com.fas.vo.Teacher;

public class TeacherService {

	/**
	 * 教师注册
	 * @Title: TeaRegisterService 
	 * @Description:
	 * @param teaid
	 * @param teaname
	 * @param teapassword
	 * @param teaemail
	 * @param teaphone
	 * @return      
	 * @exception null
	 */
	public String TeaRegisterService(String teaid, String teaname, String teapassword, String teaemail, String teaphone) {

		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = new Teacher();;
		teacher = teacherDao.queryTeaById(teaid);
		
		if (teacher.getTeaid() == null) {
			// 当前用户id不存在，即可注册
			String salt = GetStringRandom.getStringRandom(5);
			String passwordEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(teapassword) + salt));

			teacher.setTeaid(teaid);
			teacher.setTeaname(teaname);
			teacher.setTeapassword(passwordEncrypt);
			teacher.setTeasalt(salt);
			teacher.setTeaemail(teaemail);
			teacher.setTeaphone(teaphone);
			teacherDao.insertTea(teacher);
			return "success";
		} else {
			return "fail";
		}

	}
	
	public String TeaLoginService(String teaid, String teapassword) {

		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = new Teacher();;
		teacher = teacherDao.queryTeaById(teaid);

		String salt = teacher.getTeasalt();
		String passwordEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(teapassword) + salt));
		String passwordDatabase = teacher.getTeapassword();
		if (teaid.equals(teacher.getTeaid()) && passwordEncrypt.equals(passwordDatabase)) {
			return "success";
		} else {
			return "fail";
		}

	}
	
	
}
