<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Timestamp"
    import="member.*"
    %>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    %>
    
    <jsp:useBean id="dto" class="member.LoginDto">
	    <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <%
    dto.setRegdate(new Timestamp(System.currentTimeMillis()));
    LoginDao dao=LoginDao.getInstance(); //객체 얻기
    dao.insertMember(dto);
    
    response.sendRedirect("Main.jsp");
    %>