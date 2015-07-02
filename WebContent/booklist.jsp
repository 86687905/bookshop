<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="adminheader.jsp"%>
	<div id="booklist">
		<h2>图书管理</h2><hr/>
		<table class="table table-striped table-hover table-bordered table-condensed">
			<thead><tr>
			<th>#</th><th>书名</th><th>作者</th><th>出版社</th><th>出版日期</th><th>ISBN</th><th>单价</th><th>修改</th><th>删除</th>
			</tr></thead>
			<tbody>
			<s:iterator value="books" id="book" status="st">
				<tr>
					<td><span class="badge badge-info"><s:property value="#st.count"/></span></td>
					<td><s:property value="#book.name"/></td>
					<td><s:property value="#book.author"/></td>
					<td><s:property value="#book.publish"/></td>
					<td><s:date name="#book.publishDate" format="yyyy年MM月dd日"/></td>
					<td><s:property value="#book.isbn"/></td>
					<td><s:property value="#book.price"/></td>
					<td>
						<a name="book" data-id="<s:property value="#book.id"/>" class="btn btn-mini">
						<i class="icon-cog"></i></a>
					</td>
					<td>
						<a href="deletebook?id=<s:property value="#book.id"/>" class="btn btn-mini">
						<i class="icon-remove"></i></a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		<%@ include file="page.jsp"%>
		<a href="#bookinfo" class="btn btn-success pull-right" data-toggle="modal">添加图书</a><br/>
		<div id="bookinfo" class="modal hide fade" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3>图书信息</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="savebook" enctype="multipart/form-data" method="post" >
	  				<div class="control-group">
	  					<input type="hidden" name="id">
			  			<label class="control-label">书名：</label>
			  			<div class="controls"><input required name="name" type="text"></div>
			  			<label class="control-label">作者：</label>
			  			<div class="controls" ><input required name="author" type="text"></div>
			  			<label class="control-label">出版社：</label>
			  			<div class="controls" ><input required name="publish" type="text"></div>
			  			<label class="control-label">出版日期：</label>
			  			<div class="controls" ><input required name="publishDate" type="text"></div>
			  			<label class="control-label">ISBN：</label>
			  			<div class="controls" ><input required name="isbn"type="text"></div>
			  			<label class="control-label">图书描述：</label>
			  			<div class="controls" ><textarea required name="description"></textarea></div>
			  			<label class="control-label">图书封面：</label>
			  			<div class="controls" >
				  			<img name="img" width="50"/>
				  			<input type="file" name="cover">
			  			</div>
			  			
			  			<label class="control-label">图书单价：</label>
			  			<div class="controls" ><input required type="text" name="price"></div>
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