<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	
	<body>
	<table border="10" width="600" bgcolor="ivory">
	<tr>
		<td colspan="5" align="right">
		<a href="write.do">글쓰기</a>
		</td>
	</tr>
	
	<tr>
		<td colspan="5" align="center">
		<font size="4"><b>리스트</b></font>
		</td>
	</tr>
	
	<tr>
		<th align="center">글번호</th>
		<th align="center">글제목</th>
		<th align="center">글쓴이</th>
		<th align="center">조회수</th>
		<th align="center">작성일</th>
	</tr>
	
	<c:forEach var="test1" items="${list }">
	<tr>
		<td align="center">${test1.num }</td>
		<td align="center">
		<a href="content.do?num=${test1.num }">${test1.subject }</a></td>
		<td align="center">${test1.writer }</td>
		<td align="center">${test1.readcount }</td>
		<td align="center"><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${test1.wdate }"/></td>
	</tr>
	
	</c:forEach>
		
	</table>
	</body>
</html>