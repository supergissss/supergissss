package com.wftech.domain.common;

import java.sql.Date;

import com.wftech.common.DateUtils;

/**
 * @author ws
 *
 */
public class User {
	private int userid; //用户id
	private String username; //用户名
	private String password; //密码
	private int usercredits; //积分
	private int userlevel; //等级
	private int usergold; //金币
	private int userthemenum; //主题数
	private int userpostnum; //帖子数
	private Date createtime; //创建时间
	private Date lastvisttime; //最后访问时间
	private String lastip; //最后登录ip
	private String email; //email
	private String usernickname; //昵称
	
	public User createUser(String username,String usernickname,String password,String email,String lastip){
		this.username = username;
		this.usernickname = usernickname;
		this.password = password;
		this.email = email;
		this.usercredits = 0;
		this.userlevel = 0;
		this.usergold = 0;
		this.userthemenum = 0;
		this.userpostnum = 0;
		this.createtime = DateUtils.getSqlDate();
		this.lastvisttime = DateUtils.getSqlDate();
		this.lastip = lastip;
		return this;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUsercredits() {
		return usercredits;
	}
	public void setUsercredits(int usercredits) {
		this.usercredits = usercredits;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public int getUsergold() {
		return usergold;
	}
	public void setUsergold(int usergold) {
		this.usergold = usergold;
	}
	public int getUserthemenum() {
		return userthemenum;
	}
	public void setUserthemenum(int userthemenum) {
		this.userthemenum = userthemenum;
	}
	public int getUserpostnum() {
		return userpostnum;
	}
	public void setUserpostnum(int userpostnum) {
		this.userpostnum = userpostnum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLastvisttime() {
		return lastvisttime;
	}
	public void setLastvisttime(Date lastvisttime) {
		this.lastvisttime = lastvisttime;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
