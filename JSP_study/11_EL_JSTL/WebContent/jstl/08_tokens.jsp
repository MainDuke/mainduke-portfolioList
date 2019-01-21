<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>forToken 실습</title>

</head>

<body>
콤마와 점으로 구분기호를 사용하는 예제 <br>

	<c:forTokens var="token" items="빨강색, 주황색, 파랑색/초록색, 남색, 보라색" delims="/.,">
		${token }<br>
	</c:forTokens>
</body>

</html>

<%--
======================================================================
include 의 문제점
같은 프로젝트 내에서만 include 액션을 쓸수 있다. (로컬url 만 가능)
다른 프로젝트나 외부 사이트는 사용할수 없다.

JSTL의 import 기능은
같은 프로젝트내에서는 물론이고, 다른 프로젝트나 외부 사이트도 import 할 수 있다.
다음, 네이버도 가능.

======================================================================
URL 처리 태그.

1. redirect 태그 response.sendRedirect 와 같은 기능
2. url 태그	URL을 생성하새 변수에 저장할때 사용
3. import 태그. include와 같은 기능 제공


1. 
<c:redirect url="">
	<c:param name="id" value="park"/>
</c:redirect>

2.
<c:url var="a1" value="aa.jsp" scope="session">
	<c:param name="id" value="kim"/>
</c:url>

3. 

--%>