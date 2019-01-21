<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    
    %>
    
    
    <%
    String id= request.getParameter("id");
    String pwd= request.getParameter("pwd");
    
    session.setAttribute("id", id);
    session.setMaxInactiveInterval(60*5);
    
    
    %>
    
    <form method="post" action="01_Session_2.jsp">
	1.가장좋아하는 계절은 ? <br>
	<input type="radio" name="season" value="봄" >봄<br>
	<input type="radio" name="season" value="여름" >여름<br>
	<input type="radio" name="season" value="가을" >가을<br>
	<input type="radio" name="season" value="겨울" >겨울<br>
	<br>
	
	2.가장 좋아하는 과일은??  
	<input type="radio" name="fruit" value="사과" >사과<br>
	<input type="radio" name="fruit" value="멜론" >멜론<br>
	<input type="radio" name="fruit" value="수박" >수박<br>
	<input type="radio" name="fruit" value="딸기" >딸기<br>
	<br>
	
	<input type="submit" value="제출">
    
    </form>