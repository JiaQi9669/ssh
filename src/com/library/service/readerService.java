package com.library.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.tools.DateUtil;
import com.library.tools.JdbcUtil;

/**
 * 读者查询Service
 * @author JiaQi
 *
 */
public class readerService {
	//	连接对象
	private static Connection conn=null;
	//	发送sql语句
	private static PreparedStatement stmt=null;
	//	sql返回的结果集
	private static ResultSet rs=null;
//		时间
	Date date=new Date();
//		本年的开始时间本天0点
	String dataBegin=DateUtil.getY(date)+"-01-01 00:00:00";
//		今天的开始时间本天本时
	String dataEnd=DateUtil.getYMD(date)+" "+DateUtil.getHMS(date);
	public List<String> findId(String id) {
		String sql1="select r.time from record r,person p where p.major = ? and p.cartNum = r.cartNum and r.time >'"+dataBegin+"' and r.time < '"+dataEnd+"' group by r.time ;";
		System.out.println(sql1);
		// 进馆时间
		List<String> arrayList=new ArrayList<String>(); 
		conn=JdbcUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql1);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next()){
				arrayList.add(rs.getString(1));
//				System.out.println(rs.getString(1)+rs.getString(2));
			}
			rs=stmt.executeQuery();
			//		判断数据是否存在
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
		return arrayList;
	}
}
