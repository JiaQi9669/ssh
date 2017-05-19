package com.library.tools;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class DateUtil {
	public static String getDateUUID(){
		Format format = new SimpleDateFormat("mmssSSS");
		return format.format(new Date());
	}
	/**
	 * 获取年月
	 * @param date
	 * @return
	 */
	public static String getY(Date date){
		if(date==null){
	        return "无";			
			}else{
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy");
				String datestr= sFormat.format(date);
				return datestr;
			}
	}
	public static String getYM(Date date){
		if(date==null){
	        return "无";			
			}else{
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM");
				String datestr= sFormat.format(date);
				return datestr;
			}
	}
//	2017-01-23 16:23:29
	public static String getYMD(Date date){
		if(date==null){
	        return "无";			
			}else{				
//				2010-7-12 11:18:54
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String datestr= sFormat.format(date);
				String datestrs[]=datestr.split(" ");
				return datestrs[0];
			}
	}
	public static String getDates(Date date){
		if(date==null){
	        return "无";			
			}else{			
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String datestr= sFormat.format(date);
				return datestr;
			}
	}
	public static String getDate(Date date){
		if(date==null){
	        return "无";			
			}else{
				
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
				String datestr= sFormat.format(date);
				return datestr;
			}
	}
	public static String getHMS(Date date){
		if(date==null){
        return "无";			
		}else{
			
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datestr= sFormat.format(date);
			String datestrs[]=datestr.split(" ");
			return datestrs[1];
		}
	}
	public static Date[] StringToDate(String start,String end,Date startDate,Date endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			endDate = sdf.parse(end);
			startDate = sdf.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dates[] = new Date[2];
		dates[0]=startDate;
		dates[1]=endDate;
		return dates;
	}
}
