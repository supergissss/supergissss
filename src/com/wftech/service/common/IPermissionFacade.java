package com.wftech.service.common;

import java.util.List;

import com.wftech.domain.common.Permission;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Daoliang Li
 *
 */
public interface IPermissionFacade {

	/**
	 *数据库获取权限
	 * @author Daoliang Li
	 * @return 权限的json数据
	 */
	public JSONObject getPermission();
	
	/**
	 *获取权限列表
	 * @author Daoliang Li
	 * @return 权限列表
	 */
	public List<Permission> getPermissionList();
}
