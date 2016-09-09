package com.wftech.service.common;

import java.util.Map;

/**
 * @author ws
 *
 */
public interface ILoginFacade {
	
	/**
	 *�Ƿ��û�
	 * @author Daoliang Li
	 * @param username �û���
	 * @param password ����
	 * @return �Ƿ��û�
	 */
	public boolean isUser(String username,String password);
	
	/**
	 *��ȡ�û�id���û��ǳ�
	 * @author Daoliang Li
	 * @param username �û���
	 * @return map
	 */
	public Map getUseridAndUsernickname(String username);
}
