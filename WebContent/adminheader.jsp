<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上购书小网站</title>
<link href="css/css.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" >
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</a>
				<a class="blackcolor brand" href="#">网上购书小网站</a>
				<div class="nav-collapse collapse">
					<ul class="nav" id="navbar" >
						<li><a href="booklist"><i class="icon-wrench"></i>图书管理</a></li>
						<li><a href="userlist"><i class="icon-wrench"></i>用户管理</a></li>
						<li><a href="orderlist"><i class="icon-wrench"></i>订单管理</a></li>
					</ul>
					<%@ include file="navlogin.jsp"%>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="message" class="alert alert-error" style="display:none">
			<button type="button" class="close">×</button>
			<strong>[提示信息]</strong><span></span>
		</div>