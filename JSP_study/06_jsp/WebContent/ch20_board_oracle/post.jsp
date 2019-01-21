<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	//subject
	if(document.postForm.subject.value==''){
		alert("글 제목을 입력하시오.");
		document.postForm.subject.focus();
		return false;
	}
	//content
	if(document.postForm.content.value==''){
		alert("글내용을 입력하시오.");
		document.postForm.content.focus();
		return false;
	}
	//pwd
	if(document.postForm.pass.value==''){
		alert("PWD을 입력하시오.");
		document.postForm.pass.focus();
		return false;
	}
	
	document.postForm.submit();
	
	
}
</script>

</head>
<body bgcolor="pink">
<table width="80%" cellspacing="0" cellpadding="3" align="center"> 
<tr>
<td bgcolor="#84f399" height="35" align="center"> 
<b><font size=5>[[[글쓰기]]]</font></b>
</td>
</tr>
</table>
<br>

<form name="postForm"  method="post" action="postProc.jsp">

<table background="1" width="80%" cellpadding="3" cellspacing="0" align="center">

<tr>
<td align="center">

<table border="0" width="100%" align="center" bgcolor="orange">

<!-- 이름 -->
<tr>
<td width="10%">이름</td>
<td width="90%"><input type="text" name="name" size="10"></td>
</tr>
<!-- 메일 -->
<tr>
<td width="10%">메일</td>
<td width="90%"><input type="text" name="email" size="30" placeholder="abc@email.com"></td>
</tr>
<!-- 홈페이지 -->
<tr>
<td width="10%">홈페이지</td>
<td width="90%"><input type="text" name="homepage" size="30" value="http://"></td>
</tr>


<!-- 제목 -->
<tr>
<td width="10%">제목</td>
<td width="90%"><input type="text" name="subject" size="50"></td>
</tr>

<!-- 내용 -->
<tr>
<td width="10%">내용</td>
<td width="90%"><textarea name="content" rows="10" cols="50"></textarea></td>
</tr>
<!-- pass -->
<tr>
<td width="10%">암호</td>
<td width="90%"><input type="password" name="pass" size="20" placeholder="글 수정&삭제시 필요합니다."></td>
</tr>

<!-- 제목 -->
<tr>
<td colspan="2"><hr size="1"></td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>" >
	
	<input type="button" value="글 쓰기" OnClick="javaScript:check()">&nbsp;
	<input type="reset" value="초기화" >
	<input type="button" value="뒤로가기" onclick="history.go(-1)">
	
	<td>
	</tr>
	
</table>

</td>
</tr>

</table>
</form>


</body>
</html>




