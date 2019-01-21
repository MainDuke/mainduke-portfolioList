<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--04_choose.jsp--%>
<ul>
	<c:choose>
		<c:when test="${param.name=='gang'}">
		  <li>당신 이름은 ${param.name } 입니다. 
		</c:when>
		
		<c:when test="${param.age>18 }">
		  <li>당신의 ${param.age }살 이며, 성인입니다
		</c:when>
		
		<c:otherwise>
		  <li>당신은 gang이 아니고 18살 이상도 아닙니다
		  파라미터값이 없습니다
		</c:otherwise>
	</c:choose>
</ul>

<%-- 
http://localhost:9001/11_EL_JSTL/jstl/04_choose.jsp
http://localhost:9001/11_EL_JSTL/jstl/04_choose.jsp?name=gang
http://localhost:9001/11_EL_JSTL/jstl/04_choose.jsp?name=gang&age=25
--%>