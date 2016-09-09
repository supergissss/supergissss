package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Post;

/**
 * @author ws
 *
 */
public interface IPostDao {
	
	/**
	 *��������
	 * @author Daoliang Li
	 * @param post ����
	 */
	public void addPost(Post post);
	
	/**
	 *��ȡ����
	 * @author Daoliang Li
	 * @param id id
	 * @param first ��ʼλ��
	 * @param last ��ֹλ��
	 * @return ����list
	 */
	public List<Post> getPost(int id,int first,int last);
	
	/**
	 *��ȡ��������
	 * @author Daoliang Li
	 * @param themeid ����id
	 * @return ��������
	 */
	public int getPostNumByTheme(int themeid);
	
}
