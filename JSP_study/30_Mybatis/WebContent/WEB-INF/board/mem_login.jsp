<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function check(){
			
			if($("#id").val() == null || $("#id").val() == ""){ 
				alert("id를 입력해주세요");
			$("#id").val('').focus();
			return false;
			}
			
			if($("#passwd").val() == null || $("#passwd").val() == ""){ 
				alert("글쓴이를 입력해주세요");
			$("#passwd").val('').focus();
			return false;
			}
			
			return true;
		}
	</script>
	
	</head>
	
	<body>
	<h2>로그인창</h2>
	
	<form method="post" action="login.do" onSubmit="return check()">
	<!-- 액션에 mem_loginSuccess 이게 아니엇따! -->
	<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" id="id" size="20"></td>
		
		<td>PWD</td>
		<td><input type="text" name="passwd" id="passwd" size="20"></td>
		
	</tr>
	
	<tr>
		<td colspan="4" align="center">
		<input type="submit" value="로그인">
		<input type="reset"  value="리셋">
		</td>
	</tr>
	</table>
	</form>
	
	</body>
</html>