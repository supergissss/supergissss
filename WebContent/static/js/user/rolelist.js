// var userAgent = window.navigator.userAgent.toLowerCase();
//$.browser.msie8 = $.browser.msie && /msie 8\.0/i.test(userAgent);
//$.browser.msie7 = $.browser.msie && /msie 7\.0/i.test(userAgent);
//$.browser.msie6 = !$.browser.msie8 && !$.browser.msie7 && $.browser.msie && /msie 6\.0/i.test(userAgent);
var treedata;
var updateroleid = null;
var dt;
$(function(){
	$.post("getpermission",function(data){
		treedata = [data];
		load();
	},"json");
});
function load() {        
    var o = { showcheck: true
    //onnodeclick:function(item){alert(item.text);},        
    };
    o.data = treedata;                  
    $("#tree").treeview(o);            
    $("#showchecked").click(function(e){
        var s=$("#tree").getCheckedNodes();
        if(s !=null)
        alert(s.join(","));
        else
        alert("NULL");
    });
     $("#showcurrent").click(function(e){
        var s=$("#tree").getCurrentNode();
        if(s !=null)
            alert(s.text);
        else
            alert("NULL");
     });
}  

$(function(){
	dt = $("#permissiontable").DataTable({
		"searching":false, //禁用搜索
		"lengthChange":false, //禁用每页多少条
		"processing":false, //禁用正在载入
		"serverSide":true, //开启服务器模式,开启此模式后，你对datatables的每个操作 
							//每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
		"sort":false,
		"paging":true,
	//	"displayStart":$("#page").val()*10,
		"displayLength":10,
		 "ajax":"getrolelist", //可以用data传参数
		 "columns":[
			 {
				 "data":"roleid",
				 "render":function(data,type,row,meta){
					var s = [];
					s.push("<div class='col-sm-1 c_padding_1'><input type='checkbox' value='"+data+"'/></div><div divname='role' id='m"+meta.row+"' class='col-sm-11 c_padding' onclick='getrolepermission("+data+",this)'><span class='c_margin'>"+row.rolename+"</span></div>");
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


function addrole(){
	if($.trim($("#rolename").val())==""){
		alert("请先填写角色名");
		return;
	}else{
		var array = $("#tree").getCheckedNodes(true);
		var s = [];
		for(var i=0;i<array.length;i++){
			if(array[i].lastIndexOf("notleaf")==-1){
				s.push(array[i]);
			}
		}
		if(s.length==0){
			alert("请先选择权限");
			return;
		}
		$.post("addrole",{rolename:$("#rolename").val(),ids:s.join(",")},function(data){
			if(data=='success'){
				window.location.href = 'userlist';
			}else if(data=="false"){
				alert("已存在此角色");
			}else{
				alert("请先选择权限");
			}
		});
	}
}

function getrolepermission(roleid,id){
	//alert(roleid);
	$(".c_choose").each(function(){
		$(this).removeClass("c_choose");
	});
	$(id).addClass("c_choose");
	updateroleid = roleid;
	$.post("getrolepermission",{roleid:roleid},function(data){
		treedata = [data];
		load();
	},"json");
}

function updaterolepermission(roleid){
	if(updateroleid==null){
		alert("请先选择角色");
	}else{
		var array = $("#tree").getCheckedNodes(true);
		var s = [];
		for(var i=0;i<array.length;i++){
			if(array[i].lastIndexOf("notleaf")==-1){
				s.push(array[i]);
			}
		}
		if(s.length==0){
			alert("请先选择权限");
			return;
		}
		$.post("updaterolepermission",{roleid:updateroleid,ids:s.join(",")},function(data){
			alert("保存成功");
		});
	}
}

function deleterole(){
	var s = [];
	$("input[type='checkbox']").each(function(){
		if($(this).prop("checked")){
			s.push($(this).val());
		}
	});
	if(s.length==0){
		alert("请先选择角色");
	}else{
		$.post("deleterole",{ids:s.join(",")},function(data){
			if(data=="success"){
				$("#permissiontable").DataTable().ajax.reload();
			}else{
				alert("角色("+data+")已有用户启用,请先删除相关用户");
			}
		});
	}
}

//if( $.browser.msie6)
//{
//    load();
//}
//else{
//    $(document).ready(load);
//}

//function createNode(){
//  var root = {
//    "id" : "0",
//    "text" : "root",
//    "value" : "86",
//    "showcheck" : true,
//    "complete" : true,
//    "isexpand" : true,
//    "checkstate" : 0,
//    "hasChildren" : true
//  };
//  var arr = [];
//  for(var i= 1;i<8; i++){
//    var subarr = [];
//    for(var j=1;j<100;j++){
//      var value = "node-" + i + "-" + j; 
//      subarr.push( {
//         "id" : value,
//         "text" : value,
//         "value" : value,
//         "showcheck" : true,
//         "complete" : true,
//         "isexpand" : false,
//         "checkstate" : 0,
//         "hasChildren" : false
//      });
//    }
//    arr.push( {
//      "id" : "node-" + i,
//      "text" : "node-" + i,
//      "value" : "node-" + i,
//      "showcheck" : true,
//      "complete" : true,
//      "isexpand" : true,
//      "checkstate" : 0,
//      "hasChildren" : true,
//      "ChildNodes" : subarr
//    });
//  }
//  root["ChildNodes"] = arr;
//  return root; 
//}

