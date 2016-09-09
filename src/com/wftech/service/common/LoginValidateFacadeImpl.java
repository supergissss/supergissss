package com.wftech.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.dao.common.IUserDao;

/**
 * @author ws
 *
 */
@Service
public class LoginValidateFacadeImpl implements ILoginValidateFacade{
	
	@Autowired
	IUserDao userDao;
	
	public int getPermission(String username){
		return userDao.getUserlevel(username);
	}
	
	public String getUsernickname(String username){
		return userDao.getUsernickname(username);
	}
}
