package com.wftech.service.common;

import java.util.Map;

/**
 * @author ws
 *
 */
public interface ILoginFacade {
	
	/**
	 *是否用户
	 * @author Daoliang Li
	 * @param username 用户名
	 * @param password 密码
	 * @return 是否用户
	 */
	public boolean isUser(String username,String password);
	
	/**
	 *获取用户id和用户昵称
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return map
	 */
	public Map getUseridAndUsernickname(String username);
}
