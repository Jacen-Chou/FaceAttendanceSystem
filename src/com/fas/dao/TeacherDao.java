package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.Teacher;

public class TeacherDao {

	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;
	
	//查询全部记录
	public List<Teacher> queryAllTea() {
		util.getConnection();
		sql = "select * from teacher";
		List<Teacher> list = new ArrayList<Teacher>();
		rs = util.query(sql, null);
		try {
			while(rs.next()) {
				Teacher t = new Teacher();
				t.setTeaid(rs.getString("teaid"));
				t.setTeaname(rs.getString("teaname"));
				t.setTeapassword(rs.getString("teapassword"));
				t.setTeasalt(rs.getString("teasalt"));
				t.setTeaemail(rs.getString("teaemail"));
				t.setTeaphone(rs.getString("teaphone"));
				list.add(t);
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
	public Teacher queryTeaById(String teaid) {
		util.getConnection();
		sql = "select * from teacher where teaid=?";
		Teacher t = new Teacher();
		List<Object> param = new ArrayList<Object>();
		param.add(teaid);
		rs = util.query(sql, param);
		try {
			if(rs.next()) {
				t.setTeaid(rs.getString("teaid"));
				t.setTeaname(rs.getString("teaname"));
				t.setTeapassword(rs.getString("teapassword"));
				t.setTeasalt(rs.getString("teasalt"));
				t.setTeaemail(rs.getString("teaemail"));
				t.setTeaphone(rs.getString("teaphone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return t;
	}
	
	//插入
	public void insertTea(Teacher t) {
		util.getConnection();
		sql = "insert into teacher(teaid, teaname, teapassword, teasalt, teaemail, teaphone) values(?,?,?,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(t.getTeaid());
		param.add(t.getTeaname());
		param.add(t.getTeapassword());
		param.add(t.getTeasalt());
		param.add(t.getTeaemail());
		param.add(t.getTeaphone());
		util.update(sql, param);
		util.close();
	}
	
	//删除
	public void delTeaById(String teaid) {
		util.getConnection();
		sql = "delete from teacher where teaid=?";
		List<Object> param = new ArrayList<Object>();
		param.add(teaid);
		util.update(sql, param);
		util.close();
	}
	
	//更新
	public void updateTeacher(Teacher t) {
		util.getConnection();
 		String sql = "update teacher set teaname=?, teapassword=?, teasalt=?, taemail=?, teaphone=? where teaid=?";
 		List<Object> param = new ArrayList<Object>();
		param.add(t.getTeaname());
		param.add(t.getTeapassword());
		param.add(t.getTeasalt());
		param.add(t.getTeaemail());
		param.add(t.getTeaphone());
		param.add(t.getTeaid());
		util.update(sql, param);
		util.close();
	}
	
}
