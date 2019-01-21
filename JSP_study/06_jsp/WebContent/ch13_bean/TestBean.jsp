<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>TestBean.jsp</title>
</head>
<body>
<jsp:useBean id="tb" class="mybean.TestBean">
	<jsp:setProperty name="tb" property="name" value="홍길동"/>
	<jsp:setProperty name="tb" property="id" value="hong"/>
	<jsp:setProperty name="tb" property="addr" value="서울 마포구"/>
	
	이름: <jsp:getProperty name="tb" property="name"/><br>
	ID: <jsp:getProperty name="tb" property="id"/><br>
	주소: <jsp:getProperty name="tb" property="addr"/><br>
	
	<br>
	<%
	tb.setName("손오공");
	tb.setId("son");
	tb.setAddr("강남");
	%>
	이름2: <%=tb.getName() %><br>
	ID2: <%=tb.getId() %><br>
	주소2: <%=tb.getAddr()%><br>
	
	<br>
	다시한번 jsp 명령문쓴다면?
	<br>
	이름3: <jsp:getProperty name="tb" property="name"/><br>
	ID3: <jsp:getProperty name="tb" property="id"/><br>
	주소3: <jsp:getProperty name="tb" property="addr"/><br>
	
	
</jsp:useBean>
<br>
	만약 jsp필드 밖에서 다시한번 jsp명령문 또는 요청문을 쓴다면? 
	<br>
	이름4: <jsp:getProperty name="tb" property="name"/><br>
	ID4: <jsp:getProperty name="tb" property="id"/><br>
	주소4: <jsp:getProperty name="tb" property="addr"/><br>
	

</body>
</html>