package mybatis.demo.account;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//��Ű���� ���� ibatis�� ���� �ִ�..

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
		test2.setName("���");
		session.insert("insertTest", test2);
		session.commit(); //�����۾� �ϰ� Ŀ�� �ݵ��! �ؾ���! */		
		
		//5. update
	/*	Test test4 = new Test();
		test4.setId("bruce");
		test4.setPwd("gamma123");
		test4.setName("��罺");
		session.update("updateTest", test4);
		session.commit(); //�����۾� �ϰ� Ŀ�� �ݵ��! �ؾ���! */		
		//test.xml���� ID ������ ���,�̸��� �ٲ�� ���� �־����.
		
		//6. delete
		session.delete("deleteTest", "bruce");
		session.commit();
		
		System.out.println();
		
		//1. ��ü�˻�
	/*	List<Test> list = (List<Test>)session.selectList("selectAll");
		for(Test test1 : list) //���� �ϳ��� {} <-����
			System.out.println(test1); //*/
		
		System.out.println();
		
		//2. ���ǰ˻�1
		String id="tony";
		Test test = (Test)session.selectOne("selectOne", id);
		System.out.println(test);

		System.out.println();
		
		//3. ���ǰ˻�2 : �� �������� �־ ����Ʈ�� �޾���� ��
	/*	id="%y%";
		//test = (Test)session.selectOne("selectObject", id);
		List<Test> list2 = (List<Test>)session.selectList("selectObject",id);
		for(Test test3:list2)
			System.out.println(test3); //*/
		
	}//main end
	
}//class end
