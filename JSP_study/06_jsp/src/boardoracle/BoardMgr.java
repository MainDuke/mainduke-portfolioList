package boardoracle;
import java.sql.*;

import java.util.*;
import boardoracle.BoardBean;


//DAO 비즈니스 로직
public class BoardMgr {

	String DRIVER="oracle.jdbc.driver.OracleDriver";
	String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	String USER="scott";
	String PWD="tiger";
	
	Connection con=null;
	Statement	stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	
	
	//cons
	public BoardMgr(){
		
		try{
			Class.forName(DRIVER);
			//System.out.println("드라이버 로딩 성공");
			
			
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패 : "+ex);
		}
		
	}//cons end
	

	//pos 증가
	public void upPos(){
		try{
			//처리문
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			sql= "update board set pos=pos+1";
			stmt.executeUpdate(sql);
			
			
		}catch(Exception ex){
			System.out.println("upPos 예외 : "+ex);
		}finally{ //파이널 sql 닫아주기 정리
			try{
			
				if (stmt!=null) {
					stmt.close();
				}
				if (con!=null) {
					con.close();}
			
			}catch(Exception exx){}
			
			
		}//finally end
	}//pos end
//===================================================================================
	public void insertBoard(BoardBean bean){
		upPos(); 
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			
			//sql="insert into board(name,email,homepage,subject,content,pos,depth,regdate,pass,ip) values(?,?,?,?,?,?,?,curdate(),?,?)";
			sql="insert into board(num, name, email, homepage, subject, content, pos, depth, regdate, pass, ip) values(board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?)";    
			
			
			pstmt=con.prepareStatement(sql);

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getHomepage());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getContent());
			pstmt.setInt(6, bean.getPos());
			pstmt.setInt(7, bean.getDepth());
			//날짜칸 자동
			pstmt.setString(8, bean.getPass());
			pstmt.setString(9, bean.getIp());
			
			pstmt.executeUpdate();

		
		}catch(Exception ex){
			System.out.println("insertBoard 예외 : "+ex);
		}finally{
			try{
			if (pstmt!=null) {	pstmt.close();	}
			if (con!=null) {con.close();}
			}catch(Exception exxx){
				
			}
		}//finally end
	}//insertBoard end
	
	
	
	
	// 글수정, DB내용 update
		//----------------------
		public void updateBoard(BoardBean bean){
			try{
				//처리문
				con=DriverManager.getConnection(URL,USER,PWD);
				String sql="update board set name=?, email=?, homepage=?, subject=?, content=? where num=?";
				
				pstmt=con.prepareStatement(sql);
				//? 앞채우기
				
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getEmail());
				pstmt.setString(3, bean.getHomepage());
				pstmt.setString(4, bean.getSubject());
				pstmt.setString(5, bean.getContent());
				pstmt.setInt(6, bean.getNum());
				
				pstmt.executeUpdate();//쿼리수행
				
			}catch(Exception ex){
				System.out.println("updateBoard() 예외 :"+ex);
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}
		}
		
	
	
	//-----------------------------
	//조회수 증가
	//-----------------------------
	
	public void upCount(int num){
		try{
			con=DriverManager.getConnection(URL,USER,PWD);//db연결
			sql="update board set count=count+1 where num="+num;
			pstmt=con.prepareStatement(sql);//생성시 인자 호출
			pstmt.executeUpdate();//쿼리수행
		
		}catch(Exception ex1){
			System.out.println("upCount() 예외 :"+ex1);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}
	}//upCount end()
	
	
	//------------------------------------------
		//답글 위치 확보
		//------------------------------------------
		public void replyPos(BoardBean bean){
			try{
				con=DriverManager.getConnection(URL,USER,PWD);
				String sql="update board set pos=pos+1 where pos>?";
				pstmt=con.prepareStatement(sql);//생성지 인자 들어감
				
				pstmt.setInt(1, bean.getPos());
				pstmt.executeUpdate();//쿼리 수행
				
			}catch(Exception ex1){
				System.out.println("replyPos() 예외 :"+ex1);
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}//finally
		}//replyPos() end	
		
		//---------------------------------
		//답글 쓰기
		//--------------------------------
		public void replyBoard(BoardBean bean){
			
		try{
			//처리문
			con=DriverManager.getConnection(URL,USER,PWD);
			int depth=bean.getDepth()+1;//글 깊이
			int pos=bean.getPos()+1; //현재글 위치 + 1
			//sql="insert into board(name,email,homepage,subject,content,pos,depth,regdate,pass,count,ip) values(?,?,?,?,?,?,?,NOW(),?,?,?)";
			
			sql="insert into board(num, name,email,homepage,subject,content,pos,depth,regdate,pass,count,ip) values(board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
			
			pstmt=con.prepareStatement(sql);//생성시 인자 들어감
			//? 채우기
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getHomepage());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getContent());
			pstmt.setInt(6, pos);
			pstmt.setInt(7, depth);
			//날짜
			pstmt.setString(8, bean.getPass());
			pstmt.setInt(9, bean.getCount());
			pstmt.setString(10, bean.getIp());
			
			pstmt.executeUpdate();//쿼리수행
			//? 채우기
			
		}catch(Exception ex){
			System.out.println("replyBoard() end : "+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		
			}
		}
		//-------------------------------------
