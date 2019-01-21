<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%-- Write.jsp--%>
	
	<html>
	<head>
	<script type="text/javascript">
	function check(){
		if(document.writeForm.writer.value==''){
			alert("이름을 입력하시오.");
			document.writeForm.writer.focus();
			return false;
		}
		//subject
		if(document.writeForm.subject.value==''){
			alert("글 제목을 입력하시오.");
			document.writeForm.subject.focus();
			return false;
		}
		//email
		if(document.writeForm.email.value==''){
			alert("이메일을 입력하시오.");
			document.writeForm.email.focus();
			return false;
		}
		//content
		if(document.writeForm.content.value==''){
			alert("글내용을 입력하시오.");
			document.writeForm.content.focus();
			return false;
		}
		//pwd
		if(document.writeForm.pwd.value==''){
			alert("PWD을 입력하시오.");
			document.writeForm.pwd.focus();
			return false;
		}
		
		document.writeForm.action="WriteSave.jsp";
		document.writeForm.submit();
		
	}//function end
	
	</script>
	</head>
	<body bgcolor="margenta">
	<h2>게시판 글 쓰기</h2>
	<table align="center" width="407">
	<tr>
		<td align="right">
		<a href="./template.jsp?page=List.jsp?page=1">리스트</a>
		
		</td>
	</tr>
	</table>
	
	<form name="writeForm" method="post">
	<table border=10 align=center width=407 bgColor="orange" cellpadding="2" cellspacing="0">
	
	
	<!-- name -->
	<tr>
	<td width=200>이름</td>
	<td width=337 height="25" align="Left">
	<input type="text" name="writer" size=20>
	</td>	
	</tr>
	
	<!-- 글제목 -->
	<tr>
	<td >글제목</td>
		<td height="25" align="Left">
			<input type="text" name="subject" size=40>
		</td>	
	</tr>
	
	<!-- 이메일-->
	<tr>
	<td >이메일</td>
		<td height="25" align="Left">
			<input type="text" name="email" size=30>
		</td>	
	</tr>
	
	<!-- 글내용 -->
	<tr>
	<td >글내용</td>
		<td height="25" align="Left">
			<textarea name="content" rows="15" cols="40"></textarea>
		</td>	
	</tr>
	
	<!-- 암호 -->
	<tr>
	<td >암호</td>
		<td height="25" align="Left">
			<input type="password" name="pwd" size="20">
		</td>	
	</tr>
	
	<tr>
	<td colspan="2" align="center">
	<input type="button" value="전송" OnClick="javaScript:check()">&nbsp;
	<input type="button" value="취소" OnClick="history.back()">
	<td>
	</tr>
	
	</table>	
	</form>
	
	</body>
	</html>
	
	
	