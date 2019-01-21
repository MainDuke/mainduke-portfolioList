<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 형식1 //forward 액션, 웹 어플리케이션 내에서 jsp 페이지 이동
<jsp:forward page="로컬url"/>
--%>

<%-- 형식2
<jsp:forward page="로컬url">
	<jsp:param name="name" value="hong-kill-dong"/>
	<jsp:param name="id" value="hong"/>
	<jsp:param name="pwd" value="123"/>
</jsp:forward>
--%>

<h2>forward1.jsp</h2>
<h2>포워드 액션</h2>

<form action="forward2.jsp" method="post">
<table border="1">

<tr>
<td>이름</td>
<td><input type="text" name="name" size="12"></td>
</tr>


<tr>
<td>나이</td>
<td><input type="text" name="age" size="12"></td>
</tr>

<tr>
<td>주소</td>
<td><input type="text" name="addr" size="12"></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="전송">&nbsp;
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>
	   