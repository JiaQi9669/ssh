package com.library.action;

import com.library.service.partService;
import com.library.service.typeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 类型查询
 * @author JiaQi
 *
 */
public class typeAction extends ActionSupport{
	private typeService ts = new typeService();
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
//		获取全部类型名称
			ActionContext.getContext().put("type", ts.findTypeName());
			if(chkYear.equals("y1")){
				ActionContext.getContext().put("typeName", "'7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00','21:00'");
//			获取查询数据
				ActionContext.getContext().put("typezxt", ts.findTypezxt(chkName,chkYear));
			}else if(chkYear.equals("y2")){
				ActionContext.getContext().put("typeName", "'一日前','二日前','三日前','四日前','五日前','六日前','七日前'");
//				获取查询数据
					ActionContext.getContext().put("typezxt", ts.findTypezxt(chkName,chkYear));
			}else if(chkYear.equals("y3")){
				ActionContext.getContext().put("typeName", "'1~5日','5~10日','10~15日','15~20日','20~25日','25~31日'");
//				获取查询数据
					ActionContext.getContext().put("typezxt", ts.findTypezxt(chkName,chkYear));
			}else if(chkYear.equals("y5")){
				ActionContext.getContext().put("typeName", "'1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'");
//				获取查询数据
					ActionContext.getContext().put("typezxt", ts.findTypezxt(chkName,chkYear));
			}
		return "type";
	}
	
}
