package myutil;
import java.io.*; //db.properties �б� ����
import java.sql.*; //����̹��ε�
import java.util.*; //properties

public class DBConnection {

		Connection con =null;
		
		public DBConnection()// ������
		{
			Properties pro= new Properties(); //����
			
			try{
				pro.load(new FileInputStream("C:\\00_han\\01_work\\06_jsp\\db.properties"));
				//pro.load(new FileInputStream("C:/00_han/01_work/06_jsp/db.properties")); 
				// \\ �Ǵ� / �Ѵ� �ȴ�.
			}catch(IOException ie){
				System.out.println("���� �б� ����"+ie);
			}
			
			String driver=pro.getProperty("driver");
			String url=pro.getProperty("url");
			String user=pro.getProperty("user");
			String pass=pro.getProperty("pass");
			
			try{
				Class.forName(driver);
				System.out.println("����̹� �ε� ����");
				
			}catch(ClassNotFoundException cnf){
				System.out.println("����̹� �ε� ���� "+cnf);
			}
			
			try{
				con=DriverManager.getConnection(url, user, pass);
				System.out.println("DB ���� ����");
			}catch(SQLException se){
				System.out.println("DB ���� ���� : "+se);
			}
						
		}//cons end
	
		//�ܺο��� jsp  �Ǵ� servlet ����� �޼��� ����
		public Connection getCon(){
			
			return con;
			
		}//custom end
		
		/*
		public static void main(String[] args) {
			new DBConnection();
		}
		*/
		//�����غ���, main �ּ�ó���ϰ� ������ ���ش�.
}//class end
