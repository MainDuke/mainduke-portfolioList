<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>

    <%-- remove.jsp--%>
    
    <%
   Vector vec=(Vector)session.getAttribute("cart"); //장바구니 내용을 vec 에 할당
     %>
        
   <h2>삭제할 CD를 고르세요</h2>
   
   <form method="post" action="cart.jsp">
  	<select name="item">
  	<%
  	for(int i=0;i<vec.size();i++){
%>
<option value="<%=vec.get(i).toString() %>"><%=vec.get(i).toString() %>
</option>
<%  		
  	}//for
  	%> 
  	</select>
  	<input type="hidden" name="step" value="remove">
  		<input type="submit"  value="삭제">
   </form>