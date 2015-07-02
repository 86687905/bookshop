<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp"%>
	<div class="row">
		<div class="span4 offset2">
			<img src="img/unix.jpg" width="230px">
		</div>
		<div class="span6" style="margin-top:30px">
			<h3><s:property value="book.name"/></h3>
			<p class="muted">作者：<s:property value="book.author"/></p>
			<p class="text-info">出版社:<s:property value="book.publish"/></p>
			<p class="text-info">出版日期:<s:date name="#book.publishDate" format="yyyy年MM月dd日"/></p>
			<p class="text-info">ISBN:<s:property value="book.isbn"/></p>	
			<p class="text-error">价格：￥<s:property value="book.price"/></p>
			数量：<select class="span1">
				<option value="1" selected="selected">1</option><option value="2">2</option>
				<option value="3">3</option><option value="4">4</option>
				<option value="5">5</option><option value="6">6</option>
				<option value="7">7</option><option value="8">8</option>
				<option value="9">9</option><option value="10">10</option>
			</select>
			<a name="add" data-id="<s:property value="book.id"/>" class="btn btn-success">加入清单</a>
		</div>
	</div>
	<div class="row">
		<div class="span10 offset1">
			<h4>图书描述</h4>
			<s:property value="book.description"/>
		</div>
	</div>

<%@ include file="footer.jsp"%>