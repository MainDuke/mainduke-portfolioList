<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String name=request.getParameter("name"); //클라이언트에 요청하면서 보내준 데이터를 받는다.
    String pwd = request.getParameter("pwd");//
     %>
    
    당신의 이름 : <%=name%><br>
    당신의 암호 : <%=pwd%><br>
    <%--jsp 주석 --%>
    
    <%-- html을 실행시켜서, 전송버튼을 클릭한다. --%>
    
    