<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.sql.*"
    %>

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
    <body>
    <h1>글 내용보기</h1>
    <%
    /*개별 자료를 구분하기 위해서 각 자료마다 기본키인 num을 가져와서 변수 num에 저장을 한다.*/

    String num=request.getParameter("num");
    int readcount=0; //조회수를 다룰 변수 선언
    
    Class.forName(DRIVER);
    Connection con=DriverManager.getConnection(URL, USER, PWD);
    
    String sql="select * from myboard where num="+num; //num에 해당하는 자료를 DB에서 가져온다.
    
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery(sql);
    
    while(rs.next()){
	    	String writer=rs.getString("writer");
	    	String subject=rs.getString("subject");
	    	String email=rs.getString("email");
	    	String content=rs.getString("content");
	    	String pwd=rs.getString("pwd");
	    	String wdate=rs.getString("wdate");
	    	readcount=rs.getInt("readcount");
	    	String ip=rs.getString("ip");
	    	
	    	readcount++;
	%>
    <table width=407 border="10" bgColor="margenta">
	<tr>
	<td align="right">
	
 		<a href="template.jsp?page=Write.jsp">새글 쓰기</a>
 		<a href="./template.jsp?page=Edit.jsp?num=<%=num%>">글 수정</a>
 		<a href="./template.jsp?page=Delete.jsp?num=<%=num%>">글 삭제</a>
 		<a href="./template.jsp?page=List.jsp?page=1">리스트</a>
			
			<!-- 
			<a href="Write.jsp">새글 쓰기</a>
			<a href="Edit.jsp?num=<%=num%>">글 수정</a>
			<a href="Delete.jsp?num=<%=num%>">글 삭제</a>
			<a href="List.jsp?page=1">리스트</a>
			 -->
	</td>
	</tr>    
    </table>
    <table width="407" border=10>
	<tr>
	<td width=100>이름</td>
	<td width="307">[<%=writer %>]</td>
	</tr>
	<tr>
	<td>글제목</td>
	<td><%=subject %></td>
	</tr>    
    
    <tr>
	<td>날짜</td>
	<td><%=wdate %></td>
	</tr>
	
	<tr>
	<td>비밀번호</td>
	<td>
	<%
	//String temp=(String)session.getAttribute("id");
	if(session.getAttribute("id")=="admin"){
		out.println(pwd);
	}else{
		out.println("****");
	}
	%>
    </td>
    </tr>
    
    <tr>
    <td>조회수</td>
    <td><%=readcount %></td>
    </tr>
    
    <tr>
    <td>IP</td>
    <td><%=ip %></td>
    </tr>
    
    <tr>
    <td colspan="2" width="407">
    <br>
    <%=content %>
    <br><br>
    </td>
    </tr>
    
    
    </table>
    
    
    <%
    }//while end
    rs.close();
    stmt.close();
    
    //조회수를 증가하기 위한 쿼리문을 만든다.
    sql="update myboard set readcount=? where num=?";
    PreparedStatement pstmt=con.prepareStatement(sql);
    pstmt.setInt(1, readcount);
    pstmt.setInt(2, Integer.parseInt(num));
    pstmt.executeUpdate(); //쿼리문 수행
    pstmt.close();
    con.close();
    
    %>
    
    
    </body>
    </html>