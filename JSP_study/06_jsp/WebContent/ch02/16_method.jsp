<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		%>	
		
		<h2>JSP를 이용한 폼처리</h2>
		<h1>
		메서드 방식: <%=request.getMethod() %><br>
		이름: <%=request.getParameter("name")%><br>
		주소 : <%=request.getParameter("addr") %>		<br>
		</h1>
	</body>
</html>