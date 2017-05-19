package com.library.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.library.dao.DBO;

/**
 * 登录Service
 * @author JiaQi
 *
 */
public class indexService {
	private DBO db = new DBO();
	int num;
//	获取登录对象
	public int findByTotal() {
//		获得当前时间
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//		字符串格式的时间
		String beginTime=formatter2.format(date);
		String endTime=formatter.format(date);
		String sql="select count(*) from record where time > '"+beginTime+ "' and time < '"+endTime+"'";
		System.out.println(sql);
		ResultSet rs = db.getRs(sql);
		try {
			while(rs.next()){
				num=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				db.closed();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		db.closed();
		return num;
	}
}
