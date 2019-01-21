<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>06예제</h2>
    <h2>web.xml 에서 설정된 파라미터 값 읽어 오기</h2>
    
    로깅 여부: <%=application.getInitParameter("logEnabled") %><br>
    디버깅 레벨 : <%=application.getInitParameter("debugLevel") %> <br>
    이름 : <%=application.getInitParameter("name") %><br>
    <br>
    
    <%
    Enumeration e=application.getInitParameterNames();
    
    while(e.hasMoreElements()){
    	String initParam=(String)e.nextElement();
    	out.println(initParam);
    	out.println("==>");
    	out.println(application.getInitParameter(initParam));
    	out.println("<br>");
    
    	
    }
    
    %>
    