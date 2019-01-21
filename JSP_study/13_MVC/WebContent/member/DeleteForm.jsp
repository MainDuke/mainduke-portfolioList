<%@page import="sun.awt.image.PixelConverter.Bgrx"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%@ include file="../view/color.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function begin(){
	document.delForm.passwd.focus(); //페이지 실행과 동시에 포커스 설정
}//end begin
function checkIt(){
	if(!document.delForm.passwd.value){
		alert("패스 워드를 입력하시오.");
		document.delForm.passwd.focus();
		return false;
		
	}//if end
		
}//checkIt end

</script>
</head>
<body onload="begin()" bgcolor="<%=bodyback_c%>"> 
<form method="post" name="delForm" action="../member/deletePro.do" onsubmit="return checkIt();">
<table border="1" cellpadding="3" cellspacing="0" width="260" align="center"  >

<tr height="30">
<td colspan="2" valign="middle" bgcolor="<%=bodyback_c%>">>
	<font size="+2"><b>회원탈퇴</b></font>
</td>
</tr>

<tr height="30">
<td width="110" bgcolor="<%=value_c%>" align="center">
비밀번호
</td>
<td width="150">
<input type="password" name="passwd" size=15>
</td>
</tr>

<tr height="30">
<td colspan="2" align="center" valign="middle" bgcolor="<%=value_c%>">
<input type="submit" value="회원 탈퇴">
<input type="button" value="취소" onclick="javascript:location='../member/main.do'">
</td>
</tr>


</table>

</form>

</body>
</html>










