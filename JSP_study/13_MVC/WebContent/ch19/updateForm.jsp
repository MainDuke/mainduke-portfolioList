
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
	<head>
		<title>게시판</title>
		<link href="style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="script.js"></script>
	</head>
	
	<body bgcolor="${bodyback_c }">
	<center><h2>글 수정</h2></center>
	<br>
	<form method="post" name="writeform" action="${ctxpath }/ch19/updatePro.do?pageNum=${pageNum }">
	
	<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">이름</td>
		<td align="left" width="330">
			<input type="text" size="10" name="writer" value="${article.writer }">
			<input type="hidden" name="num" value="${article.num }"></td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">제목</td>
		<td align="left" width="330">
			<input type="text" size="40" name="subject" value="${article.subject }"></td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">E-mail</td>
		<td align="left" width="330">
			<input type="text" size="40" name="email" value="${article.email }"></td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">내용</td>
		<td align="left" width="330">
			<textarea name="content" rows="13" cols="40">${article.content }</textarea></td>
	</tr>
	
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">비밀번호</td>
		<td align="left" width="330">
			<input type="password" size="10" name="passwd"></td>
	</tr>
	
	<tr>
		<td colspan="2" bgcolor="${value_c }" align="center">
			<input type="button" value="글 수정" onclick="writeSave()">
			<input type="reset" value="다시 작성">
			<input type="button" value="목록 보기" onclick="document.location.href='${ctxpath}/ch19/list.do?pageNum=${pageNum }'">
		</td>
	</tr>
	
	</table>
	
	</form>
	
	</body>
</html>
