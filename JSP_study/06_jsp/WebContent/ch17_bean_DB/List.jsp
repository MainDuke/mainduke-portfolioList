<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="beandb.*"
    %>
    
<jsp:useBean id="dao" class="beandb.BeanDAO"></jsp:useBean>

<% Vector<BeanDto> vec=dao.getList();%>
<table border="5">
<tr>
<th>ID</th>
<th>이름</th>
<th>이메일</th>
<th>전화</th>
<th>글 내용</th>
</tr>

<%
for(int i=0; i<vec.size();i++){
	BeanDto dto=(BeanDto)vec.get(i);
%>

<tr>
<td><%=dto.getId() %></td>
<td><a href="Content.jsp?id=<%=dto.getId() %>">
<%=dto.getName() %>
</a>
</td>

<td><%=dto.getEmail() %></td>
<td><%=dto.getTel() %></td>
<td height="50"><%=dto.getContent() %></td>
</tr>

<%
}//for

%>

</table>