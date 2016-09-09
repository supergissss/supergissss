package com.wftech.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.dao.common.IPostDao;
import com.wftech.dao.common.IThemeDao;
import com.wftech.dao.common.IUserDao;
import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
@Service
public class PostFacadeImpl implements IPostFacade{
	
	@Autowired
	IPostDao postDao;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IThemeDao themeDao;
	

	/* (non-Javadoc)
	 * @see com.wftech.service.common.IPostFacade#post(int, int, com.wftech.domain.common.Post)
	 */
	@Override
	public void post(Theme theme) {
		// TODO Auto-generated method stub
		Post post = new Post(theme);
		postDao.addPost(post);
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IPostFacade#post(com.wftech.domain.common.Post)
	 */
	@Override
	public void post(Post post) {
		// TODO Auto-generated method stub
		int authorid = userDao.getUseridByUsernickname(post.getAuthornickname());
		Post fullpost = post.createPost(authorid);
		postDao.addPost(fullpost);
		themeDao.updateTheme(fullpost);
		userDao.updateByPost(post.getAuthorid());
	}
}
