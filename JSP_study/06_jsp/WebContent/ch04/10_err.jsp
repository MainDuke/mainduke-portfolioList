<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<% 
String msg=exception.getMessage();
String obj=exception.toString();
%>

에러 메세지 : <%=msg %> <br>
에러 실체의 클래스 명과 에러 메세지 : <%=obj %> <br>
