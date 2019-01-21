<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    import="myutil.*"
    %>
    <%
    Connection con=null;
    Statement stmt=null;
    
    String id=request.getParameter("id");
    String user_id=(String)session.getAttribute("userid");
    user_id="park";
    
    String sql= new String();
    myutil.DBConnection db= new myutil.DBConnection();
    
    if(user_id != null){
    	
    	try{
    		System.out.println("try 진입 성공");
    		con=db.getCon();
    		stmt=con.createStatement();
    		sql="delete from diary where id="+id;
    		stmt.executeUpdate(sql);
    	
    	}catch(Exception e){
    		System.out.println("예외 : "+e );
    	}//catch end
    	con.close();
    	stmt.close();
    	response.sendRedirect("calendar.jsp");
    }//if end
    
    %>

    
    
    
    
    
    