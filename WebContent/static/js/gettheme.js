var dt;

$(function(){
	dt = $("table:eq(0)").DataTable({
		"searching":false, //禁用搜索
		"lengthChange":false, //禁用每页多少条
		"processing":false, //禁用正在载入
		"serverSide":true, //开启服务器模式,开启此模式后，你对datatables的每个操作 
							//每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
		"sort":false,
		"paging":true,
		"displayLength":15,
		 "ajax":{
			 url:"getTheme", //可以用data传参数
			 data:{themeid:$("#hiddenthemeid").val()}
		 },
		 // {"postid","posttype","posttheme","postcontent","authorid","createtime","authornickname","userthemenum",
		//"userpostnum","usercredits","userlevel","usergold","lastvisittime"}
		 "columns":[
			 {
				 "data":"authornickname",
				 "render":function(data,type,row,meta){
					var s = [];
					s.push("<div class='c_bg_shallowblue'>");
					
					s.push("<div class='row'>");
					s.push("<div class='col-sm-offset-1 col-sm-10'><b>"+data+"</b></div>");
					s.push("</div>");
					
					s.push("<div class='row'>");
					s.push("<hr class='c_thread'/>");
					s.push("</div>");
					
					s.push("<div class='row'>");
					s.push("<div class='col-sm-offset-1 col-sm-10'><img src='"+contextPath+"static/img/headpicture.gif'/></div>");
					s.push("</div>");
					
					s.push("<div class='row'>");		
					s.push("<div class='col-xs-offset-1 col-xs-10'>");
					s.push("<table class='c_bg_blue c_right c_width'>");
					s.push("<tr class='c_bg_blue'><td>"+row.userthemenum+"</td><td class='c_border_left'>"+row.userpostnum+"</td><td class='c_border_left'>"+row.usercredits+"</td></tr>");
					s.push("<tr class='c_bg_blue'><td>主题</td><td class='c_border_left'>帖子</td><td class='c_border_left'>经验</td></tr>");
					s.push("</table>");
					s.push("</div>");
					s.push("</div>");
					
					s.push("<div class='row'>");
					s.push("<div class='col-sm-offset-1 col-sm-10'><button type='button' class='btn btn-primary c_nobutton col-sm-12'>"+row.userlevel+"级</button></div>");
					s.push("</div>");
					
					s.push("<div class='row'>");
					s.push("<div class='col-sm-offset-1 col-sm-5'>金币</div><div class='col-sm-5'>"+row.usergold+"</div>");
					s.push("</div>");
					
					s.push("<div class='row'>");
					s.push("<div class='col-sm-offset-1 col-sm-5'>最后登录</div><div class='col-sm-5'>"+row.lastvisittime+"</div>");
					s.push("</div>");
					
					s.push("</div>");
					return s.join("");
				 },
			 },
			 {
				 "data":"postcontent",
				 "render":function(data,type,row,meta){
					 var s = [];
					 s.push(data);
					 return s.join("");
				 }
			 }
		 ],
		 "oLanguage":{
			 "sProcessing" : "正在获取数据，请稍后...",
	            "sLengthMenu" : "显示 _MENU_ 条",
	            "sZeroRecords" : "没有找到数据",
	            "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
	            "sInfoEmpty" : "记录数为0",
	            "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
	            "sInfoPostFix" : "",
	            "sSearch" : "搜索",
	            "sUrl" : "",
	            "oPaginate" : {
	                "sFirst" : "第一页",
	                "sPrevious" : "上一页",
	                "sNext" : "下一页",
	                "sLast" : "最后一页"
	            }
			 
			 
		 }
	});
});

function replay(){
	
	$("#replayform").ajaxSubmit({
			type:"post",
			url:contextPath+"replay",
			error:function(data){
				alert("发帖失败");
			},
			success:function(data){
				$("#replay").modal("hide");
				dt.draw(false);
				$("#replaysuccess").css("display","block");
				setTimeout("replaysuccess()",2000);
			}
	});
}

function replaysuccess(){
	$("#replaysuccess").css("display","none");
}

function backToList(page){
	window.location.href = contextPath+$("input[name='posttype']").val()+"/index?page="+page;
}
