<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script src="${rootpath}static/js/gettheme.js"></script>
<style>
	tbody td{
		padding:0px 0px !important;
	}
	thead  th{
		padding:0px 0px !important;
	}
</style>
	<div>
		<div class="row">
			<div class="col-sm-offset-5 col-sm-5 c_hide c_bg_orange"><span class="c_bg_white">发表回复&nbsp;&nbsp;经验+1&nbsp;&nbsp;金币+1</span></div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12"> 
			<c:if test="${!empty username}">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#replay">回复</button>
			</c:if>
			<div class=" pull-right">
				<button class="btn btn-primary" type="button" onclick="backToList('${page}')">返回列表</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="replay" data-backdrop="false">
			<div class="modal-dialog">
				<div class="modal-content">
					<form class="form-horizontal" method="post" action="${rootpath}replay" id="replayform" onsubmit="return replay()">
						<div class="modal-header">
							<h4 class="modal-title">回复</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" name="posttheme" value="${themeid}"/>
							<input type="hidden" name="posttype" value="dota"/>
							<input type="hidden" name="authornickname" value="${usernickname}">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textarea">内容</label>
								<textarea class="col-sm-8" id="textarea" name="postcontent" rows="10"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="replay()">发帖</button>
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
	<input type="hidden" id="hiddenthemeid" name="themeid" value="${themeid}"/>
	<div class="row">
		<div class="col-sm-12">
			<table class="table table-bordered" style="width:100%">
				<thead>
					<tr>
						<th class="c_fixedwidth">
							<div class="row">
								<div class="col-sm-offset-2">
									作者
								</div>
							</div>
						</th>
						<th class="col-sm-9">
							<div class="row" >
								<div class="col-sm-offset-1">
									内容
								</div>
							</div>
						</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="../footer.jsp" %>