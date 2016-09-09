package com.wftech.domain.common;

import java.sql.Date;

/**
 * @author Daoliang Li
 *
 */
public class Role {

	private String roleid; //角色id
	private String rolename; //角色中文名称
	private String creator; //创建者
	private Date createtime; //创建时间
	private String role; //角色缩写
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj.getClass()==this.getClass()){
			if(((Role)obj).getRolename().equals(rolename)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return rolename.hashCode();
	}
}
