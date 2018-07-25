package com.fas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fas.dao.IpDao;
import com.fas.vo.Ip;

/**
 * Servlet implementation class TeaSetIp
 */
@WebServlet("/TeaSetIp")
public class TeaSetIpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaSetIpServlet() {
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
        String ip_1 =request.getParameter("ip_1");
        String ip_2=request.getParameter("ip_2");
        System.out.println(ip_1);
        System.out.println(ip_2);
        IpDao ipDao = new IpDao();
        Ip ip = new Ip();
        ip.setId(1);
        ip.setIp_1(ip_1);
        ip.setIp_2(ip_2);
        ipDao.updateIp(ip);
        
//        String ip_1_2 = "";
//		String ip_2_2 = "";
//		
//		IpDao ipDao_2 = new IpDao();
//		Ip ip_set = ipDao.queryIpById(1);
//		ip_1 = ip_set.getIp_1();
//		ip_2 = ip_set.getIp_2();
//		String regex = ip_1 + "\\." + ip_2 + "\\.[0-9]{1,3}\\.[0-9]{1,3}";
//		System.out.println(regex);
//		String ip2 = "10.24.26.26";
//		//String regex = "10\\.24\\.[0-9]{1,3}\\.[0-9]{1,3}";
//		if (!Pattern.matches(regex, ip2)) { // IP不匹配
//			System.out.println("ip_error");
//		} else {
//			System.out.println("ip_true");
//		}
        
        PrintWriter out = response.getWriter();
        out.print("<script>alert(\"修改成功!\");window.location.href='form_layouts3.jsp';</script>");
		
	}

}
