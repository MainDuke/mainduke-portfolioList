<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <html>
    <body bgcolor="#996600">
    <%@ include file="top.jsp" %>
	
	<table width=70% align="center" height="90%" bgcolor="#ffff99">
	
	<%
	if(memid!=null){
	%>
	<tr>
	<td align="center">
	<%=memid %>님 방문 확영
	</td>
	</tr>
		<%
	}else{
		%>
		<tr>
		<td align="center">
		로그인 하신후 방문
		</td></tr>
	<%} %>	
			
	</table>    
    <%@ include file="bottom.jsp" %>
    </body>
    
    </html>