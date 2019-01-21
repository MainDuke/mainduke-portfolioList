<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <jsp:useBean id="dto" class="beandb.BeanDto">
    <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <jsp:useBean id="dao" class="beandb.BeanDAO"/>
    
    <%= dao.insertDB(dto)%>