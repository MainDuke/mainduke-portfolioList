package mybatis.demo.account.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import mybatis.demo.account.Test;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional(propagation=Propagation.SUPPORTS)
public class TestController {
	
	@Autowired
	SqlSessionTemplate sst; 
	//�� �κ��� @Autowired, �ڵ����� setter ��ɱ��� ��.
	
	@RequestMapping("list.do")
	public ModelAndView listAll() throws NamingException, IOException{
		SqlSession ssession = sst.getSqlSessionFactory().openSession();
		List<Test> list = ssession.selectList("testboard.selectAll");
		//										���ӽ����̽�.id��
		ssession.close();
		return new ModelAndView("list", "list", list);
		//						�� �̸�	key		value
	}//listAll() ==========================================================

	
	//insert��
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String testWrite(){
		return "write"; //�� �̸� (�Է���)
	}//testWrite()====================================================
	
	
	//������ DB insert
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String writePro(@ModelAttribute("Test") Test test)
		throws NamingException, IOException	{
		//�� ��Ʈ����Ʈ : �Ķ���� ������ �ٷ� �����Ŵ. �����۾� �ٷ� ����. ���⼭ �־��ذ��̾�!
		//<jsp:useBean~~>
		//	<jsp:setProperty name="dto" property="*"/> �� �κ��ΰ�.
		
		//public String writePro(@ModelAttribute("Test") Test test, HttpServletRequest request)
		//�̷��� �Ἥ �� ������Ʈ ���Ķ���ͷ� �� �޴� ȸ�絵 �ִ�.. ������ ���� �ǹ̰� ���ٸ�...
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.insert("testboard.insertTest", test); //test2.xml�� ���ӽ����̽�.Id
		session.commit();
		session.close();
		return "redirect:list.do";
	}//writePro()====================================================
		
	
	//�� ���� ����
	@RequestMapping("content.do")
	public ModelAndView getOneTest(String id){
		//���ǰ˻�, �� ���뺸��
		SqlSession session = sst.getSqlSessionFactory().openSession();
		Test test = (Test)session.selectOne("testboard.selectOne", id);
		session.close();
		
		return new ModelAndView("content", "test", test);
	}//getOneTest()====================================================
	
	
	//�� ������
	@RequestMapping("/update.do")
	public ModelAndView updateForm(String id){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		Test test = (Test)session.selectOne("testboard.selectOne", id);
		session.close();
		
		return new ModelAndView("update", "test", test);
	}//updateForm()====================================================
	
	
	//�� ���� DB
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updatePro(@ModelAttribute("Test") Test test)
		throws NamingException, IOException {
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.update("testboard.updateTest", test);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//updatePro()====================================================
	
	
	//�� ���� 
	//=> delete.jsp �ȸ���� �����Ұ��̾�. ����Ʈ���� �ٷ� id �޾ƿ����ϱ�.
	@RequestMapping("delete.do")
	public String deleteBoard(String id) throws NamingException, IOException {
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.delete("testboard.deleteTest", id);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//deleteBoard()====================================================
		
	
}//class end
