<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   
   String id=request.getParameter("id");
   String name=request.getParameter("name");
   
   String hobby[] =request.getParameterValues("hobby");
  String hw=request.getParameter("hw");
  
  out.println("당신의 ID는 "+id+"<br>");
  out.println("당신의 이름은 "+name+"<br>");
    
  for(int i=0;i<hobby.length;i++)
  {
	  out.println("당신의 취미는  "+hobby[i]+"<br>");
  }//for
  
  out.println("사용중인 hw는 "+hw);
  
    %>