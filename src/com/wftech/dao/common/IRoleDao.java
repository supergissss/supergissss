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
	 *���ӽ�ɫ
	 * @author Daoliang Li
	 * @param role ��ɫ
	 * @return roleid
	 */
	public String addRole(Role role);
	
	/**
	 *��ӽ�ɫ��Ȩ��
	 * @author Daoliang Li
	 * @param role ��ɫ
	 * @param list Ȩ��list
	 */
	public void addRolePermission(Role role,List<Permission> list);
	
	/**
	 *��ȡ��ɫ�б�
	 * @author Daoliang Li
	 * @param start ��ʼ�����
	 * @param length ��Ŀ�����Ŀ
	 * @return ��ɫ�б�
	 */
	public List<Role> getRoleList(int start, int length);
	
	/**
	 *��ȡ��ɫ����
	 * @author Daoliang Li
	 * @return ��Ŀ
	 */
	public int getRoleNum();
	
	/**
	 *��ȡ��ɫȨ��
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 * @return Ȩ��
	 */
	public List<Permission> getRolePermission(String roleid);
	
	/**
	 *ɾ����ɫȨ��
	 * @author Daoliang Li
	 * @param rolename ��ɫ��
	 */
	public void deleteRolePermission(String rolename);
	
	/**
	 *ɾ���û�
	 * @author Daoliang Li
	 * @param roleid �û�id
	 */
	public void deleteRole(String roleid);
	
	/**
	 *��ɫ�Ƿ���ʹ����
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 * @return �Ƿ���ʹ����
	 */
	public boolean isRoleHasUser(String roleid);
	
	/**
	 *����id��ȡ��ɫ����
	 * @author Daoliang Li
	 * @param roleid ��ɫid
	 * @param ��ɫ����
	 */
	public String getRoleNameById(String roleid);
	
	/**
	 *��ȡ���н�ɫ
	 * @author Daoliang Li
	 * @return ��ɫ�б�
	 */
	public List<Role> getAllRole();
}
