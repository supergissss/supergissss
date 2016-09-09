package com.wftech.service.common;
/**
 * @author ws
 *
 */
public interface IGetTableFacade {
	
	/**
	 *获取表数据
	 * @author Daoliang Li
	 * @param tablename 表名
	 * @param type 类型
	 * @param length 页面内最大条数
	 * @param start 起始行数
	 * @return 表数据
	 */
	public String[][] getTableData(String tablename,String type,int length,int start);
	
	/**
	 *获取表数据
	 * @author Daoliang Li
	 * @param tablename 表名
	 * @param id 数据id
	 * @param length 页面内最大条数
	 * @param start 起始行数
	 * @return 表数据
	 */
	public String[][] getTableData(String tablename,int id,int length,int start);
	
	/**
	 *获取表数据数目
	 * @author Daoliang Li
	 * @param tablename 表名
	 * @param type 类型
	 * @return 数据数目
	 */
	public int getTableDataNum(String tablename,String type);
	/**
	 *获取表数据数目
	 * @author Daoliang Li
	 * @param tablename 表名
	 * @param id id
	 * @return 数据数目
	 */
	public int getTableDataNum(String tablename,int id);
}
