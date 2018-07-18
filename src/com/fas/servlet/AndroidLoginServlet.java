package com.fas.servlet;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.StudentDao;
import com.fas.service.StudentService;
import com.fas.vo.Student;


public class AndroidLoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       
		//���ÿͻ��˵Ľ��뷽ʽΪutf-8
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
        //���ݱ�ʾ����ȡ���������Ĳ���
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String result;
        
        StudentService studentService = new StudentService();
        result = studentService.AndroidLoginService(id, password);
        
        PrintWriter out = response.getWriter();//��Ӧ����
        out.write(result);
        System.out.println(result);
        out.flush();
        out.close();
        System.out.println(result);
        
	}

}
