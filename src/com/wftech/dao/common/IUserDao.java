package com.wftech.dao.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wftech.domain.common.Permission;
import com.wftech.domain.common.RegisterInfo;
import com.wftech.domain.common.Role;
import com.wftech.domain.common.User;

/**
 * �û���򽻵���dao
 * @author ws
 *
 */
public interface IUserDao {
	
	/**
	 *�Ƿ��û�
	 * @author Daoliang Li
	 * @param username �û���
	 * @param password ����
	 * @return �Ƿ��û�
	 */
	public boolean isUser(String username,String password);
	

	/**
	 *�����û�
	 * @author Daoliang Li
	 * @param user �û�
	 */
	public void createUser(User user);
	
	/**
	 *�Ƿ����ظ����û�����
	 * @author Daoliang Li
	 * @param username �û���
	 * @return �Ƿ�
	 */
	public boolean hasUsername(String username);
	
	/**
	 *�Ƿ����ظ����û��ǳ�
	 * @author Daoliang Li
	 * @param usernickname �û��ǳ�
	 * @return �Ƿ�
	 */
	public boolean hasUsernickname(String usernickname);
	
	/**
	 *��ȡ�û��ȼ�
	 * @author Daoliang Li
	 * @param username �û���
	 * @return �û��ȼ�
	 */
	public int getUserlevel(String username);
	
	/**
	 *��ȡ�û��ǳ�
	 * @author Daoliang Li
	 * @param username �û���
	 * @return �û��ǳ�
	 */
	public String getUsernickname(String username);
	
	/**
	 *��ȡ�û�id
	 * @author Daoliang Li
	 * @param username �û���
	 * @return �û�id
	 */
	public int getUserid(String username);
	
	/**
	 *������������ӵ���Ŀ
	 * @author Daoliang Li
	 * @param userid �û�id
	 */
	public void addThemeAndPostNum(int userid);
	
	/**
	 *��ȡ�û�����
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return �û�����
	 */
	public String getUsername(int userid);
	
	/**
	 *��ȡ�û�id���û��ǳ�
	 * @author Daoliang Li
	 * @param username �û���
	 * @return  �û��ǳƺ��û�id��map
	 */
	public Map getUseridAndUsernickname(String username);
	
	/**
	 *��ȡ�û�id
	 * @author Daoliang Li
	 * @param usernickname �û��ǳ�
	 * @return �û�id
	 */
	public int getUseridByUsernickname(String usernickname);
	
	/**
	 *������ʱ�����û�����
	 * @author Daoliang Li
	 * @param userid �û�id
	 */
	public void updateByPost(int userid);
	
	/**
	 *�жϻ��ֿ��û��Ƿ���Ҫ����
	 * @author Daoliang Li
	 * @param userid �û�id
	 */
	public void updateLevel(int userid);
	
	/**
	 *��ȡ�û� list
	 * @author Daoliang Li
	 * @param useridArray �û�id����
	 * @return �û�list
	 */
	public List<User> getUser(int[] useridArray);
	
	/**
	 *��ȡ�û��б�
	 * @author Daoliang Li
	 * @param start ��ʼ
	 * @param length ����
	 * @return �û�����
	 */
	public List<User> getUserList(int start, int length);
	
	/**
	 *��ȡ�û�����
	 * @author Daoliang Li
	 * @return �û�����
	 */
	public int getUserNum();
	
	/**
	 *��ȡ�û���ɫ����
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return ��ɫ����
	 */
	public Set<Role> getUserRole(int userid);
	
	/**
	 *��ȡ�û�
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return �û�
	 */
	public User getUser(int userid);
	
	/**
	 *ɾ���û���id
	 * @author Daoliang Li
	 * @param userid �û�id
	 */
	public void deleteUserRole(String userid);
	
	/**
	 *�����û��Ľ�ɫ��Ϣ
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @param id ��ɫid
	 */
	public void updateUserRole(String userid, String[] id);
	
	/**
	 *��ȡ�û�Ȩ��
	 * @author Daoliang Li
	 * @param userid �û�id
	 * @return Ȩ�޼���
	 */
	public Set<Permission> getPermission(int userid);
}
