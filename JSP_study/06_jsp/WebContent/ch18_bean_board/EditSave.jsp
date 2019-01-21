<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="board.*"
    %>

<%--EditSave.jsp --%>
 <%
        request.setCharacterEncoding("utf-8");
        String num=request.getParameter("num");
      %>
  <jsp:useBean id="dto" class="board.BoardDto">
    <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <jsp:useBean id="dao" class="board.BoardDAO"/>
    
    <%=dao.updateSave(dto)%>
  
    <%
    response.sendRedirect("List.jsp");
    %>
      

        
        