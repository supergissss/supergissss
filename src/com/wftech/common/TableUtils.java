package com.wftech.common;

import com.wftech.domain.common.Table;

/**
 * @author ws
 *
 */
public class TableUtils {
	
	public static final String THEME = "t_theme";
	
	public static final String USER = "t_user";
	
	public static final String POST = "t_post";
	
	public static final String POSTANDUSER = "t_post,t_user";
	
	public static final String ROLE = "rol";
	
	public static Table getTable(String type){
		Table table = null;
		if(type.equals(THEME)){
			table = new Table();
			table.setName(type);
			table.setColumnName(new String[]{"themeid","theme","createtime","replay","look","lastexpressuser","lastexpresstime","authorid"});
			table.setColumnType(new String[]{"int","String","String","Timestamp","int","int","int","Timestamp","int"});
		}
		return table;
	}
	
}
