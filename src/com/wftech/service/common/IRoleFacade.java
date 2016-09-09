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
	 *���ӽ�ɫ
	 * @author Daoliang Li
	 * @param rolename ��ɫ����
	 * @param permission Ȩ������
	 * @param usernickname �û��ǳ�
	 * @return �Ƿ�ɹ�
	 */
	public boolean addRole(String rolename,List<Permission> permission,String usenickrname);
	
	/**
	 *��ȡ��ɫ�б�
	 * @author Daoliang Li
	 * @param start ��ʼ�����
	 * @param length ��Ŀ�����Ŀ
	 * @return ��ɫ�б�
	 */
	public String[][] getRoleList(int start, int length);
	
	/**
	 *��ȡ��ɫ����
	 * @author Daoliang Li
	 * @return ��Ŀ
	 */
	public int getRoleNum();
	
	/**
	 *��ȡ��ɫȨ��
	 * @author Daoliang Li
	 * @param ��ɫid
	 * @return ��ɫȨ��
	 */
	public JSONObject getRolePermission(String roleid);
	
	/**
	 *ɾ����ɫȨ��
	 * @author Daoliang Li
	 * @param rolename ��ɫ����
	 */
	public void deleteRolePermission(String rolename);
	
	/**
	 *���½�ɫȨ��
	 * @author Daoliang Li
	 * @param roleid ��ɫid 
	 * @param permission Ȩ��
	 * @param usenickrname �û��ǳ�
	 */
	public void updateRolePermission(String roleid,List<Permission> permission,String usenickrname);
	
	/**
	 *��ɫ�Ƿ���ʹ�õ��û�
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 * @return �Ƿ����û�ʹ�øý�ɫ
	 */
	public boolean isRoleHasUser(String roleid);
	
	/**
	 *ɾ��ָ��id�Ľ�ɫ
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 */
	public void deleteRole(String roleid);
	
	/**
	 *����id��ȡ��ɫ��
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 * @return ��ɫ��
	 */
	public String getRoleNameById(String roleid);
}
