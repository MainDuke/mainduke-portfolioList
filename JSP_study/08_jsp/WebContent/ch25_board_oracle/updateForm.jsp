<%@page import="com.sun.beans.util.Cache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>
    <%@ include file="../view/color.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="script.js"></script>

</head>
<%
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");

try{
	BoardDao dao=BoardDao.getInstance();
	BoardDto dto=dao.updateGetArticle(num);
%>
<body bgcolor="<%=bodyback_c%>">
<center><b><font size="+2">글 수정</font></b></center>
<form name="writeForm" method="post" action="updatePro.jsp?pageNum=<%=pageNum%>">
	<table width="400" border="1" cellpadding="5" cellspacing="0" bgcolor="<%=bodyback_c%>" align="center">
	
	<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">이름</td>
		<td width="330">
		<input type="text" name="writer" id="writer" size="10" value="<%=dto.getWriter()%>">
		<input type="hidden" name="num" value="<%=num%>">
		</td>	
	</tr>
	
	<tr>
		<td bgcolor="<%=value_c%>" align="center">제목</td>
		<td >
		<input type="text" name="subject" id="subject" size="40" value="<%=dto.getSubject()%>">
		</td>	
	</tr>
	
	<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">Email</td>
		<td>
		<input type="text" name="email" id="email" size="30" value="<%=dto.getEmail()%>">
		</td>	
	</tr>
	
	<tr>
		<td bgcolor="<%=value_c%>" align="center">글내용</td>
		<td>
		<textarea name="content" id="content" rows="10" cols="40"><%=dto.getContent()%></textarea>
		</td>	
	</tr>
	
	<tr>
		<td bgcolor="<%=value_c%>" align="center">비밀번호</td>
		<td>
			<input type="password" name="passwd" id="passwd" size="8">
		</td>	
	</tr>
	
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="글수정">
	<input type="reset" value="다시 작성">
	<input type="button" value="목록 보기" onclick="document.location='list.jsp?pageNum=<%=pageNum%>'">
	</td>
	</tr>
	
	</table>
 </form>
</body>	
	
<%
}catch(Exception ex1){
	System.out.println("updateForm 예외 발생 :"+ex1);
}finally{
	
}//end
%>

<body>

</body>
</html>