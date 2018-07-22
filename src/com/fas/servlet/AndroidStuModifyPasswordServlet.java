package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.service.StudentService;

/**
 * Servlet implementation class AndroidStuModifyPasswordServlet
 */
@WebServlet("/AndroidStuModifyPasswordServlet")
public class AndroidStuModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AndroidStuModifyPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ���ÿͻ��˵Ľ��뷽ʽΪutf-8
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		// ���ݱ�ʾ����ȡ���������Ĳ���
		String id = request.getParameter("id");
		String old_pass = request.getParameter("old_pass");
		String new_pass = request.getParameter("new_pass");
		String result = "";

		StudentService studentService = new StudentService();
		result = studentService.AndroidStuModifyPasswordService(id, old_pass, new_pass);

		PrintWriter out = response.getWriter();// ��Ӧ����
		out.write(result);
		out.flush();
		out.close();
		System.out.println(result);
	}

}
