<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="bean" class="boardoracle.BoardBean">
	<jsp:setProperty name="bean" property="*"/>
</jsp:useBean>

<jsp:useBean id="mgr" class="boardoracle.BoardMgr"/>

<%
int nowPage=Integer.parseInt(request.getParameter("page"));
int num=Integer.parseInt(request.getParameter("num"));

BoardBean bbb=mgr.getBoard(num);//Dao 메서드호출
String inPass=request.getParameter("pass");//입력한암호
String dbPass=bbb.getPass();//DB에서 가져온 암호

if(inPass.equals(dbPass)){
	mgr.updateBoard(bean);//메서드 호출 test
	response.sendRedirect("List.jsp?page="+nowPage);
}else{
	%>
	<script>
		alert("암호가 틀립니다")
		history.go(-1)
		</script>  
	
	
	
	<%
}//else
	
%>