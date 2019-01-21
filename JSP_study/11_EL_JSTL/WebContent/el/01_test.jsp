<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--01_test.jsp--%>
    
    표현식:<%=request.getMethod()%><br>
   표현언어: ${pageContext.request.method}
   
   표현식 <%=request.getHeader("host")%>
   표현언어 ${header.host}<p>
   표현언어 ${header["host"]}<p>
   표현언어 ${headerValues}<p>
   
  <br><br>
  Accept[0] => ${headerValues.Accept[0]}<p>
  User-Agent => ${header["User-Agent"]}<p>
  ["User-data"][0] => ${headerValues["User-data"][0]}<p>