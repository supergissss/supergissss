package com.wftech.service.common;
/**
 * @author ws
 *
 */
public interface ILoginValidateFacade {
	/**
	 *��ȡȨ��
	 * @author Daoliang Li
	 * @param username �û���
	 * @return Ȩ��
	 */
	public int getPermission(String username);
	
	/**
	 *��ȡ�ǳ�
	 * @author Daoliang Li
	 * @param username �û���
	 * @return �ǳ�
	 */
	public String getUsernickname(String username);
}
