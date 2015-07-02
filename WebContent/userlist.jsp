<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminheader.jsp"%>
	<div id="userlist">
		<h2>用户管理</h2><hr/>
		<table class="table table-striped table-hover table-bordered table-condensed">
			<thead><tr>
				<th>#</th><th>用户名</th><th>邮箱</th><th>角色</th><th>订单</th><th>修改</th>	<th>删除</th>
			</tr></thead>
			<tbody>
			<s:iterator value="users" id="user" status="st">
				<tr>
					<td><span class="badge badge-info"><s:property value="#st.count"/></span></td>
					<td><s:property value="#user.username"/></td>
					<td><s:property value="#user.email"/></td>
					<td data-role="<s:property value="#user.role"/>">
						<s:if test="#user.role==0">管理员</s:if>
						<s:elseif test="#user.role==1">普通会员</s:elseif>
					</td>
					<td><i class="icon-star"></i></td>
					<td>
						<a name="user" data-id="<s:property value="#user.id"/>" class="btn btn-mini">
						<i class="icon-cog"></i></a>
					</td>
					<td>
						<a href="deleteuser?id=<s:property value="#user.id"/>" class="btn btn-mini">
						<i class="icon-remove"></i></a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		<%@ include file="page.jsp"%>
	</div>
	<a href="#userinfo" class="btn btn-success pull-right" data-toggle="modal">添加用户</a><br/>
	<div id="userinfo" class="modal hide fade" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3>用户信息</h3>
		</div>
		<div class="modal-body">
			<form class="form-horizontal" action="saveuser" method="post" >
  				<div class="control-group">
  					<input type="hidden" name="id">
		  			<label class="control-label">用户名：</label>
		  			<div class="controls"><input required name="username" type="text"></div>
		  			<label class="control-label">邮箱：</label>
		  			<div class="controls" ><input required name="email" type="email"></div>
		  			<label class="control-label">角色：</label>
		  			<div class="controls" >
			  			<select name="role">
			  				<option value="0">管理员</option>
			  				<option value="1" selected="selected">普通用户</option>
			  			</select>
		  			</div>
		  			<div class="form-actions">
		  				<input type="submit" class="btn btn-primary" value="保存" />
		  				<a class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
		  			</div>			  			
	  			</div>
  			</form>
		</div>
	</div>
<%@ include file="adminfooter.jsp" %>