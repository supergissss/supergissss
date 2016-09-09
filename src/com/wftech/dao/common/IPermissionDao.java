package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Permission;

/**
 * @author Daoliang Li
 *
 */
public interface IPermissionDao {

	/**
	 *获取权限列表
	 * @author Daoliang Li
	 * @return 权限列表
	 */
	public List<Permission> getPermission();
	
}
