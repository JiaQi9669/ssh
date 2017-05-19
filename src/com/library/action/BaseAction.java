package com.library.action;

import com.library.service.areaService;
import com.library.service.comService;
import com.library.service.indexService;
import com.library.service.partService;
import com.library.service.readerService;
import com.library.service.topService;
import com.library.service.typeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础页面跳转
 * @author JiaQi
 *
 */
public class BaseAction extends ActionSupport{
	private comService cs = new comService();
	private areaService as = new areaService();
	private typeService ts = new typeService();
	private partService ps = new partService();
	private indexService is = new indexService();
	private topService tops = new topService();
	private readerService rs=new readerService();
//	查询id用于读者查询
	private String searchid;

	public String getSearchid() {
		return searchid;
	}
	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}
	//	首页 区域统计
	public String index(){
		
		String chkName = ps.findpart();
		String chkYear = "y1";
		
//		获取全部部门名称
		ActionContext.getContext().put("part", ps.findPartName());
//		默认查询
		ActionContext.getContext().put("partName", "'7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00'");
//		获取查询数据
		ActionContext.getContext().put("partzxt", ps.findPartzxt(chkName,chkYear));
		
		return "index";
	}
//	首页 统计进馆数量
	public String index2(){
//		统计图书馆的本天入馆人员数量
		ActionContext.getContext().put("num", is.findByTotal());
		return "index2";
	}
	
//	区域
	public String area(){
		
		String chkName = as.findarea();
		String chkYear = "y1";
		
		ActionContext.getContext().put("areaName", "'7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00'");
//		获取查询数据
			ActionContext.getContext().put("areazxt", as.findAreazxt(chkName,chkYear));
		
//		获取全部类型名称
			ActionContext.getContext().put("area", as.findAreaName());
		return "area";
	}
//	综合统计
	public String comprehensive(){
		String checkbox = "y1";
		
		ActionContext.getContext().put("partbt1",cs.findpartbt1(checkbox));
		ActionContext.getContext().put("partbt2",cs.findpartbt2(checkbox));
		ActionContext.getContext().put("partbt3",cs.findpartbt3(checkbox));
		ActionContext.getContext().put("zxt1", cs.findzxt1(checkbox));
		ActionContext.getContext().put("zxt2", cs.findzxt2(checkbox));
		ActionContext.getContext().put("zxt3", cs.findzxt3(checkbox));
		
		
		ActionContext.getContext().put("comName", "'1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'");
		ActionContext.getContext().put("comzxt", cs.findreport(checkbox));
		
		return "comprehensive";
	}
//	自定义
	public String custtom(){
		return "custtom";
	}
//	内务报表
	public String report(){
		return "report";
	}
//	类型查询
	public String type(){
		
		String chkName = ts.findtype();
		String chkYear = "y1";
		
		ActionContext.getContext().put("typeName", "'7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00'");
//		获取查询数据
			ActionContext.getContext().put("typezxt", ts.findTypezxt(chkName,chkYear));
		
//		获取全部类型名称
			ActionContext.getContext().put("type", ts.findTypeName());
		return "type";
	}
//	排行榜
	public String top(){

//		获得排行榜读者前10
		ActionContext.getContext().put("toplist1", tops.findName());
//		获得排行榜学院前10
		ActionContext.getContext().put("toplist2", tops.findDepart());
//		获得排行榜类型前10
		ActionContext.getContext().put("toplist3", tops.findType());
		return "top";
	}
//	读者查询
	public String reader(){
		
//			通过id查询读者
			ActionContext.getContext().put("readerLisr", rs.findId(searchid));
			System.out.println(searchid+"dfssssssssssss");
		return "reader";
	}
	
}
