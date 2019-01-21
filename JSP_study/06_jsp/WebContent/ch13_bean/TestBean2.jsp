<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <html>
    <head>
    <title>TestBean2.jsp</title>
    </head>
    <body bgcolor="cyan">
    
    <jsp:useBean id="tb2" class="mybean.TestBean2">
    	<jsp:setProperty name="tb2" property="*"/>
    
    </jsp:useBean>
    
    <table border="10" width=50% cellpadding="3">
    
    <tr>
<td>name : </td>
<td><%=tb2.getName() %></td>
</tr>

<tr>
<td>id : </td>
<td><%=tb2.getId() %></td>
</tr>

<tr>
<td>주소 : </td>
<td><%=tb2.getAddr() %></td>
</tr>

<tr>
<td>글 내용 : </td>
<td><%=tb2.getContent() %></td>
</tr>
    
    </table>
    
    </body>
    </html>