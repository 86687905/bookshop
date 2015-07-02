<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp"%>
	
	<div id="list" >
	<s:if test="#session.user!=null">
		<h3>购物清单</h3>
		<s:if test="list == null"><p>你还没有选购图书</p></s:if><s:else>
		<span>
		创建日期：<span class="text-info text-inline"><s:date name="list.createDate" format="yyyy年MM月dd日"/></span>
		更新日期：<span class="text-info"><s:date name="list.updateDate" format="yyyy年MM月dd日"/></span>
		</span>
		<s:iterator value="list.inventoryDetails" id="detail" status="st"><hr/>
		<div class="row">
			<div class="span2"><a href="book?id=<s:property value="#detail.book.id"/>"><img src="img/<s:property value="#detail.book.cover"/>" width="100px"></a></div>
			<div class="span2">
				<h4><s:property value="#detail.book.name"/></h4>
				<p class="muted">作者：<s:property value="#detail.book.author"/></p>
				<p class="text-error"><s:property value="#detail.book.price"/></p>
			</div>
			<div class="span6"><p><s:property value="#detail.book.description"/></p></div>
			<div class="span2">
				数量：<input id="count" class="span1" type="text" value="<s:property value="#detail.count"/>"/>
				<a name="update" data-id="<s:property value="#detail.id"/>" class="btn btn-primary">修改</a>
				<a name="delete" data-listId="<s:property value="list.id"/>" data-detailId="<s:property value="#detail.id"/>" class="btn btn-danger">删除</a>
			</div>
		</div>
		</s:iterator></s:else>
		<a href="createorderfromlist" class="btn btn-success pull-right">下订单</a><br/>
	</s:if>
	<s:else>
		<h1>你还没有登录！</h1>
		<p>请登录后，刷新此页面</p>
	</s:else>		
	</div>

<%@ include file="footer.jsp"%>