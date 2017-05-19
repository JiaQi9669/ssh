package com.library.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.dao.DBO;
import com.library.tools.GetTime;

/**3
 * 综合统计
 * @author JiaQi
 *
 */
public class comService {
	private DBO db = new DBO();
	private areaService as = new areaService();
	private partService ps = new partService();
	private typeService ts = new typeService();
	/**
	 * 综合统计
	 * @param checkbox
	 */
	public String findreport(String checkbox) {
		String desc = "";
		if(checkbox.equals("y1")){
			
			try{
				

//			一年
			ResultSet rs = db.getRs("select " +
					"count(case when (r.time < '"+GetTime.getYear()+"-02') and (r.time > '"+GetTime.getYear()+"-01') then 'no' end) a," +
					"count(case when (r.time < '"+GetTime.getYear()+"-03') and (r.time > '"+GetTime.getYear()+"-02') then 'no' end) b," +
					"count(case when (r.time < '"+GetTime.getYear()+"-04') and (r.time > '"+GetTime.getYear()+"-03') then 'no' end) c, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-05') and (r.time > '"+GetTime.getYear()+"-04') then 'no' end) d, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-06') and (r.time > '"+GetTime.getYear()+"-05') then 'no' end) e, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-07') and (r.time > '"+GetTime.getYear()+"-06') then 'no' end) f, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-08') and (r.time > '"+GetTime.getYear()+"-07') then 'no' end) g, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-09') and (r.time > '"+GetTime.getYear()+"-08') then 'no' end) h, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-10') and (r.time > '"+GetTime.getYear()+"-09') then 'no' end) i, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-11') and (r.time > '"+GetTime.getYear()+"-10') then 'no' end) j, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-12') and (r.time > '"+GetTime.getYear()+"-11') then 'no' end) k, " +
					"count(case when (r.time < '"+GetTime.getYear()+"-13') and (r.time > '"+GetTime.getYear()+"-12') then 'no' end) l " +
					"from record r");
			while(rs.next()){
				desc = desc + "{name: '年报',data: ["+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10)+","+rs.getString(11)+","+rs.getString(12)+"]},";
			}
			db.closed();
			rs.close();
			
			}catch(Exception e){
				e.printStackTrace();
				db.closed();
			}
			
			
			
		}else if(checkbox.equals("y2")){
//			一月
			System.out.println("--------");
			
			System.out.println("select " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-06') and (r.time > '"+GetTime.getMonth()+"-01') then 'no' end) a," +
					"count(case when (r.time < '"+GetTime.getMonth()+"-11') and (r.time > '"+GetTime.getMonth()+"-06') then 'no' end) b," +
					"count(case when (r.time < '"+GetTime.getMonth()+"-16') and (r.time > '"+GetTime.getMonth()+"-11') then 'no' end) c, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-21') and (r.time > '"+GetTime.getMonth()+"-16') then 'no' end) d, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-26') and (r.time > '"+GetTime.getMonth()+"-21') then 'no' end) e, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-32') and (r.time > '"+GetTime.getMonth()+"-26') then 'no' end) f " +
					"from record r");
			
			
			ResultSet rs = db.getRs("select " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-06') and (r.time > '"+GetTime.getMonth()+"-01') then 'no' end) a," +
					"count(case when (r.time < '"+GetTime.getMonth()+"-11') and (r.time > '"+GetTime.getMonth()+"-06') then 'no' end) b," +
					"count(case when (r.time < '"+GetTime.getMonth()+"-16') and (r.time > '"+GetTime.getMonth()+"-11') then 'no' end) c, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-21') and (r.time > '"+GetTime.getMonth()+"-16') then 'no' end) d, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-26') and (r.time > '"+GetTime.getMonth()+"-21') then 'no' end) e, " +
					"count(case when (r.time < '"+GetTime.getMonth()+"-32') and (r.time > '"+GetTime.getMonth()+"-26') then 'no' end) f " +
					"from record r");
			try {
				while(rs.next()){
					desc = desc + "{name: '月报',data: ["+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+"]},";
				}
				System.out.println("---1");
				db.closed();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				db.closed();
			}
			
		}
		else if(checkbox.equals("y4")){
//			一周
			
			System.out.println("select a.name," +
					"count(case when (r.time < '"+GetTime.getToday()+"') and (r.time > '"+GetTime.getYesterday()+"') then 'no' end) 1," +
					"count(case when (r.time < '"+GetTime.getYesterday()+"') and (r.time > '"+GetTime.getYesterday2()+"') then 'no' end) 2," +
					"count(case when (r.time < '"+GetTime.getYesterday2()+"') and (r.time > '"+GetTime.getYesterday3()+"') then 'no' end) 3, " +
					"count(case when (r.time < '"+GetTime.getYesterday3()+"') and (r.time > '"+GetTime.getYesterday4()+"') then 'no' end) 4, " +
					"count(case when (r.time < '"+GetTime.getYesterday4()+"') and (r.time > '"+GetTime.getYesterday5()+"') then 'no' end) 5, " +
					"count(case when (r.time < '"+GetTime.getYesterday5()+"') and (r.time > '"+GetTime.getYesterday6()+"') then 'no' end) 6 " +
					"from record r,area a where r.doorNum = a.id group by a.name");
			
			
			ResultSet rs = db.getRs("select " +
					"count(case when (r.time < '"+GetTime.getToday()+"') and (r.time > '"+GetTime.getYesterday()+"') then 'no' end) a," +
					"count(case when (r.time < '"+GetTime.getYesterday()+"') and (r.time > '"+GetTime.getYesterday2()+"') then 'no' end) b," +
					"count(case when (r.time < '"+GetTime.getYesterday2()+"') and (r.time > '"+GetTime.getYesterday3()+"') then 'no' end) c, " +
					"count(case when (r.time < '"+GetTime.getYesterday3()+"') and (r.time > '"+GetTime.getYesterday4()+"') then 'no' end) d, " +
					"count(case when (r.time < '"+GetTime.getYesterday4()+"') and (r.time > '"+GetTime.getYesterday5()+"') then 'no' end) e, " +
					"count(case when (r.time < '"+GetTime.getYesterday5()+"') and (r.time > '"+GetTime.getYesterday6()+"') then 'no' end) f " +
					"from record r");
			try {
				while(rs.next()){
					desc = desc + "{name: '周报',data: ["+rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+"]},";
				}
				db.closed();
				rs.close();
			} catch (SQLException e) {
				db.closed();
				e.printStackTrace();
			}
		}
		return desc;
	}

	//	查找饼图2
	public String findpartbt2(String checkbox) {
		String desc = "";
		int i = 0;
		String name = ps.findpart();
		String[] partname = name.split(", ");
		if(checkbox.equals("y1")){
			//			{
			//                name: '软件学院',
			//                y: 56.33
			//            },
			if(checkbox.equals("y1")){

				while(i<partname.length){
					ResultSet rs = null;
					rs = db.getRs("select count(*) from  record r,person p,college c where c.id = p.college and c.name = '"+partname[i]+"' and r.cartNum = p.cartNum and r.time < '"+GetTime.getYear()+"-13' and r.time > '"+GetTime.getYear()+"';");
					try{
						while(rs.next()){
							desc = desc + " {name: '"+partname[i]+"',y:  "+rs.getInt(1)+",},";
						}
						rs.close();
					}catch (Exception e) {
					}
					i++;
				}
				db.closed();
			}
		}else if(checkbox.equals("y2")){

			while(i<partname.length){
				ResultSet rs = null;
				rs = db.getRs("select count(*) from  record r,person p,college c where c.id = p.college and c.name = '"+partname[i]+"' and r.cartNum = p.cartNum and r.time < '"+GetTime.getMonth()+"32' and r.time > '"+GetTime.getMonth()+"';");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+partname[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}else if(checkbox.equals("y4")){

			while(i<partname.length){
				ResultSet rs = null;
				rs = db.getRs("select count(*) from  record r,person p,college c where c.id = p.college and c.name = '"+partname[i]+"' and r.cartNum = p.cartNum and r.time < '"+GetTime.getToday()+"32' and r.time > '"+GetTime.getYesterday7()+"';");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+partname[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}
		System.out.println("bt2"+desc+"bt2");
		return desc;
	}

	//	查找饼图2
	public String findpartbt1(String checkbox) {
		
		String desc = "";
		int i = 0;
		String name = ts.findtype();
		String[] typename = name.split(", ");
		if(checkbox.equals("y1")){
			if(checkbox.equals("y1")){

				while(i<typename.length){
					ResultSet rs = null;
					rs = db.getRs("select count(*) from  record r,person p,type t where r.cartNum = p.cartNum and p.type = t.id and t.type = '"+typename[i]+"' and r.time < '"+GetTime.getYear()+"-13' and r.time > '"+GetTime.getYear()+"';");
					try{
						while(rs.next()){
							desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
						}
						rs.close();
					}catch (Exception e) {
					}
					i++;
				}
				db.closed();
			}
		}else if(checkbox.equals("y2")){

			while(i<typename.length){
				ResultSet rs = null;
				rs = db.getRs("select count(*) from  record r,person p,type t where p.type = t.id and t.type = '"+typename[i]+"' and r.cartNum = p.cartNum and r.time < '"+GetTime.getMonth()+"32' and r.time > '"+GetTime.getMonth()+"';");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}else if(checkbox.equals("y4")){

			while(i<typename.length){
				ResultSet rs = null;
				rs = db.getRs("select count(*) from  record r,person p,type t where p.type = t.id and t.type = '"+typename[i]+"' and r.cartNum = p.cartNum and r.time < '"+GetTime.getToday()+"' and r.time > '"+GetTime.getYesterday7()+"';");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}
		System.out.println(desc);
		return desc;
	}

	//	查找饼图3
	public String findpartbt3(String checkbox) {
		
		String desc = "";
		int i = 0;
		String name = as.findarea();
		String[] typename = name.split(", ");
		if(checkbox.equals("y1")){
			if(checkbox.equals("y1")){

				while(i<typename.length){
					ResultSet rs = null;
					System.out.println("select count(*) from  record r,area a where r.doorNum = a.id and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getYear()+"-13' and r.time > '"+GetTime.getYear()+"'");
					rs = db.getRs("select count(*) from  record r,area a where r.doorNum = a.id and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getYear()+"-13' and r.time > '"+GetTime.getYear()+"'");
					try{
						while(rs.next()){
							desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
						}
						rs.close();
					}catch (Exception e) {
					}
					i++;
				}
			}
			db.closed();
		}else if(checkbox.equals("y2")){

			while(i<typename.length){
				System.out.println("select count(*) from  record r,area a where a.id = r.doorNum and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getMonth()+"32' and r.time > '"+GetTime.getMonth()+"'");
				ResultSet rs = null;
				rs = db.getRs("select count(*) from  record r,area a where a.id = r.doorNum and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getMonth()+"32' and r.time > '"+GetTime.getMonth()+"'");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}else if(checkbox.equals("y4")){

			while(i<typename.length){
				ResultSet rs = null;
				System.out.println("select count(*) from  record r,area a where a.id = r.doorNum and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getToday()+"' and r.time > '"+GetTime.getYesterday7()+"'");
				rs = db.getRs("select count(*) from  record r,area a where a.id = r.doorNum and a.name = '"+typename[i]+"' and r.time < '"+GetTime.getToday()+"' and r.time > '"+GetTime.getYesterday7()+"';");
				try{
					while(rs.next()){
						desc = desc + " {name: '"+typename[i]+"',y:  "+rs.getInt(1)+",},";
					}
					rs.close();
				}catch (Exception e) {
				}
				i++;
			}
			db.closed();
		}
		System.out.println(desc);
		return desc;
	}

	public String findzxt1(String checkbox) {
		String name = ts.findtype();
		String select = "";
		if(checkbox.equals("y1")){
			select = "y5";
		}else if(checkbox.equals("y2")){
			select = "y3";
		}else if(checkbox.equals("y4")){
			select = "y2";
		}
		
		return ts.findTypezxt(name, select);
	}

	public String findzxt2(String checkbox) {
		String name = ps.findpart();
		String select = "";
		if(checkbox.equals("y1")){
			select = "y5";
		}else if(checkbox.equals("y2")){
			select = "y3";
		}else if(checkbox.equals("y4")){
			select = "y2";
		}
		
		return ps.findPartzxt(name, select);
	}

	public String findzxt3(String checkbox) {
		String name = as.findarea();
		String select = "";
		if(checkbox.equals("y1")){
			select = "y5";
		}else if(checkbox.equals("y2")){
			select = "y3";
		}else if(checkbox.equals("y4")){
			select = "y2";
		}
		
		return as.findAreazxt(name, select);
	}
}
