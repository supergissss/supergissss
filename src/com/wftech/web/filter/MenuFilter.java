package com.wftech.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;



/**
 * @author Daoliang Li
 *
 */
public class MenuFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String path = ((HttpServletRequest)request).getServletPath();
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(path.lastIndexOf("/dota/")!=-1){
			session.setAttribute("activeli","0");
		}else if(path.lastIndexOf("/user/")!=-1){
			session.setAttribute("activeli", "4");
		}
		chain.doFilter(request, response);
	}
}
