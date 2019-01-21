<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    
    %>
    
    <%--Edit.jsp --%>
    
    <%!
    String DRIVER="com.mysql.jdbc.Driver";
    String URL="jdbc:mysql://localhost:3306/mydb1";
    String USER="root";
    String PWD="12345";
        %>
        <%
        request.setCharacterEncoding("utf-8");
        String num=request.getParameter("num");
        
        %>
        
<html>

	<head>
	<script type="text/javascript">
	function check(){
		if(document.editForm.pwd.value==''){
			alert("암호를 입력하시오");
			document.editForm.pwd.focus();
			return;
		}//if
		document.editForm.action="EditSave.jsp?num=<%=num%>";
		document.editForm.submit();
	}//function end
	</script>
	</head>
        <body bgColor="orange" align="center">
   		<%
   		Class.forName(DRIVER);
   		Connection con=DriverManager.getConnection(URL, USER, PWD);
   		Statement stmt=con.createStatement();
   		
   		String sql="select * from Myboard where num="+num;
   		ResultSet rs=stmt.executeQuery(sql);
   		
   		while(rs.next()){
   			String writer=rs.getString("writer");
   			String subject=rs.getString("subject");
   			String email=rs.getString("email");
   			
   			String content=rs.getString("content");
   			String pwd=rs.getString("pwd");
   			String wdate=rs.getString("wdate");
   		
   			int readcount=rs.getInt("readcount");
   			String ip = rs.getString("ip");
   			%>
   			<h1>글 수정 양식</h1>
   			<form name="editForm" method="post" >
   			<table border="10" width=407 bgColor="margenta">
   			<!-- writer -->
   			<tr>
   			<td width=170 height="25">이름</td>
   			<td>
   			<input type="text" name="writer" value="<%=writer %>" size=10>
   			</td>
   			</tr>
   			
   			<!-- subject -->
   			<tr>
   			<td height="25">글 제목</td>
   			<td>
   			<input type="text" name="subject" value="<%=subject %>" size=40>
   			</td>
   			</tr>
   			
   			<!-- email -->
   			<tr>
   			<td height="25">이메일</td>
   			<td>
   			<input type="text" name="email" value="<%=email %>" size=30>
   			</td>
   			</tr>
   			
   			<!-- content -->
   			<tr>
   			<td height="25">글 내용</td>
   			<td>
   			<textarea name="content" rows="15" cols="40"><%=content %></textarea>
   			</td>
   			</tr>
   			
   			<!-- pwd -->
   			<tr>
   			<td height="25">암호</td>
   			<td>
   			<input type="text" name="pwd" size=10>
   			</td>
   			</tr>
   			
   			<tr>
   			<td align="center" colspan="2">
   			<input type="button" value="수정" onClick="javaScript:check()">
   			&nbsp;
   			<input type="button" value="이전으로 돌아가기" onClick="history.back()">
   			</td></tr>
   			</table>
   			</form>
   			
   		<%
   		}//while end
   		%>     
   		
   		
   		
   		
        </body>
</html>

    