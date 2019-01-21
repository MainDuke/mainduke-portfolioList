<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("utf-8");
    %>
    
    <jsp:useBean id="cb" class="mybean.ColorBean3">
    	<jsp:setProperty name="cb" property="*"/>
    </jsp:useBean>
    <html>
    <head>
    <title>ColorBean3.jsp</title>
    </head>
    <body bgcolor="white">
    <!-- <body bgcolor="<%=cb.getColor() %>"> -->
    
    
    <table border="10"  width=50%  cellpadding="3">
        
    <tr>
<td>name : </td>
<td><%=cb.getName() %></td>
</tr>

<tr>
<td>선택한 색깔 : </td>
<td><%=cb.getColor() %></td>
</tr>

<tr>
<td colspan="2">
<jsp:getProperty property="name" name="cb"/> 님이 선택한 색깔은
<font color='<jsp:getProperty property="color" name="cb"/>'>
<jsp:getProperty property="color" name="cb"/> 입니다. </font>
</td>
</tr>

    
    </table>
    
    </body>
    </html>