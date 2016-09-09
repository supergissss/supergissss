package com.wftech.service.common;
/**
 * @author ws
 *
 */
public interface IGetTableFacade {
	
	/**
	 *��ȡ������
	 * @author Daoliang Li
	 * @param tablename ����
	 * @param type ����
	 * @param length ҳ�����������
	 * @param start ��ʼ����
	 * @return ������
	 */
	public String[][] getTableData(String tablename,String type,int length,int start);
	
	/**
	 *��ȡ������
	 * @author Daoliang Li
	 * @param tablename ����
	 * @param id ����id
	 * @param length ҳ�����������
	 * @param start ��ʼ����
	 * @return ������
	 */
	public String[][] getTableData(String tablename,int id,int length,int start);
	
	/**
	 *��ȡ��������Ŀ
	 * @author Daoliang Li
	 * @param tablename ����
	 * @param type ����
	 * @return ������Ŀ
	 */
	public int getTableDataNum(String tablename,String type);
	/**
	 *��ȡ��������Ŀ
	 * @author Daoliang Li
	 * @param tablename ����
	 * @param id id
	 * @return ������Ŀ
	 */
	public int getTableDataNum(String tablename,int id);
}
