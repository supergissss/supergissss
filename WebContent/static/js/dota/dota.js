$(function(){
	dt = $("table").DataTable({
		"searching":false, //禁用搜索
		"lengthChange":false, //禁用每页多少条
		"processing":false, //禁用正在载入
		"serverSide":true, //开启服务器模式,开启此模式后，你对datatables的每个操作 
							//每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
		"sort":false,
		"paging":true,
		"displayStart":$("#page").val()*10,
		"displayLength":10,
		 "ajax":"getDotaTable", //可以用data传参数
		 "columns":[
			 {
				 "data":"theme",
				 "render":function(data,type,row,meta){
					var s = [];
					s.push("<a href='theme?themeid="+row.themeid+"&page="+$("table").DataTable().page()+"' class='c_a'>"+data+"</a>");
					return s.join("");
				 },
			 },
			 {
				 "data":"author",
				 "render":function(data,type,row,meta){
					 var s = [];
					 s.push("<a href='http://www.w3cschool.com' class='c_size_small c_a'>"+data+"</a><br/><span class='c_size_small'>"+row.createtime+"</span>");
					 return s.join("");
				 }
			 },
			 {
				 "data":"replay",
				 "render":function(data,type,row,meta){
					 var s = [] ;
					 s.push("<a href='#' class='c_size_small c_a'>"+data+"</a><br/><span class='c_size_small'>"+row.look+"</span>");
					 return s.join("");
				 }
			 },
			 {
				 "data":"lastexpress",
				 "render":function(data,type,row,meta){
					 var s = [];
					 s.push("<a href='#' class='c_size_small c_a'>"+data+"</a><br/><span class='c_size_small'>"+row.lastexpresstime+"</span>");
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
	                "sFirst" :"第一页",
	                "sPrevious" : "上一页",
	                "sNext" : "下一页",
	                "sLast" : "最后一页"
	            }
			 
		 }
	});
});

function launchtheme(){
	$("#postform").submit();
}

function getTheme(themeidvalue){
	$.post('getTheme',{themeid:themeidvalue},function(data){
		alert(data);
	});
}