<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="guest.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="msg" class="guest.GuestMsg"></jsp:useBean>
<%
request.setCharacterEncoding("utf-8");

String id=(String)session.getAttribute("id");

id="test";
int num=Integer.parseInt(request.getParameter("num"));

System.out.println(num);

GuestBean bean=msg.getBoard(num, id);  
String name=bean.getName();
String content=bean.getContent();



%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function Delete(){
	
	//pwd
	if(document.DeleteForm.pwd.value==''){
		alert("PWD을 입력하시오.");
		document.DeleteForm.pass.focus();
		return false;
	}
	
	//제출
	document.DeleteForm.submit();

}//insert end

</script>
</head>
<body>


<table border="1"  align="center" width="500" height="250" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
 
<tr height="80%">
<td width="80%" height="90%">

<form method="post" name="Guest<%=num%>">
<%=content %><br>
<font size="4" color="pink" ><B>From.<%=name %></B></font>
</form>


</td>

</tr>

</table> <!-- 안쪽 -->




<hr>
<form method="post" name="DeleteForm" action="Delete_save.jsp">

<table  border="5" align="center" width="400" height="250" cellpadding="3" cellspacing="0">

<tr>
<td >삭제를 원하시면 글쓰기할때 입력한 암호를 쓰시오!</td>
</tr>

<td align=center>

<input type="password"  placeholder="삭제시 필요" name="pwd">

<input type="hidden" name="num" value=<%=num %>>
<input type="button" value="삭제" onclick="Delete()" >
<input type="button" value="돌아가기" onclick="history.back()">
</td>
</tr>

</table>
</form>

<hr>


</body>
</html>