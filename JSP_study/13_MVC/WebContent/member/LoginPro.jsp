<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
	
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/view/color.jspf" %>
    
<%
request.setCharacterEncoding("utf-8");

String id=request.getParameter("id");

%>

<c:choose>
<c:when test="${check==1}">

	<% 
	session.setAttribute("memId", id);
	System.out.println("check==1  " +request.getContextPath());
	%>
	
</c:when>

<c:when test="${check==0}">
	<script>
	alert("암호가 다릅니다.");
	history.go(-1);
	</script>
</c:when>	

<c:otherwise>
	<script>
	alert("아이디가 맞지 않습니다.");
	history.go(-1);
	</script>
</c:otherwise>

</c:choose>

<meta http-equiv="Refresh" content="0;url=${ctxpath }/member/main.do">