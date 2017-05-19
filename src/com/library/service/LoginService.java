package com.library.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.bean.User;
import com.library.dao.DBO;

/**
 * 登录Service
 * @author JiaQi
 *
 */
public class LoginService {
	private DBO db = new DBO();
//	获取登录对象
	public User findByUserName(String username) {
		System.out.println("select * from root where userName = '"+username+"';");
		ResultSet rs = db.getRs("select * from root where userName = '"+username+"';");
		User user = new User();
		try {
			if(!rs.next()){
				rs.close();
				db.closed();
				return null;
			}
			db.closed();
			rs = db.getRs("select * from root where userName = '"+username+"';");
			while(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
			}
			rs.close();
			db.closed();
			return user;
		} catch (SQLException e) {
			db.closed();
			e.printStackTrace();
			return null;
		}
	}
}
