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
				//sqlMapConfig.xml 파일의 설정내용을 가져온다.
				Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
				
				//sqlMapConfig.xml 의 내용을 적용한 sqlMapper 객체 생성.
				
				sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
				reader.close();
				
			}catch(IOException ex){
				throw new RuntimeException("SqlMapClient 인스턴스 생성시 예외 발생."+ex);
			}
		}//static
	
		public static void main(String[] args) {
			
			try{
				
			
				
				
			//4.삭제
			//	sqlMapper.update("deleteUser", "yoo77");
				
				
			//3.update
			//	User user2= new User("yoo77", "test", "test",null); //id 값에 해당하는 행의 값들을 수정.
			//	sqlMapper.update("updateUser", user2); //등록 쿼리 수행
				
				
				
			//2.insert
				//User user3= new User("yoo77", "yoo77", "유재국88",null);
				//sqlMapper.insert("insertUser",user3); //등록 쿼리 수행
				//				user.xml 의 id
				
			
			//1 select * from user
			List<User> list= (List<User>)sqlMapper.queryForList("selectAll");
			
			for(User user: list){
				System.out.println(user);
				
			}
			System.out.println();
			
			
			
			
			
			//아이디가 Kim 인 사람 검색 하시오.
			
			List<User> list2= (List<User>)sqlMapper.queryForList("searchKim");
			for(User user: list2){
				System.out.println(user);
				
			}
			
			}catch(SQLException es){es.printStackTrace();	}
			
			
			
		}//class end
		
}//class e
