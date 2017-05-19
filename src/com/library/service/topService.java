package com.library.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.library.tools.DateUtil;
import com.library.tools.JdbcUtil;

/**
 * 查询排行榜
 * @author JiaQi
 *
 */
public class topService {
	//	连接对象
	private static Connection conn=null;
	//	发送sql语句
	private static PreparedStatement stmt=null;
	//	sql返回的结果集
	private static ResultSet rs=null;
//		时间
	Date date=new Date();
//		本年的开始时间本天0点
//	String dataBegin=DateUtil.getYM(date)+"-01 00:00:00";
	String dataBegin=DateUtil.getY(date)+"-01-01 00:00:00";
//		今天的开始时间本天本时
	String dataEnd=DateUtil.getYMD(date)+" "+DateUtil.getHMS(date);

//	查询全部类型名称
//		读者前10
	public Map<String , String > findName() {
		String sql1="select p.name, count(r.cartNum) from person p, record r where r.cartNum=p.cartNUm and r.time >'"+dataBegin+"' and r.time < '"+dataEnd+"' group by r.cartNum order by count(r.cartNum) desc limit 10;";
		System.out.println(sql1);
		//		name 进馆数量
		Map<String, String> hm=new LinkedHashMap<String, String>();
		conn=JdbcUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql1);
			rs=stmt.executeQuery();
			while(rs.next()){
				hm.put(rs.getString(1),rs.getString(2));
			}
			rs=stmt.executeQuery();
			//		判断数据是否存在
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}//	获取全部部门名称
		return hm;
	}

	public Map<String , String > findDepart() {
//		学院前10 本月
		String sql1="select c.name, count(r.time) from record r, college c, person p where r.cartNum=p.cartNum and p.college=c.id and r.time > '"+dataBegin+"' and r.time < '"+dataEnd+"' group by c.name order by count(r.time) desc";
		System.out.println(sql1);
		//		name 进馆数量
		Map<String, String> hm=new LinkedHashMap<String, String>();
		conn=JdbcUtil.getConnection();
		try {
			stmt=conn.prepareStatement(sql1);
			rs=stmt.executeQuery();
			while(rs.next()){
				hm.put(rs.getString(1),rs.getString(2));
			}
			rs=stmt.executeQuery();
			//		判断数据是否存在
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}//	获取全部部门名称
		return hm;
	}
//	类型前10
public Map<String, String> findType() {
	String sql1="select t.type, count(r.cartNum) from record r, type t, person p where r.cartNum=p.cartNum and p.type=t.id and r.time > '"+dataBegin+"' and r.time < '"+dataEnd+"' group by p.type order by count(r.cartNum) desc";
	System.out.println(sql1);
	//		name 进馆数量
	Map<String, String> hm=new LinkedHashMap<String, String>();
	conn=JdbcUtil.getConnection();
	try {
		stmt=conn.prepareStatement(sql1);
		rs=stmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+rs.getString(2));
			hm.put(rs.getString(1),rs.getString(2));
		}
		rs=stmt.executeQuery();
		//		判断数据是否存在
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn, stmt ,rs);
	}//	获取全部部门名称
	return hm;
}

}
