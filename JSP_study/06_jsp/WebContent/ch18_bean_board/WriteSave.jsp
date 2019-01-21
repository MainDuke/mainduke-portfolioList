<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    %>
    
<%--WriteSave.jsp--%>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <jsp:useBean id="dto" class="board.BoardDto">
    <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <jsp:useBean id="dao" class="board.BoardDAO"/>
    
    <%= dao.insertDB(dto)%>
			
	<% response.sendRedirect("List.jsp?page=1");
	%>
	</body>

</html>