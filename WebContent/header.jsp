<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<li><a href="home"><i class="icon-home"></i>首页</a></li>
						<li><a href="list"><i class="icon-th-list"></i>购物清单</a></li>
						<li><a href="order"><i class="icon-star"></i>我的订单</a></li>
					</ul>
					<%@ include file="navlogin.jsp"%>
				</div>	
			</div>
		</div>
	</div>
	<%@ include file="regist.jsp" %>
	<div class="container">
		<div id="message" class="alert" style="display:none">
			<button type="button" class="close">×</button>
			<strong>[提示信息]</strong><span></span>
		</div>