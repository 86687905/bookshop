<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
	<s:if test="#session.user==null">
	<div id="reg" class="modal hide fade" aria-hidden="true">
		<div class="modal-header">
    		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    		<h3>注册</h3>
  		</div>
  		<div class="modal-body">
  			<div id="regmess" class="alert alert-error" style="display:none">
				<button type="button" class="close">×</button>
				<strong>操作失败!</strong><span></span>
			</div>
 			<form id="regForm" class="form-horizontal">
 				<div class="control-group">
	  			<label class="control-label">用户名：</label>
	  			<div class="controls">
	  				<input required name="username" type="text">
	  			</div>
	  			<label class="control-label">邮箱：</label>
	  			<div class="controls" >
	  				<input required name="email" type="email">
	  			</div>
	  			<div style="clear: both"></div>
	  			<label class="control-label">密码：</label>
	  			<div class="controls">
	  				<input required name="password" type="password">
	  			</div>
	  			<label class="control-label">重复输入密码：</label>
	  			<div class="controls">
	  				<input required name="password2" type="password">
	  			</div>
	  			<div class="form-actions">
	  				<button id="regBtn" type="button" class="btn btn-primary">提交</button>
	  				<a class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
	  			</div>	
  				</div>
  			</form>
  		</div>
  	</div>
  	</s:if>