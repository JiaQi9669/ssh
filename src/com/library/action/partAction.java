package com.library.action;

import com.library.service.partService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class partAction extends ActionSupport{
	private partService ps = new partService();
	private String chkName;
	private String chkYear;
	
	public String getChkYear() {
		return chkYear;
	}

	public void setChkYear(String chkYear) {
		this.chkYear = chkYear;
	}

	public String getChkName() {
		return chkName;
	}

	public void setChkName(String chkName) {
		this.chkName = chkName;
	}
	
//	通过条件查询
	public String findBySelect(){
//		获取全部部门名称
			ActionContext.getContext().put("part", ps.findPartName());
			if(chkYear.equals("y1")){
				ActionContext.getContext().put("partName", "'7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00'");
//			获取查询数据
				ActionContext.getContext().put("partzxt", ps.findPartzxt(chkName,chkYear));
			}else if(chkYear.equals("y2")){
				ActionContext.getContext().put("partName", "'一日前','二日前','三日前','四日前','五日前','六日前','七日前'");
//				获取查询数据
					ActionContext.getContext().put("partzxt", ps.findPartzxt(chkName,chkYear));
			}else if(chkYear.equals("y3")){
				ActionContext.getContext().put("partName", "'1~5日','5~10日','10~15日','15~20日','20~25日','25~31日'");
//				获取查询数据
					ActionContext.getContext().put("partzxt", ps.findPartzxt(chkName,chkYear));
			}else if(chkYear.equals("y5")){
				ActionContext.getContext().put("partName", "'1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'");
//				获取查询数据
					ActionContext.getContext().put("partzxt", ps.findPartzxt(chkName,chkYear));
			}
		return "part";
	}
}
