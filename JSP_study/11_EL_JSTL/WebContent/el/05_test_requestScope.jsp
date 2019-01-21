<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>05_test_requestScope.jsp</title>
</head>
<body>
<%
request.setAttribute("name", "강동원");
%>

request의 name 속성값 => ${requestScope.name}<br>
request의 name 속성값 => ${requestScope["name"]}<br>
<br>
요청 URI : ${pageContext.request.requestURI}<br>
요청 URL : ${pageContext.request.requestURL}<br>
<br>
파라미터 id : ${param.id}<br>
파라미터 pwd : ${param.pwd}<br>
</body>
</html>