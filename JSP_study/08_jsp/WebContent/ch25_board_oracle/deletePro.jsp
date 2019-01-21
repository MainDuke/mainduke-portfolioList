<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
String passwd=request.getParameter("passwd");

BoardDao dao=BoardDao.getInstance();
int check=dao.deleteArticle(num, passwd);

if(check==1){
	response.sendRedirect("list.jsp?pageNum="+pageNum);
}else{
	%>
		<script>
	alert("비밀번호가 틀립니다.");
	history.back();
	</script>
	
	<%
}//else

%>