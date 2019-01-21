<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fmt:setLocale value="kr"/>
<fmt:bundle basename="resource.message">
<fmt:message key="title" var="tt"/>
<h2>${tt }</h2>
<fmt:message key="greeting"/><br>

<c:if test="${!empty param.id }">
	<fmt:message key="visitor">
		<fmt:param value="${param.id }"/>
	</fmt:message>
</c:if>
</fmt:bundle>

<%--
http://localhost:9001/11_EL_JSTL/jstl02/05_message.jsp?id=park
--%>