package com.wftech.service.common;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
public interface ILaunchThemeFacade {
	/**
	 *��������
	 * @author Daoliang Li
	 * @param username �û���
	 * @param theme ����
	 */
	public void launchTheme(String username,Theme theme);
}
