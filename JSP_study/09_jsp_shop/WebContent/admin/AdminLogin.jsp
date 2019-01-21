<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="style.css" type="text/css">
		
		<script type="text/javascript" src="script.js"></script> 
		
		
		</head>
	
	<body bgcolor="#996600" topmargin="20">
			<form method="post" action="AdminLoginProc.jsp">
		<table width="50%" border="1" align="center">
	
		<tr>
		<td width="47%" align="center">Admin ID</td>
		<td width="53%"><input type="text" name="admin_id" id="admin_id"></td>
		</tr>
		
		<tr>
		<td width="47%" align="center">Admin PWD</td>
		<td width="53%"><input type="text" name="admin_passwd" id="admin_passwd"></td>
		</tr>
		
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="Admin 로그인">&nbsp;&nbsp;
		<input type="reset" value="리셋">
		</td>
		</tr>
		
		
		</table>
		</form>
	</body>
	
	</html>