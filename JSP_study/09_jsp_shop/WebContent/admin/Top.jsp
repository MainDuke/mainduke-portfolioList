<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String admin_id=(String)session.getAttribute("admin_id");

if(admin_id==null){
	response.sendRedirect("AdminLogin.jsp");
}

String contxt=request.getContextPath(); //=>/09_jsp_shop

%>

<table width="80%" align="center" bgcolor="#ffff99">

<tr bgcolor="#ffcc00">
<td align="center"><b><a href="<%=contxt %>/Index.jsp">홈</a></b></td>
<td align="center"><b><a href="<%=contxt %>/admin/AdminLogout.jsp">로그아웃</a></b></td>
<td align="center"><b><a href="<%=contxt %>/admin/MemberMgr.jsp">회원관리</a></b></td>
<td align="center"><b><a href="<%=contxt %>/admin/ProductMgr.jsp">상품관리</a></b></td>
<td align="center"><b><a href="<%=contxt %>/admin/OrderMgr.jsp">주문관리</a></b></td>
</tr>

</table>












