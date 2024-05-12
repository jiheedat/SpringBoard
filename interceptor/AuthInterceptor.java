package com.jh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("인터셉터 실행됨 - session.getAttribute loginId = " + session.getAttribute("loginId"));
//		return true;
		if(session != null && session.getAttribute("loginId")!=null) {
			return true;
		}
		request.setAttribute("msg", "로그인 후 이용해주세요");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}
}
