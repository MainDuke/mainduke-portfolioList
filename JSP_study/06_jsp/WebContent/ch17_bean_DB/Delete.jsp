<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    String id=request.getParameter("id");
    %>
    
    <jsp:useBean id="dao" class="beandb.BeanDAO"></jsp:useBean>
    
    <%
    dao.deleteDB(id);
    response.sendRedirect("List.jsp");
    %>