package com.wftech.web.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wftech.domain.common.RegisterInfo;
import com.wftech.service.common.IRegisterFacade;

/**
 * @author ws
 *
 */
@Controller
public class RegisterAction {
	
	@Autowired
	IRegisterFacade registerFacade;
	
	@RequestMapping("registerinfo")
	public String registerInfo(){
		
		return "common/register";
	}
	
	@RequestMapping("register")
	public void register(HttpServletResponse response,HttpServletRequest request,RegisterInfo registerInfo){
		registerInfo.setLastip(request.getRemoteAddr());
		boolean tag = registerFacade.isRegisterSuccess(registerInfo);
		String url = request.getHeader("referer");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			if(tag){
				out.write(url);
				request.getSession().setAttribute("username",registerInfo.getUsername());
			}else{
				out.write("fail");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
}
