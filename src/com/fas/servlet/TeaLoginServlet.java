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
		
		//设置客户端的解码方式为utf-8
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
        //根据标示名获取表单所包含的参数
        String teaid =request.getParameter("teaid");
        String teapassword=request.getParameter("teapassword");
        String result = "";
        
        TeacherService teacherService = new TeacherService();
        result = teacherService.TeaLoginService(teaid, teapassword);
        System.out.println(result);
        PrintWriter out = response.getWriter();
		if (result == "success") {
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			out.print("<script>alert(\"账号或密码错误!\");window.location.href='index.jsp';</script>"); 
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
