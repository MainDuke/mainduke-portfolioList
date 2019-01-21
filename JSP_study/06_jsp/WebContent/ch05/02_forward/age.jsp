<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <h2>age.jsp</h2>
    
    <%
    int age=Integer.parseInt(request.getParameter("age"));
    %>
    
    <%
    if(age>=0 && age<=10){
   	%>
   	<jsp:forward page="aa.jsp"/>
   	<%
    }else if(age>10 && 20>=age){
    %>
    <jsp:forward page="bb.jsp"/>
    <%
    }else if(age>20 && age<=40){
   	%>
    	<jsp:forward page="cc.jsp"/>
   	<%
    }else if(age>40 && age <=70){
  	%>
    	<jsp:forward page="dd.jsp"/>
   	<%
    }else{
   	out.println("70세 이상 알아서 잘 사세요.");
    }
    %>