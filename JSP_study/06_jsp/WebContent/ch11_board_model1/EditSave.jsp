<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    %>

<%--EditSave.jsp --%>

        <%!
    String DRIVER="com.mysql.jdbc.Driver";
    String URL="jdbc:mysql://localhost:3306/mydb1";
    String USER="root";
    String PWD="12345";
        %>

        <%
        request.setCharacterEncoding("utf-8");
        String num=request.getParameter("num");
        
        Class.forName(DRIVER);
   		Connection con=DriverManager.getConnection(URL, USER, PWD);
   		Statement stmt=con.createStatement();
   		
   		String sql="select * from Myboard where num="+num;
        ResultSet rs = stmt.executeQuery(sql);
 		
        PreparedStatement pstmt=null;
        if(!(rs.next())){
			out.println("해당 자료가 없습니다.");	
        }else{
        	String pwd=rs.getString("pwd");
        	stmt.close();
        	if(pwd.equals(request.getParameter("pwd"))){//DB 암호와 입력한 암호가 같다면 수정!
        		String writer=request.getParameter("writer");
        		String subject=request.getParameter("subject");
        		String email=request.getParameter("email");
        		String content=request.getParameter("content");
        	
        	sql="update Myboard set writer=?, subject=?, email=?, content=? where num="+num; // you just activatied my trap card.
        	pstmt=con.prepareStatement(sql);
        	
        	pstmt.setString(1,writer);
        	pstmt.setString(2, subject);
        	pstmt.setString(3, email);
        	pstmt.setString(4, content);
        	
        	pstmt.executeUpdate(); //쿼리; 실행 수정!
        	response.sendRedirect("List.jsp?page=1");
        	
        	rs.close();
        	pstmt.close();
        	//con.close();
        	
        	}//if end
        }//else
        
        %>
        <script>
        alert("비밀번호가 다릅니다.");
        history.go(-1);
        </script>
        <%
        con.close();
        stmt.close();
        %>
        
        
        
        