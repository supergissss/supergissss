package com.wftech.domain.common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ws
 *
 */
public class Post {
	private int postid; //帖子id
	private String posttype; //帖子类型
	private int posttheme; //帖子主题id
	private int authorid; //作者id
	private String authornickname; //作者昵称
	private String postcontent; //帖子内容
	private Timestamp createtime; //创建时间
	
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
