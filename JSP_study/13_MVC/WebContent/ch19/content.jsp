
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
	<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	
	<body bgcolor="${bodyback_c }">
		<center><h2>글 내용 보기</h2></center>
		
		<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr height="30">
			<td align="center" width="125" bgcolor="${value_c }">글번호</td>
			<td align="center" width="125">${article.num }</td>
			<td align="center" width="125" bgcolor="${value_c }">조회수</td>
			<td align="center" width="125">${article.readcount }</td>
		</tr>
		
		<tr height="30">
			<td align="center" width="125" bgcolor="${value_c }">작성자</td>
			<td align="center" width="125">${article.writer }</td>
			<td align="center" width="125" bgcolor="${value_c }">작성일</td>
			<td align="center" width="125">${article.regdate }</td>
		</tr>
		
		<tr height="30">
			<td align="center" width="125" bgcolor="${value_c }">글제목</td>
			<td align="center" width="375" colspan="3">${article.subject }</td>
		</tr>
		
		<tr height="30">
			<td align="center" width="125" bgcolor="${value_c }">글내용</td>
			<td width="375" colspan="3"><pre>${article.content }</pre></td>
		</tr>
		
		<tr height="30">
			<td colspan="4" bgcolor="${value_c }" align="right">
				
				<input type="button" value="글수정" onclick="document.location.href='${ctxpath}/ch19/updateForm.do?num=${article.num }&pageNum=${pageNum }'">
				&nbsp;&nbsp;
				
				<input type="button" value="글삭제" onclick="document.location.href='${ctxpath}/ch19/deleteForm.do?num=${article.num }&pageNum=${pageNum }'">
				&nbsp;&nbsp;
				
				<input type="button" value="답글쓰기" onclick="document.location.href='${ctxpath}/ch19/writeForm.do?num=${article.num }&ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'">
				&nbsp;&nbsp;
				
				<input type="button" value="글목록" onclick="document.location.href='${ctxpath}/ch19/list.do?pageNum=${pageNum }'">
				&nbsp;&nbsp;
			
			</td>
		</tr>
		
		</table>
	</body>
</html>

