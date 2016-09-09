var dt;
var treedata;
var updateuserid = null;
$(function(){
	dt = $("#usertable").DataTable({
		"searching":false, //禁用搜索
		"lengthChange":false, //禁用每页多少条
		"processing":false, //禁用正在载入
		"serverSide":true, //开启服务器模式,开启此模式后，你对datatables的每个操作 
							//每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
		"sort":false,
		"paging":true,
	//	"displayStart":$("#page").val()*10,
		"displayLength":10,
		 "ajax":"getuserlist", //可以用data传参数
		 "columns":[//"userid","username","usercredits","userlevel","usergold","userthemenum","userpostnum","createtime","usernickname","email"
			 {
				 "data":"userid",
				 "render":function(data,type,row,meta){
					var s = [];
					s.push("<div class='col-sm-1 c_padding_1'><input type='checkbox' value='"+data+"'/></div><div divname='role' id='m"+meta.row+"' class='col-sm-11 c_padding' onclick='getUserData("+data+",this)'><span class='c_margin'>"+row.usernickname+"</span></div>");
					return s.join("");
				 },
			 }
		 ],
		 "fnDrawCallback":function(){
			 $("#m0").click();
		 },
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
	                "sFirst" :"第一页",
	                "sPrevious" : "上一页",
	                "sNext" : "下一页",
	                "sLast" : "最后一页"
	            }
			 
		 }
	});
});
function load() {        
    var o = { showcheck: true
    //onnodeclick:function(item){alert(item.text);},        
    };
    o.data = treedata;                  
    $("#tree").treeview(o);
}

function getUserData(userid, divid){
	updateuserid = userid;
	$(".c_choose").each(function(){
		$(this).removeClass("c_choose");
	});
	$(divid).addClass("c_choose");
	
	$.post("getuserdata",{userid:userid},function(data){
		//"userid","username","usercredits","userlevel","usergold","userthemenum","userpostnum","createtime","usernickname","email"
		$("#usernickname").val(data.usernickname);
		$("#createtime").val(data.createtime);
		treedata = data.role;
		load();
	},"json");
}

function updateUserRole(){
	var s = [];
	var array = $("#tree").getCheckedNodes(true);
//	$("input[type='checkbox']").each(function(){
//		if($(this).prop("checked")){
//			s.push($)
//		}
//	});
//	for(var i=0;i<array.length;i++){
//		s.push($(array[i]).val());
//	}
	if(array.length==0||updateuserid==null){
		alert("请先选择角色");
	}else{
		$.post("updateuserrole",{userid:updateuserid,ids:array.join(",")},function(){
			alert("保存成功");
		});
	}
}