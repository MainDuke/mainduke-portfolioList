<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	
	<script type="text/javascript">
	function writeFormCheck(){

		if($("#subject").val() == null || $("#subject").val() == ""){
			alert("제목을 입력하세요.");
			$("#subject").focus();
			return false;
		}

		if($("#email").val() == null || $("#email").val() == ""){
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		
		if($("#content").val() == null || $("#content").val() == ""){
			alert("내용을 입력하세요.");
			$("#content").focus();
			return false;
		}
		
		if($("#pwd").val() == null || $("#pwd").val() == ""){
			alert("비밀번호를 입력하세요.");
			$("#pwd").focus();
			return false;
		}
		
		return true;
		
	}//writeFormCheck()
	</script>
	</head>
	
	<body>
	<h2>유저 수정 화면</h2>
	현재 컨텍스트 구하기 : <%=request.getServletContext().getContextPath() %><br>
	<form method="post" action="update.do" onSubmit="return writeFormCheck()">
	
	<table border="1" style="background-color:ivory;">
	<tr height="40px">
		<td>글쓴이</td>
		<td><input type="text" id="writer" name="writer" maxlength="20" 
		value="${BoardDto.writer }" readonly="readonly"/></td>
	</tr>

	<tr height="40px">
		<td>제목</td>
		<td><input type="text" id="subject" name="subject" maxlength="20" value="${BoardDto.subject }"/></td>
	</tr>
	
		<tr height="40px">
		<td>email</td>
		<td><input type="text" id="email" name="email" maxlength="20" value="${BoardDto.email }"/></td>
	</tr>
	
	<tr height="40px">
		<td>내용</td>
		<td><textarea cols="22" rows="10" id="content" name="content">${BoardDto.content}</textarea></td>
	</tr>
	
	<tr height="40px">
		<td>비밀번호</td>
		<td><input type="text" id="pwd" name="pwd" maxlength="20" value="${BoardDto.pwd }"/></td>
	</tr>
	
	<tr height="40px">
		<td>날짜</td>
		<td>${BoardDto.wdate }
		<input type="hidden" name="num" value="${BoardDto.num }"></td>
	</tr>
	
	
	<tr height="40px">
		<td colspan="3" align="center">
		<input type="submit" value="수정">
		<input type="reset" value="리셋">
		</td>
	</tr>
	</table>
	
	</form>
	</body>
</html>