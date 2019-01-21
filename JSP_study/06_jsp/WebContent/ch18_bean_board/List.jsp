<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="board.*"
    %>
    
<jsp:useBean id="dao" class="board.BoardDAO"></jsp:useBean>

<% Vector<BoardDto> vec=dao.getList();%>
<table border="5">
<tr>
<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>이메일</th>
<th>날짜</th>
<th>조회수</th>
</tr>

<%
for(int i=0; i<vec.size();i++){
	BoardDto dto=(BoardDto)vec.get(i);
%>

<tr>
<td><%=dto.getNum() %></td>
<td><%=dto.getWriter() %></td>
<td><a href="Content.jsp?num=<%=dto.getNum() %>">
<%=dto.getSubject() %>
</a></td>

<td><%=dto.getEmail() %></td>
<td><%=dto.getDate() %></td>
<td ><%=dto.getReadcount() %></td>
</tr>

<%
}//for

%>

</table>