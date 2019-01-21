package myutil;
import java.io.*; //db.properties 읽기 위해
import java.sql.*; //드라이버로딩
import java.util.*; //properties

public class DBConnection {

		Connection con =null;
		
		public DBConnection()// 생성자
		{
			Properties pro= new Properties(); //생성
			
			try{
				pro.load(new FileInputStream("C:\\00_han\\01_work\\06_jsp\\db.properties"));
				//pro.load(new FileInputStream("C:/00_han/01_work/06_jsp/db.properties")); 
				// \\ 또는 / 둘다 된다.
			}catch(IOException ie){
				System.out.println("파일 읽기 에러"+ie);
			}
			
			String driver=pro.getProperty("driver");
			String url=pro.getProperty("url");
			String user=pro.getProperty("user");
			String pass=pro.getProperty("pass");
			
			try{
				Class.forName(driver);
				System.out.println("드라이버 로딩 성공");
				
			}catch(ClassNotFoundException cnf){
				System.out.println("드라이버 로딩 실패 "+cnf);
			}
			
			try{
				con=DriverManager.getConnection(url, user, pass);
				System.out.println("DB 연결 성공");
			}catch(SQLException se){
				System.out.println("DB 연결 실패 : "+se);
			}
						
		}//cons end
	
		//외부에서 jsp  또는 servlet 사용할 메서드 정의
		public Connection getCon(){
			
			return con;
			
		}//custom end
		
		/*
		public static void main(String[] args) {
			new DBConnection();
		}
		*/
		//실행해보고, main 주석처리하고 컴파일 해준다.
}//class end
