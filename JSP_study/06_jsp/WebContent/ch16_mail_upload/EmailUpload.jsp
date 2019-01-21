<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% request.setCharacterEncoding("utf-8");
    %>
    <html>
    <body>
    
    <jsp:useBean id="bb" class="emailupload.MailUpload">
    	<jsp:setProperty name="bb" property="*"/>
    </jsp:useBean>
    
    <%=bb.upload(request)%>
    </body>
    </html>