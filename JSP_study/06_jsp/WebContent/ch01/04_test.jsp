<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>04_test.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8"); //post 방식 한글처리.
 String name=request.getParameter("name");
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
%>

당신의 이름: <%=name %><br>
당신의  ID: <%=id %><br>
당신의 PWD: <%=pwd %><br>


</body>
</html>