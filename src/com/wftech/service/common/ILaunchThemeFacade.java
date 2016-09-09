package com.wftech.service.common;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
public interface ILaunchThemeFacade {
	/**
	 *发起主题
	 * @author Daoliang Li
	 * @param username 用户名
	 * @param theme 主题
	 */
	public void launchTheme(String username,Theme theme);
}
