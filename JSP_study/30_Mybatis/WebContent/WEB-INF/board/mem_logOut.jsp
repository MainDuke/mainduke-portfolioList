<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:remove var="id" scope="session"/><!-- 변수제거,세션무효화 -->
<%
session.invalidate();//세션 무효화 
%>
  <%
  response.sendRedirect("login.do");//hhtp:// 새로 연결된다 
  %>