package com.fas.services;

import com.fas.dao.StudentDao;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Student;

public class LoginServices {
	
	public String AndroidLoginService(String id, String password) {
		
		Student s = new Student();
        StudentDao stuDao = new StudentDao();
        s = stuDao.queryStuById(id);
        
        String salt = s.getStuSalt();
        String password_encrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(password, "SHA-512") + salt), "SHA-512");
        
        if(id.equals(s.getStuId())&&password_encrypt.equals(s.getStuPassword())){
        	return "success";
        } else {
        	return "fail";
        }
		
	}

}
