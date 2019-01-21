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
<%@include file="Top.jsp" %>

<table width="75%" align="center" bgcolor="#ffff99" height="100%">

<%
	String mem_id=(String)session.getAttribute("mem_id");

if(mem_id!=null){
%>
	<tr>
	<td align="center"><%=mem_id %>님 방문해 주셔서 감사합니다.</td>
	</tr>
	
	<tr>
	<td align="center"><a href="ProductList.jsp">상품목록보기</a>
	</td>
	</tr>	
<%	
}else{%>
	<tr>
	<td align="center">로그인 하신 후 이용해 주세요.
	<a href="Login.jsp">로그인</a>
	</td>
	</tr>
	
<%	
}//else
%>

</table>


</body>
</html>