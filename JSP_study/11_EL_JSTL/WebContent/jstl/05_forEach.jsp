<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%--05_forEach.jsp--%>
<h2>1~10까지 출력하기</h2>
<c:forEach var="i" begin="1" end="10" step="1">
	${i }
</c:forEach>
<br>
<c:forEach var="i" begin="2" end="10" step="2">
 ${i }
</c:forEach>

<h2>1,3,5,7,9를 출력하세요</h2>
<c:set var="sum" value="0"/>

<c:forEach var="i" begin="1" end="10">
  <c:set var="sum" value="${sum+i}"/> 
</c:forEach>
<h2>1~10까지 합을 구해서 출력 하세요</h2>

