<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">tr{height:40px}</style>
	</head>

	<body>
	<h2>글 수정</h2>
	
	<form method="post" action="update.do">
	<table border="10" bgcolor="ivory" width="400">
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" id="id" value="${test.id }" size="20" readonly="readonly"></td>		
	</tr>

	<tr>
		<td>pwd</td>
		<td><input type="text" name="pwd" id="pwd" value="${test.pwd }" size="20"></td>		
	</tr>
	
	<tr>
		<td>name</td>
		<td><input type="text" name="name" id="name" value="${test.name }" size="20"></td>		
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="등록">
		<input type="reset" value="리셋">
		</td>
	</tr>
	
	</table>
	</form>
	
	</body>
</html>