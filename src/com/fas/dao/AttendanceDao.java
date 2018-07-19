package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.Attendance;
import com.fas.vo.Student;

public class AttendanceDao {

	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;

	// 查询全部记录
	public List<Attendance> queryAllAttendance() {
		util.getConnection();
		sql = "select * from attendance";
		List<Attendance> list = new ArrayList<Attendance>();
		rs = util.query(sql, null);
		try {
			while (rs.next()) {
				Attendance attendance = new Attendance();
				attendance.setId(rs.getString("id"));
				attendance.setName(rs.getString("name"));
				attendance.setDate(rs.getDate("date"));
				attendance.setTime(rs.getTime("time"));
				list.add(attendance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// 根据id查询记录
	public List<Attendance> queryAttendanceById(String id) {
		util.getConnection();
		sql = "select * from attendance where id=?";
		List<Attendance> list = new ArrayList<Attendance>();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		rs = util.query(sql, param);
		try {
			while (rs.next()) {
				Attendance attendance = new Attendance();
				attendance.setId(rs.getString("id"));
				attendance.setName(rs.getString("name"));
				attendance.setDate(rs.getDate("date"));
				attendance.setTime(rs.getTime("time"));
				list.add(attendance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return list;
	}

	// 插入
	public void insertAttendance(Attendance attendance) {
		util.getConnection();
		sql = "insert into attendance(id, name, date, time) values(?,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(attendance.getId());
		param.add(attendance.getName());
		param.add(attendance.getDate());
		param.add(attendance.getTime());
		util.update(sql, param);
		util.close();
	}

	// 删除
	public void delAttendanceById(String id) {
		util.getConnection();
		sql = "delete from attendance where id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		util.update(sql, param);
		util.close();
	}

	// 更新
	public void updateAttendance(Attendance attendance) {
		util.getConnection();
		String sql = "update attendance set name=?, date=?, time=? where id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(attendance.getName());
		param.add(attendance.getDate());
		param.add(attendance.getTime());
		param.add(attendance.getId());
		util.update(sql, param);
		util.close();
	}

}
