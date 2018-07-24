package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.AttGroupDao;
import com.fas.dao.AttGroupStudentDao;
import com.fas.vo.AttGroup;
import com.fas.vo.AttGroupStudent;

/**
 * Servlet implementation class TeaCreateAttGroupServlet
 */
@WebServlet("/TeaCreateAttGroupServlet")
public class TeaCreateAttGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaCreateAttGroupServlet() {
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
        System.out.println(teaid);
        String group_name =request.getParameter("group_name");
        System.out.println(group_name);
		String[] item = request.getParameterValues("chkItem");
		ArrayList<String>  stu_id = new ArrayList<String> (); 
		for(int i=0;i<item.length;i++) {
			System.out.println(item[i]);
			stu_id.add(item[i]);
		}
		
		AttGroupDao attGroupDao = new AttGroupDao();
		AttGroup attGroup = new AttGroup();
		attGroup.setGroup_name(group_name);
		attGroup.setTeaid(teaid);
		attGroupDao.insertAttGroup(attGroup);
		
		attGroup = attGroupDao.queryAttGroupByConditions(group_name, teaid);
		int attGroupId = attGroup.getGroupid();
		
		AttGroupStudentDao attGroupStudentDao = new AttGroupStudentDao();
		AttGroupStudent attGroupStudent = new AttGroupStudent();
		
		for(int i=0;i<stu_id.size();i++) {
			System.out.println(stu_id.get(i));
			attGroupStudent.setGroupid(attGroupId);
			attGroupStudent.setStuid(stu_id.get(i));
			attGroupStudentDao.insertAttGroupStudent(attGroupStudent);
		}
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert(\"创建成功!\");window.history.go(-2);</script>"); 
		
		
	}

}
