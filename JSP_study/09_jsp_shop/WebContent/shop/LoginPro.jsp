<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String mem_id=request.getParameter("mem_id");
String mem_passwd=request.getParameter("mem_passwd");

if(mem_id != null || mem_id.length()>0){
	session.setAttribute("mem_id", mem_id);
	
	response.sendRedirect("Index.jsp");
}//if end
%>