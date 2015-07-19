package com.angelmedics.mvc;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KukaFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//	
//		if (httpRequest.getHeader("User-Agent").contains("MicroMessenger")) {
//			filterChain.doFilter(request, response);
//		} else {
//			// String str = "请使用微信进行访问";
//			// OutputStream out = response.getOutputStream();
//			// out.write(str.getBytes());
//
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.sendError(403, "请使用微信进行访问!");
//		}
		 filterChain.doFilter(request, response);
	
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
