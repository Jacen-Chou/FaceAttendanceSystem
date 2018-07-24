package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.TeacherDao;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Teacher;

/**
 * Servlet implementation class TeaMofidyPassServlet
 */
@WebServlet("/TeaMofidyPassServlet")
public class TeaModifyPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaModifyPassServlet() {
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
        String old_pass = request.getParameter("old_pass");
		System.out.println("old_pass:" + old_pass);
		String new_pass = request.getParameter("new_pass");
		System.out.println("new_pass:" + new_pass);
        
        TeacherDao teacherDao =new TeacherDao();
        Teacher teacher = new Teacher();
        teacher = teacherDao.queryTeaById(teaid);
        PrintWriter out = response.getWriter();// 回应请求
        
        if (teacher.getTeaid() != null) {
        	String salt = teacher.getTeasalt();
			String oldPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(old_pass) + salt));
			if (oldPassEncrypt.equals(teacher.getTeapassword())) {
				String newPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(new_pass) + salt));
				teacher.setTeapassword(newPassEncrypt);
				teacherDao.updateTeacher(teacher);
				out.print("<script>alert(\"密码修改成功!\");window.history.go(-2);</script>"); 
			} else {
				out.print("<script>alert(\"原密码错误!\");window.history.go(-2);</script>"); 
			}
        } else {
        	out.print("<script>alert(\"输入错误!\");window.history.go(-2);</script>"); 
        }
		
	}

}
