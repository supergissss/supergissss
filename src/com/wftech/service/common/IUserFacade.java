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
	 *��ȡ�û��б�
	 * @author Daoliang Li
	 * @param start ��ʼ
	 * @param length ����
	 * @return �û�����
	 */
	public String[][] getUserList(int start, int length);
	
	/**
	 *��ȡ�û�����
	 * @author Daoliang Li
	 * @return �û�����
	 */
	public int getUserNum();
	
	/**
	 *��ȡ�û���Ϣ
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return �û���Ϣ
	 */
	public JSONObject getUserData(int userid);
	
	/**
	 *�����û���ɫ
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @param id ��ɫid
	 */
	public void updateUserRole(String userid, String[] id);
	
	/**
	 *��ȡȨ�޼���
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return Ȩ�޼���
	 */
	public Set<Permission> getPermission(int userid);
	
}
