package com.wftech.service.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.dao.common.IThemeDao;
import com.wftech.dao.common.IUserDao;
import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;

/**
 * @author ws
 *
 */
@Service
public class LaunchThemeFacadeImpl implements ILaunchThemeFacade{
	
	@Autowired
	IPostFacade postFacade;
	
	@Autowired
	IThemeDao themeDao;
	
	@Autowired 
	IUserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.ILaunchThemeFacade#launchTheme(java.lang.String, com.wftech.domain.common.Post)
	 */
	public void launchTheme(String username,Theme theme){
		Map map = userDao.getUseridAndUsernickname(username);
		int userid = (int)map.get("userid");
		String usernickname = (String)map.get("usernickname");
		Theme fulltheme = theme.createTheme(userid,usernickname);
		int themeid = themeDao.createTheme(fulltheme);
		fulltheme.setThemeid(themeid);
		postFacade.post(fulltheme);
		userDao.addThemeAndPostNum(userid);
	}
	
}
