<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script src="${rootpath}static/js/dota/dota.js"></script>
<style>
	tbody td{
	vertical-align:middle!important;
	padding:10px 18px !important;
}
</style>

	<div class="row">
		<div class="col-sm-1"> 
			<c:if test="${empty username}">
				<button class="btn btn-primary" data-toggle="modal" 
					data-target="#loginModal"  onclick="showLogin()">发帖</button>
			</c:if>
			<c:if test="${!empty username}">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#postTopic">发帖</button>
			</c:if>
		</div>
		<c:if test="${!empty username}" >
			<c:forEach var="data" items="${permissionSet}">
				<c:if test="${data.perm=='dota/delete'}">
					<div class="col-sm-offset-10 col-sm-1">
						<button class="btn btn-primary">删帖</button>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
	
	<div class="row">
		<div class="modal fade" id="postTopic" data-backdrop="false">
			<div class="modal-dialog">
				<div class="modal-content">
					<form class="form-horizontal" id="postform" action="../launchtheme" method="post">
						<div class="modal-header">
							<h4 class="modal-title">发帖</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" name="themetype" value="dota">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="topic">标题</label>
								<input class="col-sm-6" id="topic" type="text" name="theme"/>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textarea">内容</label>
								<textarea class="col-sm-8" id="textarea" name="themecontent" rows="10"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="launchtheme()">发帖</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			&nbsp;
		</div>
	</div>
	<c:if test="${!empty page}">
		<input type="hidden" id="page" value="${page}"/>
	</c:if>
	<c:if test="${empty page}">
		<input type="hidden" id="page" value="0"/>
	</c:if>
	<div class="row">
		<div class="col-sm-12">
			<table class="table table-striped" style="width:100%">
				<thead>
					<tr>
						<th class="col-sm-9">主题</th>
						<th class="col-sm-1">作者</th>
						<th class="col-sm-1">回复&frasl;查看</th>
						<th class="col-sm-1">最后发表</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="../footer.jsp" %>