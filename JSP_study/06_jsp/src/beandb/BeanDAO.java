package beandb;

import	java.sql.*;

import java.util.*;


public class BeanDAO {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb1";
	private static final String USER="root";
	private static final String PWD= "12345";

	public BeanDAO(){
		
		try{
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException ex1){
			System.out.println("드라이버 로딩 실패 : "+ex1);
		}
		
	}//cons end
//=====================================================================================
	public String insertDB(BeanDto dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		String msg="";
		try{
			
			con=DriverManager.getConnection(URL,USER, PWD);
			String sql="insert into test6 values(?, ?, ?, ?, ?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getContent());
			
			int r=pstmt.executeUpdate();
			
			if(r>0){
				msg="insert 성공";			
				}else{
					msg="insert 실패";			
					
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

//=====================================================================================
	public Vector getList(){  ///////글 리스트 보기
		
		Connection con=null;
		Statement	stmt=null;
		ResultSet rs=null;
		
		String sql="select * from test6";
		Vector<BeanDto> vec=new Vector<BeanDto>(); //제너릭, 컴파일시 캐스팅 에러 잡아내기 위해서!
		
		try{
			
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				BeanDto dto = new BeanDto(
				rs.getString("id"),
				rs.getString("name"),
				rs.getString("email"),
				rs.getString("tel"),
				rs.getString("contents")	);
				//dto를 vec 에 넣는다.
				vec.add(dto);
			}//while end
			System.out.println("dto 생성 완료");
		}catch(Exception ex3){
			
			System.out.println("getList() 예외 : "+ex3);
			
			
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
	//글 수정, 글 내용보기
	public BeanDto getcontents(String id){
		
		Connection con=null;
		Statement	stmt=null;
		ResultSet rs=null;
		
		String sql= "select * from test6 where id='"+id+"'";
		BeanDto dto = null;
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			if (rs.next()) {
				dto= new BeanDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				String contents= rs.getString("contents");
				contents=contents.replace("\n", "<br>");
				
				dto.setContent(contents);
				
				
			}//if end
			
		}catch(Exception ex){
			System.out.println("getList() 예외 : "+ex);
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
				
			}catch(Exception exx){
				
			}
		}//end
		
		return dto;
	}//getcontents end
	
//=====================================================================================	
	//수정된 글을 DB에 update 합니다.
	public String updateSave(BeanDto dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update test6 set name=?, email=?, tel=?, contents=? where id=?";
		int re=-1;
		String msg="";
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getId());
			
			re= pstmt.executeUpdate();
			
			if (re>0) {
				msg="업데이트 성공";
				
			}else{
			
			}
		
		}catch(Exception ex){
			System.out.println("updateSave() 예외 : "+ex);
			msg="업데이트 실패";
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
	public void deleteDB(String id){
		
		Connection con=null;
		Statement	stmt=null;
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			
			stmt.executeUpdate("delete from test6 where id='"+id+"'");
			
			
		}catch(Exception ex2){
			System.out.println("deleteDB 예외 : "+ex2);
		}finally{
			try{
			if (stmt!=null) {stmt.close();		}
			if (con!=null) {con.close();		    }
			}catch(Exception exxx){}
			
		}//end
		
	}//deleteDB end
	
	
	/*public static void main(String[] args) {
		new BeanDAO();
	}*/
	
}//class end
