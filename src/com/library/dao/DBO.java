package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBO {
	private String URL;
	private String classname;
	private String username;
	private String password;
	
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	/**
	 * default method
	 */
	public DBO(){
		URL="jdbc:mysql://127.0.0.1:3306/library?useUnicode=true&characterEncoding=utf8";
		classname="com.mysql.jdbc.Driver";
		username="root";
		password="jiaqi";
	}
	
	/**
	 * start driver
	 */
	private void LoadDriver(){
		try{
			Class.forName(classname);
		}catch(ClassNotFoundException e){
//			System.out.println("加载驱动程序失败！");
//			JOptionPane.showMessageDialog(null, "加载驱动程序失败！");
			System.out.println("加载驱动程序失败！");
		}
	}
	
	/**
	 * get connection
	 * @return
	 */
	private Connection getCon(){
		LoadDriver();
		try{
			con=DriverManager.getConnection(URL,username,password);
		}catch(Exception e){
//			System.out.println("创建数据库连接失败！");
//			JOptionPane.showMessageDialog(null, "创建数据库连接失败！");
			System.out.println("创建数据库连接失败！");
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * creat connection statement
	 * @return
	 */
	private Statement getStm(){
		getCon();
		try{
			stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);			
		}catch(Exception e){
//			System.out.println("创建Statement对象失败！");
//			JOptionPane.showMessageDialog(null, "创建Statement对象失败！");
			System.out.println("创建Statement对象失败！");
		}
		return stm;
	}
	
	/**
	 * 数据库查询，需要手动关闭
	 * @param sql
	 * @return
	 */
	public ResultSet getRs(String sql){
		if(sql==null){
			sql="";
		}
		getStm();
		try{
			rs=stm.executeQuery(sql);			
		}catch(Exception e){
//			System.out.println("DBO层查询数据库失败！");
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "DBO层查询数据库失败！");
			System.out.println("DBO层查询数据库失败！");
		}			
		return rs;		
	}
	
	/**
	 * 数据库更新，执行增删改操作，并返回受影响的行数。自动closed
	 * 返回1代表更新成功，-1代表失败
	 * @param sql
	 * @return
	 */
	public int update(String sql){
		if(sql==null){
			sql="";
		}
//		System.out.println("SQL："+sql);
		getStm();
		int i=-1;
		try{
			i=stm.executeUpdate(sql);
		}catch(Exception e){
//			e.printStackTrace();
			i=-1;
		}finally{
			closed();
		}
		return i;
	}
	
	/**
	 * 关闭数据连接
	 */
	public void closed(){
		try{
			if(this.rs!=null)
				rs.close();
			if(this.stm!=null)
				stm.close();
			if(this.con!=null)
				con.close();
		}catch(Exception e){
//			JOptionPane.showMessageDialog(null, "数据流关闭异常！");
		}
	}

	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
