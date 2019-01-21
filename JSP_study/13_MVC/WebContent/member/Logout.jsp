<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <%@ include file="/view/color.jspf" %>
<%
session.invalidate(); //세션 무효화

%>

<meta http-equiv="Refresh" content="0;url=${ctxpath }/member/main.do">

