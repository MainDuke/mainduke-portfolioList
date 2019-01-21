<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>O.jsp</h2>
    
    <%
    String bloodType=request.getParameter("bloodType");
    String name= request.getParameter("name");
    %>
    
    <b><%=name %></b>님의 혈액형은 
    <b><%=bloodType %></b>형 이고
    <br>
    평화주의자입니다.