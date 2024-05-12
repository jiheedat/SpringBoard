package com.jh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("���ͼ��� ����� - session.getAttribute loginId = " + session.getAttribute("loginId"));
//		return true;
		if(session != null && session.getAttribute("loginId")!=null) {
			return true;
		}
		request.setAttribute("msg", "�α��� �� �̿����ּ���");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}
}
