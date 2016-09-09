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
	 *���ݿ��ȡȨ��
	 * @author Daoliang Li
	 * @return Ȩ�޵�json����
	 */
	public JSONObject getPermission();
	
	/**
	 *��ȡȨ���б�
	 * @author Daoliang Li
	 * @return Ȩ���б�
	 */
	public List<Permission> getPermissionList();
}
