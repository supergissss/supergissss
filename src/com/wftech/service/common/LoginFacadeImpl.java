package com.wftech.service.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.dao.common.IUserDao;

/**
 * @author ws
 *
 */
@Service
public class LoginFacadeImpl implements ILoginFacade{
	
	@Autowired
	IUserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.ILoginFacade#isUser(java.lang.String, java.lang.String)
	 */
	public boolean isUser(String username, String password) {
		return userDao.isUser(username,password);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.ILoginFacade#getUseridAndUsernickname(java.lang.String)
	 */
	@Override
	public Map getUseridAndUsernickname(String username) {
		// TODO Auto-generated method stub
		Map map = userDao.getUseridAndUsernickname(username);
		return map;
	}
}
