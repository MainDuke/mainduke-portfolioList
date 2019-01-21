<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% String contentPage= request.getParameter("contentPage");%>
    <html>
    <body bgcolor="margenta">
	<table align="center" width=90% height=90% border=10 bgcolor="orange">
	
	<tr>
	<td colspan="2"  bgcolor="margenta" height="10%">
	<jsp:include page="top.jsp" flush="false"/><!-- flush는 출력버퍼를 지우지 않는다. -->
	</td>
	</tr>
	
	<tr>
	<td width="10%" bgcolor="pink"><jsp:include page="left.jsp" flush="false"/></td> <!-- 왼쪽 메뉴 배치 -->
	<td width="90%" valign="top"><jsp:include page="<%=contentPage %>"/></td>
	</tr>
	
	<tr>
	<td colspan="2"  bgcolor="LightGray" height="10%">
	<jsp:include page="bottom.jsp" flush="false"/><!-- flush는 출력버퍼를 지우지 않는다. -->
	</td>
	</tr>
	
	
	</table>    
    
    </body>
    
    </html>