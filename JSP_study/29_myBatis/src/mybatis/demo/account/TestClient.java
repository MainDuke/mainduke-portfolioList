package mybatis.demo.account;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//패키지는 아직 ibatis를 쓰고 있다..

public class TestClient {
	
	public static void main(String[] args) throws Exception {
		String resource = "mybatis/demo/account/SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		//4. insert
	/*	Test test2 = new Test();
		test2.setId("bruce");
		test2.setPwd("green123");
		test2.setName("배너");
		session.insert("insertTest", test2);
		session.commit(); //세터작업 하고 커밋 반드시! 해야함! */		
		
		//5. update
	/*	Test test4 = new Test();
		test4.setId("bruce");
		test4.setPwd("gamma123");
		test4.setName("브루스");
		session.update("updateTest", test4);
		session.commit(); //세터작업 하고 커밋 반드시! 해야함! */		
		//test.xml에서 ID 넣으면 비번,이름이 바뀌도록 쿼리 넣어놨음.
		
		//6. delete
		session.delete("deleteTest", "bruce");
		session.commit();
		
		System.out.println();
		
		//1. 전체검색
	/*	List<Test> list = (List<Test>)session.selectList("selectAll");
		for(Test test1 : list) //문장 하나라 {} <-생략
			System.out.println(test1); //*/
		
		System.out.println();
		
		//2. 조건검색1
		String id="tony";
		Test test = (Test)session.selectOne("selectOne", id);
		System.out.println(test);

		System.out.println();
		
		//3. 조건검색2 : 얜 여러갤수 있어서 리스트로 받아줘야 함
	/*	id="%y%";
		//test = (Test)session.selectOne("selectObject", id);
		List<Test> list2 = (List<Test>)session.selectList("selectObject",id);
		for(Test test3:list2)
			System.out.println(test3); //*/
		
	}//main end
	
}//class end
