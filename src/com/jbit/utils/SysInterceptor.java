package com.jbit.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录权限拦截器
 * 
 * @author Administrator
 * 
 */
public class SysInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return false;
	}
}
