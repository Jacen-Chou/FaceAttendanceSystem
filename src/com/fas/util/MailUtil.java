package com.fas.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.fas.dao.StudentDao;
import com.fas.vo.Student;

public class MailUtil {

	public void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDao stuDao = new StudentDao();
		Student s = new Student();
		s.setStuId("123456");
		s.setStuName("����ѧ��1");
		s.setStuPassword("147258");
		s.setStuEmail("774845313@qq.com");
		stuDao.insertStu(s);
		
		mailSend(s);
	}

	public void mailSend(Student stu) throws Exception {
		StudentDao stuDao = new StudentDao();
		String info;
		if (stu != null) {
			// ������������
			String password = GetStringRandom.getStringRandom(6);
			stu.setStuPassword(password);
			stuDao.updateStu(stu);

			// �����ʼ�
			Properties props = new Properties();
			props.load(this.getClass().getResourceAsStream("/mailConfig.properties"));

			Context ctx = new InitialContext();
			Session session = (Session) ctx.lookup("java:comp/env/mail/Session");// ͨ��JNDI�ķ�ʽ�õ�Session����
			
			//Context initCtx = new InitialContext();
		    //Context envCtx = (Context) initCtx.lookup("java:comp/env");
		    //Session session = (Session) envCtx.lookup("mail/Session");
			
			Message msg = new MimeMessage(session);// �����ʼ�����
			msg.setSubject("�һ�����֪ͨ");// �����ʼ�����
			String host = props.getProperty("mail.host");
			String email = props.getProperty("mail.username") + "@" + host.substring(host.indexOf(".") + 1);
			msg.setFrom(new InternetAddress(MimeUtility.encodeText("ϵͳ����") + " <" + email + ">"));// �����ʼ���Դ
			String msgContent = "�װ���" + stu.getStuName() + "�����ã�<br/><br/>" + "����"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "�ύ���һ����������<br/><br/>"
					+ "�����������ʻ�����ʱ������Ϣ��<br/><br/>" + "�û�����" + stu.getStuName() + "����ʱ���룺" + password + "<br/><br/>"
					+ "����������ʱ���룬���������޸����룬��лʹ�ñ�ϵͳ��" + "<br/><br/>" + "��Ϊ�Զ������ʼ�������ֱ�ӻظ���";
			msg.setContent(msgContent, "text/html;charset=utf-8");// �����ʼ����ݣ�Ϊhtml��ʽ
			// �����ʼ�
			Transport transport = session.getTransport();// �����ʼ����Ͷ���
			transport.connect(host, props.getProperty("mail.username"), props.getProperty("mail.password"));// �����ʼ�������
			transport.sendMessage(msg, InternetAddress.parse(stu.getStuEmail()));// ���û������䷢���ʼ�
			transport.close();// �ر�����
			info = "�ʼ����ͳɹ�";
			// request.setAttribute("host", "mail." +
			// userForm.getEmail().substring(userForm.getEmail().indexOf("@") +
			// 1));// ���û��������������ַ���ص�ǰ̨�������û���¼
		} else {
			info = "�ʼ����ʹ���";
		}
	}
}

