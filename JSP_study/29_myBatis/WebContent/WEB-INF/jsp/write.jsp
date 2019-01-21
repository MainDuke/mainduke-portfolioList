<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
	function writeFormCheck(){
		
		if($("#id").val() == null || $("#id").val() == ""){ //jquery라 폼 이름 안줘도 돼
			alert("ID 입력해주세요");
		$("#id").val('').focus();
		return false;
		}
		
		if($("#pwd").val() == null || $("#pwd").val() == ""){ //jquery라 폼 이름 안줘도 돼
			alert("비밀번호 입력해주세요");
		$("#pwd").val('').focus();
		return false;
		}
		
		if($("#name").val() == null || $("#name").val() == ""){ //jquery라 폼 이름 안줘도 돼
			alert("이름을 입력해주세요");
		$("#name").val('').focus();
		return false;
		}
		return true;
	}//function
	</script>
	<style type="text/css">tr{height:40px;}</style>
	</head>

	<body>
	<h2>글쓰기 폼</h2>
	<form method="post" action="write.do" onsubmit="return writeFormCheck()">
	<table border="10" bgcolor="ivory" width="400">
	
	<tr>
		<td align=center width=130>ID</td>
		<td><input type="text" id="id" name="id" size="20"/></td>
	</tr>
	
	<tr>
		<td align=center>PWD</td>
		<td><input type="text" id="pwd" name="pwd" size="20"/></td>
	</tr>
	
	<tr>
		<td align=center>name</td>
		<td><input type="text" id="name" name="name" size="20"/></td>
	</tr>
	
	<tr>
		<td colspan=2 align="center">
		<input type="submit" value="제출">
		<input type="reset" value="리셋">
		</td>
	</tr>
	</table>
	</form>
	</body>
</html>