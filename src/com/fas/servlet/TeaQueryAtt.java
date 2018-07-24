package com.fas.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.AttendanceDao;
import com.fas.vo.Attendance;
import com.fas.vo.AttendanceWithGroup;
import com.fas.vo.Student;

/**
 * Servlet implementation class TeaQueryAtt
 */
@WebServlet("/TeaQueryAtt")
public class TeaQueryAtt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaQueryAtt() {
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
        
        AttendanceDao attendanceDao = new AttendanceDao();
		List<AttendanceWithGroup> list = new ArrayList<AttendanceWithGroup>();
		list = attendanceDao.queryAllAttWithGroup();
		request.setAttribute("list", list);
		request.getRequestDispatcher("table.jsp").forward(request, response);
		
		
	}

}
