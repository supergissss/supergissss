package com.wftech.web.common;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.User;
import com.wftech.service.common.ILoginFacade;
import com.wftech.service.common.IPermissionFacade;
import com.wftech.service.common.IUserFacade;

/**
 * @author ws
 *
 */
@Controller
@RequestMapping("common")
public class LoginAction {
	@Autowired
	ILoginFacade loginFacade;
	
	@Autowired
	IUserFacade userFacade;
	
	@Autowired
	IPermissionFacade permissionFacade;
	
	@RequestMapping("login")
	public void login(HttpServletRequest request,HttpServletResponse response,User user){
		String username = user.getUsername();
		String password = user.getPassword();
		boolean tag = loginFacade.isUser(user.getUsername(),user.getPassword());
		String url = request.getHeader("referer");
		try{
			PrintWriter out = response.getWriter();
			if(tag){
				out.write(url);
				Map map = loginFacade.getUseridAndUsernickname(username);
				request.getSession().setAttribute("username",username);
				request.getSession().setAttribute("usernickname",map.get("usernickname"));
				request.getSession().setAttribute("userid",map.get("userid"));
				Set<Permission> userPermission = userFacade.getPermission((Integer)map.get("userid"));
				List<Permission> permission = permissionFacade.getPermissionList();
				request.getSession().setAttribute("permissionSet", userPermission);
				request.getSession().setAttribute("permissionList",permission);
			}else{
				out.write("false");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("loginout")
	public String loginOut(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Enumeration<String> er= session.getAttributeNames();
		while(er.hasMoreElements()){
			session.removeAttribute(er.nextElement());
		}
		String url = request.getHeader("referer");
		return "redirect:"+url;
	}
}
