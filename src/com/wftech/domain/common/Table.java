package com.wftech.domain.common;
/**
 * @author ws
 *
 */
public class Table {
	private String name;
	private String[] columnName;
	private String[] columnType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getColumnName() {
		return columnName;
	}
	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}
	public String[] getColumnType() {
		return columnType;
	}
	public void setColumnType(String[] columnType) {
		this.columnType = columnType;
	}
}
