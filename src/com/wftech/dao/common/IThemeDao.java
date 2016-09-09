package com.wftech.dao.common;

import java.util.List;

import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
public interface IThemeDao {
	
	/**
	 *��������
	 * @author Daoliang Li
	 * @param theme ����
	 * @return ����id
	 */
	public int createTheme(Theme theme);

	
	/**
	 *��ȡ�����б�
	 * @author Daoliang Li
	 * @param type ����
	 * @param first ��ʼ���
	 * @param last ��ֹ���
	 * @return �����б�
	 */
	public List<Theme> getTheme(String type,int first,int last);
	
	/**
	 *��ȡ������Ŀ
	 * @author Daoliang Li
	 * @param type ��������
	 * @return ������Ŀ
	 */
	public int getThemeNum(String type);
	
	/**
	 *�Ƿ����ָ������
	 * @author Daoliang Li
	 * @param themeid ����id
	 * @return �Ƿ�
	 */
	public boolean hasTheme(int themeid);
	
	/**
	 *������������
	 * @author Daoliang Li
	 * @param post ����
	 */
	public void updateTheme(Post post);
}
