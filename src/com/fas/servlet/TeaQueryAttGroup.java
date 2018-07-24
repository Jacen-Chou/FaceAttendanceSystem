package com.fas.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.AttGroupDao;
import com.fas.vo.AttGroup;
import com.fas.vo.AttGroupWithStudent;

/**
 * Servlet implementation class TeaQueryAttGroup
 */
@WebServlet("/TeaQueryAttGroup")
public class TeaQueryAttGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaQueryAttGroup() {
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
        AttGroupDao attGroupDao = new AttGroupDao();
        List<AttGroupWithStudent> list = new ArrayList<AttGroupWithStudent>();
        list = attGroupDao.queryAttGroupByTea(teaid);
        request.setAttribute("list", list);
        request.getRequestDispatcher("table2.jsp").forward(request, response);
		
	}

}
