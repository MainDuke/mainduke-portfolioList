<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>JSTL fmt 예제 timeZone</h2>
<c:set var="now" value="<%=new java.util.Date() %>"/>

Korea KST:
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>


UK GMT:
</body>
</html>

<%-- 
<fmt:formatDate value="${now}"..../> 사용해서 현재 우리나라 시간대를 표시
<fmt:timeZone value="GMT"> 로 설정해서 영국 시간대를 표시합니다.

GMT [Greenwich Mean Time] 그리니치 평균시
런던 교외의 그리니치 천문대의 자오선상에서 평균 태양시를 기준으로 하여
전세계의 지방표준시를 나타냄.

--%>


