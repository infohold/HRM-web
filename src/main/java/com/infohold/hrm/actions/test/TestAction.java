package com.infohold.hrm.actions.test;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

@Component("testAction")
public class TestAction implements SessionAware, ServletResponseAware {
	private String				json;
	private Map<String, Object>	session;
	private HttpServletResponse	response;
	private String				str;

	public String execute() throws Exception {
		System.out.println("str:"+str);
		return "success";
	}

	public String getJson() {
		return json;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
