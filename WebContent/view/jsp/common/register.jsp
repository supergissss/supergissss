<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
	<!--script>
	$(function(){
		$("#registerusername").val("supergissss");
		$("#usernickname").val("船长");
		$("#registerpassword").val("a123456");
	    $("#confirmpassword").val("a123456");
		$("#email").val("727150502@qq.com");
	});
	</script-->
	<div class="row">
		<div class="col-sm-offset-4 col-sm-3">
			<div class="row">
				<div class="col-sm-3">
					<h4 >注册账号</h4>
				</div>
				<div class="col-offset-1 c_hide col-sm-5 c_bg_blue" id="registerfail" ><b class="c_white">注册失败,请检查数据</b></div>
			</div>
			<hr/>
		</div>
	</div>
	<div class="row">
		<form class="form-horizontal" id="regisetForm" action="register" >
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="username">用户名</label>
				<input type="text" class="col-sm-1" name="reisgterusername" id="registerusername" var="registerusername"/>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="usernickname">用户昵称</label>
				<input type="text" class="col-sm-1" name="usernickname" id="usernickname" var="usernickname"/>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="password">密码</label>
				<input type="text" class="col-sm-1" name="registerpassword" id="registerpassword" var="registerpassword"/>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="confirmpassword">确认密码</label>
				<input type="text" class="col-sm-1" name="cofirmpassword" id="confirmpassword" var="confirmpassword"/>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-3 col-sm-2" for="email">邮箱</label>
				<input type="text" class="col-sm-1" name="email" id="email" var="email"/>
			</div>
			<div class="form-group">
				<button type="button" class="col-sm-offset-5 col-sm-1 btn btn-primary" onclick="register()">立即注册</button>
			</div>
		</form>
	</div>	
	
<%@ include file="../footer.jsp" %>