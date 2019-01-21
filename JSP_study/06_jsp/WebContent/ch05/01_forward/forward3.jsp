<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<h2>forward3.jsp</h2>
<h2>포워드 된 액션</h2>

<table border=1>
<tr>
<td>이름</td>
<td><%=request.getParameter("name") %></td>
</tr>

<tr>
<td>나이</td>
<td><%=request.getParameter("age") %></td>
</tr>

<tr>
<td>주소</td>
<td><%=request.getParameter("addr") %></td>
</tr>

<tr>
<td>핸드폰번호</td>
<td><%=request.getParameter("tel") %></td>
</tr>

<tr>
<td>이메일</td>
<td><%=request.getParameter("email") %></td>
</tr>

<tr>
<td>내용</td>
<td><%=request.getParameter("content") %></td>
</tr>

</table>
    