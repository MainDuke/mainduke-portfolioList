<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id= request.getParameter("id");
%>

<%--객체 생성 --%>

<jsp:useBean id="dao" class="beandb.BeanDAO"></jsp:useBean>

<!-- 객체생성을 <%-- beandb.BeanDAO dao= new beandb.getContent(id)--%> 해줘도 된다. -->

<html>
<body>
<%
beandb.BeanDto dto=dao.getcontents(id);
%>
<table border="1" borderColor="blue" bgColor="pink">
<tr>
<td colspan="2" align="center">
<h2>글내용 보기</h2>
</td>
</tr>

<tr>
<td>ID</td>
<td><%=dto.getId() %></td>
</tr>

<tr>
<td>NAME</td>
<td><%=dto.getName() %></td>
</tr>
<tr>
<td>Email</td>
<td><%=dto.getEmail() %></td>
</tr>
<tr>
<td>TEL</td>
<td><%=dto.getTel()%></td>
</tr>
<tr>
<td>Content</td>
<td><%=dto.getContent()%></td>
</tr>

<tr>
<td colspan="2" align="center">
<a href="WriteForm.jsp">글쓰기</a>&nbsp;
<a href="List.jsp">리스트</a>&nbsp;
<a href="UpdateForm.jsp?id=<%=dto.getId()%>">글수정</a>&nbsp;
<a href="Delete.jsp?id=<%=dto.getId()%>">글삭제</a>&nbsp;
</td>
</tr>

</table>
</body>
</html>