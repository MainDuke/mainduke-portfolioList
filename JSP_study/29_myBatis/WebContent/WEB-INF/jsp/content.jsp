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
	<h2>글 내용보기</h2>
	
	<table width="400">
	<tr>
		<td height="40px" align="center">
		<a href="update.do?id=${test.id }">글수정</a> &nbsp;&nbsp;
		<a href="delete.do?id=${test.id }">글삭제</a> &nbsp;&nbsp;
		<a href="write.do">글쓰기</a> &nbsp;&nbsp;
		<a href="list.do">리스트</a>
		</td>
	</tr>
	</table>
	
	<table border="10" bgcolor="ivory" width="400">
	<tr height="40px" align="center">
		<td width="130">ID</td>
		<td>${test.id }</td>
	</tr>
	
	<tr height="40px" align="center">
		<td width="130">PWD</td>
		<td>${test.pwd }</td>
	</tr>
	
	<tr height="40px" align="center">
		<td width="130">이름</td>
		<td>${test.name }</td>
	</tr>
	</table>
	
	</body>
</html>