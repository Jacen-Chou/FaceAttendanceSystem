package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.AskForLeave;
import com.fas.vo.Attendance;

public class AskForLeaveDao {

	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;

	// 查询全部记录
	public List<AskForLeave> queryAllAskForLeave() {
		util.getConnection();
		sql = "select * from ask_for_leave";
		List<AskForLeave> list = new ArrayList<AskForLeave>();
		rs = util.query(sql, null);
		try {
			while (rs.next()) {
				AskForLeave askForLeave = new AskForLeave();
				askForLeave.setLeaveid(rs.getInt("leave_id"));
				askForLeave.setStuid(rs.getString("stuid"));
				askForLeave.setTeaid(rs.getString("teaid"));
				askForLeave.setDate(rs.getDate("date"));
				askForLeave.setNumberOfDays(rs.getInt("numberofdays"));
				askForLeave.setReason(rs.getString("reason"));
				askForLeave.setIsPassed(rs.getString("ispassed"));
				list.add(askForLeave);
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
	public List<AskForLeave> queryAskForLeaveByStuId(String stuid) {
		util.getConnection();
		sql = "select * from ask_for_leave where stuid=?";
		List<AskForLeave> list = new ArrayList<AskForLeave>();
		List<Object> param = new ArrayList<Object>();
		param.add(stuid);
		rs = util.query(sql, param);
		try {
			while (rs.next()) {
				AskForLeave askForLeave = new AskForLeave();
				askForLeave.setLeaveid(rs.getInt("leave_id"));
				askForLeave.setStuid(rs.getString("stuid"));
				askForLeave.setTeaid(rs.getString("teaid"));
				askForLeave.setDate(rs.getDate("date"));
				askForLeave.setNumberOfDays(rs.getInt("numberofdays"));
				askForLeave.setReason(rs.getString("reason"));
				askForLeave.setIsPassed(rs.getString("ispassed"));
				list.add(askForLeave);
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
	public void insertAskForLeave(AskForLeave askForLeave) {
		util.getConnection();
		sql = "insert into ask_for_leave(stuid, teaid, date, numberofdays, reason) values(?,?,?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(askForLeave.getStuid());
		param.add(askForLeave.getTeaid());
		param.add(askForLeave.getDate());
		param.add(askForLeave.getNumberOfDays());
		param.add(askForLeave.getReason());
		util.update(sql, param);
		util.close();
	}

	// 删除
	public void delAskForLeave(String leaveid) {
		util.getConnection();
		sql = "delete from ask_for_leave where leave_id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(leaveid);
		util.update(sql, param);
		util.close();
	}

	// 更新
	public void updateAskForLeave(AskForLeave askForLeave) {
		util.getConnection();
		String sql = "update ask_for_leave set stuid=?, teaid=?, date=?, numberofdays=?, reason=? where leave_id=?";
		List<Object> param = new ArrayList<Object>();
		param.add(askForLeave.getStuid());
		param.add(askForLeave.getTeaid());
		param.add(askForLeave.getDate());
		param.add(askForLeave.getNumberOfDays());
		param.add(askForLeave.getReason());
		param.add(askForLeave.getLeaveid());
		param.add(askForLeave.getIsPassed());
		util.update(sql, param);
		util.close();
	}

}
