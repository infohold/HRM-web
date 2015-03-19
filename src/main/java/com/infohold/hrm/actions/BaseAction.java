package com.infohold.hrm.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware{
	protected Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
