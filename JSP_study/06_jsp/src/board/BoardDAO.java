package board;

import java.sql.*;


import javax.servlet.*;
import javax.servlet.http.*;

import beandb.BeanDto;

import java.util.*;


public class BoardDAO {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb1";
	private static final String USER="root";
	private static final String PWD= "12345";

	public BoardDAO(){
		
		try{
			Class.forName(DRIVER);
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException ex1){
			System.out.println("����̹� �ε� ���� : "+ex1);
		}
		
	}//cons end
//�� �Է�...................................===================================================================
	public String insertDB(BoardDto dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		String msg="";
		
		//String ip= request.getRemoteAddr();
		try{
			
			con=DriverManager.getConnection(URL,USER, PWD);
			//String sql="insert into Myboard values(?, ?, ?, ?, ?, curdate(), ?)";
			String sql="insert into Myboard (writer, subject, email, content, pwd, wdate, ip) values(?, ?, ?, ?, ?, curdate(), ?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getPwd());
			pstmt.setString(6, dto.getIp());
			
			int r=pstmt.executeUpdate();
			
			if(r>0){
				msg="insert ����";			
				}else{
					msg="insert ����";			
					
				}//if end
			
		}catch(Exception e2){
			msg+=e2;
		}finally{
			try{
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();
					
				}
			}catch(Exception ex2){
				
			}
		}//end final
		return msg;
	}//end custom
//===========================================================================================
public Vector getList(){  ///////�� ����Ʈ ����
		
		Connection con=null;
		Statement	stmt=null;
		ResultSet rs=null;
		
		String sql="select * from Myboard";
		Vector<BoardDto> vec=new Vector<BoardDto>(); //���ʸ�, �����Ͻ� ĳ���� ���� ��Ƴ��� ���ؼ�!
		
		try{
			
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			/*
			 * int num=rs.getInt("num");
 		String subject=rs.getString("subject");
 		//String email=rs.getString("email");
 		String writer=rs.getString("writer");
 		String wdate=rs.getString("wdate");
 		int readcount=rs.getInt("readcount");
			 * */
			while(rs.next()){
				BoardDto dto = new BoardDto(
				rs.getInt("num"),
				rs.getString("writer"),
				rs.getString("subject"),
				rs.getString("email"),
				rs.getString("wdate"),
				rs.getInt("readcount")
				);
								
				//dto�� vec �� �ִ´�.
				vec.add(dto);
			}//while end
			
		}catch(Exception ex3){
			
			System.out.println("getList() ���� : "+ex3);
			
			
		}finally{
			try{
				if (rs!=null) {
					rs.close();
				}
				
				if (stmt!=null) {
					stmt.close();
				}
				if (con!=null) {
					con.close();}
				}catch(Exception ex4){
				
			}//try  end
		}//final end
		
		
		System.out.println(vec);
		return vec;
	}//getList() end

//=====================================================================================
	//�� ����, �� ���뺸��
	public BoardDto getContent(String num){
		
		PreparedStatement pstmt=null;
		Connection con=null;
		Statement	stmt=null;
		ResultSet rs=null;
		
		int readcount=0; //��ȸ���� �ٷ� ���� ����
		
		String sql= "select * from Myboard where num='"+num+"'";
		BoardDto dto = null;
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			/*
				private int num;
				private String wirter;
				private String subject;
				private String email;
				private String content;
				private int pwd;
				private String date;
				private int readcount;
				private String ip;
			 */
			
			if (rs.next()) {
				dto= new BoardDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setEmail(rs.getString("email"));
				
				String contents= rs.getString("content");
				contents=contents.replace("\n", "<br>");
				dto.setContent(contents);
				dto.setDate(rs.getString("wdate"));
				
				readcount=rs.getInt("readcount");
				dto.setReadcount(readcount);
				dto.setIp(rs.getString("ip"));
				dto.setPwd(rs.getInt("pwd"));
				
				readcount++;
			}//if end
			
			 sql="update myboard set readcount=? where num=?";
			    pstmt=con.prepareStatement(sql);
			    pstmt.setInt(1, readcount);
			    pstmt.setInt(2, Integer.parseInt(num));
			    pstmt.executeUpdate(); //������ ����
			  
			
		}catch(Exception ex){
			System.out.println("getContent() ���� : "+ex);
		}finally{
			try{
				if (rs!=null) {
					rs.close();
				}
				if (pstmt !=null) {
					pstmt.close();
					}
			
					if (stmt!=null) {
					stmt.close();
				}
				if (con!=null) {
					con.close();}
				
			}catch(Exception exx){
				
			}
		}//end
		
		return dto;
	}//getcontents end
	
//=====================================================================================
	//������ ���� DB�� update �մϴ�.
		public String updateSave(BoardDto dto){
			Connection con=null;
			PreparedStatement pstmt=null;
		
			String msg="";
			
			try{
				
				String sql="update Myboard set writer=?, subject=?, email=?, content=? where num=?";
				con=DriverManager.getConnection(URL,USER, PWD);
				
				pstmt=con.prepareStatement(sql);
				
				
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getContent());
				pstmt.setInt(5, dto.getNum());
				
				pstmt.executeUpdate();
				
				msg="������Ʈ ����";
			}catch(Exception ex){
				System.out.println("updateSave() ���� : "+ex);
				msg="������Ʈ ����";
			}finally{
				try{
				if (pstmt!=null) {
					pstmt.close();
				}
				if (con!=null) {
					con.close();}
				}catch(Exception ex5){
					
				}
				
			}//final end
			
			
			return msg;
			
		}// updateSave end
	//=====================================================================================	
		public void deleteDB(String num){
			
			Connection con=null;
			Statement	stmt=null;
			
			try{
				con=DriverManager.getConnection(URL,USER, PWD);
				stmt=con.createStatement();
				
				stmt.executeUpdate("delete from Myboard where num='"+num+"'");
				
				
			}catch(Exception ex2){
				System.out.println("deleteDB ���� : "+ex2);
			}finally{
				try{
				if (stmt!=null) {stmt.close();		}
				if (con!=null) {con.close();		    }
				}catch(Exception exxx){}
				
			}//end
			
		}//deleteDB end
		
		
		/*
	public static void main(String[] args) {
		new BoardDAO();
	}*/
	
}//class end
