<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String userId=(String)session.getAttribute("userId");

String log="";
String mem="";

if(userId==null){
	log="<a href=Login.jsp>로그인</a>";
}else{
	log="<a href=Logout.jsp>로그아웃</a>";
}

if(userId==null){
	mem="<a href=Register.jsp>회원가입</a>";
}else{
	mem="<a href=MemberUpdate.jsp>회원수정</a>";
}

%>

<table width="75%" border="1" cellpadding="1" cellspacing="0" align="center">

<tr bgcolor="#66ffcc">
<td align="center"><b><%=log %></b></td>
<td align="center"><b><%=mem %></b></td>
<td align="center"><b><a href="ProductList.jsp">상품목록</a></b></td>
<td align="center"><b><a href="CartList.jsp">장바구니</a></b></td>
<td align="center"><b><a href="OrderList.jsp">구매목록</a></b></td>
</tr>

</table>












