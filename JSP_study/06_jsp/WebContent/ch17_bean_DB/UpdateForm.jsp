<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
     %>
     
     <jsp:useBean id="dao" class="beandb.BeanDAO"></jsp:useBean>
    <%
	beandb.BeanDto dto = dao.getcontents(id);
	%>     
     
     <html>
     <body bgColor="margenta">
	 <form method="post" action="UpdateSave.jsp">
	 <table border="1" borderColor="blue" bgColor="pink">
	 <tr>
	 <td colspan="2" align="center"><h2>글 수정하기</h2></td>
	 </tr>
	 
	 <tr>
	 <td>ID</td>
	 <td><input type="text" name="id" value="<%=dto.getId()%>" readonly="readonly" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>NAME</td>
	 <td><input type="text" name="name" value="<%=dto.getName()%>" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>Email</td>
	 <td><input type="text" name="email" value="<%=dto.getEmail()%>" ></td>	 
	 </tr>
	 <tr>
	 <td>TEL</td>
	 <td><input type="text" name="tel" value="<%=dto.getTel()%>" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>Content</td>
	 <td><textarea name="content" rows=10 cols=50 ><%=dto.getContent() %></textarea>
	 </td>	 
	 </tr>
	 
	 <tr>
<td colspan=2> 
<input type="submit" value="전송">
<input type="reset" value="리셋">
</td></tr>
	 
	 </table>
	 
	 
	 </form>

     </body>
     
     </html>
    