<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.text.SimpleDateFormat"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>04_test_date</title>
		</head>
		<body>
					<u><big>오늘 날짜 출력 예제</big></u>
					<%
					java.util.Date date= new java.util.Date(); //객체 생성.
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd H:mm:ss a EEEE");
					//a : 오전 오후
					//EEEE : 금요일
					//EEE : 금
					
					%>
					<h2>
					<%=sdf.format(date) %>
					</h2>
					
		</body>
</html>