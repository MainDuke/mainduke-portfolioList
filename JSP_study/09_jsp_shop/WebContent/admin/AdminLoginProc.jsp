<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String admin_id=request.getParameter("admin_id");
String admin_passwd=request.getParameter("admin_passwd");

//DB 작업
session.setAttribute("admin_id", admin_id);

%>

<script>
 location.href="Index.jsp";
</script>