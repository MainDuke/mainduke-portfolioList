<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="10_err.jsp" %> <%--예외가 발생시 이쪽 페이지로 간다잉 --%>
    <h2>10_exception.jsp</h2>
    
    <%--
    exception 내장 객체 는 프로그래머가 jsp 페이지에서 발생한 예외를 처리하는 페이지를 지정한 경우
    에러페이지에 전달되는 예외 객체 이다.
    메서드들~ 생략.
    
String getMessage() 
발생된 예외의 메시지를 리턴한다. 
String toString() 
발생된 예외 클래스명과 메시지를 리턴한다. 
String pritnStackTrace() 
발생된 예외를 역추적하기 위해 표준 예외 스트림을 출력한다. 예외 발생시 예외가 발생한 곳을 알아낼 때 주로 사용된다. 
   --%>
   
   <%
   int a=7;
   int b=0;
   %>
   
   a+b=<%=a+b %><br>
   a-b=<%=a-b %><br>
   a*b=<%=a*b %><br>
   a/b=<%=a/b %><br>
   a%b=<%=a%b %><br>
   