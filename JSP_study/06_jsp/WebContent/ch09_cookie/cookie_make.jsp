<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.net.*"
    %>
    
    cookie_make.jsp<br>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    //쿠키 심기
    
    String visitor=request.getParameter("visitor");
    
    Cookie cookie= new Cookie("visitor", URLEncoder.encode(visitor));

    cookie.setMaxAge(30*24*60*60); //30일 24시간 60분 60초
    
    response.addCookie(cookie); //클라이언트에 쿠키를 넣는다.
    %>
    
    