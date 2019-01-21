package shopdb;
import java.sql.*;
import java.util.*;

import javax.sql.*;
import javax.naming.*;

//상품 등록 하려고, 파일 업로드, cos.jar 사용
//jdk/jre/ext/cos.jar
//Tomcat7/lib/cos.jar
//현재 프로젝트 WEB-INF/lib/cos.jar
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

import javax.servlet.http.*;

import java.io.*;
//커넥션 풀 사용
// 비즈니스 로직 : DAO
public class ProductMgr {
	
	
	private static ProductMgr mgr= new ProductMgr();
	public static ProductMgr getInstance(){
		return mgr;
	}//getInstance end
	
	private ProductMgr(){} //디폴트 생성자
	
	private Connection getConnection() throws Exception{
		
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		
		return ds.getConnection();
	}//
	
//1. 상품 목록 리스트
	
	public List getGoodList() throws Exception{
		String sql="";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<ProductBean> goodList=new ArrayList<ProductBean>();
		
		try{
			con=getConnection();
			sql="select * from shop_info";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				ProductBean bean= new ProductBean();
				
				bean.setPro_no(rs.getInt("pro_no"));
				bean.setCode(rs.getString("code"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				
				bean.setStock(rs.getInt("stock"));
				bean.setDetail(rs.getString("detail"));
				
				bean.setComp(rs.getString("comp"));
				
				//now() 저장
				bean.setReg_date(rs.getTimestamp("reg_date"));
				bean.setImage(rs.getString("image"));
												
				goodList.add(bean);
			}//while
			
			
		}catch(Exception ex){
			System.out.println("getGoodList() 예외: "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
				
			}catch(Exception exx){}
		}//end
		
		return goodList;
	}//end getGoodList();
	
//2.상세보기 detail.
	
	public ProductBean getDetails(String code){
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="";
		ProductBean bean=new ProductBean();
		
		try{
			con=getConnection();
			stmt=con.createStatement();
			sql="select * from shop_info where code='"+code+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				
				bean.setPro_no(rs.getInt("pro_no"));
				bean.setCode(rs.getString("code"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				
				bean.setStock(rs.getInt("stock"));
				bean.setDetail(rs.getString("detail"));
				
				bean.setComp(rs.getString("comp"));
				bean.setReg_date(rs.getTimestamp("reg_date"));
				bean.setImage(rs.getString("image"));
			}//while
			
			
		}catch(Exception ex){
			System.out.println("getDetails 예외: "+ex);
		}finally{
			
			try{	
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
			}catch(Exception exx){}
			
		}//finally end
		
		return bean;
	}//end getDetails

//3. pro_no 정보 : 상품, 일련번호, update 에서 사용.
	public ProductBean getProduct(String code, int pro_no){
		
		ProductBean bean=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		try{
			con=getConnection();
			
			sql="select * from shop_info where pro_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				bean=new ProductBean();
				
				bean.setPro_no(rs.getInt("pro_no"));
				bean.setCode(rs.getString("code"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getInt("price"));
				
				bean.setStock(rs.getInt("stock"));
				bean.setDetail(rs.getString("detail"));
				
				bean.setComp(rs.getString("comp"));
				bean.setReg_date(rs.getTimestamp("reg_date"));
				bean.setImage(rs.getString("image"));
				
				
			}//while
			
		}catch(Exception ex2){
			System.out.println("getProduct 예외: "+ex2);
		}finally{
			
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex3){}
		}//end
		
		return bean;
	}//getProduct end
	
	//4.남은 물량 계산.
	
	public void reduceProduct(OrderBean order){
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			
			con=getConnection();
			String sql="update shop_info set stock=(stock-?) where pro_no=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, order.getQuantity());
			pstmt.setInt(2, order.getPro_no());
			pstmt.executeUpdate();
			
			
		}catch(Exception ex2){
			System.out.println("reduceProduct 예외: "+ex2);
		}finally{
			
			try{
			
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex3){}
		}//end
		
	}//reduceProduct
	
