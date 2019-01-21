<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    %>

    <%-- List.jsp--%>
    
    <%!
    String DRIVER="com.mysql.jdbc.Driver";
    String URL="jdbc:mysql://localhost:3306/mydb1";
    String USER="root";
    String PWD="12345";
    %>
    
    <%
    request.setCharacterEncoding("UTF-8");
    
    %>
    
    <html>
    <body bgColor="margenta">
    <center><h2>게시판 리스트</h2></center>
 
 	<table width="430" border="1" cellpadding="1" cellspacing="0" align="center">
 	<tr>
 	<td align="right" >
 	
    <a href="./template.jsp?page=Write.jsp"><br>
 	
 	<img alt="새글" src="imgs/write.gif" border="0">
 	</a>	
 	</td></tr>
 	
 	</table>
 	
 	<%
 	Class.forName(DRIVER);
 	
 	Connection con=DriverManager.getConnection(URL, USER, PWD);
 	Statement stmt=con.createStatement(); 
 	
 	String sql="select num, subject, wdate, writer, readcount from Myboard order by num desc";
 	ResultSet rs=stmt.executeQuery(sql);
 	
 	%>
 	<table border=10 width=430  align="center">
	<tr bgColor="cyan" height="20"> 	
 	<td width=50>번호</td>
 	<td width=130>글제목</td>
 	<td width=75>작성자</td>
 	<td width=103>작성일</td>
 	<td width=103>조회수</td>
 	</tr>
 	<%
 	while(rs.next()){
 		int num=rs.getInt("num");
 		String subject=rs.getString("subject");
 		//String email=rs.getString("email");
 		String writer=rs.getString("writer");
 		String wdate=rs.getString("wdate");
 		int readcount=rs.getInt("readcount");
 		%>
 		<tr>
 		<td><%=num %></td>
 		
 		
 		<%--<td><%=subject%></td> --%>
 		
 		<%--글제목을 클릭하면 글 내용 보기로 가기 --%>
 		<td>
 		<a href="./template.jsp?page=content.jsp?num=<%=num%>">
 		
 		<%=subject %>
 		</a></td>
 		<td><%=writer %></td>
 		<td><%=wdate %></td>
 		<td><%=readcount %></td>
 		</tr>
 		
 		<%
 	}//while end
 	rs.close();
 	stmt.close();
 	con.close();
 	%>
 	
 	</table>
 
 
    </body>
    </html>