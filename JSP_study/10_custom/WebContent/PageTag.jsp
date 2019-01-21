<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/PageTag.tld" prefix="pp"%>

<%
String start="1";
String end="10";
String nowPage="1";

if(request.getParameter("nowPage") != null){
	nowPage=request.getParameter("nowPage");
}
%>

<h1>속성 값을 갖는 태그</h1>
현재 페이지는 <b><%=nowPage %></b>입니다.
<font size="+1" color="green">
	<pp:page from="<%=start%>" to="<%=end %>"></pp:page>
</font> 

