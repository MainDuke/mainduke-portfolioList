<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
       
    %>
    
    <h2>forward2.jsp</h2>
    
    <jsp:forward page="forward3.jsp">
    	<jsp:param name="tel" value="010-333-5555"/>
    	<jsp:param name="email" value="ppp@abc.com"/>
    	<jsp:param name="content" value="안녕하세요~"/>
    
    </jsp:forward>