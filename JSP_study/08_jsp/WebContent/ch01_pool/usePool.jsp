<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.sql.*"
    import="javax.sql.*"
    import="javax.naming.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>커넥션 풀 사용</h2>
<table width="70%" border="10">

<tr>
<td width="100">글쓴이</td>
<td width="150">Email</td>
<td width="200">주소</td>
</tr>

<%  
Connection con=null;
Statement stmt= null;
ResultSet rs= null;

try{
	Context ct = new InitialContext();
	//	Context envCt=(Context)ct.lookup("java:comp/env");
	//DataSource ds=(DataSource)envCt.lookup("jdbc/mysql");
	
	
	Context envCtx =(Context)ct.lookup("java:comp/env");
	DataSource ds = (DataSource)envCtx.lookup("jdbc/mysql");

	//DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/mysql");
	con = ds.getConnection();
	
	stmt=con.createStatement(); //statement 생성, 
	rs=stmt.executeQuery("select * from test");
	
	/*
	★Context ct = new InitialContext(); //현재 환경의 naming Context 획득하기
	
	InitialContext()는 웹 어플리케이션이 처음으로 배치될때 설정되고 모든 설정된 에트리와 자원은 JNDI namespace 의 java:comp/env 부분에 놓이게 된다.
	그래서 자원 접근을 Context ct = new InitialContext*(; 이렇게 합니다.)
	
	★Context envCt=(Context)ct.lookup("java:comp/env");
	JNDI에 등록된 생성할 자원 이름( 즉, 컨텍스트에 대한 상대적인 이름)
	
	★DataSource ds=(DataSource)envCt.lookup("jdbc/mysql");
	//server.xmp, context.xml , xeb.xml에 설정해놓은 이름.
	*/
	
	
	
	while(rs.next()){
		String name=rs.getString("name");
		String email=rs.getString("email");
		String addr= rs.getString("addr");
	
	%>
	<tr>
	<td><%=name %></td>
	<td><%=email %></td>
	<td><%=addr%></td>
	</tr>
	
<%
	}//while
		rs.close();
		stmt.close();
	con.close();
		
}catch(Exception ex){}

%>




</table>

</body>
</html>