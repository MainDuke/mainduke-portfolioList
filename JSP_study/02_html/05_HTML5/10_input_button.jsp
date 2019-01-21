<%@page import="sun.misc.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%!
String color="black"; //전역변수
%>

<body bgcolor="<%=color%>">
<!-- 
<h2>10_input_button.jsp<br>
나는 서버이다<br>
당신이 구매한 물건 갯수:  <%= request.getParameter("cnt")%>; <br>

당신이 입력한 날짜: <%= request.getParameter("date") %>
<br>

당신이 입력한 날짜와 시간 : <%= request.getParameter("birthday2") %><br>

직접 데이터 입력 1 : <%= request.getParameter("birthday3")%><br>

직접 데이터 입력 2 : <%= request.getParameter("birthday4")%><br>
-->
<%
color= request.getParameter("color");
%>

당신이 입력한 color: <%=color %><br>

</h2>



</body>
</html>