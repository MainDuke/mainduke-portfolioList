<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--02_test.jsp--%>

<%
session.setAttribute("id","park");
session.setAttribute("pwd", "123");
%>

<html>
	<body>
	표현식 <%=session.getAttribute("id") %>님<br>
	표현식 <%=session.getAttribute("pwd") %> <br><br>
	
	표현언어 ${sessionScope.id}님 환영 합니다<p>
	표현언어 ${sessionScope.pwd}<p>
	</body>
</html>