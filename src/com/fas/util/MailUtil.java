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
		s.setStuName("测试学生1");
		s.setStuPassword("147258");
		s.setStuEmail("774845313@qq.com");
		stuDao.insertStu(s);
		
		mailSend(s);
	}

	public void mailSend(Student stu) throws Exception {
		StudentDao stuDao = new StudentDao();
		String info;
		if (stu != null) {
			// 重新设置密码
			String password = GetStringRandom.getStringRandom(6);
			stu.setStuPassword(password);
			stuDao.updateStu(stu);

			// 设置邮件
			Properties props = new Properties();
			props.load(this.getClass().getResourceAsStream("/mailConfig.properties"));

			Context ctx = new InitialContext();
			Session session = (Session) ctx.lookup("java:comp/env/mail/Session");// 通过JNDI的方式得到Session对象
			
			//Context initCtx = new InitialContext();
		    //Context envCtx = (Context) initCtx.lookup("java:comp/env");
		    //Session session = (Session) envCtx.lookup("mail/Session");
			
			Message msg = new MimeMessage(session);// 创建邮件对象
			msg.setSubject("找回密码通知");// 设置邮件主题
			String host = props.getProperty("mail.host");
			String email = props.getProperty("mail.username") + "@" + host.substring(host.indexOf(".") + 1);
			msg.setFrom(new InternetAddress(MimeUtility.encodeText("系统中心") + " <" + email + ">"));// 设置邮件来源
			String msgContent = "亲爱的" + stu.getStuName() + "，您好，<br/><br/>" + "您在"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "提交了找回密码的请求。<br/><br/>"
					+ "以下是您的帐户及临时密码信息：<br/><br/>" + "用户名：" + stu.getStuName() + "，临时密码：" + password + "<br/><br/>"
					+ "该密码是临时密码，请您尽快修改密码，感谢使用本系统。" + "<br/><br/>" + "此为自动发送邮件，请勿直接回复！";
			msg.setContent(msgContent, "text/html;charset=utf-8");// 设置邮件内容，为html格式
			// 发送邮件
			Transport transport = session.getTransport();// 创建邮件发送对象
			transport.connect(host, props.getProperty("mail.username"), props.getProperty("mail.password"));// 连接邮件服务器
			transport.sendMessage(msg, InternetAddress.parse(stu.getStuEmail()));// 向用户的邮箱发送邮件
			transport.close();// 关闭连接
			info = "邮件发送成功";
			// request.setAttribute("host", "mail." +
			// userForm.getEmail().substring(userForm.getEmail().indexOf("@") +
			// 1));// 将用户的邮箱服务器地址返回到前台，方便用户登录
		} else {
			info = "邮件发送错误";
		}
	}
}

