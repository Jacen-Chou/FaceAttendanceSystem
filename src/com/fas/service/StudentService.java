package com.fas.service;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.fas.dao.AttendanceDao;
import com.fas.dao.StudentDao;
import com.fas.util.GetStringRandom;
import com.fas.util.MailUtil;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Attendance;
import com.fas.vo.Student;
import com.sun.accessibility.internal.resources.accessibility;

public class StudentService {

	/**
	 * @Title: AndroidRegisterService
	 * @Description: 通过安卓APP注册
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @return
	 * @exception null
	 */
	public String AndroidRegisterService(String id, String name, String password, String email) {

		Student s = new Student();
		StudentDao stuDao = new StudentDao();

		s = stuDao.queryStuById(id);
		if (s.getStuId() == null) {
			// 当前用户id不存在，即可注册
			String salt = GetStringRandom.getStringRandom(5);
			String passwordEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(password) + salt));
			
			s.setStuId(id);
			s.setStuName(name);
			s.setStuPassword(passwordEncrypt);
			s.setStuEmail(email);
			s.setStuSalt(salt);
			stuDao.insertStu(s);
			return "success";
		} else {
			return "fail";
		}

	}

	/**
	 * @Title: AndroidLoginService
	 * @Description: 通过安卓APP登陆
	 * @param id
	 * @param password
	 * @return
	 * @exception null
	 */
	public String AndroidLoginService(String id, String password) {

		Student s = new Student();
		StudentDao stuDao = new StudentDao();
		s = stuDao.queryStuById(id);

		String salt = s.getStuSalt();
		String passwordEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(password) + salt));
		String passwordDatabase = s.getStuPassword();
		if (id.equals(s.getStuId()) && passwordEncrypt.equals(passwordDatabase)) {
			return "success";
		} else {
			return "fail";
		}

	}
	
	/**
	 * @Title: AndroidForgetPasswordService 
	 * @Description: 忘记密码，设置初始密码
	 * @param id
	 * @return
	 * @throws Exception      
	 * @exception null
	 */
	public String AndroidForgetPasswordService(String id) throws Exception {
		Student s = new Student();
		StudentDao stuDao = new StudentDao();
		s = stuDao.queryStuById(id);
		
		if(s.getStuId() != null){
			
			// 重新设置密码，使用GetStringRandom方法
			String password = GetStringRandom.getStringRandom(6);
			String salt = s.getStuSalt();
			String passwordEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(password) + salt));
			s.setStuPassword(passwordEncrypt);
			stuDao.updateStu(s);
			
			MailUtil mailUtil = new MailUtil();
			mailUtil.mailSend(s, password);
			return "success";
		} else {
			return "fail";
		}
		
	}
	
	
	/**
 	 * @Title: AndroidIfRegisteredFaceService 
	 * @Description: 判断是否注册过人脸
	 * @param id
	 * @return      
	 * @exception null
	 */
	public String AndroidIfRegisteredFaceService(String id) {
		
        StudentDao stuDao = new StudentDao();
        Student s = new Student();
        s=stuDao.queryStuById(id);
        
        System.out.println(s.getStuFaceIsRegistered());
        if(s.getStuFaceIsRegistered().equals("false")){
        	return "success";
        }else{
        	return "fail";
        }
		
	}
	
	/**
	 * @Title: AndroidFaceRegisterService 
	 * @Description: 注册人脸
	 * @param id
	 * @param registereFace
	 * @return      
	 * @exception null
	 */
	public String AndroidFaceRegisterService(String id) {
		
		StudentDao stuDao = new StudentDao();
		Student s = new Student();
        s=stuDao.queryStuById(id);
        
        if(s.getStuFaceIsRegistered().equals("false")){
        	s.setStuFaceIsRegistered("true");
        	stuDao.updateStu(s);
        	return "success";
        }else{
        	return "fail";
        }
	}
	
	
	/**
	 * @Title: AndroidAttendanceService
	 * @Description: 学生打卡考勤
	 * @param id
	 * @param judge
	 * @return
	 * @exception null
	 */
	public String AndroidAttendanceService(String id, String judge) {

		if (judge.equals("true")) {

			// 确定打卡的学生
			StudentDao stuDao = new StudentDao();
			Student s = new Student();
			s = stuDao.queryStuById(id);

			// 记录考勤相关信息
			AttendanceDao attendaceDao = new AttendanceDao();
			Attendance attendance = new Attendance();
			attendance.setId(id);
			attendance.setName(s.getStuName());
			attendance.setDate(new java.sql.Date(new java.util.Date().getTime()));
			attendance.setTime(new java.sql.Time(System.currentTimeMillis()));

			// 插入数据库
			attendaceDao.insertAttendance(attendance);
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 * @Title: AndroidQueryAllAttByIdService 
	 * @Description: 查询考勤记录
	 * @param id
	 * @return      
	 * @exception null
	 */
	public String AndroidQueryAllAttByIdService(String id) {
		
		AttendanceDao attendanceDao = new AttendanceDao();
		List<Attendance> list = attendanceDao.queryAttendanceById(id);
		
		String result = "";
		for (Attendance e : list) {
			result = result + "+" + e.toString();
		}
		return result;
	}
}
