<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminheader.jsp"%>
	<div id="orderlist">
		<h2>订单管理</h2><hr/>
		<s:iterator value="orders" id="order">
		<div class="row"><div class="progress"><div class="bar" style="width: 100%;"></div></div></div>
		<div class="row">
		<div class="span7">
			<span>用户：<s:property value="#order.user.username"/></span>
			<span class="text-info">下单日期：<s:date name="#order.orderDate" format="yyyy年MM月dd日"/></span>
			<span class="text-info">结账日期：
				<s:if test="#order.checkoutDate==null">未结账</s:if>
				<s:else><s:date name="#order.checkoutDate" format="yyyy年MM月dd日"/></s:else>
			</span>
		</div>
		<div class="span5">
			<span class="text-error">总价：￥<s:property value="#order.totalPrice"/></span>
			<span>
				<s:if test="#order.checkoutDate==null">
				<a href="checkout2?id=<s:property value="#order.id"/>" class="btn btn-success">未结账</a></s:if>
				<s:else><a class="btn btn-success disabled">已结账</a></s:else>
			</span>
		
				<a name="addbook" data-id="<s:property value="#order.id"/>" class="btn btn-primary" >增加图书</a>
				<a class="btn btn-danger" href="deleteorder?id=<s:property value="#order.id"/>">删除订单</a>	
		</div>
		</div><br/>
		<div class="row">	
			<table class="table table-striped table-hover table-bordered table-condensed">
				<thead><tr>
					<th>#</th><th>书名</th><th>作者</th><th>出版社</th><th>ISBN</th><th>价格</th><th>数量</th><th>修改</th>	<th>删除</th>
				</tr></thead>
				<tbody>
				<s:iterator value="#order.orderDetails" id="detail" status="st">
					<tr>
						<td><span class="badge badge-info"><s:property value="#st.count"/></span></td>
						<td><s:property value="#detail.book.name"/></td>
						<td><s:property value="#detail.book.author"/></td>
						<td><s:property value="#detail.book.publish"/></td>
						<td><s:property value="#detail.book.isbn"/></td>
						<td><s:property value="#detail.book.price"/></td>
						<td><s:property value="#detail.count"/></td>
						<td>
						<form action="updateorderdetail" method="post">
							<input type="text" name="count" value="<s:property value="#detail.count"/>"/>
							<input type="hidden"  name="id" value="<s:property value="#detail.id"/>">
							<button type="submit" class="btn btn-mini">
							<i class="icon-cog"></i></button>
						</form>
						</td>
						<td>
						<a href="deleteorderdetail?orderId=<s:property value="#order.id"/>&detailId=<s:property value="#detail.id"/>" class="btn btn-mini">
						<i class="icon-remove"></i></a></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>		
		</div><br/>
		</s:iterator>
		<%@ include file="page.jsp" %>
		<a href="#orderinfo" class="btn btn-success pull-right" data-toggle="modal">添加订单</a><br/>
		<div id="book" class="modal hide fade" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3>添加图书</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="createorderdetail" method="post" >
	  				<div class="control-group">
	  					<input type="hidden" name="orderId"/>
			  			<label class="control-label">图书ID：</label>
			  			<div class="controls"><input required name="bookId" type="text"></div>
			  			<label class="control-label">数量：</label>
			  			<div class="controls"><input required name="count" type="text"></div>
			  			<div class="form-actions">
			  				<input type="submit" class="btn btn-primary" value="保存" />
			  				<a class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
			  			</div>			  			
		  			</div>
	  			</form>
			</div>
		</div>
		<div id="orderinfo" class="modal hide fade" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3>订单信息</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="createorder" method="post" >
	  				<div class="control-group">
			  			<label class="control-label">用户ID：</label>
			  			<div class="controls"><input required name="userId" type="text"></div>
			  			<label class="control-label">下单日期：</label>
			  			<div class="controls"><input required name="orderDate" type="date"></div>
			  			<label class="control-label">结账日期：</label>
			  			<div class="controls"><input name="checkoutDate" type="date"></div>
			  			<div class="form-actions">
			  				<input type="submit" class="btn btn-primary" value="保存" />
			  				<a class="btn" data-dismiss="modal" aria-hidden="true">取消</a>
			  			</div>			  			
		  			</div>
	  			</form>
			</div>
		</div>
	</div>
<%@ include file="adminfooter.jsp" %>