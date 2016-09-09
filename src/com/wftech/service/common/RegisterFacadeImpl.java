package com.wftech.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.common.check.CheckDataUtils;
import com.wftech.dao.common.IUserDao;
import com.wftech.domain.common.RegisterInfo;
import com.wftech.domain.common.User;

/**
 * @author ws
 *
 */
@Service
public class RegisterFacadeImpl implements IRegisterFacade{
	
	@Autowired
	IUserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IRegisterFacade#isRegisterSuccess(com.wftech.domain.common.RegisterInfo)
	 */
	public boolean isRegisterSuccess(RegisterInfo registerInfo){
		boolean tag;
		User user;
		
		String username = registerInfo.getUsername();
		String usernickname = registerInfo.getUsernickname();
		String password = registerInfo.getPassword();
		String confirmpassword = registerInfo.getConfirmpassword();
		String email = registerInfo.getEmail();
		String lastip = registerInfo.getLastip();
		
		boolean hasUsername =  userDao.hasUsername(username);
		boolean hasUsernickname = userDao.hasUsernickname(usernickname);
		boolean isPassword = CheckDataUtils.isPassword(password);
		boolean isConfirmPassword = password.equals(confirmpassword);
		boolean isEmail = CheckDataUtils.isEmail(email);
		tag = !hasUsername&&!hasUsernickname&&isConfirmPassword&&isPassword&&isEmail;
		if(tag){
			user = new User().createUser(username, usernickname, password, email,lastip);
			userDao.createUser(user);
		}
		return tag;
	}
}
