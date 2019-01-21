<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
     import="guest.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
id="test";
int num=Integer.parseInt(request.getParameter("num"));

%>

<jsp:useBean id="bb" class="guest.GuestBean">
	<jsp:setProperty name="bb" property="*"/>
</jsp:useBean>
<jsp:useBean id="msg" class="guest.GuestMsg"></jsp:useBean>

<%

GuestBean bbb=msg.getBoard(num, id);//Dao 메서드호출
String inPass=request.getParameter("pwd");//입력한암호
String dbPass=bbb.getPwd();//DB에서 가져온 암호

if(inPass.equals(dbPass)){
	msg.updateBoard(bb);//메서드 호출 test
	response.sendRedirect("Guest.jsp");
}else{  
	%>
	<script>
		alert("암호가 틀립니다")
		history.go(-1)
		</script>  
	
	
	
	<%
}//else
	
%>

