package com.infohold.hrm.common.rpc.portalInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.infohold.hrm.common.ConfigUtil;
import com.infohold.hrm.common.rpc.RpcManager;

public class PortalOutputInterface {
	/**
	 * 根据传入的url判断用户是否有访问权限
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<String> getAuthorityUrlFromPortalByUserId(String userId, HttpSession session) {
		List<String> urlList = new ArrayList<String>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("user_id", userId);
		params.put("app_id", "0");

		String methodName = "tp.kernel.permission.get.user.authority";
		Map result = null;
		
		try {
			result = RpcManager.getClient(RpcManager.portalService).invoke(methodName, params, session);
		} catch (Throwable e) {
			e.printStackTrace();
			return urlList;
		}

		if (null == result || result.isEmpty()) {
			return urlList;
		}
		String code = (String) result.get("code");
		if (!"0".equals(code)) {
			return urlList;
		}
		Map data = (Map) result.get("data");
		if (null == data || data.isEmpty()) {
			return urlList;
		}
		List<Map> applicationList = (List<Map>) data.get("application_list");
		if (null == applicationList || applicationList.isEmpty() || applicationList.size() == 0) {
			return urlList;
		}
		for (Map application : applicationList) {
			String applicationUrl = (String) application.get("application_url");
			if (null == applicationUrl || applicationUrl.equals("")) {
				continue;
			}
			urlList.add(applicationUrl);
		}

		return urlList;
	}

	/**
	 * 根据传入的url判断是否在门户中管理
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<String> getAuthorityUrlFromPortalByAppId(HttpSession session) {
		List<String> urlList = new ArrayList<String>();
		String appId = ConfigUtil.instance().getProperty("app_id");
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_id", appId);

		String methodName = "tp.kernel.permission.get.subsys.authority";
		JsonRpcHttpClient client;
		Map result = null;
		try {
			result = RpcManager.getClient(RpcManager.portalService).invoke(methodName, params, session);
		} catch (Throwable e) {
			e.printStackTrace();
			return urlList;
		}

		if (null == result || result.isEmpty()) {
			return urlList;
		}
		String code = (String) result.get("code");
		if (!"0".equals(code)) {
			return urlList;
		}
		Map data = (Map) result.get("data");
		if (null == data || data.isEmpty()) {
			return urlList;
		}
		List<Map> applicationList = (List<Map>) data.get("application_list");
		if (null == applicationList || applicationList.isEmpty() || applicationList.size() == 0) {
			return urlList;
		}
		for (Map application : applicationList) {
			String applicationUrl = (String) application.get("application_url");
			if (null == applicationUrl || applicationUrl.equals("")) {
				continue;
			}
			urlList.add(applicationUrl);
		}

		return urlList;
	}

	/**
	 * 获取菜单列表
	 * @param session	session
	 * @return
	 */
	public static List<HashMap<String, Object>> getMenuListFromPortalByUserId(Map<String,Object> session) {
		if(session.size() != 0){
			List<HashMap<String, Object>> menuDataItem = new ArrayList<HashMap<String, Object>>();
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("user_id", session.get("user_id").toString());

			String methodName = "tp.kernel.permission.get.user.menu";
			Map result = null;
			try {
				result = RpcManager.getClient(RpcManager.portalService).invoke(methodName, params, session);
			} catch (Throwable e) {
				e.printStackTrace();
				return null;
			}
			//校验返回结果
			if (!"0".equals(result.get("code"))) {
                return null;
            } else {
                Map menuData = (Map)result.get("data");
                menuDataItem = (List)menuData.get("menu_list");
            }
			return menuDataItem;
		}else{
			return null;
		}
	}
	
	/**
	 * 获取领子信息
	 * @return
	 */
	public static Map getCollarByUserId(Map<String,Object> session){
		if(session.size() != 0){
			Map menuData = new HashMap();
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("user_id", session.get("user_id").toString());
			params.put("app_id", "portal");

			String methodName = "tp.kernel.widget.get.collar";
			Map result = null;
			try {
				result = RpcManager.getClient(RpcManager.portalService).invoke(methodName, params, session);
			} catch (Throwable e) {
				e.printStackTrace();
				return null;
			}
			//校验返回结果
			if (!"0".equals(result.get("code"))) {
                return null;
            } else {
                menuData = (Map)result.get("data");
                menuData.put("user_id", session.get("user_id").toString());
                menuData.put("enterprise_id", session.get("enterprise_id").toString());
            }
			return menuData;
		}else{
			return null;
		}
	}
}
