package client;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import model.User;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class IBatisClient {

		private static SqlMapClient sqlMapper;
		
		static{
			try{
				//sqlMapConfig.xml ������ ���������� �����´�.
				Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
				
				//sqlMapConfig.xml �� ������ ������ sqlMapper ��ü ����.
				
				sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
				reader.close();
				
			}catch(IOException ex){
				throw new RuntimeException("SqlMapClient �ν��Ͻ� ������ ���� �߻�."+ex);
			}
		}//static
	
		public static void main(String[] args) {
			
			try{
				
			
				
				
			//4.����
			//	sqlMapper.update("deleteUser", "yoo77");
				
				
			//3.update
			//	User user2= new User("yoo77", "test", "test",null); //id ���� �ش��ϴ� ���� ������ ����.
			//	sqlMapper.update("updateUser", user2); //��� ���� ����
				
				
				
			//2.insert
				//User user3= new User("yoo77", "yoo77", "���籹88",null);
				//sqlMapper.insert("insertUser",user3); //��� ���� ����
				//				user.xml �� id
				
			
			//1 select * from user
			List<User> list= (List<User>)sqlMapper.queryForList("selectAll");
			
			for(User user: list){
				System.out.println(user);
				
			}
			System.out.println();
			
			
			
			
			
			//���̵� Kim �� ��� �˻� �Ͻÿ�.
			
			List<User> list2= (List<User>)sqlMapper.queryForList("searchKim");
			for(User user: list2){
				System.out.println(user);
				
			}
			
			}catch(SQLException es){es.printStackTrace();	}
			
			
			
		}//class end
		
}//class e
