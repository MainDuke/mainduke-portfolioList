<%@page import="boardmysql.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- writePro.jsp -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("utf-8"); 
%>
<jsp:useBean id="dto" class="boardmysql.BoardDto">
<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
dto.setIp(request.getRemoteAddr()); //ip setter 작업

BoardDao dao=BoardDao.getInstance();
dao.insertArticle(dto); //메서드 호출
response.sendRedirect("list.jsp"); //list.jsp 이동

%>
