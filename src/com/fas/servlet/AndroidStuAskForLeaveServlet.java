package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.service.StudentService;

/**
 * Servlet implementation class AndroidStuAskForLeaveServlet
 */
@WebServlet("/AndroidStuAskForLeaveServlet")
public class AndroidStuAskForLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidStuAskForLeaveServlet() {
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
        String stuid = request.getParameter("stuid");
        String teaid = request.getParameter("teaid");
        String date_string = request.getParameter("date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		try {
			date = formatter.parse(date_string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int numberOfDays = Integer.parseInt(request.getParameter("numberofdays"));
        String reason = request.getParameter("reason");
        String result = "";
        
        StudentService studentService = new StudentService();
        result = studentService.AndroidAskForLeaveService(stuid, teaid, date, numberOfDays, reason);
        
        PrintWriter out = response.getWriter();//回应请求
        out.write(result);
        out.flush();
        out.close();
        System.out.println(result);
		
	}

}
