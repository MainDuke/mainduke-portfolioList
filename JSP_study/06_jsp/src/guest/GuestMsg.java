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
	//������
	public GuestMsg(){
		try{
			Class.forName(DRIVER);
			System.out.println("����̹� �ε� ����");
			
			
		}catch(ClassNotFoundException ex){
			System.out.println("����̹� �ε� ���� : "+ex);
		}
		
	}//������
	//==========================================================================================

	//pos ����
		public void upPos(){
			try{
				//ó����
				con=DriverManager.getConnection(URL,USER, PWD);
				stmt=con.createStatement();
				sql= "update guest set pos=pos+1";
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
	
	//���� �Է��ϱ�~
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
			//��¥ĭ �ڵ�
			pstmt.setString(6, bean.getPwd());
			pstmt.setString(7, bean.getIp());
			
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
	//==========================================================================================
	
	public Vector getBoardList(String keyField, String keyWord){
		
		Vector vec = new Vector();
		sql="";
		
		try{
			con=DriverManager.getConnection(URL,USER, PWD);
			stmt=con.createStatement();
		
			
			if(keyWord.equals(null) || keyWord.equals("")){
				sql="select * from guest order by pos asc";
			}else{//�� �˻�
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
	//==========================================================================================	
	//�� ���뺸��, �ۼ���
		//-------------------------
		public GuestBean getBoard(int num, String id){
			GuestBean bean=new GuestBean();
			try{
				//ó����
				con=DriverManager.getConnection(URL,USER,PWD);//DB����
				String sql="select * from guest where num="+num;
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();//���� ����
			
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
	//==========================================================================================		
		//------------------------------------------
				//��� ��ġ Ȯ��
				//------------------------------------------
				public void replyPos(GuestBean bean){
					try{
						con=DriverManager.getConnection(URL,USER,PWD);
						String sql="update guest set pos=pos+1 where pos>?";
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
				public void replyBoard(GuestBean bean, String id){
					
				try{
					//ó����
					con=DriverManager.getConnection(URL,USER,PWD);
					int depth=bean.getDepth()+1;//�� ����
					int pos=bean.getPos()+1; //����� ��ġ + 1
					
					sql="insert into guest(name,content,pos,depth,regdate,pwd,ip, id) values(?, ?, ?, ?, NOW(), ?, ?, ?)";
					
					pstmt=con.prepareStatement(sql);//������ ���� ��
					//? ä���
					pstmt.setString(1, bean.getName());
					pstmt.setString(2, bean.getContent());
					pstmt.setInt(3, pos);
					pstmt.setInt(4, depth);
					//��¥
					pstmt.setString(5, bean.getPwd());
					pstmt.setString(6, bean.getIp());
					pstmt.setString(7, id);
					
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
	
				// �ۼ���, DB���� update
				//----------------------
				public void updateBoard(GuestBean bean){
					try{
						//ó����
						con=DriverManager.getConnection(URL,USER,PWD);
						String sql="update guest set name=?, content=?  where num=?";
						//sql="insert into guest(name,content,pos,depth,regdate,pwd,ip, id) values(?, ?, ?, ?, NOW(), ?, ?, ?)";
						
						pstmt=con.prepareStatement(sql);
						//? ��ä���
						
						pstmt.setString(1, bean.getName());
						pstmt.setString(2, bean.getContent());
						pstmt.setInt(3, bean.getNum());
						
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
				
				
				//-------------------------------------
				//�ۻ���
				//-----------------------------------
				public void deleteBoard(int num){
					try{
						con=DriverManager.getConnection(URL,USER,PWD);
						sql="delete from guest where num="+num;
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
		new GuestMsg();
	}//class end
	*/
	
}//class end
