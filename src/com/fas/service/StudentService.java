package com.fas.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fas.dao.AskForLeaveDao;
import com.fas.dao.AttendanceDao;
import com.fas.dao.StudentDao;
import com.fas.util.GetStringRandom;
import com.fas.util.MailUtil;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.AskForLeave;
import com.fas.vo.Attendance;
import com.fas.vo.Student;

public class StudentService {

	/**
	 * @Title: AndroidRegisterService
	 * @Description: ͨ����׿APPע��
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
			// ��ǰ�û�id�����ڣ�����ע��
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
	 * @Description: ͨ����׿APP��½
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
	 * @Description: �������룬���ó�ʼ����
	 * @param id
	 * @return
	 * @throws Exception
	 * @exception null
	 */
	public String AndroidForgetPasswordService(String id) throws Exception {
		Student s = new Student();
		StudentDao stuDao = new StudentDao();
		s = stuDao.queryStuById(id);

		if (s.getStuId() != null) {

			// �����������룬ʹ��GetStringRandom����
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
	 * @Description: �ж��Ƿ�ע�������
	 * @param id
	 * @return
	 * @exception null
	 */
	public String AndroidIfRegisteredFaceService(String id, String flag) {

		StudentDao stuDao = new StudentDao();
		Student s = new Student();
		s = stuDao.queryStuById(id);

		System.out.println(s.getStuFaceIsRegistered());
		if (s.getStuFaceIsRegistered().equals("false")) {
			return "success";
		} else {
			if (flag == "2") {
				s.setStuFaceIsRegistered("false");
			}
			return "fail";
		}

	}

	/**
	 * @Title: AndroidFaceRegisterService
	 * @Description: ע������
	 * @param id
	 * @param registereFace
	 * @return
	 * @exception null
	 */
	public String AndroidFaceRegisterService(String id) {

		StudentDao stuDao = new StudentDao();
		Student s = new Student();
		s = stuDao.queryStuById(id);

		if (s.getStuFaceIsRegistered().equals("false")) {
			s.setStuFaceIsRegistered("true");
			stuDao.updateStu(s);
			return "success";
		} else {
			return "fail";
		}
	}

	/**
	 * @Title: AndroidAttendanceService
	 * @Description: ѧ���򿨿���
	 * @param id
	 * @param judge
	 * @return
	 * @exception null
	 */
	public String AndroidAttendanceService(String id, String judge, String ip) {

		String regex = "10\\.24\\.[0-9]{1,3}\\.[0-9]{1,3}";
		if (!Pattern.matches(regex, ip)) { // IP��ƥ��
			return "ip_error";
		} else { // IPƥ��
			if (judge.equals("true")) { // ���Ŷ�����
				// ȷ���򿨵�ѧ��
				StudentDao stuDao = new StudentDao();
				Student s = new Student();
				s = stuDao.queryStuById(id);

				// ��¼���������Ϣ
				AttendanceDao attendaceDao = new AttendanceDao();
				Attendance attendance = new Attendance();
				attendance.setId(id);
				attendance.setName(s.getStuName());
				attendance.setDate(new java.sql.Date(new java.util.Date().getTime()));
				attendance.setTime(new java.sql.Time(System.currentTimeMillis()));

				// �������ݿ�
				attendaceDao.insertAttendance(attendance);
				return "success";
			} else { // ���ŶȲ�����
				return "fail";
			}
		}
	}

	/**
	 * @Title: AndroidQueryAllAttByIdService
	 * @Description: ��ѯ���ڼ�¼
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

	/**
	 * @Title: AndroidAskForLeaveService
	 * @Description: ��ٹ���
	 * @param stuid
	 * @param teaid
	 * @param date
	 * @param numberOfDays
	 * @param reason
	 * @return
	 * @exception null
	 */
	public String AndroidAskForLeaveService(String stuid, String teaid, Date date, int numberOfDays, String reason) {
		AskForLeaveDao askForLeaveDao = new AskForLeaveDao();
		AskForLeave askForLeave = new AskForLeave();

		StudentDao stuDao = new StudentDao();
		Student s = new Student();
		s = stuDao.queryStuById(stuid);

		if (s.getStuId() != null) {

			// ��¼��������Ϣ
			askForLeave.setStuid(stuid);
			askForLeave.setTeaid(teaid);
			askForLeave.setDate(date);
			askForLeave.setNumberOfDays(numberOfDays);
			askForLeave.setReason(reason);
			// �������ݿ�
			askForLeaveDao.insertAskForLeave(askForLeave);
			return "success";
		} else {
			return "fail";
		}

	}

	/**
	 * @Title: AnroidQueryPersonalInfoService 
	 * @Description: ��ѯ������Ϣ
	 * @param id
	 * @return      
	 * @exception null
	 */
	public String AnroidQueryPersonalInfoService(String id) {
		
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		
		student = studentDao.queryStuById(id);
		JSONArray array=new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("id", student.getStuId());
		obj.put("name", student.getStuName());
		obj.put("email", student.getStuEmail());
		obj.put("face_is_registered", student.getStuFaceIsRegistered());
		String result = obj.toString();
		
		return result;
	}
	
	/**
	 * @Title: AndroidStuModifyPasswordService 
	 * @Description: �޸�����
	 * @param id
	 * @param old_pass
	 * @param new_pass
	 * @return      
	 * @exception null
	 */
	public String AndroidStuModifyPasswordService(String id, String old_pass, String new_pass) {

		StudentDao studentDao = new StudentDao();
		Student s = new Student();
		s = studentDao.queryStuById(id);

		if (s.getStuId() != null) {
			String salt = s.getStuSalt();
			String oldPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(old_pass) + salt));
			if (oldPassEncrypt.equals(s.getStuPassword())) {
				String newPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(new_pass) + salt));
				s.setStuPassword(newPassEncrypt);
				studentDao.updateStu(s);
				return "success";
			} else {
				return "pass_error";
			}
		} else {
			return "fail";
		}
	}

}
