package com.fas.services;

import com.fas.dao.StudentDao;
import com.fas.vo.Student;

public class RegisterServices {

	public String AndroidRegisterService(String id, String name, String password, String email) {
		
        Student s = new Student();
        StudentDao stuDao = new StudentDao();
        
        s = stuDao.queryStuById(id);
        if (s == null) {
        	//当前用户id不存在
        	s.setStuId(id);
        	s.setStuName(name);
        	s.setStuPassword(password);
        	s.setStuEmail(email);
        	stuDao.insertStu(s);
        	return "true";
        } else {
        	return "id already exists.";
        }
        
        
	}
	
}
