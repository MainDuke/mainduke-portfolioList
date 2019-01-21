package jdbc;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class DBCPInit2 extends HttpServlet{
	Connection con=null;
	Statement stmt= null;
	ResultSet rs=null;
	String url ;
	String user ;
	String pwd ;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		try {
			/*
			url =getInitParameter("jdbcUrl");
			 user =getInitParameter("dbUser");
			 pwd =getInitParameter("dbPwd");
			
			con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from sangpum");
		*/
			while (rs.next()) {
		
				String title = rs.getString("title");
				String imgfile= rs.getString("imgfile");
				String imghtml= rs.getString("imghtml");
				String content= rs.getString("content");
			System.out.println(title+"---"+imgfile+"---"+imghtml+"---"+content);
			}//while
			rs.close();
			stmt.close();
			con.close();
			} catch (Exception e9) {
				System.out.println("SQL ����"+e9);
				
			}
		
	}//end
	
	public void init() throws ServletException{
		loadJDBCDriver(); //�޼��� ȣ��.
		initConnectionPool(); //�޼��� ȣ��.
	
	}//init end
	
	public void loadJDBCDriver(){
		
		String driverClass=getInitParameter("jdbcdriver");
		try{
				Class.forName(driverClass);
		}catch(ClassNotFoundException ex1){
				throw new RuntimeException("����̹� �ε� ����"+ex1);
			
		}
		}//load JDBCDriver end
	
	
	
	private void initConnectionPool(){
	try {
		url =getInitParameter("jdbcUrl");
		user =getInitParameter("dbUser");
		pwd =getInitParameter("dbPwd");
		
		con=DriverManager.getConnection(url, user, pwd);
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from sangpum");
	
		/*
		while (rs.next()) {
	
			String title = rs.getString("title");
			String imgfile= rs.getString("imgfile");
			String imghtml= rs.getString("imghtml");
			String contetn= rs.getString("content");
		System.out.println(title+"---"+imgfile+"---"+imghtml+"---"+content);
		}//while
		rs.close();
		stmt.close();
		con.close();*/
		} catch (Exception e2) {}
		
	}//end initConnectionPool
	
	
	
}//class end
