package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.AttGroup;
import com.fas.vo.AttGroupStudent;
import com.fas.vo.Attendance;

public class AttGroupStudentDao {

	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;
	
	// ≤Â»Î
	public void insertAttGroupStudent(AttGroupStudent attGroupStudent) {
		util.getConnection();
		sql = "insert into att_group__student(groupid, stuid) values(?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(attGroupStudent.getGroupid());
		param.add(attGroupStudent.getStuid());
		util.update(sql, param);
		util.close();
	}
	
}
