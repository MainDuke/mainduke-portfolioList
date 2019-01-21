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
	//이 부분을 @Autowired, 자동으로 setter 기능까지 함.
	
	@RequestMapping("list.do")
	public ModelAndView listAll() throws NamingException, IOException{
		SqlSession ssession = sst.getSqlSessionFactory().openSession();
		List<Test> list = ssession.selectList("testboard.selectAll");
		//										네임스페이스.id명
		ssession.close();
		return new ModelAndView("list", "list", list);
		//						뷰 이름	key		value
	}//listAll() ==========================================================

	
	//insert폼
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String testWrite(){
		return "write"; //뷰 이름 (입력폼)
	}//testWrite()====================================================
	
	
	//실질적 DB insert
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String writePro(@ModelAttribute("Test") Test test)
		throws NamingException, IOException	{
		//모델 어트리뷰트 : 파라미터 넣은걸 바로 연결시킴. 세터작업 바로 연결. 여기서 넣어준것이야!
		//<jsp:useBean~~>
		//	<jsp:setProperty name="dto" property="*"/> 이 부분인것.
		
		//public String writePro(@ModelAttribute("Test") Test test, HttpServletRequest request)
		//이렇게 써서 다 리퀘스트 겟파라미터로 다 받는 회사도 있다.. 스프링 쓰는 의미가 없다만...
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.insert("testboard.insertTest", test); //test2.xml의 네임스페이스.Id
		session.commit();
		session.close();
		return "redirect:list.do";
	}//writePro()====================================================
		
	
	//글 내용 보기
	@RequestMapping("content.do")
	public ModelAndView getOneTest(String id){
		//조건검색, 글 내용보기
		SqlSession session = sst.getSqlSessionFactory().openSession();
		Test test = (Test)session.selectOne("testboard.selectOne", id);
		session.close();
		
		return new ModelAndView("content", "test", test);
	}//getOneTest()====================================================
	
	
	//글 수정폼
	@RequestMapping("/update.do")
	public ModelAndView updateForm(String id){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		Test test = (Test)session.selectOne("testboard.selectOne", id);
		session.close();
		
		return new ModelAndView("update", "test", test);
	}//updateForm()====================================================
	
	
	//글 수정 DB
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updatePro(@ModelAttribute("Test") Test test)
		throws NamingException, IOException {
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.update("testboard.updateTest", test);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//updatePro()====================================================
	
	
	//글 삭제 
	//=> delete.jsp 안만들고 삭제할것이야. 콘텐트에서 바로 id 받아왔으니까.
	@RequestMapping("delete.do")
	public String deleteBoard(String id) throws NamingException, IOException {
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.delete("testboard.deleteTest", id);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//deleteBoard()====================================================
		
	
}//class end
