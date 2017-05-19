package com.library.action;

import com.library.bean.User;
import com.library.service.LoginService;
import com.library.service.indexService;
import com.library.service.partService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录Action
 * @author JiaQi
 */
public class LoginAction extends ActionSupport{
	private LoginService ls = new LoginService();
	private partService ps = new partService();
	private indexService is=new indexService();
	private String username;
	private String password;
	
    public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//	登录判定
	public String Login(){
		User user = ls.findByUserName(username);
		if(user == null){
			
			return "file";
		}else{
			if(user.getPassword().equals(password)){
//				fangsession
				ActionContext.getContext().getSession().put("user", user);
//				获取部门名称
				ActionContext.getContext().put("part", ps.findPartName());
//				统计图书馆的本天入馆人员数量
				ActionContext.getContext().put("num", is.findByTotal());
				return "success";	
			}else{
//				向前台传递一个密码登录失败的信号
				ActionContext.getContext().put("file","file");
				return "file";
			}
		}
	}
	
	
}
