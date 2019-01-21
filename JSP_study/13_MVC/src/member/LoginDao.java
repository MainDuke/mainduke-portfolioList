package member;
import java.sql.*;
import javax.naming.*;
import member.*;
import java.util.*;
import javax.sql.*;


public class LoginDao {

	private static LoginDao intance=new LoginDao(); //싱글톤 객체를 하나만 사용하도록 한다. 메모리 할당이 된다.
	

	public static LoginDao getInstance(){
		return intance;
	}//getInstance 
	
	private LoginDao(){} //디폴트 생성자, 외부에서 객체 생성 못한다. 
	
	
	public Connection getConnection() throws Exception{
		Context ct = new InitialContext();
		Context envCtx =(Context)ct.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/mysql");
	
		return ds.getConnection();
	}//end getConnection();
//=========================================================================================
	//회원 가입.
	public void insertMember(LoginDto dto) throws Exception{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getJumin1());
			pstmt.setString(5, dto.getJumin2());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getZipcode());
			pstmt.setString(8, dto.getAddr());
			pstmt.setString(9, dto.getJob());
			pstmt.setString(10, dto.getBlog());
			pstmt.setTimestamp(11, dto.getRegdate());			
			
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("insertMember() 예외 "+ex);
		}finally{
			try{
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
				
			}catch(Exception ex1){}
		}//end
		
	}//insert Member end
//=========================================================================================
	//id 체크
	public int confirmId(String id) throws Exception{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		int x=-1;
		try{
			con=getConnection();
			pstmt=con.prepareStatement("select id from member where id=?");
			
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				x=1;
			}else{
				x=-1;
			}
			
		}catch(Exception exx){
			System.out.println("confirmId() 예외 "+exx);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
				
			}catch(Exception ex2){}
		}//finally end
		return x;
	}//confirmId end
	
	//=========================================================================================
	public Vector<ZipcodeDto> zipcodeRead(String area3){
				
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		Vector<ZipcodeDto> vec= new Vector<ZipcodeDto>();
		
		try{
				con=getConnection();//커넥션 얻기
				String sql="select * from zipcode where area3 like '%"+area3+"%'";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					ZipcodeDto dto=new ZipcodeDto();
					dto.setZipcode(rs.getString("zipcode"));
					dto.setArea1(rs.getString("area1"));
					dto.setArea2(rs.getString("area2"));
					dto.setArea3(rs.getString("area3"));
					dto.setArea4(rs.getString("area4"));
					vec.add(dto);
				}//while
		
		}catch(Exception exxx){			
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex3){}
		}//finally
		
		return vec;
	}//zipcodeRead end

	//============================================================================================
	//로그인 인증
	//-----------------------------------------------------------------------
	
public int userCheck(String id, String passwd) throws Exception{
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	
	String dbPwd="";
	int x=-1;
	
	try{
		con=getConnection();
		pstmt=con.prepareStatement("select * from member where id=?");
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			dbPwd=rs.getString("password");
			if (passwd.equals(dbPwd)) {
				x=1; //인증 성공
			}else{
				x=0; //암호 틀림
			}//else end
		}//if end
		
		
	}catch(Exception exxxx){
		System.out.println("userCheck 예외 ="+exxxx);
	}finally{
		try{
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(con != null){con.close();}
		}catch(Exception e3){}
	}//finally end
	
	return x;
}//userCheck
	

//============================================================================================
//회원 정보 수정 : 웹에 출력
//-----------------------------------------------------------------------
public LoginDto getMember(String id) throws Exception{
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	LoginDto dto=null;
	
	try {
		con=getConnection();
		pstmt=con.prepareStatement("select * from member where id='"+id+"'");
		rs=pstmt.executeQuery();

		if(rs.next()){
		dto=new LoginDto();
		
		dto.setId(rs.getString("id"));
		dto.setPasswd(rs.getString("password"));
		dto.setName(rs.getString("name"));
		
		dto.setJumin1(rs.getString("jumin1"));
		dto.setJumin2(rs.getString("jumin2"));
		dto.setEmail(rs.getString("email"));
		
		dto.setZipcode(rs.getString("zipcode"));
		dto.setAddr(rs.getString("addr"));
		
		dto.setJob(rs.getString("job"));
		dto.setBlog(rs.getString("blog"));
		dto.setRegdate(rs.getTimestamp("regdate"));
				
			
		}//if end
		
	
		
	} catch (Exception e5) {
		System.out.println("getMember 예외"+e5);
	}finally{
		try {
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(con != null){con.close();}
		} catch (Exception e6) {	}
		
	}//finally end
	return dto;
}//getMember end

//============================================================================================
//회원 정보 수정 : DB 수정
//-----------------------------------------------------------------------
public void updateMember(LoginDto dto) throws Exception{
	Connection con=null;
	PreparedStatement pstmt=null;
	
	try {
		con=getConnection();
		String sql="update member set password=?, name=?, email=?, zipcode=?, addr=?, job=?, blog=? where id=?";
		pstmt=con.prepareStatement(sql);
		
		//String pw=dto.getPasswd();
		pstmt.setString(1, dto.getPasswd());
		pstmt.setString(2, dto.getName());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getZipcode());
		pstmt.setString(5, dto.getAddr());
		pstmt.setString(6, dto.getJob());
		pstmt.setString(7, dto.getBlog());
		pstmt.setString(8, dto.getId());
		
		pstmt.executeUpdate();
		
	} catch (Exception e7) {
		System.out.println("updateMember 예외"+e7);
	}finally{
		try {

			if(pstmt != null){pstmt.close();}
			if(con != null){con.close();}
		} catch (Exception e8) {}
		
	}//finally end
}//updateMember end


//============================================================================================
//회원 탈퇴
//-----------------------------------------------------------------------

public int deleteMember(String id, String pwd) throws Exception{
	
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt2=null;
	ResultSet rs= null;
	String dbPwd="";
	int x=-1;
	
	try {
		con=getConnection();
		pstmt=con.prepareStatement("select password from member where id=?");
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		
		if (rs.next()) {
			dbPwd=rs.getString("password");
		
			if (dbPwd.equals(pwd)) {
				pstmt2=con.prepareStatement("delete from member where id=?");
				pstmt2.setString(1, id);
				pstmt2.executeUpdate();
				x=1;//회원 탈퇴
				
			}else{
				x=-1;
			}
			
		}//if end
		
	} catch (Exception e9) {
		System.out.println("deleteMember 예외"+e9);
	}finally{
		try {
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(pstmt2 != null){pstmt2.close();}
			if(con != null){con.close();}
		} catch (Exception e10) {}
		
	}//finally end
	
	return x;
}//deleteMember end

}//class end






