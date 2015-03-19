package com.infohold.hrm.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

public class TestJsonRPC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String enterpriseId = session.getAttribute("enterprise_id").toString();
		String sessionId = session.getAttribute("session_id").toString();
		String userId = session.getAttribute("user_id").toString();
		
		List<String> urlList = new ArrayList<String>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("user_id", userId);
		params.put("app_id", "0");
		params.put("enterprise_id", enterpriseId);
		params.put("session_id", sessionId);
		params.put("login_user_id", userId);
		
		String methodName = "tp.kernel.permission.get.user.authority";
		JsonRpcHttpClient client;
		Map result = null;
		try {
			client = new JsonRpcHttpClient(new URL("http://218.25.139.95:10046/platform/openapi"));
			result = client.invoke(methodName, new Object[] { params }, Map.class);
			System.out.println(1);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
