<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="u1" value="../shopping.do"/>

<c:url var="u2" value="../shopping/do">
	<c:param name="id" value="park"/>
</c:url>

<c:url var="u3" value="http://localhost:9001/11_EL_JSTL/jstl/01_test_set_remove.jsp">
	<c:param name="id" value="park"/>
</c:url>

<ul>
<li>u1=${u1}
<li>u2=${u2}
<li>u3=${u3}

</ul>

<%--
1. 
<c:redirect url="">
	<c:param name="id" value="park"/>
</c:redirect>

2.
<c:url var="a1" value="aa.jsp" scope="session">
	<c:param name="id" value="kim"/>
</c:url>

var= 생성된 URL이 저장될 변수명
value = 생성될 URL
scope = 변수에 저장될 범위 지정

#value 속성에 올수 있는 값 (3가지)
완전 URL : http://ip.port/컨텍스트이름/중간이름/a.jsp
웹 어플리케이션 내에서 절대  경로 : /bb.jsp
현재 경로에 대한 상대 경로. ../member/aa.jsp

--%>