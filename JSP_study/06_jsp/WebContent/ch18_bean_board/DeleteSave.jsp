<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    %>
    <%
    request.setCharacterEncoding("utf-8");
    String num=request.getParameter("num");
    %>
    
    <jsp:useBean id="dao" class="board.BoardDAO"></jsp:useBean>
    
    <%
    dao.deleteDB(num);
    
    response.sendRedirect("List.jsp");
    %>