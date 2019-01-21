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


GuestBean bean=msg.getBoard(num, id);  

String name=bean.getName();
String content=bean.getContent();
String pwd=bean.getPwd();


%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function update(){
	

	//이름
	if(document.updateForm.name.value==''){
		alert("name을 입력하시오.");
		document.updateForm.name.focus();
		return false;
	}
	//content
	if(document.updateForm.content.value==''){
		alert("글내용을 입력하시오.");
		document.updateForm.content.focus();
		return false;
	}
	//pwd
	if(document.updateForm.pwd.value==''){
		alert("PWD을 입력하시오.");
		document.updateForm.pass.focus();
		return false;
	}
	
	//제출
	document.updateForm.submit();

}//insert end

</script>
</head>
<body>

 <hr>
<form method="post" name="updateForm" action="Update_save.jsp">

<table  border="5" align="center" width="400" height="250" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">

<tr>
<td colspan="2">방명록 내용을 수정하세요.</td>
</tr>

<tr>
<td width="80%" height="90%">
<textarea rows=10 cols=50 name="content"><%=content %></textarea>
</td>

<td width="20%" height="90%" align=center>

<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>" >
<input type="hidden" name="id" value=<%=id %>>
<input type="hidden" name="num" value=<%=num %>>

<input type="text"  placeholder="이름" name="name" value=<%=name %>>
<input type="password"  placeholder="삭제시 필요" name="pwd">


<input type="button" value="글 쓰기" onclick="update()" ><br>
<input type="reset" value="리셋"><br>
<input type="button" value="돌아가기" onclick="history.back()"><br>
</td>
</tr>
</table>
</form>

<hr>


</body>
</html>