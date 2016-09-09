package com.wftech.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wftech.dao.common.IUserDao;
import com.wftech.service.common.ILoginValidateFacade;
/**
 * @author ws
 *
 */
@Controller("loginValidate")
public class LoginValidateFilter implements Filter{
	
	@Autowired
	ILoginValidateFacade loginValidateFacade;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String username = (String)session.getAttribute("username");
		if(username!=null){
			int level = loginValidateFacade.getPermission(username);
			request.setAttribute("userlevel", level);
			String usernickname = loginValidateFacade.getUsernickname(username);
			request.setAttribute("usernickname",usernickname);
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
