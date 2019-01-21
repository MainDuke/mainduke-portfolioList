package boardmysql;
//비지니스 로직 : DAO

//커넥션 풀 사용 

import java.sql.*;

import javax.sql.*;//DataSource
import javax.naming.*;//lookup

import java.util.*;
import java.util.Date;

public class BoardDao {
	
	private static BoardDao instance=new BoardDao();//싱글톤 사용 
	
	//jsp에서 사용할 메서드
	public static BoardDao getInstance(){
		return instance;
	}
	
	private BoardDao(){}//생성자 
	
	//--------------------------------------------
	
	//커넥션 얻기
	private Connection getConnection() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");//###
		return ds.getConnection();
	}//getConnection()
	
	//--------------------------------------------	
	// 원글, 답글
	//--------------------------------------------	
	public void insertArticle(BoardDto dto) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int num=dto.getNum(); // 글번호
		int ref=dto.getRef(); // 답글 그룹
		int re_step=dto.getRe_step(); // 글 순서
		int re_level=dto.getRe_level(); // 글 깊이
		
		int number=0; //board 테이블에 들어갈 글번호
		String sql="";
		
		try {
			//처리문
			con=getConnection();//커넥션 얻기
			pstmt=con.prepareStatement("select max(num) from board3");//최대 글번호 얻기 
			
			rs=pstmt.executeQuery();//쿼리 수행
			
			if(rs.next()){//글이 존재하면
				number=rs.getInt(1)+1;
			}else{//글이 없을 때
				number=1;//첫번째 글
			}
			
			if(num!=0){//답글이면
				
				//답글 끼워넣기 위치 확보
				sql="update board3 set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);//생성시 인자 들어감
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();//쿼리수행, insert, update, delete => executeUpdate()
				//						select = executeQuery 
				re_step=re_step+1;
				re_level=re_level+1;
			}else{//원글
				ref=number;//글 그룹번호, 현재 글번호를 ref에 넣어준다
				re_step=0;
				re_level=0;
			}//else
			
			sql="insert into board3(writer,email,subject,passwd,regdate,ref,re_step,re_level,content,ip)"
				+" values(?,?,?,?,NOW(),?,?,?,?,?)";
				// NOW() : 날짜 시분초
				// curdate() : 날짜
				// sysdate : 오라클
			
			pstmt=con.prepareStatement(sql);// 생성시 인자 들어간다
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getPasswd());
			//pstmt.setDate(5, dto.getRegdate());
			
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, dto.getContent());
			pstmt.setString(9, dto.getIp());
			
			pstmt.executeUpdate();// 쿼리 수행			
			
		} catch (Exception ex) {
			System.out.println("insertArticle() 예외 :"+ex);
		} finally{
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally end
	}//insertArticle() end
	
	//-----------------------------	
	// 글 갯수
	//-----------------------------	
	public int getArticleCount() throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=0;
		
		try{
			con=getConnection();//커넥션 얻기
			pstmt=con.prepareStatement("select count(*) from board3");			
			rs=pstmt.executeQuery();//쿼리 수행
			
			if(rs.next()){//글이 존재하면
				x=rs.getInt(1);//글 갯수
			}//if
			
		}catch(Exception ex1){
			System.out.println("getArticleCount() 예외 :"+ex1);
		}finally{
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception ex2) {}
		}//finally end
		return x;
	}//getArticleCount() end
	
	//-----------------------------	
	// 리스트
	//-----------------------------
	public List getList(int start, int cnt) throws Exception{
		//mysql에서 int start(시작위치), int end(갯수)
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDto> list=null;// Vector 대신 List, ArrayList 사용 
		
		try {
			//처리문
			con=getConnection();//커넥션 얻기
			pstmt=con.prepareStatement("select * from board3 "
					+ "order by ref desc, re_step asc limit ?,?");
													//limit 시작위치, 글 갯수
			pstmt.setInt(1, start-1);//시작위치
			pstmt.setInt(2, cnt);//글 갯수
			rs=pstmt.executeQuery();//쿼리 수행
			
			if(rs.next()){
				list=new ArrayList<BoardDto>();
				
				do{
					BoardDto dto= new BoardDto();//모델빈 객체 생성
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));
					
					//System.out.println(rs.getDate("regdate"));
					//System.out.println(rs.getString("regdate"));
					
					dto.setRegdate(rs.getTimestamp("regdate"));
					
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					
					list.add(dto); //list에 넣기
					  
					
				}while(rs.next());
				
			}//if
			
			
		} catch (Exception ex) {
			System.out.println("getList() 예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception exx){}
		}//finally end
		return list;//***
	}//getList() end
	
