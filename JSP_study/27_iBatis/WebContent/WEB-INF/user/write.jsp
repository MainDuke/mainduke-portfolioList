<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
function writeFormCheck(){
	if($("#userId").val()==null || $("#userId").val()==""){
		alert("유저 ID 입력해 주세요.!");
		$("#userId").focus();
		return false;
	}
	
	if($("#userPw").val()==null || $("#userPw").val()==""){
		alert("유저 Pwd 입력해 주세요.!");
		$("#userPw").focus();
		return false;
	}
	
	if($("#userName").val()==null || $("#userName").val()==""){
		alert("유저 Name 입력해 주세요.!");
		$("#userName").focus();
		return false;
	}
	return true;
}

</script>

</head>
<body bgcolor="yellow">
글쓰기 폼
콘텐츠 jsp 입니다.

<%=request.getContextPath() %>

<form method="post" action="write.do" onsubmit="return writeFormCheck()">

<table border="1" bgcolor="margenta">
	
	<tr height="40px">
	<td>유저 ID</td>
	<td><input type="text" id="userId" name="userId" maxlength="20"/></td>
	
	</tr>
	
	<tr height="40px">
	<td>패스워드</td>
	<td><input type="text" id="userPw" name="userPw" maxlength="20"/></td>
	
	</tr>
	
	<tr height="40px">
	<td>이름</td>
	<td><input type="text" id="userName" name="userName" maxlength="20"/></td>
	
	</tr>	
</table>

	<table>
		<tr>
		<td height="40px" align="center"><input type="submit" value="등록"></td>
		<td height="40px" align="center"><input type="reset" value="리셋"></td>
		
		</tr>
	</table>

</form>

</body>

</html>









