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
	 *创建主题
	 * @author Daoliang Li
	 * @param theme 主题
	 * @return 主题id
	 */
	public int createTheme(Theme theme);

	
	/**
	 *获取主题列表
	 * @author Daoliang Li
	 * @param type 类型
	 * @param first 起始序号
	 * @param last 终止序号
	 * @return 主题列表
	 */
	public List<Theme> getTheme(String type,int first,int last);
	
	/**
	 *获取主题数目
	 * @author Daoliang Li
	 * @param type 主题类型
	 * @return 主题数目
	 */
	public int getThemeNum(String type);
	
	/**
	 *是否存在指定主题
	 * @author Daoliang Li
	 * @param themeid 主题id
	 * @return 是否
	 */
	public boolean hasTheme(int themeid);
	
	/**
	 *更新主题数据
	 * @author Daoliang Li
	 * @param post 帖子
	 */
	public void updateTheme(Post post);
}
