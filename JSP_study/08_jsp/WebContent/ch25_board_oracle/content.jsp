<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.text.SimpleDateFormat"
    import="boardoracle.*"
    %>
<%@ include file="../view/color.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<%
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum"); //page
SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

try{
	BoardDao dao=BoardDao.getInstance();
	BoardDto dto=dao.getArticle(num);
	
	int ref=dto.getRef();// 글 그룹
	int re_step=dto.getRe_step();//글 순서 처리
	int re_level=dto.getRe_level(); //글 레벨(글 깊이= 들여쓰기)
	%>
	<body bgcolor="<%=bodyback_c%>">
	<center><h1>글 내용 보기</h1></center>
	<table width="500" border="1" cellpadding="3" cellspacing="0" align="center" bgcolor="<%=bodyback_c%>">
	
	<tr height="30">
	<td align="center" width="125" bgcolor="<%=value_c%>">글 번호</td>
	<td abbr="center" width="125"><%=dto.getNum()%></td>
	<td abbr="center" width="125" bgcolor="<%=value_c %>">조회수</td>
	<td abbr="center" width="125"><%=dto.getReadcount()%></td>
	</tr>
	
	<tr height="30">
	<td align="center" width="125" bgcolor="<%=value_c %>">작성자</td>
	<td abbr="center" width="125"><%=dto.getWriter()%></td>
	<td abbr="center" width="125" bgcolor="<%=value_c %>">작성일</td>
	<td abbr="center" width="125"><%=dto.getRegdate()%></td>
	</tr>
	
	<tr>
	<td align="center" width="125" bgcolor="<%=value_c%>">글 내용</td>
	<%
	String temp=dto.getContent();
	temp=temp.replace("\n", "<br>");
	%>
	
	<td colspan="3" align="center" width="375"><%=temp%></td>
	</tr>
	
	<td colspan="4" bgcolor="<%=value_c %>" align="right">
	<input type="button" value="글 수정" onclick="document.location.href='updateForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>'">  
	<input type="button" value="글 삭제" onclick="document.location.href='deleteForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>'">
	<input type="button" value="답글 쓰기" onclick="document.location.href='writeForm.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
	<input type="button" value="리스트" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
	</td>
	
	</table>
	</body>

	<%	
	}catch(Exception ex){}//end
	
	%>
</html>