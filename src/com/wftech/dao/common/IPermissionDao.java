package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Permission;

/**
 * @author Daoliang Li
 *
 */
public interface IPermissionDao {

	/**
	 *��ȡȨ���б�
	 * @author Daoliang Li
	 * @return Ȩ���б�
	 */
	public List<Permission> getPermission();
	
}
