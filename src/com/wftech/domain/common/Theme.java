package com.wftech.domain.common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ws
 *
 */
public class Theme {
	private int themeid; //����id
	private String themetype; //��������
	private String theme; //����
	private Timestamp createtime; //����ʱ��
	private int replay; //�ظ�����
	private int look; //�鿴����
	private int lastexpressuser; //�������û�id
	private Timestamp lastexpresstime; //������ʱ��
	private int authorid; //����id
	private String themecontent; //���������
	private String authornickname; //�����ǳ�
	private String lastnickname; //�������ǳ�
	
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
