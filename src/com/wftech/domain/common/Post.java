package com.wftech.domain.common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ws
 *
 */
public class Post {
	private int postid; //����id
	private String posttype; //��������
	private int posttheme; //��������id
	private int authorid; //����id
	private String authornickname; //�����ǳ�
	private String postcontent; //��������
	private Timestamp createtime; //����ʱ��
	
	public Post(){
		
	}
	
	public Post(Theme theme){
		posttype = theme.getThemetype();
		posttheme = theme.getThemeid();
		postcontent = theme.getThemecontent();
		authorid = theme.getAuthorid();
		authornickname = theme.getAuthornickname();
		createtime = theme.getCreatetime();
	}
	
	public Post createPost(int authorid){
		this.authorid = authorid;
		createtime = new Timestamp(new Date().getTime());
		return this;
	}
	
	public String getAuthornickname() {
		return authornickname;
	}

	public void setAuthornickname(String authornickname) {
		this.authornickname = authornickname;
	}

	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getPosttype() {
		return posttype;
	}
	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}
	public int getPosttheme() {
		return posttheme;
	}
	public void setPosttheme(int posttheme) {
		this.posttheme = posttheme;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getPostcontent() {
		return postcontent;
	}
	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