//===================================================================================
public Vector getBoardList(String keyField, String keyWord){
	
	Vector vec = new Vector();
	sql="";
	
	try{
		con=DriverManager.getConnection(URL,USER, PWD);
		stmt=con.createStatement();
	
		
		if(keyWord.equals(null) || keyWord.equals("")){
			sql="select * from board order by pos asc";
		}else{//글 검색
				sql="select * from board where "+keyField+" like '%"+keyWord+"%' order by pos asc";
			
		}//else
		
		rs=stmt.executeQuery(sql);

		while(rs.next()){
			BoardBean bean= new BoardBean();
			bean.setNum(rs.getInt("num"));
			bean.setName(rs.getString("name"));
			bean.setEmail(rs.getString("email"));
			
			bean.setHomepage(rs.getString("homepage"));
			bean.setSubject(rs.getString("subject"));
			bean.setContent(rs.getString("content"));
			
			bean.setPos(rs.getInt("pos"));
			bean.setDepth(rs.getInt("depth"));
			bean.setRegdate(rs.getString("regdate"));
			
			bean.setPass(rs.getString("pass"));
			bean.setCount(rs.getInt("count"));
			bean.setIp(rs.getString("ip"));
			
			vec.add(bean);
						
		}//end while
		
	}catch(Exception ex){
		System.out.println("getBoardList 예외 : "+ex);
	}finally{
		try{
			if (rs!=null) {	pstmt.close();	}
			if (stmt!=null) {	pstmt.close();	}
			if (con!=null) {con.close();}
			}catch(Exception exxx){
				
			}
	}
	
	return vec;
	
}//end getBoardList

//글 내용보기, 글수정
	//-------------------------
	public BoardBean getBoard(int num){
		BoardBean bean=new BoardBean();
		try{
			//처리문
			con=DriverManager.getConnection(URL,USER,PWD);//DB연결
			String sql="select * from board where num="+num;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//쿼리 수행
		
			while(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setHomepage(rs.getString("homepage"));
				bean.setSubject(rs.getString("subject"));
				
				bean.setContent(rs.getString("content"));
				bean.setPos(rs.getInt("pos"));
				bean.setDepth(rs.getInt("depth"));
				
				bean.setRegdate(rs.getString("regdate"));
				bean.setPass(rs.getString("pass"));
				bean.setCount(rs.getInt("count"));
				bean.setIp(rs.getString("ip"));
				
			}//while end
			
		}catch(Exception ex){
			System.out.println("getBoard() 예외 :"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
		}catch(Exception exx){}
		}
		return bean;
	}//getBoard() end
	
	//-------------------------------------
		//글삭제
		//-----------------------------------
		public void deleteBoard(int num){
			try{
				con=DriverManager.getConnection(URL,USER,PWD);
				sql="delete from board where num="+num;
				pstmt=con.prepareStatement(sql);
				pstmt.executeUpdate();
			}catch(Exception ex2){
				System.out.println("deleteBoard() 예외 :"+ex2);
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}
		}
		//--------------------------------------------
	
	
	/*
	public static void main(String[] args) {
		new BoardMgr();
	}
	*/
}//class end
