package com.infohold.hrm.actions.load;

import java.util.Map;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;

import com.infohold.hrm.actions.BaseAction;
import com.infohold.hrm.common.rpc.portalInterface.PortalOutputInterface;

@Component("loadCollar")
public class LoadCollar extends BaseAction {
	private String	json;

	public String execute() throws Exception {
		Map collarMap = PortalOutputInterface.getCollarByUserId(session);
		if (collarMap != null) {
			json = JSONArray.fromObject(collarMap).toString();
		} else {
			json = "";
		}

		return "success";
	}

	public String getJson() {
		return json;
	}

}
