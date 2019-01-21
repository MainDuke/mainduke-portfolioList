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
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException ex1){
			System.out.println("����̹� �ε� ���� : "+ex1);
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

//=====================================================================================
	public Vector getList(){  ///////�� ����Ʈ ����
		
		Connection con=null;
		Statement	stmt=null;
		ResultSet rs=null;
		
		String sql="select * from test6";
		Vector<BeanDto> vec=new Vector<BeanDto>(); //���ʸ�, �����Ͻ� ĳ���� ���� ��Ƴ��� ���ؼ�!
		
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
				//dto�� vec �� �ִ´�.
				vec.add(dto);
			}//while end
			System.out.println("dto ���� �Ϸ�");
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
			System.out.println("getList() ���� : "+ex);
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
	//������ ���� DB�� update �մϴ�.
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
				msg="������Ʈ ����";
				
			}else{
			
			}
		
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
	public void deleteDB(String id){
		
		Connection con=null;
		Statement	stmt=null;
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			
			stmt.executeUpdate("delete from test6 where id='"+id+"'");
			
			
		}catch(Exception ex2){
			System.out.println("deleteDB ���� : "+ex2);
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
