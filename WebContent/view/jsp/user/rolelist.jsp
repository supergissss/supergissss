<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/tree.css"/>
<script src="${rootpath}static/js/user/rolelist.js"></script>
<script src="${rootpath}static/js/jquery.tree.js"></script>
<style>
	tbody td{
	vertical-align:middle;
	padding:10px 18px ;
}
</style>

	
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
			<li ><a href="${rootpath}user/userlist">用户管理</a></li>
			<li class="active"><a href="#">角色管理</a></li>
		</ul>

	<div class="tab-content">
		<div class="box">
			<div class="box-body">
				<div class="dt-bootstrap">
				<div class="row">
					<div class="col-sm-offset-6 col-sm-3">
						<button class="btn btn-primary" onclick="window.location.href='${rootpath}user/addrolefill'">新建</button>
						<button class="btn btn-primary" onclick="updaterolepermission()">保存</button>
						<button class="btn btn-primary" onclick="deleterole()">删除</button>
					</div>
					<div class="col-sm-offset-6 col-sm-3">
						<br/>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-7 ">
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-bordered">
									<tr>
										<td class=" col-sm-5 c_top">
											<div class="row">
												<table id="permissiontable" class="table table-bordered table-hover c_td_nopadding" style="width:100%">
													
												</table>
											</div>
										</td>
										<td class="col-sm-4">
											<div class="row">
												<div  class="col-sm-offset-2 col-sm-10">
													
													<table class=" ">
														<tr>
															<td>
																<label>权限设置</label>
															</td>
															<td>
																<table class="table table-bordered">
																		<tr>
																			<td>
																				<div id="tree"></div>
																			</td>
																		</tr>
																	</table>
															</td>
														</tr>
													</table>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	</div>
<%@ include file="../footer.jsp" %>