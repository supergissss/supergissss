package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.Role;

/**
 * @author Daoliang Li
 *
 */
public interface IRoleDao {

	/**
	 *增加角色
	 * @author Daoliang Li
	 * @param role 角色
	 * @return roleid
	 */
	public String addRole(Role role);
	
	/**
	 *添加角色的权限
	 * @author Daoliang Li
	 * @param role 角色
	 * @param list 权限list
	 */
	public void addRolePermission(Role role,List<Permission> list);
	
	/**
	 *获取角色列表
	 * @author Daoliang Li
	 * @param start 起始项序号
	 * @param length 项目序号数目
	 * @return 角色列表
	 */
	public List<Role> getRoleList(int start, int length);
	
	/**
	 *获取角色总数
	 * @author Daoliang Li
	 * @return 数目
	 */
	public int getRoleNum();
	
	/**
	 *获取角色权限
	 * @author Daoliang Li
	 * @param roleid 角色id
	 * @return 权限
	 */
	public List<Permission> getRolePermission(String roleid);
	
	/**
	 *删除角色权限
	 * @author Daoliang Li
	 * @param rolename 角色名
	 */
	public void deleteRolePermission(String rolename);
	
	/**
	 *删除用户
	 * @author Daoliang Li
	 * @param roleid 用户id
	 */
	public void deleteRole(String roleid);
	
	/**
	 *角色是否有使用者
	 * @author Daoliang Li
	 * @param roleid 角色id
	 * @return 是否有使用者
	 */
	public boolean isRoleHasUser(String roleid);
	
	/**
	 *根据id获取角色名称
	 * @author Daoliang Li
	 * @param roleid 角色id
	 * @param 角色名称
	 */
	public String getRoleNameById(String roleid);
	
	/**
	 *获取所有角色
	 * @author Daoliang Li
	 * @return 角色列表
	 */
	public List<Role> getAllRole();
}
