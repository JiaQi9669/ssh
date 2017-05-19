package com.library.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取系统当前时间
 * @author JiaQi
 *
 */
public class GetTime {
	/**
	 * 获取系统当前时间
	 * yyyy-MM-dd
	 */
	public static String getToday() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	/**
	 * 获取系统当前月份
	 * yyyy-MM-dd
	 */
	public static String getnowMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(new Date());
	}
	/**
	 * 获取明天
	 */
	public static String getTom() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() + 24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	
	public static String getYesterday() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday2() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 2*24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday8() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 8*24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday3() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 3*24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday4() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 4*24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday5() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 5*24*3600*1000);
	}
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday6() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 6*24*3600*1000);
	}	
	
	/**
	 * 获取当前系统时间的昨天
	 */
	public static String getYesterday7() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime() - 7*24*3600*1000);
	}
	/**
	 * 获取当前系统时间年份
	 * yyyy
	 */
	public static String getYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(new Date());
	}
	/**
	 * 获取当前系统时间月份
	 * yyyy-MM
	 */
	public static String getMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(new Date());
	}
}
