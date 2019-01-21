<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--패키지 , 파일이름(확장자는 쓰지 않는다.) --%>
<%--resource.testBundle.properties 저장--%>
<fmt:setLocale value="en"/>
<fmt:bundle basename="resource.testBundle">
<html>


<body>
<h2>JSTL fmt 예제, bundle message</h2>

<fmt:message key="name"/><br>
<fmt:message key="MSG"/><br>

<fmt:message key="MSG" var="msg"/><br>
<c:out value="${msg }"/>



</body>

</html>
 </fmt:bundle>
 