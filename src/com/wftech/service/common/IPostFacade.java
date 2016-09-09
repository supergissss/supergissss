package com.wftech.service.common;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
public interface IPostFacade {

	

	/**
	 *����
	 * @author Daoliang Li
	 * @param theme �������
	 */
	public void post(Theme theme);
	
	/**
	 *����
	 * @author Daoliang Li
	 * @param post ����
	 */
	public void post(Post post);
}
