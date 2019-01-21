<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
	import="java.myutil.*"    
    %>
    
    <%-- write.jsp--%>
    
    <%
    request.setCharacterEncoding("utf-8");
	/*
	인자
	mode : 작업모드
	modify: 수정: 암호 입력 받기전
	modify_ok : 수정:암호 받은 후
	update : 데이터 업데이트
	insert : 새글 저장
		
	year : 년도
	month : 월
	day : 일
	id : 고유 번호
	subject : 제목
	content : 내용
	
	*/
    Connection con= null;
    Statement stmt = null;
    PreparedStatement pstmt=null;
	ResultSet rs=null;
    
    
    String mode = request.getParameter("mode");
    if(mode==null){
    	mode="";
    }
    
    String id = request.getParameter("id"); //수정할때 필요.
 
 

    //======================================
    String year= request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    
    String subject = request.getParameter("subject");
    String contents = request.getParameter("contents");
    if(subject == null){subject="";}
    if(contents== null){contents="";} //표시 null 때문에
    //======================================
    
    try{
    	//String user_id = (String)session.getAttribute("userid");
    	String user_id ="park"; 
    	String sql=""; //변수
    	String created="";
    	
    	myutil.DBConnection db = new myutil.DBConnection();
    	con=db.getCon();
    	stmt=con.createStatement();
    	
    	if(mode.equals("modify")){ //수정하기 위해
    		
    		sql= "select * from whre id="+id;
    		rs= stmt.executeQuery(sql);
    		
    		if(rs.next()){
    		
    			year=rs.getString("year");
    			month=rs.getString("month");
    			subject=rs.getString("subject");
    			day=rs.getString("day");
    			contents=rs.getString("contents");
    			created=rs.getString("created");
    			mode="update";
    			
    		}//end
    		rs.close();
    	
    	}else if(mode.equals("insert")){
    		
    		sql="insert into diary values(0, ?, ?, ?, ?, ?, curdate(), ?)";
    		
    		pstmt=con.prepareStatement(sql);
    		
    		pstmt.setString(1, year);
    		pstmt.setString(2, month);
    		pstmt.setString(3, day);
    		pstmt.setString(4, subject);
    		pstmt.setString(5, contents);
    		pstmt.setString(6, user_id);
			pstmt.executeUpdate(); //쿼리 실행
			
			response.sendRedirect("calendar.jsp");
    		
    	}else if(mode.equals("update")){//수정작업
    		
    		sql="update diary set year=?, month=?, day=?, subject=?, contents=?, where id="+id;
    		
    	pstmt=con.prepareStatement(sql);
    	
    	pstmt.setString(1, year);
    	pstmt.setString(2, month);
		pstmt.setString(3, day);
		pstmt.setString(4, subject);
		pstmt.setString(5, contents);
		pstmt.executeUpdate(); //쿼리 실행	
		
		response.sendRedirect("calendar.jsp");
    	
    	}else{
    		mode="insert"; //새글 저장 위해
    	}//if 조건절 end
    	
    	
    }catch(Exception ex){
    	System.out.println("에러 "+ex);
    	ex.printStackTrace();
    }finally{
    	stmt.close();
    	con.close();
    }
    
	%>
	<!-- 글쓰기 화면과 수정화면 -->
	<html>
	<head>
	<title>다이어리</title>
	</head>
	<body>
	<form method="post" action="write.jsp">
	<table width=600 border=1 cellspacing=0 cellpadding=3 align=center>
	
	<tr>
	<td width=22% align=center bgcolor=cornflowerblue>날짜</td>
	<td width=78% bgcolor="FFCCFF">
		<input type="text" name="year" value=<%=year %> size=4>년
		<input type="text" name="month" value=<%=month %> size=2>월
		<input type="text" name="day" value=<%=day %> size=2>일
	</td>
	</tr>
	
	<tr>
	<td width=22% align=center bgcolor=cornflowerblue>제목</td>
	<td width=78% bgcolor="FFCCFF">
		<input type="text" name="subject" value="<%=subject %>" size=50 maxlength="100">
	</td>
	</tr>
	
	<tr>
	<td width=22% align=center bgcolor=cornflowerblue>내용</td>
	<td width=78% bgcolor="FFCCFF">
		<textarea  name="contents"  col=60 rows=10><%=contents %></textarea>
	</td>
	</tr>
	</table>
	
	<table width=600 border=1 cellspacing=0 cellpadding=3 align=center>
	<tr align=center>
		<td colspan=2 bgcolor=CCFFCC>
			<input type="hidden" name="mode" value=<%=mode %>>
			<input type="hidden" name="id" value=<%=id %>>
			
			<input type="submit" value="전송">
			<input type="button" value="취소"  onClick="location='calendar.jsp'">
		</td>
	</tr>
	</table>
	
	</form>
	
	</body>
	</html>
	
	
    