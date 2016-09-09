package com.wftech.service.common;

import java.util.Set;

import com.wftech.domain.common.Permission;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Daoliang Li
 *
 */
public interface IUserFacade {

	/**
	 *获取用户列表
	 * @author Daoliang Li
	 * @param start 起始
	 * @param length 长度
	 * @return 用户数据
	 */
	public String[][] getUserList(int start, int length);
	
	/**
	 *获取用户数量
	 * @author Daoliang Li
	 * @return 用户数量
	 */
	public int getUserNum();
	
	/**
	 *获取用户信息
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 用户信息
	 */
	public JSONObject getUserData(int userid);
	
	/**
	 *保存用户角色
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @param id 角色id
	 */
	public void updateUserRole(String userid, String[] id);
	
	/**
	 *获取权限集合
	 * @author Daoliang Li
	 * @param userid 用户id
	 * @return 权限集合
	 */
	public Set<Permission> getPermission(int userid);
	
}
