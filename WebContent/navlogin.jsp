<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
					<s:if test="#session.user==null">
					<div id="login1">
						<form id="loginForm" class="navbar-form pull-right">
							<input class="input-small" name="username" type="text" placeholder="用户名">
							<input class="input-small" name="password" type="password" placeholder="密码">
							<button id="loginBtn" type="button" class="btn btn-info">登录</button>
							<a href="#reg" class="btn btn-success" data-toggle="modal">注册</a>
						</form>
					</div>
					<div id="login2" style="display:none">
						<ul class="nav pull-right">			
							<li id="user"><a href="info"><i class="icon-user"></i></a></li>
							<li><a href="logout"><i class="icon-share-alt"></i>退出登录</a></li>
						</ul>	
					</div>
					</s:if>
					<s:else>
					<ul class="nav pull-right">			
						<li id="user"><a href="info"><i class="icon-user"></i><s:property value="#session.user.username"/></a></li>
						<li><a href="logout"><i class="icon-share-alt"></i>退出登录</a></li>
					</ul>	
					</s:else>