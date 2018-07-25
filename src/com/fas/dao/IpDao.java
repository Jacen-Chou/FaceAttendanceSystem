package com.fas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fas.util.DBUtil;
import com.fas.vo.Ip;
import com.fas.vo.Student;

public class IpDao {
	
	private DBUtil util = DBUtil.getInstance();
	private Connection conn;
	private ResultSet rs;
	private String sql;
	
	//根据id查询一条记录
	public Ip queryIpById(int id) {
		util.getConnection();
		sql = "select * from ip where id=?";
		Ip ip = new Ip();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		rs = util.query(sql, param);
		try {
			if(rs.next()) {
				ip.setId(rs.getInt("id"));
				ip.setIp_1(rs.getString("ip_1"));
				ip.setIp_2(rs.getString("ip_2"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close();
		}
		return ip;
	}
	
	//更新
	public void updateIp(Ip ip) {
		util.getConnection();
 		String sql = "update ip set ip_1=?, ip_2=? where id=1";
 		List<Object> param = new ArrayList<Object>();
 		param.add(ip.getIp_1());
 		param.add(ip.getIp_2());
		util.update(sql, param);
		util.close();
	}
}
