
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>target.jsp</title>
	</head>
	
	<body>
	<%-- Vector 사용 --%>
	<h3> <%= (String)request.getAttribute("name") %>
	님의 쇼핑카트에 담긴 물건: </h3>
	
	<ol>
	<%
	Vector vec=(Vector)request.getAttribute("cart");
	for(int i=0; i<vec.size(); i++){
		%>
		<li><%= vec.get(i) %>
		<%
	}//for
	%>
	</ol>
	
	<%--------%>
	<%-- HashMap 사용 --%>
	<h2>HashMap 사용</h2>
	
	<h3>${name2}님의 쇼핑카트에 담긴 물건: </h3>
	item1:${cart2.item1 }<br>
	item2:${cart2.item2 }<br>
	item3:${cart2.item3 }<br>
	<br>
	
	<c:forEach var="m" items="${cart2 }">
		${m.key } ==> ${m.value } <br>
	</c:forEach>
	
	
	</body>
</html>
