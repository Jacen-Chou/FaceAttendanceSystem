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
		
		//���ÿͻ��˵Ľ��뷽ʽΪutf-8
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
        //���ݱ�ʾ����ȡ���������Ĳ���
        String teaid =request.getParameter("teaid");
        String old_pass = request.getParameter("old_pass");
		System.out.println("old_pass:" + old_pass);
		String new_pass = request.getParameter("new_pass");
		System.out.println("new_pass:" + new_pass);
        
        TeacherDao teacherDao =new TeacherDao();
        Teacher teacher = new Teacher();
        teacher = teacherDao.queryTeaById(teaid);
        PrintWriter out = response.getWriter();// ��Ӧ����
        
        if (teacher.getTeaid() != null) {
        	String salt = teacher.getTeasalt();
			String oldPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(old_pass) + salt));
			if (oldPassEncrypt.equals(teacher.getTeapassword())) {
				String newPassEncrypt = PasswordEncryptUtil.SHA512((PasswordEncryptUtil.SHA512(new_pass) + salt));
				teacher.setTeapassword(newPassEncrypt);
				teacherDao.updateTeacher(teacher);
				out.print("<script>alert(\"�����޸ĳɹ�!\");window.history.go(-2);</script>"); 
			} else {
				out.print("<script>alert(\"ԭ�������!\");window.history.go(-2);</script>"); 
			}
        } else {
        	out.print("<script>alert(\"�������!\");window.history.go(-2);</script>"); 
        }
		
	}

}
