<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
		<head>
		<title>Insert title here</title>
		</head>
		<body>
		<h2>while 예제</h2>
		<%!
		String msg;
		%>
		<%
		request.setCharacterEncoding("UTF-8");
		%>
		<%
		out.println(request.getParameter("name"));
		msg=request.getParameter("name");
		int cnt=Integer.parseInt(request.getParameter("cnt"));
		
		int count=0;//변수
		while(cnt>count){
		out.println(msg+"<br>");
		count++;
		}//while
		%>
		
		</body>
</html>