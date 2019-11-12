package net.fsd.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CORSInterceptor implements HandlerInterceptor {

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		String serv = request.getServletPath();
		// Access-Control-Allow-Origin = http://localhost:4200
		//response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:4200");
		System.out.println(">>>>>>>>>>>>CORSInterceptor.postHandle is invoked");
	}
}
