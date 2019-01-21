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
		
		if($("#writer").val() == null || $("#writer").val() == ""){ 
			alert("글쓴이를 입력해주세요");
		$("#writer").val('').focus();
		return false;
		}
		
		if($("#subject").val() == null || $("#subject").val() == ""){
			alert("글제목을 입력해주세요");
		$("#subject").val('').focus();
		return false;
		}
		
		if($("#email").val() == null || $("#email").val() == ""){  
			alert("email을 입력해주세요");
		$("#email").val('').focus();
		return false;
		}
		
		if($("#content").val() == null || $("#content").val() == ""){  
			alert("글내용을 입력해주세요");
		$("#content").val('').focus();
		return false;
		}
		
		if($("#pwd").val() == null || $("#pwd").val() == ""){  
			alert("비밀번호를 입력해주세요");
		$("#pwd").val('').focus();
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
	<table border="10" bgcolor="ivory" width="600">
	
	<tr>
		<td align=center width=100>글쓴이</td>
		<td><input type="text" id="writer" name="writer" size="20"/></td>
	</tr>
	
	<tr>
		<td align=center>글제목</td>
		<td><input type="text" id="subject" name="subject" size="20"/></td>
	</tr>
	
	<tr>
		<td align=center>이메일</td>
		<td><input type="text" id="email" name="email" size="20"/></td>
	</tr>
	
	<tr>
		<td align=center>글내용</td>
		<td><textarea name="content" id="content" rows="13" cols="40"></textarea></td>
	</tr>
	
	<tr>
		<td align=center>비밀번호</td>
		<td><input type="text" id="pwd" name="pwd" size="20"/>
		<input type="hidden" name="ip" value="<%=request.getRemoteHost() %>"></td>
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