<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

Reply.jsp
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mgr" class="boardoracle.BoardMgr"></jsp:useBean>

<%

//List.jsp에서 보내준 값을 받기
int num=Integer.parseInt(request.getParameter("num"));
int nowPage=Integer.parseInt(request.getParameter("page"));
BoardBean bean=mgr.getBoard(num);  
String subject=bean.getSubject();
String content=bean.getContent();

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="460" cellpadding="3" cellspacing="0" align="center">
<tr>
<td bgcolor="#cccc00" height="21" align="center">
답변글 쓰기
</td>
</tr>
</table>

<form method="post" name="reForm" action="ReplyProc.jsp">

<table width="527" cellpadding="7" cellspacing="9" align="center">
<tr>
<td align="center">
<table border="0">

<tr>
<td width="20%">이름</td>
<td width="80%">
<input type="text" name="name" size="20">
</td>
</tr>

<tr>
<td width="20%">E-mail</td>
<td width="80%">
<input type="text" name="email" size="40">
</td>
</tr>

<tr>
<td width="20%">HomePage</td>
<td width="80%">
<input type="text" name="homepage" size="20" value="http://">
</td>
</tr>


<!-- 제목 -->
<tr>
<td width="20%">제목</td>
<td width="80%"><input type="text" name="subject" size="50" value="└Re : <%=subject%>"></td>
</tr>

<!-- 내용 -->
<tr>
<td width="20%">내용</td>
<td width="80%"><textarea name="content" rows="10" cols="50"><%=content%></textarea></td>
</tr>
<!-- pass -->
<tr>
<td width="20%">암호</td>
<td width="80%"><input type="password" name="pass" size="20"></td>
</tr>

<!-- 제목 -->
<tr>
<td colspan="2"><hr size="1"></td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit" value="답글 등록" >
	<input type="reset" value="다시 쓰기" >
	<input type="button" value="뒤로" onclick="history.go(-1)">
	
	
	<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>" >
	<input type="hidden" name="page" value="<%=nowPage %>" >
	<input type="hidden" name="num" value="<%=num %>" >
	
	</td>
	</tr>



</table>

</table>


</form>

</body>
</html>







