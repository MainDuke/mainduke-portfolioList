<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.sql.*"
    %>

    <%
    request.setCharacterEncoding("UTF-8");
    String num= request.getParameter("num");
    %>
    
    <jsp:useBean id="dao" class="board.BoardDAO"></jsp:useBean>
    
    
    <html>
    <body>
    <h1>글 내용보기</h1>
    <%
	board.BoardDto dto=dao.getContent(num);
	%>
    
    
<table border="1" borderColor="blue" bgColor="pink">
<tr>
<td colspan="2" align="center">
<h2>글내용 보기</h2>
</td>
</tr>

<tr>
<td>글번호</td>
<td><%=dto.getNum() %></td>
</tr>

<tr>
<td>작성자</td>
<td><%=dto.getWriter() %></td>
</tr>
<tr>
<td>글 제목</td>
<td><%=dto.getSubject() %></td>
</tr>

<tr>
<td>Email</td>
<td><%=dto.getEmail() %></td>
</tr>

<tr>
<td>조회수</td>
<td><%=dto.getReadcount()%></td>
</tr>
<tr>
<td>작성자 IP</td>
<td><%=dto.getIp()%></td>
</tr>

<tr>
<td>작성일</td>
<td><%=dto.getDate() %></td>
</tr>


<tr>
<td>글 내용</td>
<td><%=dto.getContent()%></td>
</tr>




<tr>
<td colspan="2" align="center">
<a href="Write.jsp">글쓰기</a>&nbsp;
<a href="List.jsp">리스트</a>&nbsp;
<a href="Edit.jsp?num=<%=dto.getNum()%>">글수정</a>&nbsp;
<a href="Delete.jsp?num=<%=dto.getNum()%>">글삭제</a>&nbsp;
</td>
</tr>

</table>
    </body>
    </html>