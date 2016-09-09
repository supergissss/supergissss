<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="rootpath" value="${pageContext.request.contextPath}/" />
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/AdminLTE.min.css"/>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/control.css"/>
<script>
	var contextPath = "${rootpath}";
	var activeli = "${activeli}";
</script>
<script src="${rootpath}static/js/jquery-1.11.3.js"></script>
<script src="${rootpath}static/js/jquery-migrate.js"></script>
<script src="${rootpath}static/js/app.js"></script>
<script src="${rootpath}static/js/bootstrap.min.js"></script>
<script src="${rootpath}static/js/jquery.dataTables.min.js"></script>
<script src="${rootpath}static/js/header.js"></script>
<script src="${rootpath}static/js/jquery.form.js"></script>
<title>GameForum</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">超级论坛</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="${rootpath}dota/index">DOTA&amp;DOTA2专区</a></li>
			<li><a href="#">LOL专区</a></li>
			<li><a href="#">星际争霸2专区</a></li>
			<li><a href="#">炉石传说专区</a></li>
			<li><a href="${rootpath}user/userlist">权限管理</a></li>	
		</ul>
	</nav>
	<div class="content">
		<div class="row">
			<form class="form-inline">
				<div class="form-group col-sm-10">
					<input class="form-control" id="search" type="text" placeholder="请输入搜索内容"/>
					<button class="btn btn-primary" type="button" onclick="query()">搜索</button>
				</div>
			</form>
			<div class="form-group pull-right c_right" >
				<c:if test="${empty username}">		
					<button class="btn btn-primary" onclick="turnToRegister()">注册</button>
					<button class="btn btn-primary" data-toggle="modal" 
					data-target="#loginModal">登陆</button>
				</c:if>
				<c:if test="${!empty username}">
					<span class="glyphicon glyphicon-user"></span>&nbsp;${usernickname}<span class="c_pipe">|</span><a href="${rootpath}common/loginout">退出</a>
				</c:if>
			</div>
		</div>	
		<div class="row">
			<div class="modal fade" id="loginModal" data-backdrop="false">
				<div class="modal-dialog">
					<div class="modal-content">
						<form class="form-horizontal" id="login" action="loginCheck" method="post">
							<div class="modal-header">
								<div class="row c_hide" id="pleaselogin">
									<h4 class="col-sm-offset-2 ">抱歉，您尚未登录，没有权限在该版块发帖</h4>
									<br/>
								</div>
								<div class="row">
									<h4 class="modal-title col-sm-3">用户登录</h4>
									<div class="col-sm-3 c_hide c_bg_blue" id="loginerror" ><b class="c_white">用户名或密码错误</b></div>
								</div>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label class="control-label col-sm-2" for="username">用户名</label>
									<input type="text" class="col-sm-6" id="username"/>&nbsp;<a href="${rootpath}common/registerinfo">注册</a>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="password">密码</label>
									<input type="password" class="col-sm-6" id="password"/>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" onclick="login()">登陆</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="errormiss()">关闭</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<hr/>
		

