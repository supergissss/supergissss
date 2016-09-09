package com.wftech.service.common;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wftech.common.DataTableColumn;
import com.wftech.common.DateUtils;
import com.wftech.common.TableUtils;
import com.wftech.common.TypeUtils;
import com.wftech.dao.common.IPostDao;
import com.wftech.dao.common.IThemeDao;
import com.wftech.dao.common.IUserDao;
import com.wftech.domain.common.Post;
import com.wftech.domain.common.Theme;
import com.wftech.domain.common.User;

/**
 * @author ws
 *
 */
@Service
public class GetTableFacadeImpl implements IGetTableFacade{
	
	@Autowired
	IThemeDao themeDao;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IPostDao postDao;
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IGetTableFacade#getTableData()
	 */
	public String[][] getTableData(String tablename,String type,int length,int start){
		String[][] tableData = null;
		int i;
		int first = start+1;//(page-1)*pageMaxNum+1;
		int last = start+length;//page*pageMaxNum;
		List list = null;
		if(tablename.equals(TableUtils.THEME)){
			list = themeDao.getTheme(type, first, last);
			if(type.equals(TypeUtils.DOTA)){
				tableData = getThemeDota(list,last-first+1);
			}
		}
		return tableData;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IGetTableFacade#getTableData(java.lang.String, int, int, int)
	 */
	public String[][] getTableData(String tablename,int id,int length,int start){
		String[][] tableData = null;
		int i;
		int first = start+1;//(page-1)*pageMaxNum+1;
		int last = start+length;//page*pageMaxNum;
		List list = null;
		if(tablename.equals(TableUtils.POSTANDUSER)){
			list = postDao.getPost(id, first, last);
			tableData = getPostAndUser(list,last-first+1);
		}
		return tableData;
	}
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IGetTableFacade#getTableDataNum(java.lang.String, java.lang.String)
	 */
	public int getTableDataNum(String tablename,String type){
		int num = 0;
		if(tablename.equals(TableUtils.THEME)){
			if(type.equals(TypeUtils.DOTA)){
				num = themeDao.getThemeNum(type);
			}
		}
		return num;
	}
	
	/* (non-Javadoc)
	 * @see com.wftech.service.common.IGetTableFacade#getTableDataNum(java.lang.String, int)
	 */
	public int getTableDataNum(String tablename,int id){
		int num = 0;
		if(tablename.equals(TableUtils.POST)){
				num = postDao.getPostNumByTheme(id);
		}
		return num;
	}
	
	
	private String[][] getThemeDota(List list,int num){
		String[] column = DataTableColumn.getColumn(TableUtils.THEME, TypeUtils.DOTA);
		int length = column.length;
		Object[] obj = list.toArray();
		String[][] data = new String[obj.length][length];
		Theme theme;
		int count = 0,i;
		for(i=0;i<obj.length;i++){
			theme = (Theme)obj[i];
			//{"themeid","theme","author","createtime","replay","Look","lastExpress","lastExpressTime"}
			data[count][0] = ""+theme.getThemeid();
			data[count][1] = theme.getTheme();
			data[count][2] = theme.getAuthornickname();
			data[count][3] = ""+DateUtils.getTime(theme.getCreatetime());
			data[count][4] = ""+theme.getReplay();
			data[count][5] = ""+theme.getLook();
			data[count][6] = theme.getLastnickname();
			data[count][7] = ""+DateUtils.getTime(theme.getLastexpresstime());
			count++;
		}
		return data;
	}
	
	private String[][] getPostAndUser(List list,int num){
		String[] column = DataTableColumn.getColumn(TableUtils.POSTANDUSER, TypeUtils.DOTA);
		int length = column.length;
		Object[] obj = list.toArray();
		int objlength = obj.length;
		String[][] data = new String[objlength][length];
		int[] useridArray = new int[objlength];
		Post post;
		int count = 0,i;
		for(i=0;i<objlength;i++){
			post = (Post)obj[i];
			//{"postid","posttype","posttheme","postcontent","authorid","createtime","authornickname",
			data[count][0] = ""+post.getPostid();
			data[count][1] = post.getPosttype();
			data[count][2] = ""+post.getPosttheme();
			data[count][3] = post.getPostcontent();
			data[count][4] = ""+post.getAuthorid();
			data[count][5] = ""+DateUtils.getTime(post.getCreatetime());
			data[count][6] = post.getAuthornickname();
			useridArray[i] = post.getAuthorid(); 
			count++;
		}
		//"userthemenum","userpostnum","usercredits","userlevel","usergold","lastvisttime"};
		List userData = userDao.getUser(useridArray);
		Iterator iterator = userData.iterator();
		User user;
		i = 0;
		while(iterator.hasNext()){
			user = (User)iterator.next();
			data[i][7] = ""+user.getUserthemenum();
			data[i][8] = ""+user.getUserpostnum();
			data[i][9] = ""+user.getUsercredits();
			data[i][10] = ""+user.getUserlevel();
			data[i][11] = ""+user.getUsergold();
			data[i][12] = ""+user.getLastvisttime();
			i++;
		}
		return data;
	}
	
}
