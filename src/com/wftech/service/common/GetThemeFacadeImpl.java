package com.wftech.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.dao.common.IThemeDao;

/**
 * @author ws
 *
 */
@Service
public class GetThemeFacadeImpl implements IGetThemeFacade{

	@Autowired
	IThemeDao themeDao;
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IGetThemeFacade#hasTheme(int)
	 */
	public boolean hasTheme(int themeid){
		return themeDao.hasTheme(themeid);
	}
	
}
