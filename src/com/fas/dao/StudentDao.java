package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.util.GetStringRandom;
import com.fas.util.PasswordEncryptUtil;
import com.fas.vo.Student;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.org.apache.regexp.internal.recompile;

public class StudentDao {
	
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;
	
	//查询全部记录
	public List<Student> queryAllStu() {
		util.getConnection();
		sql = "select * from student";
		List<Student> list = new ArrayList<Student>();
		rs = util.query(sql, null);
		try {
			while(rs.next()) {
				Student s = new Student();
				s.setStuId(rs.getString("stuid"));
				s.setStuName(rs.getString("stuname"));
				s.setStuPassword(rs.getString("stupassword"));
				s.setStuEmail(rs.getString("stuemail"));
				s.setStuSalt(rs.getString("stusalt"));
				s.setStuFaceIsRegistered(rs.getString("stufaceisregistered"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	} 
	
	//根据id查询一条记录
	public Student queryStuById(String stuid) {
		util.getConnection();
		sql = "select * from student where stuid=?";
		Student s = new Student();
		List<Object> param = new ArrayList<Object>();
		param.add(stuid);
		rs = util.query(sql, param);
		try {
			if(rs.next()) {
				s.setStuId(rs.getString("stuid"));
				s.setStuName(rs.getString("stuname"));
				s.setStuPassword(rs.getString("stupassword"));
				s.setStuEmail(rs.getString("stuemail"));
				s.setStuSalt(rs.getString("stusalt"));
				s.setStuFaceIsRegistered(rs.getString("stufaceisregistered"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return s;
	}
	
	//插入
	public void insertStu(Student s) {
		util.getConnection();
		sql = "insert into student(stuid, stuname, stupassword, stuemail, stusalt) values(?,?,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(s.getStuId());
		param.add(s.getStuName());
		param.add(s.getStuPassword());
		param.add(s.getStuEmail());
		param.add(s.getStuSalt());
		util.update(sql, param);
		util.close();
	}
	
	//删除
	public void delStuById(String stuid) {
		util.getConnection();
		sql = "delete from student where stuid=?";
		List<Object> param = new ArrayList<Object>();
		param.add(stuid);
		util.update(sql, param);
		util.close();
	}
	
	//更新
	public void updateStu(Student s) {
		util.getConnection();
 		String sql = "update student set stuname=?, stupassword=?, stuemail=?, stusalt=?, stufaceisregistered=? where stuid=?";
 		List<Object> param = new ArrayList<Object>();
		param.add(s.getStuName());
		param.add(s.getStuPassword());
		param.add(s.getStuEmail());
		param.add(s.getStuSalt());
		param.add(s.getStuFaceIsRegistered());
		param.add(s.getStuId());
		util.update(sql, param);
		util.close();
	}
	
	// 计算学生总数
	public int CountStuNum() {
		util.getConnection();
		sql = " select count(*) from student";
		rs = util.query(sql, null);
		int stunum = 0;
		try {
			if(rs.next()) {
				stunum = rs.getInt(1);
				System.out.println(stunum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return stunum;
	}
	
}
