<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp"%>
	
	<div id="info" >
	<s:if test="#session.user!=null">
		<form id="updateInfoForm">
			<h3>个人资料</h3><hr/>
				<div class="control-group">
				<div class="offset4">
		  			<label class="control-label">用户名：</label>
		  			<div class="controls">
		  				<input required name="username" type="text" value="<s:property value="username"/>">
		  			</div>
		  			<label class="control-label">邮箱：</label>
		  			<div class="controls" >
		  				<input required name="email" type="email" value="<s:property value="email"/>">
		  			</div>
		  		</div>
		  		<div class="form-actions">
		  			<div class="offset6">
		  				<button id="updateInfoBtn" type="button" class="btn btn-primary">修改</button>
		  			</div>
		 		</div>
	 			</div>
		</form>
		
		<form id="updatePasswordForm">
			<h3>修改密码</h3><hr/>
				<div class="control-group">
				<div class="offset4">
		  			<label class="control-label">新密码：</label>
		  			<div class="controls">
		  				<input required name="password" type="password">
		  			</div>
		  			<label class="control-label">重复新密码：</label>
		  			<div class="controls">
		  				<input required name="password2" type="password">
		  			</div>
		  		</div>
		  		<div class="form-actions">
		  			<div class="offset6">
		  				<button id="updatePasswordBtn" type="button" class="btn btn-primary">修改</button>
		  			</div>
		  		</div>
		 		</div>
		</form>
	</s:if>
	<s:else>
		<h1>你还没有登录！</h1>
		<p>请登录后，刷新此页面</p>
	</s:else>
	</div>

<%@ include file="footer.jsp"%>