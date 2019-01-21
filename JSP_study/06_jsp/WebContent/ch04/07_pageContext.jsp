<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>07_pageContext</h2>
<h2>pageContext 내장 객체</h2>

요청 객체 :<%=pageContext.getRequest() %><br>
세션 객체 :<%=pageContext.getSession() %><br>
예외 객체 :<%=pageContext.getException() %><br>

<%

pageContext.getOut().println("술마시고 늦게 온 사람 : ~~");

String name= pageContext.getServletContext().getInitParameter("name");

out.println("name : "+name);

%>
