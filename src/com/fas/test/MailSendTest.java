package com.fas.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.StudentDao;
import com.fas.util.GetStringRandom;
import com.fas.util.MailUtil;
import com.fas.vo.Student;

/**
 * Servlet implementation class MailTest2
 */
@WebServlet("/MailTest2")
public class MailSendTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSendTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StudentDao stuDao = new StudentDao();
				
		Student s = new Student();
		s.setStuId("41500011");
		s.setStuName("≤‚ ‘—ß…˙11");
		s.setStuPassword("147258");
		s.setStuEmail("774845313@qq.com");
		stuDao.insertStu(s);
		String password = GetStringRandom.getStringRandom(6);
		MailUtil mailUtil = new MailUtil();
		try {
			mailUtil.mailSend(s, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