	public boolean insertProduct(HttpServletRequest req){
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		int count=-1;
		//jsp경우 : 실제 경로 얻기 : 그림 등록
		//<%=config.getServletContext().getRealPath("/")
		//<%=application.getRealPath("/")%>
		
		//서블릿에서 실제 경로 얻기 : 그림등록
		//request.getRealPath("/");
		//request.getServletContext().getRealPath("/"); => 익섯이 더 정확함.
		
		//jsp웹 경로 얻기 : 그림을 가져와 웹으로 출력할때
		//<%=request.getContextPath()%> ==> 프로젝트 이름이 컨텍스트 이름이다.
		
		try{
			
			con=getConnection();
			String real_path=req.getServletContext().getRealPath("/"); //실제 경로 얻기
			String upload_Dir=real_path+"/imgs/";//상품 등록 하려고
			
			//cos.jar 사용, 파일 업로드
			MultipartRequest multi=new MultipartRequest(req, upload_Dir, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			//오라클 : values(no, nextval,?,?,?,?,sysdate,?);
			//mysql : now(), curdate
			
			//java.util.Date date=new java.util.Date()
			//java.text.SimpleDateFormat
			
			String sql="insert into shop_info(pro_no, name, code, price, stock, detail, comp, reg_date, image) "
					+ "values(0, ?,?,?,?,?,?,now(),?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, multi.getParameter("code"));
			pstmt.setInt(3, Integer.parseInt(multi.getParameter("price")));
			pstmt.setInt(4, Integer.parseInt(multi.getParameter("stock")));
			
			pstmt.setString(5, multi.getParameter("detail"));
			pstmt.setString(6, multi.getParameter("comp"));
			
			if(multi.getFilesystemName("image")!=null){
				pstmt.setString(7, multi.getFilesystemName("image"));
			}else{
				pstmt.setString(7, "ready.gif");
			}
			
			pstmt.executeUpdate();
			
			if(count == 1){
				result=true;
			}
			
		}catch(Exception ex2){
			System.out.println("insertProduct 예외: "+ex2);
		}finally{
			
			try{
			
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex3){}
		}//end
		
		
		return result;
	}//insertProduct end
	
	//update 수정
	public boolean updateProduct(HttpServletRequest req){
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		
		try{
			
			con=getConnection();
			String real_path=req.getServletContext().getRealPath("/"); //실제 경로 얻기
			String upload_Dir=real_path+"/imgs/";//상품 등록 하려고
			
			MultipartRequest multi=new MultipartRequest(req, upload_Dir, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			if(multi.getFilesystemName("image")==null){//그림 파일이 없으면
				String sql="update shop_info set name=?, stock=?, detail=?, price=?, code=?, comp=? where pro_no=?";
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, multi.getParameter("name"));
				pstmt.setInt(2, Integer.parseInt(multi.getParameter("stock")));
				pstmt.setString(3, multi.getParameter("detail"));
				
				
				pstmt.setInt(4, Integer.parseInt(multi.getParameter("price")));
				pstmt.setString(5, multi.getParameter("code"));
				
				pstmt.setString(6, multi.getParameter("comp"));
				pstmt.setInt(7, Integer.parseInt(multi.getParameter("pro_no")));
							
				
			}else{//그림 파일 있으면
				
				String sql2="select image from shop_info where pro_no="+Integer.parseInt(multi.getParameter("pro_no"));
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql2);
				
				if(rs.next()){
					File f= new File(upload_Dir + rs.getString("image"));
					if(f.isFile()){//파일이 존재하면
						f.delete();//그림 파일 삭제
					}//if
				}//if
				
				st.close();
				rs.close();
			
				//먼저 그림 파일 삭제, update 작업 시작
				
				String sql="update shop_info set name=?, stock=?, detail=?, price=?, code=?, comp=?, image=? where pro_no=?";
				
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, multi.getParameter("name"));
				pstmt.setInt(2, Integer.parseInt(multi.getParameter("stock")));
				pstmt.setString(3, multi.getParameter("detail"));
				
				pstmt.setInt(4, Integer.parseInt(multi.getParameter("price")));
				pstmt.setString(5, multi.getParameter("code"));
				
				pstmt.setString(6, multi.getParameter("comp"));
				pstmt.setString(7, multi.getFilesystemName("image"));
				pstmt.setInt(8, Integer.parseInt(multi.getParameter("pro_no")));
								
			}//else
			
			int count= pstmt.executeUpdate();
			if(count == 1){
				result=true;
			}
			
			
		
	}catch(Exception ex4){
		System.out.println("updateProduct예외: "+ex4);
	}finally{
		try{
			if(pstmt!=null){pstmt.close();}
			if(con!=null){con.close();}
		}catch(Exception ex4){}
	}//end
		return result;
	}//updateProduct end
	
	
//삭제 (관리자가 하는일) 	
//이미지 삭제
public boolean deleteProduct(HttpServletRequest req, int pro_no){
	
	Connection con=null;
	PreparedStatement pstmt=null;
	boolean result=false;
	
	try{
		
		con=getConnection();
		
		String sql2="select image from shop_info where pro_no="+pro_no;
		
		String real_path=req.getServletContext().getRealPath("/"); //실제 경로 얻기
		String upload_Dir=real_path+"/imgs/";//상품 등록 하려고
		
		
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql2);
		
		if(rs.next()){
			File f= new File(upload_Dir + rs.getString("image"));
			if(f.isFile()){//파일이 존재하면
				f.delete();//그림 파일 삭제
			}//if
		}//if
		
		st.close();
		rs.close();
		//그림 삭제 끝낸 다음에~ 게시글 삭제.
		String sql="delete from shop_info where pro_no=?";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, pro_no);
		
		int count= pstmt.executeUpdate();
		if(count >0){
			result = true;
		}//if
		
		}catch(Exception ex4){
			System.out.println("deleteProduct() 예외: "+ex4);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex4){}
		}//end
			return result;
}//deleteProduct end
	
	
	
}//class end









