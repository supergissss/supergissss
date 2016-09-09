package com.wftech.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;
import com.wftech.service.common.ILaunchThemeFacade;
import com.wftech.service.common.IPostFacade;

/**
 * @author ws
 *
 */
@Controller
public class LaunchThemeAction {
	
	@Autowired
	ILaunchThemeFacade launchThemeFacade;
	
	@RequestMapping("launchtheme")
	public String post(HttpServletRequest request,Theme theme){
		String url = request.getHeader("referer");
		String username = (String)request.getSession().getAttribute("username");
		launchThemeFacade.launchTheme(username,theme);
		return "redirect:"+url;
	}
}
