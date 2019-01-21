<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    import="myutil.*"
    
    %>

<%
request.setCharacterEncoding("utf-8");

Connection con= null;
Statement stmt = null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String id = request.getParameter("id"); //수정할때 필요.
String user_id = (String)session.getAttribute("userid");
user_id ="park"; 

String year="";
String month="";
String day="";
String subject="";
String contents="";
String created="";
String sql="";

myutil.DBConnection db= new myutil.DBConnection();
con=db.getCon();
stmt=con.createStatement();
try{
	
	sql="select * from diary where id="+id;
	rs=stmt.executeQuery(sql);
	if(rs.next()){
		year=rs.getString("year");
		month=rs.getString("month");
		day=rs.getString("day");
		subject=rs.getString("subject");
		contents=rs.getString("contents");
		created=rs.getString("created");
		
	}
	rs.close();
	
}catch(Exception e){
	System.out.println("에러 "+e);
}

stmt.close();
con.close();

%>
<html>
<head>
<title>다이어리</title>
<script type="text/javascript">
function del(id){
	if(confirm("삭제를 하시겠습니까?")){
		location="delete.jsp?id="+id;
	}

}//del end
</script>
</head>
<body bgcolor="margenta">
<table width=600  border=1 cellspacing=0 cellpadding=3 align=center>
<tr>
<td width=20% align=center>날짜</td>
<td width=80%><%=year %>년 <%=month %>월 <%=day %>일</td>
</tr>

<tr>
<td width=20% align=center>제목</td>
<td width=80%><%=subject %></td>
</tr>

<tr>
<td width=20% align=center>작성일자</td>
<td width=80%><%=created %></td>
</tr>

<tr>
<td width=20% align=center>글내용</td>
<td>
<textarea readonly="readonly" rows=10 cols=55><%=contents %></textarea>
</td>
</tr>

</table>

<table width=600 border=0 cellspacing=0 cellpadding=3 align=center>
<tr align=center>
<td colspan=2>
<input type=button value="달력" onClick="location='calendar.jsp'">
<input type=button value="수정" onClick="location='write'.jsp?mode=modify&id=<%=id%>'">
<input type=button value="삭제" onClick="del(<%=id%>)">

</td>
</tr>
</table>

</body>
</html>

    