package com.wftech.service.common;
/**
 * @author ws
 *
 */
public interface ILoginValidateFacade {
	/**
	 *获取权限
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 权限
	 */
	public int getPermission(String username);
	
	/**
	 *获取昵称
	 * @author Daoliang Li
	 * @param username 用户名
	 * @return 昵称
	 */
	public String getUsernickname(String username);
}
