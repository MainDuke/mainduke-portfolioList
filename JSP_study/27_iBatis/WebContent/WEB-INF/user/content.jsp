<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
글쓰기 폼
콘텐츠 jsp 입니다.

현재 경로 : <%=request.getContextPath() %>
현재 경로 : <%=request.getServletContext().getContextPath() %>
<form method="get" action="content.do"">

<table border="1" bgcolor="margenta" width="500">
	<tr height="40px">
	<td width="150">유저 ID</td>
	<td width="300">${user.userId } </td>
	</tr>

	<tr height="40px">
	<td width="150">패스워드</td>
	<td width="300">${user.userPw} </td>
	</tr>
	
	<tr height="40px">
	<td width="150">유저 이름</td>
	<td width="300">${user.userName } </td>
	</tr>

	<tr height="40px">
	<td width="150">날짜</td>
	<td width="300">${user.wdate} </td>
	</tr>
	
	<tr>
	<td colspan="2">
	<input type="button" value="수정" onclick="location='update.do?userId=${user.userId}'">
	<input type="button" value="삭제" onclick="location='delete.do'">
	<input type="button" value="리스트" onclick="location='list.do'">
	</td>

	</tr>
</table>
</form>

</body>

</html>