//============================================================
	public BoardDto getArticle(int num) throws Exception{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDto dto=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("update board3 set readcount=readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("select * from board3 where num=?");
			pstmt.setInt(1, num);
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				 dto =new BoardDto();
				 dto.setNum(rs.getInt("num"));
				
				 dto.setWriter(rs.getString("writer"));
				 dto.setEmail(rs.getString("email"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setPasswd(rs.getString("passwd"));
				
				 dto.setRegdate(rs.getTimestamp("regdate"));
				
				 dto.setReadcount(rs.getInt("readcount"));
				 dto.setRef(rs.getInt("ref"));
				 dto.setRe_step(rs.getInt("re_step"));
				 dto.setRe_level(rs.getInt("re_level"));
				
				 dto.setContent(rs.getString("content"));
				 dto.setIp(rs.getString("ip"));
			}//if
			
		}catch(Exception ex){
			System.out.println("getArticle 예외: "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
				
			}catch(Exception exx){
				
			}//end
			
		}//end final
		
		return dto;
		
	}//end getArticle();
//-------------------------------------------------------------------------------
//글 수정 폼 ==>jsp 로 보내기 위한 로직
//-------------------------------------------------------------------------------
	public BoardDto updateGetArticle(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDto dto=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("select * from board3 where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//---
			
			if(rs.next()){
				 dto =new BoardDto();
				 dto.setNum(rs.getInt("num"));
				
				 dto.setWriter(rs.getString("writer"));
				 dto.setEmail(rs.getString("email"));
				 dto.setSubject(rs.getString("subject"));
				 dto.setPasswd(rs.getString("passwd"));
				
				 dto.setRegdate(rs.getTimestamp("regdate"));
				
				 dto.setReadcount(rs.getInt("ref"));
				 dto.setRe_step(rs.getInt("re_step"));
				 dto.setRe_level(rs.getInt("re_level"));
				
				 dto.setContent(rs.getString("content"));
				 dto.setIp(rs.getString("ip"));
			}//if
			
		}catch(Exception ex1){
			System.out.println("getArticle() 예외: "+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
			
		}
		
		return dto;
	}//end updateGetArticle
	
//-------------------------------------------------------------------------------	
//글 수정 폼 ==>DB 로 보내기 위한 로직
//-------------------------------------------------------------------------------

public int updateArticle(BoardDto dto){
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String dbPwd="";
	String sql="";
	int x=-1;
	
	try{
		con=getConnection();
		pstmt=con.prepareStatement("select * from board3 where num=?");
		pstmt.setInt(1, dto.getNum());
		rs=pstmt.executeQuery();
		////
		if(rs.next()){
			dbPwd=rs.getString("passwd");
			if(dbPwd.equals(dto.getPasswd())){//암호가 일치하면
				
				pstmt=con.prepareStatement("update board3 set writer=?, email=?, subject=?, content=? where num=?");
				
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setInt(5, dto.getNum());
				
				pstmt.executeUpdate();
				x=1; //성공
				
			}else{
				x=0; //실패
			}//else end
		
		}//if
		
		
		
	}catch(Exception ex3){
		System.out.println("updateArticle() 예외: "+ex3);
	}finally{
		try{
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			if(con!=null){con.close();}
		}catch(Exception ex4){}
		
	}//end final
	
	return x;
}//updateArticle

//-------------------------------------------------------------------------------	
//삭제
//-------------------------------------------------------------------------------
	public int deleteArticle(int num, String passwd){
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String dbPwd="";
		int x=-1;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("select passwd from board3 where num=?");
			//? 채우기
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//---------------------
			if(rs.next()){
				dbPwd=rs.getString("passwd");
				if(dbPwd.equals(passwd)){//암호가 일치하면
					pstmt=con.prepareStatement("delete from board3 where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x=1;
				}else{
					x=0;
				}
			}//if
			
			
		}catch(Exception ex5){
			System.out.println("deleteArticle() 예외: "+ex5);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex6){}
		}
				
		return x;
	}//end delete
	
}//class end










