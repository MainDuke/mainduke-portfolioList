<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	
	<script type="text/javascript">
	function aa(){
		//var key= document.getElementById("userId");
		//key.value="";
		
		$('#userId').val('');
	}
	function bb(){
		//var key= document.getElementById("userPw");
		//key.value="";
		//$('#userPw').val('');
		$('#userPw').val('').attr('type','password');
	}
	</script>
	</head>
		<body style="background-color:yellow;">
			<h2>글 삭제 폼입니다.</h2>
			
			<form action="delete.do" method="post" name="delForm">
			<table style="border:3px solid blue; width:500px; background-color:margenta;">
				<tr height="40px">
				<td width="70px">유저 Id</td>
				<td>
				<input type="text" id="userId" name="userId" value="${map.id }" size="30" onmousedown="aa()">
				</td>
				</tr>	
				
				<tr height="40px">
				<td width="70px">패스워드</td>
				<td>
				<input type="text" id="userPw" name="userPw" value="${map.pwd }" size="30" onmousedown="bb()">
				</td>
				</tr>
								
				<tr height="40px">
				<td colspan="2" align="center">
				
				<input type="submit" value="글삭제">
				
				</td>
				</tr>
								
			</table>
		</form>
		</body>
	</html>






