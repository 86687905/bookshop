<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="pagination pagination-right">
			<ul>
				<s:if test="page==1"><li class="disabled"><a>&laquo;</a></li></s:if>
				<s:else><li><a href="?page=1">&laquo;</a></li></s:else>
				<s:if test="page==1">
				<li class="disabled"><a>1</a></li>
				<s:iterator value="{2,3,4,5}" id="p" status="st">
				<s:if test="#p<=totalPage"><li><a href="?page=<s:property value="#p"/>"><s:property value="#p"/></a></li></s:if>
				</s:iterator>
				</s:if>
				<s:elseif test="page==2">
				<li><a href="?page=1">1</a></li>
				<li class="disabled"><a>2</a></li>
				<s:iterator value="{3,4,5}" id="p" status="st">
				<s:if test="#p<=totalPage"><li><a href="?page=<s:property value="#p"/>"><s:property value="#p"/></a></li></s:if>
				</s:iterator>
				</s:elseif>
				<s:elseif test="page+2<=totalPage">
				<li><a href="?page=<s:property value="page-2"/>"><s:property value="page-2"/></a></li>
				<li><a href="?page=<s:property value="page-1"/>"><s:property value="page-1"/></a></li>
				<li class="disabled"><a><s:property value="page"/></a></li>
				<li><a href="?page=<s:property value="page+1"/>"><s:property value="page+1"/></a></li>
				<li><a href="?page=<s:property value="page+2"/>"><s:property value="page+2"/></a></li>
				</s:elseif>
				<s:elseif test="page+1==totalPage">
				<s:iterator value="{3,2,1}" id="p" status="st">
				<s:if test="page-#p>0"><li><a href="?page=<s:property value="page-#p"/>"><s:property value="page-#p"/></a></li></s:if>
				</s:iterator>
				<li class="disabled"><a><s:property value="page"/></a></li>
				<li><a href="?page=<s:property value="page+1"/>"><s:property value="page+1"/></a></li>
				</s:elseif>
				<s:else>
				<s:iterator value="{4,3,2,1}" id="p" status="st">
				<s:if test="page-#p>0"><li><a href="?page=<s:property value="page-#p"/>"><s:property value="page-#p"/></a></li></s:if>
				</s:iterator>
				<li class="disabled"><a><s:property value="page"/></a></li>
				</s:else>
				<s:if test="page==totalPage"><li class="disabled"><a>&raquo;</a></li></s:if>
				<s:else><li><a href="?page=<s:property value="totalPage"/>">&raquo;</a></li></s:else>
			</ul>
		</div>