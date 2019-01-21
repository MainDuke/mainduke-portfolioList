<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.oreilly.servlet.*"
    %>

    <html>
    <body>
    <jsp:useBean id="mailBean" class="mail.MailSender">
    	<jsp:setProperty name="mailBean" property="*"/>
    	
    </jsp:useBean>
    	
    	<%=mailBean.send() %>
    
    </body>
    
    </html>