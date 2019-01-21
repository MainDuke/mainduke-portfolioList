<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function updateUser(){
	//alert("updateUser(): "+document.updateForm.id.value);
	document.updateForm.action = "editForm.do"; //회원수정
	document.updateForm.submit();
}

function deleteUser(){
	//alert("deleteUser(): "+document.updateForm.id.value);
	document.deleteForm.action = "memDelete.do"; //회원탈퇴
	document.deleteForm.submit();
}

</script>
</head>
<body>
${memberDto.name }님, 저희 홈에 오신것을 환영합니다<br>

<%
//session.setAttribute("id", "park");
//session.setAttribute("pwd", "park123");
%>
<!-- 위에꺼처럼 할 수 있는걸 아래처럼 el,jstl로 할거야 -->
<c:set var="id" value="${memberDto.id }" scope="session"/>

<a href="list.do">게시판 리스트</a>&nbsp;&nbsp;
<a href="javaScript:updateUser()">회원정보 수정</a>&nbsp;&nbsp;
<a href="javaScript:deleteUser()">회원 탈퇴</a>&nbsp;&nbsp;

<a href="logOut.do">로그아웃</a>

<form method="post" name="updateForm">
	<input type="hidden" id="id" name="id" value="${id }">
</form>

<form method="post" name="deleteForm">
	<input type="hidden" id="id" name="id" value="${id }">
</form>

</body>
</html>