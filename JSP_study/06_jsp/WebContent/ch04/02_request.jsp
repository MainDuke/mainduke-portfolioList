<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>02_request</h2>
<li>메서드 : <%=request.getMethod() %>
<li>요청 URI : <%=request.getRequestURI() %>
<li> 요청 URL : <%=request.getRequestURL() %>
<p>
<li>프로토콜 : <%=request.getProtocol() %><%--서버 --%>
<li>서버이름 : <%=request.getServerName() %>
<li>서버포트 : <%=request.getServerPort() %>
<p>
<li>사용자 주소 : <%=request.getRemoteAddr() %>
<li>사용자 컴퓨터 이름 : <%=request.getRemoteHost() %>

<p>
<li>사용중인 웹 브라우저 : <%=request.getHeader("User-Agent") %>
<p>
<li>브라우저를 지원하는 file의 type : <%=request.getHeader("Accept") %>
<p>
<li>이전 URL 알아내기 : <%=request.getHeader("referer") %>


</body>
</html>