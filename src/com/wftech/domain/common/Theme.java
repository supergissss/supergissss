package com.wftech.domain.common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ws
 *
 */
public class Theme {
	private int themeid; //主题id
	private String themetype; //主题类型
	private String theme; //主题
	private Timestamp createtime; //创建时间
	private int replay; //回复数量
	private int look; //查看数量
	private int lastexpressuser; //最后回帖用户id
	private Timestamp lastexpresstime; //最后回帖时间
	private int authorid; //作者id
	private String themecontent; //主题的内容
	private String authornickname; //作者昵称
	private String lastnickname; //最后回帖昵称
	
	public Theme createTheme(int userid,String usernickname){
		createtime = new Timestamp(new Date().getTime());
		replay = 0;
		look = 0;
		lastexpressuser = userid;
		lastexpresstime = createtime;
		authorid = userid;
		lastnickname = usernickname;
		authornickname = usernickname;
		return this;
	}
	
	
	
	public String getAuthornickname() {
		return authornickname;
	}



	public void setAuthornickname(String authornickname) {
		this.authornickname = authornickname;
	}



	public String getLastnickname() {
		return lastnickname;
	}



	public void setLastnickname(String lastnickname) {
		this.lastnickname = lastnickname;
	}



	public String getThemecontent() {
		return themecontent;
	}
	public void setThemecontent(String themecontent) {
		this.themecontent = themecontent;
	}
	public int getThemeid() {
		return themeid;
	}
	public void setThemeid(int themeid) {
		this.themeid = themeid;
	}
	public String getThemetype() {
		return themetype;
	}
	public void setThemetype(String themetype) {
		this.themetype = themetype;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getReplay() {
		return replay;
	}
	public void setReplay(int replay) {
		this.replay = replay;
	}
	public int getLook() {
		return look;
	}
	public void setLook(int look) {
		this.look = look;
	}
	public int getLastexpressuser() {
		return lastexpressuser;
	}
	public void setLastexpressuser(int lastexpressuser) {
		this.lastexpressuser = lastexpressuser;
	}
	public Timestamp getLastexpresstime() {
		return lastexpresstime;
	}
	public void setLastexpresstime(Timestamp lastexpresstime) {
		this.lastexpresstime = lastexpresstime;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	
}
