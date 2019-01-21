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
<body bgcolor="#996600" topmargin="100"> 
<%@ include file="Top.jsp" %>

	<table width="75%" align="center" bgcolor="#ffff99">
		<tr bordercolor="#ffff99">
			<td height="190">
			
				<form name="login" method="post" action="LoginPro.jsp">
				<table width="50%" border="1" align="center">
				<tr bordercolor="#ffff66">
					<td colspan="2" align="center">로그인</td>
				</tr>
				
				<tr>
				<td width="47%" align="center">ID</td>
				<td width="53%" align="center"> 
				<input type="text" name="mem_id" id="mem_id" value="123" >
				</td>
				</tr>
				
				<tr>
				<td align="center">PWD</td>
				<td align="center">
				<input type="password" name="mem_passwd" id="mem_passwd" value="123">
				</td>
				</tr>
				
				<tr>
				<td>
				<input type="button" value="로그인" onclick="loginCheck()">&nbsp;&nbsp;
				<input type="reset" value="리셋">
				</td>
				</tr>
				
				</table>
				</form>
				
			</td>
		 </tr>
		
	</table>

<%@ include file="Bottom.jsp" %>
</body>
</html>