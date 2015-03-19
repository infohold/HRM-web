package com.infohold.hrm.actions.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.infohold.hrm.common.rpc.portalInterface.PortalOutputInterface;

@Component("testAction")
public class TestAction implements SessionAware{
	private String				json;
	private Map<String, Object>	session;

	public String execute() throws Exception {
		List<HashMap<String, Object>> menuList = PortalOutputInterface.getMenuListFromPortalByUserId(session);
		if(menuList != null){
			json = JSONArray.fromObject(menuList).toString();
		}else{
			json = "";
		}
		PortalOutputInterface.getCollarByUserId(session);
		
		return "success";
	}

	public String getJson() {
		return json;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
