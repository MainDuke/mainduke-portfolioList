<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<hr size="3">
<c:if test="${param.id !=null }">
[HEADER] ${param.id} 님의 방문을 환영.
</c:if>
<hr size="3">

    
    