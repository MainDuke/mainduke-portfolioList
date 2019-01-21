<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
    	String os=request.getParameter("os");
        String jdk[]=request.getParameterValues("jdk");
        String content=request.getParameter("content");
     
		out.println("당신이 사용하는 os는 "+os+"<br>");
		
		for(int i=0; i<jdk.length;i++)
		{
			out.println("당신이 사용하는 JDK는"+jdk[i]+"<br>");
		}
		
		out.println("당신이 쓴 글");
		out.println(content);
 %> 
		
		
	