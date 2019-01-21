<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    news.jsp<br>
    
    <%
    String []titles={
    		"태양의 후예",
    		"송중기 중극에서 떳다.",
    		"송혜교 원래부터 중국에서 스타였다."
    };
    
    for(int i=0;i<titles.length;i++){
    	if(i==0){
    		%>
    		<strong>
    		<%
    	}//if
    %>
    <%=titles[i] %>
    <%
    	if(i==0){
    %>
    		</strong>
	<%	
    }//if end
    %>
    <br>
    <%
    }//for
   %> 