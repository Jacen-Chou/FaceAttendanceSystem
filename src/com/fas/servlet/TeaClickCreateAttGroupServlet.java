package com.fas.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.StudentDao;
import com.fas.vo.Student;

/**
 * Servlet implementation class TeaCreateAttGroup
 */
@WebServlet("/TeaCreateAttGroup")
public class TeaClickCreateAttGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaClickCreateAttGroupServlet() {
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
		
		StudentDao studentDao = new StudentDao();
		List<Student> list = new ArrayList<Student>();
		list = studentDao.queryAllStu();
		request.setAttribute("list", list);
		request.getRequestDispatcher("form_layouts.jsp").forward(request, response);		
		
	}

}
