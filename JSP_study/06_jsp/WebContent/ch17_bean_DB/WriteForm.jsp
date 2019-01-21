<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center><h2>글 쓰기~ 입니다~</h2></center>

<form method="post" action="WriteSave.jsp">
<table border="5" width="500" bgColor="pink">

<tr>
<td>ID</td>
<td><input type="text" name="id" size="10"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" size="12"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" size="30"></td>
</tr>

<tr>
<td>전화번호</td>
<td><input type="text" name="tel" size="14"></td>
</tr>

<tr>
<td>글 내용</td>
<td><textarea name="content" cols="50" rows="10"></textarea></td>
</tr>

<tr>
<td colspan=2> 
<input type="submit" value="전송">
<input type="reset" value="리셋">
</td></tr>


</table>


</form>

</body>
</html>