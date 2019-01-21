<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>08_config.jsp</h2>
<h2> config 내장 객체</h2>
 
 서블릿 이름 : <%=config.getServletName() %><br>
 서블릿 context : <%=config.getServletContext() %><br>

이름 : <%=config.getInitParameter("name") %><br>
 이름 : <%=config.getServletContext().getInitParameter("name") %><br>
 이름 : <%=application.getInitParameter("name") %>
