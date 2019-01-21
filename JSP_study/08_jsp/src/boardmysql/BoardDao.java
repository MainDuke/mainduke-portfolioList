package boardmysql;
//�����Ͻ� ���� : DAO

//Ŀ�ؼ� Ǯ ��� 

import java.sql.*;

import javax.sql.*;//DataSource
import javax.naming.*;//lookup

import java.util.*;
import java.util.Date;

public class BoardDao {
	
	private static BoardDao instance=new BoardDao();//�̱��� ��� 
	
	//jsp���� ����� �޼���
	public static BoardDao getInstance(){
		return instance;
	}
	
	private BoardDao(){}//������ 
	
	//--------------------------------------------
	
	//Ŀ�ؼ� ���
	private Connection getConnection() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");//###
		return ds.getConnection();
	}//getConnection()
	
	//--------------------------------------------	
	// ����, ���
	//--------------------------------------------	
	public void insertArticle(BoardDto dto) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int num=dto.getNum(); // �۹�ȣ
		int ref=dto.getRef(); // ��� �׷�
		int re_step=dto.getRe_step(); // �� ����
		int re_level=dto.getRe_level(); // �� ����
		
		int number=0; //board ���̺� �� �۹�ȣ
		String sql="";
		
		try {
			//ó����
			con=getConnection();//Ŀ�ؼ� ���
			pstmt=con.prepareStatement("select max(num) from board3");//�ִ� �۹�ȣ ��� 
			
			rs=pstmt.executeQuery();//���� ����
			
			if(rs.next()){//���� �����ϸ�
				number=rs.getInt(1)+1;
			}else{//���� ���� ��
				number=1;//ù��° ��
			}
			
			if(num!=0){//����̸�
				
				//��� �����ֱ� ��ġ Ȯ��
				sql="update board3 set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);//������ ���� ��
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();//��������, insert, update, delete => executeUpdate()
				//						select = executeQuery 
				re_step=re_step+1;
				re_level=re_level+1;
			}else{//����
				ref=number;//�� �׷��ȣ, ���� �۹�ȣ�� ref�� �־��ش�
				re_step=0;
				re_level=0;
			}//else
			
			sql="insert into board3(writer,email,subject,passwd,regdate,ref,re_step,re_level,content,ip)"
				+" values(?,?,?,?,NOW(),?,?,?,?,?)";
				// NOW() : ��¥ �ú���
				// curdate() : ��¥
				// sysdate : ����Ŭ
			
			pstmt=con.prepareStatement(sql);// ������ ���� ����
			
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
			
			pstmt.executeUpdate();// ���� ����			
			
		} catch (Exception ex) {
			System.out.println("insertArticle() ���� :"+ex);
		} finally{
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally end
	}//insertArticle() end
	
	//-----------------------------	
	// �� ����
	//-----------------------------	
	public int getArticleCount() throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=0;
		
		try{
			con=getConnection();//Ŀ�ؼ� ���
			pstmt=con.prepareStatement("select count(*) from board3");			
			rs=pstmt.executeQuery();//���� ����
			
			if(rs.next()){//���� �����ϸ�
				x=rs.getInt(1);//�� ����
			}//if
			
		}catch(Exception ex1){
			System.out.println("getArticleCount() ���� :"+ex1);
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
	// ����Ʈ
	//-----------------------------
	public List getList(int start, int cnt) throws Exception{
		//mysql���� int start(������ġ), int end(����)
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDto> list=null;// Vector ��� List, ArrayList ��� 
		
		try {
			//ó����
			con=getConnection();//Ŀ�ؼ� ���
			pstmt=con.prepareStatement("select * from board3 "
					+ "order by ref desc, re_step asc limit ?,?");
													//limit ������ġ, �� ����
			pstmt.setInt(1, start-1);//������ġ
			pstmt.setInt(2, cnt);//�� ����
			rs=pstmt.executeQuery();//���� ����
			
			if(rs.next()){
				list=new ArrayList<BoardDto>();
				
				do{
					BoardDto dto= new BoardDto();//�𵨺� ��ü ����
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
					
					list.add(dto); //list�� �ֱ�
					  
					
				}while(rs.next());
				
			}//if
			
			
		} catch (Exception ex) {
			System.out.println("getList() ����:"+ex);
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
			System.out.println("getArticle ����: "+ex);
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
//�� ���� �� ==>jsp �� ������ ���� ����
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
			System.out.println("getArticle() ����: "+ex1);
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
//�� ���� �� ==>DB �� ������ ���� ����
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
			if(dbPwd.equals(dto.getPasswd())){//��ȣ�� ��ġ�ϸ�
				
				pstmt=con.prepareStatement("update board3 set writer=?, email=?, subject=?, content=? where num=?");
				
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setInt(5, dto.getNum());
				
				pstmt.executeUpdate();
				x=1; //����
				
			}else{
				x=0; //����
			}//else end
		
		}//if
		
		
		
	}catch(Exception ex3){
		System.out.println("updateArticle() ����: "+ex3);
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
//����
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
			//? ä���
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//---------------------
			if(rs.next()){
				dbPwd=rs.getString("passwd");
				if(dbPwd.equals(passwd)){//��ȣ�� ��ġ�ϸ�
					pstmt=con.prepareStatement("delete from board3 where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x=1;
				}else{
					x=0;
				}
			}//if
			
			
		}catch(Exception ex5){
			System.out.println("deleteArticle() ����: "+ex5);
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










