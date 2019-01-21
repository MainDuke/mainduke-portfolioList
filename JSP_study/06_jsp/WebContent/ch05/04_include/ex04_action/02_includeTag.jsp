<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>02_includeTag.jsp</h2>
<%request.setCharacterEncoding("utf-8"); %>
<hr color="red">
<jsp:include page="02_includeTagTop.jsp">
	<jsp:param name="name" value="홍길동"/>
	<jsp:param name="addr" value="서울"/>
	<jsp:param name="tel" value="010-0000-0000"/>
	</jsp:include>
<hr color="red">

02_includeTag.jsp 바디 부분<br>
02_includeTag.jsp바디 부분<br>
02_includeTag.jsp바디 부분<br>

</body>

</html>