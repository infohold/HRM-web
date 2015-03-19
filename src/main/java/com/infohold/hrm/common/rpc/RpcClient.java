package com.infohold.hrm.common.rpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.infohold.hrm.common.ConfigUtil;

public final class RpcClient {
	private String				serviceIp;	// 服务ip
	private JsonRpcHttpClient	client;		//JsonRpc客户端

	public RpcClient(String serverName) throws MalformedURLException {
		this.serviceIp = ConfigUtil.instance().getProperty(serverName);
		this.client = new JsonRpcHttpClient(new URL(serviceIp));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map invoke(String methodName, Map params ,Map session) {
		Map result = null;
		
		params.put("enterprise_id", session.get("enterprise_id"));
		params.put("session_id", session.get("session_id"));
		params.put("login_user_id", session.get("user_id"));
		
		try {
			result = client.invoke(methodName, new Object[] { params }, Map.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map invoke(String methodName, Map params,HttpSession session){
		Map result = null;
		
		params.put("enterprise_id", session.getAttribute("enterprise_id"));
		params.put("session_id", session.getAttribute("session_id"));
		params.put("login_user_id", session.getAttribute("user_id"));
		
		try {
			result = client.invoke(methodName, new Object[] { params }, Map.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
