
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
	<head>
	<title>게시판</title>
	<link href="style.css" rel="stylesheet" type="text/css">
	<script>
	function deleteSave(){
		if(document.delForm.passwd.value==''){
			alert("비밀번호를 입력하십시오");
			document.delForm.passwd.focus();
			return false;
		}
	}//deleteSave()
	</script>
	</head>
	
	<body bgcolor="${bodyback_c }">
		<center><h2>글 삭제</h2></center>
		<br>
		<form method="post" name="delForm" action="${ctxpath }/ch19/deletePro.do?pageNum=${pageNum}" onsubmit="return deleteSave()">
		
		<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
		
		<tr height="30">
			<td align="center" bgcolor="${value_c }">
			<b>비밀번호를 입력해주세요</b></td>
		</tr>
		
		<tr height="30">
			<td align="center">비밀번호 :
			<input type="password" name="passwd" size="8">
			<input type="hidden" name="num" value="${num }"></td>
		</tr>
		
		<tr height="30">
			<td align="center" bgcolor="${value_c }">
			<input type="submit" value="글삭제">
			<input type="button" value="글목록" onclick="document.location.href='${ctxpath}/ch19/list.do?pageNum=${pageNum}'"></td>
		</tr>
			
		</table>
		
		</form>
	</body>
</html>
