package com.wftech.service.common;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
public interface IPostFacade {

	

	/**
	 *发帖
	 * @author Daoliang Li
	 * @param theme 主题对象
	 */
	public void post(Theme theme);
	
	/**
	 *发帖
	 * @author Daoliang Li
	 * @param post 帖子
	 */
	public void post(Post post);
}
