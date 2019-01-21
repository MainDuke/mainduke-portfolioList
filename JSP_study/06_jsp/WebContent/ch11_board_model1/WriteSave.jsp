<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    %>
<%--WriteSave.jsp--%>

<%! 
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://localhost:3306/mydb1";
String USER="root";
String PWD="12345";
%>

<%
request.setCharacterEncoding("utf-8");
%>

<html>

	<body>
	<%
	String ip= request.getRemoteAddr(); //클라이언트의  IP를 구한다.
	try{	
		Class.forName(DRIVER); //드라이버 로딩
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String email=request.getParameter("email");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		Connection con= DriverManager.getConnection(URL, USER, PWD); //DB 연결
		String sql="insert into Myboard (writer, subject, email, content, pwd, wdate, ip) values(?, ?, ?, ?, ?, curdate(), ?)";
		
		//
		//Statment 는 실행시 인자가 들어간다.
		//PreparedStatment 생성시 인자 들어간다.
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, writer);
		pstmt.setString(2, subject);
		pstmt.setString(3, email);
		pstmt.setString(4, content);
		pstmt.setString(5, pwd);
		//날짜
		pstmt.setString(6, ip);
			//쿼리 실행
			pstmt.executeUpdate(); //dB에 저장
			
			pstmt.close();
			con.close();
			
			//response.sendRedirect("List.jsp?page=1");
	%>
		<jsp:forward page="List.jsp"></jsp:forward>	
			<%
	}catch(Exception e){
		System.out.println("SQL예외 : "+e);
		
		out.println("<script>");
		out.println("alert('SQL Error : '"+e+")");
		out.println("history.back();");
		out.println("</script>");
	}
	%>
	</body>

</html>