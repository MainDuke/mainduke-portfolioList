<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:redirect url="03_iftag.jsp">
	<c:param name="name" value="lee"/>
	<c:param name="age" value="20"/>
</c:redirect>

<%--
1. 
<c:redirect url="">
	<c:param name="id" value="park"/>
</c:redirect>

2.
<c:url var="a1" value="aa.jsp" scope="session">
	<c:param name="id" value="kim"/>
</c:url>
--%>