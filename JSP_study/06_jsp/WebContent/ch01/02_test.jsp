<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 서블릿보다 JSP를 오류 찾기가 힘들다. JAVA 문법이랑 약간 다르기 때문에~ -->
    <h1>02_test.jsp</h1>
    
   html 코드로 출력<br>
   html 코드로 출력<br>
   html 코드로 출력<br>
   html 코드로 출력<br>
   
   <%
   //자바코드=는 서블릿이 들어가는부분
   out.println("<h2>자바코드 부분</h2>");
   out.println("html 코드로 출력<br>");
   out.println("html 코드로 출력<br>");
   out.println("html 코드로 출력<br>");
   out.println("html 코드로 출력<br>");
   
   %>
   
   <h2>JSP 코드부분</h2>
   <%="JSP코드부분"%><br> <%--JSP주석 --%>
	<%="JSP코드 부분" %><br>
	<%="JSP코드 부분" %><br>
	<%="JSP코드 부분" %><br>
	<%="JSP코드 부분" %><br>
   