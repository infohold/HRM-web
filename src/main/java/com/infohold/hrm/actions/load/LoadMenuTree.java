package com.infohold.hrm.actions.load;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.infohold.hrm.actions.BaseAction;
import com.infohold.hrm.common.rpc.portalInterface.PortalOutputInterface;

@Component("loadMenuTree")
public class LoadMenuTree extends BaseAction {
	private String	json;

	public String execute() throws Exception {
		List<HashMap<String, Object>> menuList = PortalOutputInterface.getMenuListFromPortalByUserId(session);
		if (menuList != null) {
			json = JSONArray.fromObject(menuList).toString();
		} else {
			json = "";
		}

		return "success";
	}

	public String getJson() {
		return json;
	}
}
