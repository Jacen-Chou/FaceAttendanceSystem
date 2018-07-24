package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.AskForLeave;
import com.fas.vo.AttGroup;
import com.fas.vo.AttGroupWithStudent;

public class AttGroupDao {

	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;
	
	
	// 根据教师查询全部记录
	public List<AttGroupWithStudent> queryAttGroupByTea(String teaid) {
		util.getConnection();
		sql = "select g.groupid, g.group_name, a.stuid, s.stuname from att_group g join att_group__student a on g.groupid=a.groupid join student s on a.stuid=s.stuid where g.teaid=?";
		List<AttGroupWithStudent> list = new ArrayList<AttGroupWithStudent>();
		List<Object> param = new ArrayList<Object>();
		param.add(teaid);
		rs = util.query(sql, param);
		try {
			while (rs.next()) {
				AttGroupWithStudent attGroupWithStudent = new AttGroupWithStudent();
				attGroupWithStudent.setGroupid(rs.getInt("groupid"));
				attGroupWithStudent.setGroup_name(rs.getString("group_name"));
				attGroupWithStudent.setStuid(rs.getString("stuid"));
				attGroupWithStudent.setStuname(rs.getString("stuname"));
				list.add(attGroupWithStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}
	
	// 根据名称和教师查询记录
	public AttGroup queryAttGroupByConditions(String group_name, String teaid) {
		util.getConnection();
		sql = "select * from att_group where group_name=? and teaid=?";
		AttGroup attGroup = new AttGroup();
		List<Object> param = new ArrayList<Object>();
		param.add(group_name);
		param.add(teaid);
		rs = util.query(sql, param);
		try {
			while (rs.next()) {
				attGroup.setGroupid(rs.getInt("groupid"));
				attGroup.setGroup_name(rs.getString("group_name"));
				attGroup.setTeaid(rs.getString("teaid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return attGroup;
	}
	
	// 插入
	public void insertAttGroup(AttGroup attGroup) {
		util.getConnection();
		sql = "insert into att_group(group_name, teaid) values(?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(attGroup.getGroup_name());
		param.add(attGroup.getTeaid());
		util.update(sql, param);
		util.close();
	}
	
}
