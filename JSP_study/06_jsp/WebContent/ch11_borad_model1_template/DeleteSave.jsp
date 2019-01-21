<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    %>

       <%!
    String DRIVER="com.mysql.jdbc.Driver";
    String URL="jdbc:mysql://localhost:3306/mydb1";
    String USER="root";
    String PWD="12345";
        %>

        <%
        request.setCharacterEncoding("utf-8");
        String num=request.getParameter("num");
        
        try{
        	Class.forName(DRIVER);
        	Connection con=DriverManager.getConnection(URL, USER, PWD);
       		Statement stmt=con.createStatement();
       		
       		String sql="select * from Myboard where num="+num;
            ResultSet rs = stmt.executeQuery(sql);
            
            PreparedStatement pstmt=null;
            
            if(!(rs.next())){
    			out.println("해당 자료가 없습니다.");	
            }else{
        
            String pwd=rs.getString("pwd").trim();
        	if(pwd.equals(request.getParameter("pwd"))){
        		sql="delete from Myboard where num="+num;
        		pstmt=con.prepareStatement(sql);
        		pstmt.executeUpdate();
        		
        		rs.close();
        		stmt.close();
        		pstmt.close();
        		
        		response.sendRedirect("./template.jsp?page=List.jsp?page=1");
        	}else{
        		%>
        		<script>
        		alert("비밀번호가 다릅니다.");
        		history.back();
        		</script>
        		<%
        		       		
        	}//inner else end
        	
            }//else
        con.close();
            
        }catch(Exception e){
        out.println("SQL 예외 : "+e);
        }//catch end
        %>