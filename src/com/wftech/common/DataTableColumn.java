package com.wftech.common;

import java.util.List;

/**
 * @author ws
 *
 */
public class DataTableColumn {
	
	public static String[] getColumn(String tableName,String type){
		String[] columns = null;
		if(tableName.equals(TableUtils.THEME)){
			if(type.equals(TypeUtils.DOTA)){
				String[] dota =  {"themeid","theme","author","createtime","replay","look","lastexpress","lastexpresstime"};
				columns = dota;
			}
		}else if(tableName.equals(TableUtils.POST)){
			if(type.equals(TypeUtils.DOTA)){
				String[] dota = {"postid","posttype","posttheme","postcontent","authorid","createtime","authornickname"};
				columns = dota;
			}
		}else if(tableName.equals(TableUtils.POSTANDUSER)){
			if(type.equals(TypeUtils.DOTA)){
				String[] dota = {"postid","posttype","posttheme","postcontent","authorid","createtime","authornickname","userthemenum",
						"userpostnum","usercredits","userlevel","usergold","lastvisittime"};
				columns = dota;
			}
		}else if(tableName.equals(TableUtils.ROLE)){
			columns = new String[]{"roleid","role","rolename","creator","createtime"};
		}else if(tableName.equals(TableUtils.USER)){
			columns = new String[]{"userid","username","usercredits","userlevel","usergold","userthemenum","userpostnum","createtime","usernickname","email"};
		}
		return columns;
	}
	
}
