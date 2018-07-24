package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fas.dao.TeacherDao;
import com.fas.service.StudentService;
import com.fas.service.TeacherService;
import com.fas.vo.Teacher;

/**
 * Servlet implementation class TeaLoginServlet
 */
@WebServlet("/TeaLoginServlet")
public class TeaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaLoginServlet() {
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
		
		//���ÿͻ��˵Ľ��뷽ʽΪutf-8
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
        //���ݱ�ʾ����ȡ���������Ĳ���
        String teaid =request.getParameter("teaid");
        String teapassword=request.getParameter("teapassword");
        String result = "";
        
        TeacherService teacherService = new TeacherService();
        result = teacherService.TeaLoginService(teaid, teapassword);
        System.out.println(result);
        
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacher = new Teacher();
		teacher = teacherDao.queryTeaById(teaid);
		String teaname =teacher.getTeaname();
        
        PrintWriter out = response.getWriter();
		//��ȡSession
		HttpSession session = request.getSession();
		if (result == "success") {
			session.setAttribute("teaname", teaname);
			session.setAttribute("teaid", teaid);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			out.print("<script>alert(\"�˺Ż��������!\");window.location.href='index.jsp';</script>"); 
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
