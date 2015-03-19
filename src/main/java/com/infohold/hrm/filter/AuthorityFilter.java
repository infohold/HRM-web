package com.infohold.hrm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.infohold.hrm.common.rpc.portalInterface.PortalOutputInterface;

public class AuthorityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		AttributePrincipal ap = (AttributePrincipal) httpRequest.getUserPrincipal();

		String userId = "";
		String enterpriseID = "";
		String sessionID = "";
		if (ap != null) {
			userId = ap.getName();
			Map<String, Object> att = ap.getAttributes();
			enterpriseID = (String) att.get("ent_id");
			sessionID = (String) att.get("session_id");
		}

		String url = httpRequest.getRequestURI();
		// 将信息存入session
		HttpSession httpSession = httpRequest.getSession();
		httpSession.setAttribute("enterprise_id", enterpriseID);
		httpSession.setAttribute("session_id", sessionID);
		httpSession.setAttribute("user_id", userId);

		List<String> appUrlList = (List<String>) httpSession.getAttribute("app_url");
		if (appUrlList == null) {
			appUrlList = PortalOutputInterface.getAuthorityUrlFromPortalByAppId(httpSession);
			httpSession.setAttribute("app_url", appUrlList);
		}

		List<String> userUrlList = (List<String>) httpSession.getAttribute("user_url");
		if (userUrlList == null) {
			userUrlList = PortalOutputInterface.getAuthorityUrlFromPortalByUserId(userId, httpSession);
			httpSession.setAttribute("user_url", userUrlList);
		}
		// 判断url是否在portal中进行管理
		if (checkUrlInUrlList(url, appUrlList)) {// 在portal中管理
			// 判断用户对该url是否有权限
			if (!checkUrlInUrlList(url, userUrlList)) {// 没有权限
				HttpServletResponse res = (HttpServletResponse) response;
				HttpServletRequest req = (HttpServletRequest) request;
				res.sendRedirect(req.getContextPath() + "/accessroleerrorpage.html");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	private boolean checkUrlInUrlList(String url, List urlList) {
		boolean checkFlag = false;
		if (urlList == null || urlList.size() == 0) {
			return checkFlag;
		}
		for (int i = 0; i < urlList.size(); i++) {
			String applicationUrl = (String) urlList.get(i);
			if (url.indexOf(applicationUrl) != -1) {
				checkFlag = true;
				break;
			}
		}
		return checkFlag;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
