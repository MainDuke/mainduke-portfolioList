<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	
	<body>
	<table border="10" width="600" bgcolor="ivory">
	<tr>
		<td colspan="3" align="right">
		<a href="write.do">글쓰기</a>
		</td>
	</tr>
	
	<tr>
		<td colspan="3" align="center">
		<font size="4"><b>리스트</b></font>
		</td>
	</tr>
	
	<tr>
		<th align="center">ID</th>
		<th align="center">PWD</th>
		<th align="center">이름</th>
	</tr>
	
	<c:forEach var="test1" items="${list }">
	<tr>
		<td align="center">
		<a href="content.do?id=${test1.id }">${test1.id }</a></td>
		<td align="center">${test1.pwd }</td>
		<td align="center">${test1.name }</td>
	</tr>
	
	</c:forEach>
		
	</table>
	</body>
</html>