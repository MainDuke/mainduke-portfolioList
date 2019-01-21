<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
	
    %>
<%
request.setCharacterEncoding("utf-8");

String id=request.getParameter("id");
String passwd=request.getParameter("passwd");

LoginDao dao= LoginDao.getInstance();
int check=dao.userCheck(id, passwd);

if(check==1){
	session.setAttribute("memId", id);
	response.sendRedirect("Main.jsp");
}else if(check==0){
	%>
	
	<script>
	alert("암호가 다릅니다.");
	history.go(-1);
	</script>
	<%
	
}else{%>
	<script>
	alert("아이디가 맞지 않습니다.");
	history.go(-1);
	</script>


<%
}//else

%>
