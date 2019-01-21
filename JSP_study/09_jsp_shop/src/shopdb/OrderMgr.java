package shopdb;

//DAO 비즈니스 로직
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class OrderMgr {

	public OrderMgr(){}
	
	private Connection getConnection() throws Exception{
	
		Context ct= new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		
		return ds.getConnection();
	}//getConnection
	
	//1.주문
	public void insertOrder(OrderBean order) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			
			con=getConnection();
			String sql="insert into shop_order(ordno, userid, pro_no, quantity, ord_date, state ) values(0,?,?,?,NOW(),?)";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, order.getUserid());
			pstmt.setInt(2, order.getPro_no());
			pstmt.setString(3, order.getQuantity());
			pstmt.setString(4, order.getState());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception ex){
			System.out.println("insertOrder 예외 : "+ex);
		}finally{
			try{
				
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex1){}
			
		}//end final
		
	}//end
	
//2.userid 에 해당하는 주문 목록 얻기
	public Vector<OrderBean> getOrder(String userid){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector<OrderBean> vec = new Vector<OrderBean>();

		try{
			
			con=getConnection();
			String sql="select * from shop_order where userId=? order by ordno desc";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			OrderBean order=null;
			
			while(rs.next()){
				//rs 자료를 꺼내어,빈에 저장. 빈을 vec 에 넣는다.
				order=new OrderBean();
				
				order.setUserid(rs.getString("userid"));
				order.setQuantity(rs.getString("quantity"));
				order.setOrd_date(rs.getTimestamp("ord_date"));
				order.setOrdno(rs.getInt("ordno"));
				order.setState(rs.getString("state"));
				order.setPro_no(rs.getInt("pro_no"));
		
				vec.add(order);
				
			}//while end
			
			}catch(Exception ex){
				System.out.println("insertOrder 예외 : "+ex);
			}finally{
				try{
					
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex1){}
				
			}//end final
		
		return vec;
	}//end getOrder
	
//3. 모든 주문 정보
	public Vector getOrderList(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		Vector<OrderBean> vec = new Vector<OrderBean>();
		OrderBean order=null;
		
		
		try{
			
			con=getConnection();
			String sql="select * from shop_order order by ordno desc";
			stmt= con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				order=new OrderBean();
				
				order.setUserid(rs.getString("userid"));
				order.setQuantity(rs.getString("quantity"));
				order.setOrd_date(rs.getTimestamp("ord_date"));
				order.setOrdno(rs.getInt("ordno"));
				order.setState(rs.getString("state"));
				order.setPro_no(rs.getInt("pro_no"));
		
				vec.add(order);
			}
			
		}catch(Exception ex){
			System.out.println("insertOrder 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex1){}
			
		}//end final
		return vec;
	}//getOrderList
	
}//class end
