<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp"%>
	
	<div id="order" >
	<s:if test="#session.user!=null">
		<h3>我的订单</h3>
		<s:if test="orders.size == 0"><p>你还没有下过订单</p></s:if><s:else>
		<s:iterator value="orders" id="order">
		<div class="row-fluid">
			<div class="span12"><div class="progress"><div class="bar" style="width: 100%;"></div></div></div>
			<div class="span3">
				<h4>下单日期：</h4><p class="text-info"><s:date name="#order.orderDate" format="yyyy年MM月dd日"/></p>
				<h4>结账日期：</h4><p class="text-info">
				<s:if test="#order.checkoutDate==null">未结账</s:if>
				<s:else><s:date name="#order.checkoutDate" format="yyyy年MM月dd日"/></s:else>
				</p>
				<h4>总价：</h4><p class="text-error">￥<s:property value="#order.totalPrice"/></p>
				<s:if test="#order.checkoutDate==null"><a href="checkout?id=<s:property value="#order.id"/>" class="btn btn-success">结账</a></s:if>
				<s:else><a class="btn btn-success disabled">已结账</a></s:else>
				
			</div>
			<div class="span8">
				<s:iterator value="#order.orderDetails" id="detail" status="st">
					<s:if test="#st.odd"><div class="row"></s:if>
					<div class="span2">
						<a  href="book?id=<s:property value="#detail.book.id"/>">
						<img src="img/<s:property value="#detail.book.cover"/>" width="100px">
					</a></div>
					<div class="span4">
						<h4><s:property value="#detail.book.name"/></h4>
						<p class="muted">作者：<s:property value="#detail.book.author"/></p>
						<p class="text-error">价格：￥<s:property value="#detail.book.price"/></p>
						<p class="text-info">数量：<s:property value="#detail.count"/></p>
					</div>
					<s:if test="#st.even||#st.last"></div><hr/></s:if>
				</s:iterator>
			</div>	
		</div>
		<br/>
		</s:iterator></s:else>
	</s:if>
	<s:else>
		<h1>你还没有登录！</h1>
		<p>请登录后，刷新此页面</p>
	</s:else>		
	</div>

<%@ include file="footer.jsp"%>