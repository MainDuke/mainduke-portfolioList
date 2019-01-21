<%@page import="boardmysql.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");

%>

<jsp:useBean id="dto" class="boardmysql.BoardDto">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
String pageNum=request.getParameter("pageNum");
BoardDao dao=BoardDao.getInstance();
int check=dao.updateArticle(dto);

if(check==1){//수정 완료
	response.sendRedirect("list.jsp?pageNum="+pageNum);
%>
	
	
<%	
}else{%>
	<script>
	alert("비밀번호가 틀립니다.");
	history.back();
	</script>
<%	
}//if end
%>

