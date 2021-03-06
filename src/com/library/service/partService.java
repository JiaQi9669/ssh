package com.library.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.library.dao.DBO;
import com.library.tools.GetTime;

/**
 * 部门Service
 * @author JiaQi
 *
 */
public class partService {
	private DBO db = new DBO();
	public ArrayList<String> findPartName(){
		//	获取全部部门名称
		ArrayList<String> part_list = new ArrayList<String>();
		try{
			ResultSet rs = db.getRs("select name from college");
			while(rs.next()){
				part_list.add(rs.getString(1));
			}
			db.closed();
			rs.close();
		}catch (Exception e) {
		}
		if(part_list.isEmpty()){
			part_list.add("暂未发现部门，请添加部门！");
		}
		db.closed();
		return part_list;
	}

	//	查找部门数据
	public String findPartzxt(String chkName, String chkYear) {
		String desc = "";
		String[] partname = chkName.split(", ");
		int i = 0;
		try{
			//		判断查询时间
			if(chkYear.equals("y1")){
//				一天
				
				
				ResultSet rs = db.getRs("select c.name," +
						"count(case when (r.time < '"+GetTime.getToday()+" 8') and (r.time > '"+GetTime.getToday()+" 7') then 'no' end) a," +
						"count(case when (r.time < '"+GetTime.getToday()+" 9') and (r.time > '"+GetTime.getToday()+" 8') then 'no' end) b," +
						"count(case when (r.time < '"+GetTime.getToday()+" 10') and (r.time > '"+GetTime.getToday()+" 9') then 'no' end) c, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 11') and (r.time > '"+GetTime.getToday()+" 10') then 'no' end) d, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 12') and (r.time > '"+GetTime.getToday()+" 11') then 'no' end) e, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 13') and (r.time > '"+GetTime.getToday()+" 12') then 'no' end) f, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 14') and (r.time > '"+GetTime.getToday()+" 13') then 'no' end) g, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 15') and (r.time > '"+GetTime.getToday()+" 14') then 'no' end) h, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 16') and (r.time > '"+GetTime.getToday()+" 15') then 'no' end) i, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 17') and (r.time > '"+GetTime.getToday()+" 16') then 'no' end) j, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 18') and (r.time > '"+GetTime.getToday()+" 17') then 'no' end) k, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 19') and (r.time > '"+GetTime.getToday()+" 18') then 'no' end) l, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 20') and (r.time > '"+GetTime.getToday()+" 19') then 'no' end) m, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 21') and (r.time > '"+GetTime.getToday()+" 20') then 'no' end) n, " +
						"count(case when (r.time < '"+GetTime.getToday()+" 22') and (r.time > '"+GetTime.getToday()+" 21') then 'no' end) o " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				while(rs.next()){
					desc = desc + "{name: '"+rs.getString(1)+"',data: ["+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10)+","+rs.getString(11)+","+rs.getString(12)+","+rs.getString(13)+","+rs.getString(14)+","+rs.getString(15)+","+rs.getString(16)+"]},";
				}
				db.closed();
				rs.close();
				
				
				
				
				
				
			}else if(chkYear.equals("y2")){
//				一周
				
				System.out.println("select c.name," +
						"count(case when (r.time < '"+GetTime.getToday()+"') and (r.time > '"+GetTime.getYesterday()+"') then 'no' end) 1," +
						"count(case when (r.time < '"+GetTime.getYesterday()+"') and (r.time > '"+GetTime.getYesterday2()+"') then 'no' end) 2," +
						"count(case when (r.time < '"+GetTime.getYesterday2()+"') and (r.time > '"+GetTime.getYesterday3()+"') then 'no' end) 3, " +
						"count(case when (r.time < '"+GetTime.getYesterday3()+"') and (r.time > '"+GetTime.getYesterday4()+"') then 'no' end) 4, " +
						"count(case when (r.time < '"+GetTime.getYesterday4()+"') and (r.time > '"+GetTime.getYesterday5()+"') then 'no' end) 5, " +
						"count(case when (r.time < '"+GetTime.getYesterday5()+"') and (r.time > '"+GetTime.getYesterday6()+"') then 'no' end) 6 " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				
				
				ResultSet rs = db.getRs("select c.name," +
						"count(case when (r.time < '"+GetTime.getToday()+"') and (r.time > '"+GetTime.getYesterday()+"') then 'no' end) a," +
						"count(case when (r.time < '"+GetTime.getYesterday()+"') and (r.time > '"+GetTime.getYesterday2()+"') then 'no' end) b," +
						"count(case when (r.time < '"+GetTime.getYesterday2()+"') and (r.time > '"+GetTime.getYesterday3()+"') then 'no' end) c, " +
						"count(case when (r.time < '"+GetTime.getYesterday3()+"') and (r.time > '"+GetTime.getYesterday4()+"') then 'no' end) d, " +
						"count(case when (r.time < '"+GetTime.getYesterday4()+"') and (r.time > '"+GetTime.getYesterday5()+"') then 'no' end) e, " +
						"count(case when (r.time < '"+GetTime.getYesterday5()+"') and (r.time > '"+GetTime.getYesterday6()+"') then 'no' end) f " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				while(rs.next()){
					desc = desc + "{name: '"+rs.getString(1)+"',data: ["+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+"]},";
				}
				db.closed();
				rs.close();
				
				
				
				
				
			}
			else if(chkYear.equals("y3")){
				
//				一月
				
				System.out.println("select c.name," +
						"count(case when (r.time < '"+GetTime.getToday()+"') and (r.time > '"+GetTime.getYesterday()+"') then 'no' end) 1," +
						"count(case when (r.time < '"+GetTime.getYesterday()+"') and (r.time > '"+GetTime.getYesterday2()+"') then 'no' end) 2," +
						"count(case when (r.time < '"+GetTime.getYesterday2()+"') and (r.time > '"+GetTime.getYesterday3()+"') then 'no' end) 3, " +
						"count(case when (r.time < '"+GetTime.getYesterday3()+"') and (r.time > '"+GetTime.getYesterday4()+"') then 'no' end) 4, " +
						"count(case when (r.time < '"+GetTime.getYesterday4()+"') and (r.time > '"+GetTime.getYesterday5()+"') then 'no' end) 5, " +
						"count(case when (r.time < '"+GetTime.getYesterday5()+"') and (r.time > '"+GetTime.getYesterday6()+"') then 'no' end) 6 " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				
				
				ResultSet rs = db.getRs("select c.name," +
						"count(case when (r.time < '"+GetTime.getMonth()+"-06') and (r.time > '"+GetTime.getMonth()+"-01') then 'no' end) a," +
						"count(case when (r.time < '"+GetTime.getMonth()+"-11') and (r.time > '"+GetTime.getMonth()+"-06') then 'no' end) b," +
						"count(case when (r.time < '"+GetTime.getMonth()+"-16') and (r.time > '"+GetTime.getMonth()+"-11') then 'no' end) c, " +
						"count(case when (r.time < '"+GetTime.getMonth()+"-21') and (r.time > '"+GetTime.getMonth()+"-16') then 'no' end) d, " +
						"count(case when (r.time < '"+GetTime.getMonth()+"-26') and (r.time > '"+GetTime.getMonth()+"-21') then 'no' end) e, " +
						"count(case when (r.time < '"+GetTime.getMonth()+"-32') and (r.time > '"+GetTime.getMonth()+"-26') then 'no' end) f " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				while(rs.next()){
					desc = desc + "{name: '"+rs.getString(1)+"',data: ["+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+"]},";
				}
				db.closed();
				rs.close();
				
				

			}else if(chkYear.equals("y5")){
				System.out.println("select c.name," +
						"count(case when (r.time < '"+GetTime.getYear()+" 02') and (r.time > '"+GetTime.getYear()+" 01') then 'no' end) a," +
						"count(case when (r.time < '"+GetTime.getYear()+" 03') and (r.time > '"+GetTime.getYear()+" 02') then 'no' end) b," +
						"count(case when (r.time < '"+GetTime.getYear()+" 04') and (r.time > '"+GetTime.getYear()+" 03') then 'no' end) c, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 05') and (r.time > '"+GetTime.getYear()+" 04') then 'no' end) d, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 06') and (r.time > '"+GetTime.getYear()+" 05') then 'no' end) e, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 07') and (r.time > '"+GetTime.getYear()+" 06') then 'no' end) f, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 08') and (r.time > '"+GetTime.getYear()+" 07') then 'no' end) g, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 09') and (r.time > '"+GetTime.getYear()+" 08') then 'no' end) h, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 10') and (r.time > '"+GetTime.getYear()+" 09') then 'no' end) i, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 11') and (r.time > '"+GetTime.getYear()+" 10') then 'no' end) j, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 12') and (r.time > '"+GetTime.getYear()+" 11') then 'no' end) k, " +
						"count(case when (r.time < '"+GetTime.getYear()+" 13') and (r.time > '"+GetTime.getYear()+" 12') then 'no' end) l " +
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				
				
//				一年
				ResultSet rs = db.getRs("select c.name," +
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
						"from record r,person p,college c where r.cartNum = p.cartNum and p.college = c.id group by c.name");
				while(rs.next()){
					desc = desc + "{name: '"+rs.getString(1)+"',data: ["+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10)+","+rs.getString(11)+","+rs.getString(12)+","+rs.getString(13)+"]},";
				}
				db.closed();
				rs.close();
				
				
				
			}
		}catch (Exception e) {
		}
		db.closed();
		System.out.println(desc);
		return desc;
	}

//	获取全部部门名称
	public String findpart() {
		//	获取全部部门名称
		String name = "";
		try{
			ResultSet rs = db.getRs("select name from college");
			while(rs.next()){
				name = name + rs.getString(1) + ", ";
			}
			db.closed();
			rs.close();
		}catch (Exception e) {
		}
		if(name.equals("")){
			name = "暂未发现部门，请添加部门！";
		}
		db.closed();
		return name;
	}
}