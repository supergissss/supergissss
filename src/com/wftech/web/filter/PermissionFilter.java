package com.wftech.web.filter;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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

import com.wftech.domain.common.Permission;
import com.wftech.service.common.IUserFacade;

/**
 * @author Daoliang Li
 *
 */
@Controller("permission")
public class PermissionFilter implements Filter{
	
	@Autowired
	IUserFacade userFacade;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String username = (String)session.getAttribute("username");
		Integer userid = (Integer)session.getAttribute("userid");
		String url = ((HttpServletRequest)request).getServletPath();
		if(username!=null){
			Set<Permission> userPermission = (Set<Permission>)session.getAttribute("permissionSet");
			List<Permission> allPermission = (List<Permission>)session.getAttribute("permissionList");
			if(isForbidUrl(url,userPermission,allPermission)){
				if(url.lastIndexOf("/")!=url.indexOf("/")){
					request.getRequestDispatcher("../dota/forbid").forward(request, response);
				}else{
					request.getRequestDispatcher("dota/forbid").forward(request, response);
				}
				return;
			}
		}
		chain.doFilter(request,response);
	}
	
	private boolean isForbidUrl(String url, Set<Permission> set, List<Permission> list){
		if(url.lastIndexOf("/static")!=-1||url.lastIndexOf("/common")!=-1){
			return false;
		}
		for(Permission permission:list){
			if(permission.getType()==1&&!set.contains(permission)&&url.lastIndexOf(permission.getPerm())!=-1){
				return true;
			}
		}
		boolean isForbid = true;
		for(Permission permission:set){
			if(permission.getType()==2){
				if(url.lastIndexOf(permission.getPerm())!=-1){
					isForbid = false;
				}
			}
		}
		return isForbid;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
