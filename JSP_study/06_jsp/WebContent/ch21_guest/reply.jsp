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
function insert(){
	

	//이름
	if(document.replyForm.name.value==''){
		alert("name을 입력하시오.");
		document.replyForm.name.focus();
		return false;
	}
	//content
	if(document.replyForm.content.value==''){
		alert("글내용을 입력하시오.");
		document.replyForm.content.focus();
		return false;
	}
	//pwd
	if(document.replyForm.pwd.value==''){
		alert("PWD을 입력하시오.");
		document.replyForm.pass.focus();
		return false;
	}
	
	//제출
	document.replyForm.submit();

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

<td width="20%" height="90%" align=center>

</td>

</tr>

</table> <!-- 안쪽 -->




<hr>
<form method="post" name="replyForm" action="reply_save.jsp">

<table  border="5" align="center" width="400" height="250" cellpadding="3" cellspacing="0">

<tr>
<td colspan="2">위 방명록에 달 답글을 쓰세요.</td>
</tr>

<tr>
<td width="80%" height="90%">
<textarea rows=10 cols=50 name="content"></textarea>
</td>

<td width="20%" height="90%" align=center>
<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>" >
<input type="hidden" name="id" value=<%=id %>>
<input type="hidden" name="num" value=<%=num %>>

<input type="text"  placeholder="이름" name="name">
<input type="password"  placeholder="삭제시 필요" name="pwd">
<input type="button" value="글 쓰기" onclick="insert()" >
<input type="reset" value="리셋">
<input type="button" value="돌아가기" onclick="history.back()">
</td>
</tr>
</table>
</form>

<hr>


</body>
</html>