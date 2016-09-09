package com.wftech.service.common;
/**
 * @author ws
 *
 */
public interface IGetThemeFacade {
	/**
	 *是否存在指定主题
	 * @author Daoliang Li
	 * @param themeid 主题id
	 * @return 是否
	 */
	public boolean hasTheme(int themeid);
}
