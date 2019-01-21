<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="java.net.URLDecoder"%>
    
    <html>
    <body>
       <%
      Cookie cookies[]=request.getCookies();
      String visitor=null;
      
      if(cookies!=null){
         for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("visitor")){
               visitor=URLDecoder.decode(cookies[i].getValue()); //쿠키를 얻는다.
            out.println("쿠키이름:"+cookies[i].getName());
			out.println("쿠키 값:"+cookies[i].getValue());

            }
         }
      }
      
      if(visitor==null){
         %>
    	
    	<form method="post" action="cookie_make.jsp">
    	이름을 입력하시오.<br>
    	<input type="text" name="visitor">
    	<input type="submit">
    	  	
    	</form>
    	   	
    	<%
    }else{
    	out.println("<h3>"+visitor+"님 반갑습니다.</h3>");
    }//else
    
    %>
        </body>
    </html>