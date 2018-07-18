package com.fas.servlet;

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

/**
 * Servlet implementation class AndroidStuFaceRegisterServlet
 */
@WebServlet("/AndroidStuFaceRegisterServlet")
public class AndroidStuRegisterFaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidStuRegisterFaceServlet() {
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

        //根据标示名获取JSP文件中表单所包含的参数
        String id = request.getParameter("id");
        //String registereFace = request.getParameter("data");
        String result;
        
        StudentService studentService = new StudentService();
        result = studentService.AndroidFaceRegisterService(id);
        
        PrintWriter out = response.getWriter();//回应请求
        out.write(result);
        out.flush();
        out.close();
        System.out.println(result);		
	}

}
