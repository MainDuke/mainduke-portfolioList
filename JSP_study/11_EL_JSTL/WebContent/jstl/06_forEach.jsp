<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--06_forEach.jsp--%>
<%--
items속성과 함께 begin, end 속성을 사용하면
참조할 변수 갯수를 제한 할 수 있다

정수배열에서 2 인덱스 부터 4인덱스 까지만 참조 하고 싶다면 
begin="2" end="4" 지정하면 된다
--%>

<c:set var="intArr" value="new int[]{1,2,3,4,5,6,7,8,9}"/>

<c:forEach var="i" items="${intArr }" begin="2" end="4">
	${i }&nbsp;
</c:forEach>