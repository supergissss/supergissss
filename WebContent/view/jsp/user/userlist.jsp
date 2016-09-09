<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" type="text/css" href="${rootpath}static/css/tree.css"/>
<script src="${rootpath}static/js/user/userlist.js"></script>
<script src="${rootpath}static/js/jquery.tree.js"></script>
<style>
	tbody td{
	vertical-align:middle;
	padding:10px 18px ;
}
</style>

	
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">用户管理</a></li>
			<li ><a href="${rootpath}user/rolelist">角色管理</a></li>
		</ul>

	<div class="tab-content">
		<div class="box">
			<div class="box-body">
				<div class="dt-bootstrap">
				<div class="row">
					<div class="col-sm-offset-6 col-sm-3">
						<button class="btn btn-primary" onclick="window.location.href='${rootpath}user/addrolefill'">新建</button>
						<button class="btn btn-primary" onclick="updateUserRole()">保存</button>
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
												<table id="usertable" class="table table-bordered table-hover c_td_nopadding" style="width:100%">
													
												</table>
											</div>
										</td>
										<td class="col-sm-4">
											<div class="row">
												<div  class="col-sm-12">
													<div class="form-group row">
														<label class="col-sm-3" for="usernickname">用户昵称</label>
														<input class="col-sm-7" type="text" id="usernickname" disabled/>
													</div>
													<div class="form-group row">
														<label class="col-sm-3" for="createtime">创建时间</label>
														<input class="col-sm-7" type="text" id="createtime" disabled/>
													</div>
													<div class="row">
														<div class="form-group">
																<label class = "col-sm-3">角色设置</label>
															
															<div class="col-sm-7">
																<table class="table table-bordered">
																		<tr>
																			<td>
																				<div id="tree"></div>
																			</td>
																		</tr>
																	</table>
															</div>
														</div>
													</div>
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