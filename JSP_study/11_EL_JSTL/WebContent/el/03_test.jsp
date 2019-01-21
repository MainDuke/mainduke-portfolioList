<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("id","Admin"); 
%>
<form method="post" action="03_test_2.jsp">
	<table border="10">
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="강동원"></td>
	</tr>
	
	<tr>
		<td>주소</td>
		<td><input type="text" name="addr" value="서울 서대문구 현저동"></td>
	</tr>
	
	<tr>
		<td>전화</td>
		<td><input type="text" name="tel" value="010-8840-0818"></td>
	</tr>
	
	<tr>
		<td>
		<input type="checkbox" name="hobby" value="트래킹">트래킹
		<input type="checkbox" name="hobby" value="여행">여행
		<input type="checkbox" name="hobby" value="축구">축구
		<input type="checkbox" name="hobby" value="야구">야구
		<input type="checkbox" name="hobby" value="발레">발레 
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="서버로전송">
		<input type="reset" value="취소">
		</td>
	</tr>
	</table>
</form>
</body>
</html>