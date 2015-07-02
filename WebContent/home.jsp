<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp"%>
	<div id="carousel" class="carousel slide">
		<div class="carousel-inner">
			<div class="item active"><img src="img/carousel01.jpg" alt=""></div>
			<div class="item"><img src="img/carousel02.jpg" alt=""></div>
			<div class="item"><img src="img/carousel03.jpg" alt=""></div>
		</div>
		<a class="left carousel-control" href="#carousel" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#carousel" data-slide="next">&rsaquo;</a>
	</div>
	<div id="home" >
	<s:iterator value="books" id="book" status="st">
		<s:if test="#st.index%4 == 0">
			<div class="row-fluid">
				<ul class="thumbnails">
		</s:if>
				<li class="span3">
					<a href="book?id=<s:property value="#book.id"/>" class="thumbnail">
					<img src="img/<s:property value="#book.cover"/>" width="150px" >
					</a>
					<h4 ><s:property value="#book.name"/></h4>
					<p class="muted">作者：<s:property value="book.author"/></p>
					<p class="text-error"><s:property value="#book.price"/></p>
					<p class="pull-right">
						<input type="hidden" name="count" value="1"/>
						<a name="add" data-id="<s:property value="#book.id"/>" class="btn btn-success">加入清单</a>
					</p>
				</li></a>
		<s:if test="#st.index%4 == 3 || #st.last">
				</ul>
			</div>
		</s:if>
	</s:iterator>
		
	<%@ include file="page.jsp"%>
		
	</div>
<%@ include file="footer.jsp"%>