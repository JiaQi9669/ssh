package com.library.tools;

import com.library.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginFilter extends MethodFilterInterceptor{

	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User u=(User)ActionContext.getContext().getSession().get("user");
		if(u!=null){
			arg0.invoke();
//			return "login";
		}
		return "login";
	}

	
}
