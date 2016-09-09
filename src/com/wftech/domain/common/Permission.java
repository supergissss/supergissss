package com.wftech.domain.common;

import java.sql.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wftech.common.utls.ParentTree;

/**
 * @author Daoliang Li
 *
 */
public class Permission extends ParentTree{

	private String permid; //权限id
	private String permname; //权限中文名称
	private String perm; //权限名缩写
	private String creator; //权限创建用户
	private Date createtime; //创建时间
	private int permtypeid; //权限类型id
	private String parentnode; //父节点名称
	
	@Override
	public Object getParentValue() {
		// TODO Auto-generated method stub
		return parentnode;
	}
	
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public JSONObject execute(int i) {
		// TODO Auto-generated method stub
//		 "id" : "node-" + i,
//	      "text" : "node-" + i,
//	      "value" : "node-" + i,
//	      "showcheck" : true,
//	      "complete" : true,
//	      "isexpand" : true,
//	      "checkstate" : 0,
//	      "hasChildren" : true,
//	      "ChildNodes" : subarr
		JSONObject  obj = new JSONObject();
		if(permtypeid==2&&!perm.equals("root")){
			obj.put("id",perm+"notleaf");
			obj.put("name", "permid"+"1");
			obj.put("text",permname);
			obj.put("value", permid+"notleaf");
		}else{
			obj.put("id",perm);
			obj.put("name", "permid");
			obj.put("text",permname);
			obj.put("value", permid);
		}
		obj.put("showcheck", true);
		obj.put("complete",true);
		obj.put("isexpand", true);
		obj.put("checkstate", i);
		return obj;
	}
	
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return permtypeid;
	}
	
	public String getPermid() {
		return permid;
	}
	public void setPermid(String permid) {
		this.permid = permid;
	}
	public String getPermname() {
		return permname;
	}
	public void setPermname(String permname) {
		this.permname = permname;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
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
	public int getPermtypeid() {
		return permtypeid;
	}
	public void setPermtypeid(int permtypeid) {
		this.permtypeid = permtypeid;
	}
	public String getParentnode() {
		return parentnode;
	}
	public void setParentnode(String parentnode) {
		this.parentnode = parentnode;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj.getClass()==this.getClass()){
			if(((Permission)obj).getPermid().equals(permid)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return permid.hashCode();
	}
	
}
