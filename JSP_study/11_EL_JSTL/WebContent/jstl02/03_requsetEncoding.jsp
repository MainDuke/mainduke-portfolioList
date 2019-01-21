<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<%
//request.setCharacterEncoding("urf-8");
%>

<fmt:requestEncoding value="utf-8"/>

<html>
<body>
<c:out value="out"></c:out>
파라미터 : <c:out value="${param.name }"/>

<form method="post" action="03_requsetEncoding.jsp">
	<input type="text" name="name" value="홍길동">
	<input type="submit" value="확인">
</form>

</body>
</html>