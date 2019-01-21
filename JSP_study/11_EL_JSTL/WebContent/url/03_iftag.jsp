<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--03_iftag.jsp --%>
    
    <c:if test="true">
    무조건 실행<br>
    무조건 실행<br>
    무조건 실행<br>
    </c:if>
    
    <c:if test="${param.name=='lee' }">
    ${param.name }님 환영합니다<br>
    </c:if>
    
<c:if test="${param.age>18 }">
	당신의 나이는 ${param.age }살 이며, 성인 입니다 
</c:if>