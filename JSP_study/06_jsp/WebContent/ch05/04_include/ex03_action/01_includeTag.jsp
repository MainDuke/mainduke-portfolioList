<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <html>
	    <body>
	    <h2>01_includeTag.jsp</h2>
	    
	    <%
	    request.setCharacterEncoding("utf-8");
	    String name="Korea Football";
	    
	    %>
	    <hr>
	    <jsp:include page="01_includeTagTop.jsp"/>
		<hr>
		01_includeTag.jsp의 body 입니다.<br>
		01_includeTag.jsp의 body 입니다.<br>
		01_includeTag.jsp의 body 입니다.<br>
		01_includeTag.jsp의 body 입니다.<br>
		<%=name %>	    
	    
	    </body>
	</html>