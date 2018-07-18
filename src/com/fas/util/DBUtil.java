package com.fas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {

	private static final DBUtil util = new DBUtil();
	
	private DBUtil() {
			
		}
		
		public static DBUtil getInstance() {
			return util;
		}
		
		private String className = "com.mysql.jdbc.Driver";
		private String url = "jdbc:mysql://localhost:3306/face_attendance_system";
		private String user = "root";
		private String password = "root";
		private Connection conn;
		private PreparedStatement ps;
		private ResultSet rs;
		
		public Connection getConnection() {
			try {
				Class.forName(className);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		//查询
		public ResultSet query(String sql, List<Object> param) {
			try {
				ps = conn.prepareStatement(sql);
				if(param!=null && param.size()>0) {
					for(int i=0;i<param.size();i++) {
						ps.setObject(i+1, param.get(i));
					}
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		
		//增、删、改
		public void update(String sql, List<Object> param) {
			try {
				ps = conn.prepareStatement(sql);
				if(param!=null && param.size()>0) {
					for(int i=0;i<param.size();i++) {
						ps.setObject(i+1, param.get(i));
					}
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//关闭连接
		public void close() {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
