package boardoracle;
import java.sql.*;

import java.util.*;
import boardoracle.BoardBean;


//DAO ����Ͻ� ����
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
			//System.out.println("����̹� �ε� ����");
			
			
		}catch(ClassNotFoundException ex){
			System.out.println("����̹� �ε� ���� : "+ex);
		}
		
	}//cons end
	

	//pos ����
	public void upPos(){
		try{
			//ó����
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
			sql= "update board set pos=pos+1";
			stmt.executeUpdate(sql);
			
			
		}catch(Exception ex){
			System.out.println("upPos ���� : "+ex);
		}finally{ //���̳� sql �ݾ��ֱ� ����
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
			//��¥ĭ �ڵ�
			pstmt.setString(8, bean.getPass());
			pstmt.setString(9, bean.getIp());
			
			pstmt.executeUpdate();

		
		}catch(Exception ex){
			System.out.println("insertBoard ���� : "+ex);
		}finally{
			try{
			if (pstmt!=null) {	pstmt.close();	}
			if (con!=null) {con.close();}
			}catch(Exception exxx){
				
			}
		}//finally end
	}//insertBoard end
	
	
	
	
	// �ۼ���, DB���� update
		//----------------------
		public void updateBoard(BoardBean bean){
			try{
				//ó����
				con=DriverManager.getConnection(URL,USER,PWD);
				String sql="update board set name=?, email=?, homepage=?, subject=?, content=? where num=?";
				
				pstmt=con.prepareStatement(sql);
				//? ��ä���
				
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getEmail());
				pstmt.setString(3, bean.getHomepage());
				pstmt.setString(4, bean.getSubject());
				pstmt.setString(5, bean.getContent());
				pstmt.setInt(6, bean.getNum());
				
				pstmt.executeUpdate();//��������
				
			}catch(Exception ex){
				System.out.println("updateBoard() ���� :"+ex);
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}
		}
		
	
	
	//-----------------------------
	//��ȸ�� ����
	//-----------------------------
	
	public void upCount(int num){
		try{
			con=DriverManager.getConnection(URL,USER,PWD);//db����
			sql="update board set count=count+1 where num="+num;
			pstmt=con.prepareStatement(sql);//������ ���� ȣ��
			pstmt.executeUpdate();//��������
		
		}catch(Exception ex1){
			System.out.println("upCount() ���� :"+ex1);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}
	}//upCount end()
	
	
	//------------------------------------------
		//��� ��ġ Ȯ��
		//------------------------------------------
		public void replyPos(BoardBean bean){
			try{
				con=DriverManager.getConnection(URL,USER,PWD);
				String sql="update board set pos=pos+1 where pos>?";
				pstmt=con.prepareStatement(sql);//������ ���� ��
				
				pstmt.setInt(1, bean.getPos());
				pstmt.executeUpdate();//���� ����
				
			}catch(Exception ex1){
				System.out.println("replyPos() ���� :"+ex1);
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}//finally
		}//replyPos() end	
		
		//---------------------------------
		//��� ����
		//--------------------------------
		public void replyBoard(BoardBean bean){
			
		try{
			//ó����
			con=DriverManager.getConnection(URL,USER,PWD);
			int depth=bean.getDepth()+1;//�� ����
			int pos=bean.getPos()+1; //����� ��ġ + 1
			//sql="insert into board(name,email,homepage,subject,content,pos,depth,regdate,pass,count,ip) values(?,?,?,?,?,?,?,NOW(),?,?,?)";
			
			sql="insert into board(num, name,email,homepage,subject,content,pos,depth,regdate,pass,count,ip) values(board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
			
			pstmt=con.prepareStatement(sql);//������ ���� ��
			//? ä���
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getHomepage());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getContent());
			pstmt.setInt(6, pos);
			pstmt.setInt(7, depth);
			//��¥
			pstmt.setString(8, bean.getPass());
			pstmt.setInt(9, bean.getCount());
			pstmt.setString(10, bean.getIp());
			
			pstmt.executeUpdate();//��������
			//? ä���
			
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
		}else{//�� �˻�
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
		System.out.println("getBoardList ���� : "+ex);
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

//�� ���뺸��, �ۼ���
	//-------------------------
	public BoardBean getBoard(int num){
		BoardBean bean=new BoardBean();
		try{
			//ó����
			con=DriverManager.getConnection(URL,USER,PWD);//DB����
			String sql="select * from board where num="+num;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();//���� ����
		
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
			System.out.println("getBoard() ���� :"+ex);
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
		//�ۻ���
		//-----------------------------------
		public void deleteBoard(int num){
			try{
				con=DriverManager.getConnection(URL,USER,PWD);
				sql="delete from board where num="+num;
				pstmt=con.prepareStatement(sql);
				pstmt.executeUpdate();
			}catch(Exception ex2){
				System.out.println("deleteBoard() ���� :"+ex2);
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
