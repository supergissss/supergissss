$(function(){
	$("li:eq("+activeli+")").addClass("active");
});

function query(){
	$("table").fnDraw(false);
	$("#loginerror").css("display","");

}

function login(){
	$.post(contextPath+"common/login",{username:$("#username").val(),password:$("#password").val()},function(data){
		if(data=="false"){
			$("#loginerror").css("display","block");
			setTimeout("loginfail()",2000);
		}else{
			window.location.href = data;
		}
	});
}

function loginout(){
	$.post(contextPath+"common/loginout",function(data){
		window.location.href = data;
	});
}

function loginfail(){
	$("#loginerror").css("display","none");
}

function errormiss(){
	$("#loginerror").css("display","none");
	$("#pleaselogin").css("display","none");
}

function registerfail(){
	$("#registerfail").css("display","none");
}

function turnToRegister(){
	window.location.href = contextPath+"registerinfo";
}

function register(){
	var usernameValue = $("#registerusername").val();
	var usernicknameValue = $("#usernickname").val();
	var passwordValue = $("#registerpassword").val();
	var confirmpasswordValue = $("#confirmpassword").val();
	var emailValue = $("#email").val();
	$.post(""+contextPath+"register",{username:usernameValue,usernickname:usernicknameValue,password:passwordValue,
		confirmpassword:confirmpasswordValue,email:emailValue},function(data){
		if(data=="fail"){
			$("#registerfail").css("display","block");
			setTimeout("registerfail()",2000);
		}else{
			window.location.href = data;
		}
	});
}

function showLogin(){
	$("#pleaselogin").css("display","block");
}
