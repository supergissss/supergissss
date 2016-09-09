package com.wftech.service.common;

import java.util.List;

import net.sf.json.JSONObject;

import com.wftech.domain.common.Permission;

/**
 * @author Daoliang Li
 *
 */
public interface IRoleFacade {

	/**
	 *增加角色
	 * @author Daoliang Li
	 * @param rolename 角色名称
	 * @param permission 权限名称
	 * @param usernickname 用户昵称
	 * @return 是否成功
	 */
	public boolean addRole(String rolename,List<Permission> permission,String usenickrname);
	
	/**
	 *获取角色列表
	 * @author Daoliang Li
	 * @param start 起始项序号
	 * @param length 项目序号数目
	 * @return 角色列表
	 */
	public String[][] getRoleList(int start, int length);
	
	/**
	 *获取角色总数
	 * @author Daoliang Li
	 * @return 数目
	 */
	public int getRoleNum();
	
	/**
	 *获取角色权限
	 * @author Daoliang Li
	 * @param 角色id
	 * @return 角色权限
	 */
	public JSONObject getRolePermission(String roleid);
	
	/**
	 *删除角色权限
	 * @author Daoliang Li
	 * @param rolename 角色名称
	 */
	public void deleteRolePermission(String rolename);
	
	/**
	 *更新角色权限
	 * @author Daoliang Li
	 * @param roleid 角色id 
	 * @param permission 权限
	 * @param usenickrname 用户昵称
	 */
	public void updateRolePermission(String roleid,List<Permission> permission,String usenickrname);
	
	/**
	 *角色是否有使用的用户
	 * @author Daoliang Li
	 * @param roleid 角色id
	 * @return 是否有用户使用该角色
	 */
	public boolean isRoleHasUser(String roleid);
	
	/**
	 *删除指定id的角色
	 * @author Daoliang Li
	 * @param roleid 角色id
	 */
	public void deleteRole(String roleid);
	
	/**
	 *根据id获取角色名
	 * @author Daoliang Li
	 * @param roleid 角色id
	 * @return 角色名
	 */
	public String getRoleNameById(String roleid);
}
