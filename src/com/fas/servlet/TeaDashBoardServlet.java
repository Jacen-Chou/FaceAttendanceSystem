package com.fas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fas.dao.AttendanceDao;
import com.fas.dao.StudentDao;

/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/DashBoardServlet")
public class TeaDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeaDashBoardServlet() {
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

		// 设置客户端的解码方式为utf-8
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		StudentDao studentDao = new StudentDao();
		int stunum = studentDao.CountStuNum();
		System.out.println(stunum);
		// 获取Session
		HttpSession session = request.getSession();
		session.setAttribute("stunum", stunum);
		
		AttendanceDao attendanceDao = new AttendanceDao();
		int attnum = attendanceDao.CountAttNum();
		System.out.println(attnum);
		session.setAttribute("attnum", attnum);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);

	}

}
