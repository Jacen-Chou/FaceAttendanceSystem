package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.service.StudentService;
import com.fas.service.TeacherService;

/**
 * Servlet implementation class TeaRegisterServlet
 */
@WebServlet("/TeaRegisterServlet")
public class TeaRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaRegisterServlet() {
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
		
        //设置客户端的解码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //根据标示名获取表单所包含的参数
        String teaid = request.getParameter("teaid");
        String teaname = request.getParameter("teaname");
        String teapassword = request.getParameter("teapassword");
        String teaemail = request.getParameter("teaemail");
        String teaphone = request.getParameter("teaphone");
        String result = "";
        
        TeacherService teacherService = new TeacherService();
        result = teacherService.TeaRegisterService(teaid, teaname, teapassword, teaemail, teaphone);
        System.out.println(result);
        
        request.setAttribute("teaid", teaid);
        request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
