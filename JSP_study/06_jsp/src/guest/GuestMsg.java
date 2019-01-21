package guest;

import java.sql.*;
import java.util.*;

import boardre.BoardBean;
import guest.GuestBean;


public class GuestMsg {

	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/mydb1";
	String USER="root";
	String PWD= "12345";
	
	Connection con=null;
	Statement	stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	
	//==========================================================================================
	//생성자
	public GuestMsg(){
		try{
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			
			
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패 : "+ex);
		}
		
	}//생성자
	//==========================================================================================

	//pos 증가
		public void upPos(){
			try{
				//처리문
				con=DriverManager.getConnection(URL,USER, PWD);
				stmt=con.createStatement();
				sql= "update guest set pos=pos+1";
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
	
	//방명록 입력하기~
	//==========================================================================================
	public void insertBoard(GuestBean bean, String id){
		upPos(); 
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			
			//sql="insert into board(name,email,homepage,subject,content,pos,depth,regdate,pass,ip) values(?,?,?,?,?,?,?,curdate(),?,?)";
			sql="insert into guest(name, content, id, pos, depth, regdate, pwd, ip) values(?, ?, ?, ?, ?, NOW(), ?, ?)";    
						
			pstmt=con.prepareStatement(sql);

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, id);
			pstmt.setInt(4, bean.getPos());
			
			pstmt.setInt(5, bean.getDepth());
			//날짜칸 자동
			pstmt.setString(6, bean.getPwd());
			pstmt.setString(7, bean.getIp());
			
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
	//==========================================================================================
	
	public Vector getBoardList(String keyField, String keyWord){
		
		Vector vec = new Vector();
		sql="";
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
		
			
			if(keyWord.equals(null) || keyWord.equals("")){
				sql="select * from guest order by pos asc";
			}else{//글 검색
					sql="select * from guest where "+keyField+" like '%"+keyWord+"%' order by pos asc";
				
			}//else
			
			rs=stmt.executeQuery(sql);

			while(rs.next()){
				GuestBean bean= new GuestBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setId(rs.getString("id"));
								
				bean.setContent(rs.getString("content"));
				
				bean.setPos(rs.getInt("pos"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				
				bean.setPwd(rs.getString("pwd"));
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
	//==========================================================================================	
	//글 내용보기, 글수정
		//-------------------------
		public GuestBean getBoard(int num, String id){
			GuestBean bean=new GuestBean();
			try{
				//처리문
				con=DriverManager.getConnection(URL,USER,PWD);//DB연결
				String sql="select * from guest where num="+num;
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();//쿼리 수행
			
				while(rs.next()){
					bean.setNum(rs.getInt("num"));
					bean.setName(rs.getString("name"));
					bean.setId(rs.getString("id"));
					
					bean.setContent(rs.getString("content"));
					bean.setPos(rs.getInt("pos"));
					bean.setDepth(rs.getInt("depth"));
					
					bean.setRegdate(rs.getString("regdate"));
					bean.setPwd(rs.getString("pwd"));
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
	//==========================================================================================		
		//------------------------------------------
				//답글 위치 확보
				//------------------------------------------
				public void replyPos(GuestBean bean){
					try{
						con=DriverManager.getConnection(URL,USER,PWD);
						String sql="update guest set pos=pos+1 where pos>?";
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
				public void replyBoard(GuestBean bean, String id){
					
				try{
					//처리문
					con=DriverManager.getConnection(URL,USER,PWD);
					int depth=bean.getDepth()+1;//글 깊이
					int pos=bean.getPos()+1; //현재글 위치 + 1
					
					sql="insert into guest(name,content,pos,depth,regdate,pwd,ip, id) values(?, ?, ?, ?, NOW(), ?, ?, ?)";
					
					pstmt=con.prepareStatement(sql);//생성시 인자 들어감
					//? 채우기
					pstmt.setString(1, bean.getName());
					pstmt.setString(2, bean.getContent());
					pstmt.setInt(3, pos);
					pstmt.setInt(4, depth);
					//날짜
					pstmt.setString(5, bean.getPwd());
					pstmt.setString(6, bean.getIp());
					pstmt.setString(7, id);
					
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
	
				// 글수정, DB내용 update
				//----------------------
				public void updateBoard(GuestBean bean){
					try{
						//처리문
						con=DriverManager.getConnection(URL,USER,PWD);
						String sql="update guest set name=?, content=?  where num=?";
						//sql="insert into guest(name,content,pos,depth,regdate,pwd,ip, id) values(?, ?, ?, ?, NOW(), ?, ?, ?)";
						
						pstmt=con.prepareStatement(sql);
						//? 앞채우기
						
						pstmt.setString(1, bean.getName());
						pstmt.setString(2, bean.getContent());
						pstmt.setInt(3, bean.getNum());
						
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
				
				
				//-------------------------------------
				//글삭제
				//-----------------------------------
				public void deleteBoard(int num){
					try{
						con=DriverManager.getConnection(URL,USER,PWD);
						sql="delete from guest where num="+num;
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
		new GuestMsg();
	}//class end
	*/
	
}//class end
