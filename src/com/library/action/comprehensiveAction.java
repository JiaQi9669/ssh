package com.library.action;

import com.library.service.comService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 综合统计
 * @author JiaQi
 *
 */
public class comprehensiveAction extends ActionSupport{
	private comService cs = new comService();
	private String checkbox;

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	//	查询数据
	public String findBySelect(){
		System.out.println(checkbox.equals("y2")+"--------------------------------------------");
		ActionContext.getContext().put("partbt1",cs.findpartbt1(checkbox));
			ActionContext.getContext().put("partbt2",cs.findpartbt2(checkbox));
			ActionContext.getContext().put("partbt3",cs.findpartbt3(checkbox));
			ActionContext.getContext().put("zxt1", cs.findzxt1(checkbox));
			ActionContext.getContext().put("zxt2", cs.findzxt2(checkbox));
			ActionContext.getContext().put("zxt3", cs.findzxt3(checkbox));
		//		年报
		if(checkbox.equals("y1")){
			ActionContext.getContext().put("comName", "'1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'");
			ActionContext.getContext().put("comzxt", cs.findreport(checkbox));
		}else if(checkbox.equals("y4")){
				ActionContext.getContext().put("comName", "'一日前','二日前','三日前','四日前','五日前','六日前','七日前'");
				ActionContext.getContext().put("comzxt", cs.findreport(checkbox));
			}
		else if(checkbox.equals("y2")){
				
				System.out.println("-----------------000");
				
				ActionContext.getContext().put("comName", "'1~5日','5~10日','10~15日','15~20日','20~25日','25~31日'");
				System.out.println("-----------------000....");
				ActionContext.getContext().put("comzxt", cs.findreport(checkbox));
			}
		return "com";
	}
}
