<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${sessionScope.id}님 환영</h3>
	<h3>${param.name}</h3>
	<h3>${param.addr}</h3>
	<h3>${param.tel}</h3>
	<h3>${paramValues.hobby[0]}</h3>
	<h3>${paramValues.hobby[1]}</h3>
	<h3>${paramValues.hobby[2]}</h3>

</body>
</html>