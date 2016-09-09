package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Post;

/**
 * @author ws
 *
 */
public interface IPostDao {
	
	/**
	 *创建帖子
	 * @author Daoliang Li
	 * @param post 帖子
	 */
	public void addPost(Post post);
	
	/**
	 *获取帖子
	 * @author Daoliang Li
	 * @param id id
	 * @param first 起始位置
	 * @param last 终止位置
	 * @return 帖子list
	 */
	public List<Post> getPost(int id,int first,int last);
	
	/**
	 *获取帖子数量
	 * @author Daoliang Li
	 * @param themeid 帖子id
	 * @return 帖子数量
	 */
	public int getPostNumByTheme(int themeid);
	
}
