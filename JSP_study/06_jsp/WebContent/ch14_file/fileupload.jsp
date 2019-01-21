<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- scope= 범위 -->
<jsp:useBean id="bb" class="upload.FileUploadBean" scope="request"></jsp:useBean>
    
    <%=bb.upload(request) %>
    