<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
01_Session_2.jsp<br>

<%
request.setCharacterEncoding("utf-8");
String season=request.getParameter("season");
String fruit=request.getParameter("fruit");
String id=(String)session.getAttribute("id");

String sessionId=session.getId(); //session ID얻기, sessionID는 자동부여된다.
int intervalTime=session.getMaxInactiveInterval();//세션 유지 시간 얻기.

if(id != null){
	%>
	
	<b><%=id %>님이 좋아하는 계절과 과일은</b>
	<b><%=season %></b>과 <b><%=fruit %></b>입니다.
	<br>
	세션 ID:<%=sessionId %><br>
	세션 유지시간: <%=intervalTime %><br>
	
	<%
	session.invalidate();//세션 무효화.
}else{
out.println("세션시간이 경과 하였거나 다른 이유로 연결 할 수 없습니다. 로그인을 하시오.");
}//else end

%>