package board.controller;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDto;

//��Ʈ�ѷ�. Action�� �ش�
@Controller
public class BoardController {

	@Autowired
	SqlSessionTemplate sst; //���� �� �κ��� @Autowired
	
	
	//����Ʈ
	@RequestMapping("list.do")
	public ModelAndView listAll() throws NamingException, IOException {
		
		SqlSession ssession = sst.getSqlSessionFactory().openSession();
		List list = ssession.selectList("board.selectAll"); //���ӽ����̽�.id��
		ssession.close();
		return new ModelAndView("list", "list", list);
		//						 view	  key	value	
		//							${xx.xxxx}���� xx�� ��ü
	}//listAll()=================================================
	
	
	//insert��
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String boardWrite(){
		return "writeForm"; //�� �̸�
	}//boardWrite()=================================================
	
	
	//insert DB
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String WritePro(@ModelAttribute("boardDto") BoardDto boardDto)
		throws NamingException, IOException{
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.insert("board.insertBoard", boardDto);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//WritePro()=================================================
	
	
	//content
	@RequestMapping("content.do")
	public ModelAndView boardContent(int num){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		
		session.update("board.readcountBoard", new Integer(num));//��ȸ�� ����
		session.commit();
		
		BoardDto dto = (BoardDto)session.selectOne("board.selectOne", num);
		session.close();
		return new ModelAndView("content", "BoardDto", dto);
	}//boardContent()=================================================
	
	
	//update
	@RequestMapping("update.do")
	public ModelAndView boardUpdate(int num){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		BoardDto dto = (BoardDto)session.selectOne("board.selectOne", num);
		session.close();		
		return new ModelAndView("updateForm", "BoardDto", dto);		
	}//boardUpdate()=================================================
	
	
	//update DB
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updatePro(@ModelAttribute("BoardDto") BoardDto boardDto)
		throws NamingException, IOException {
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.update("board.updateBoard", boardDto);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//updatePro()====================================================
	
	
	//delete
	//=> delete.jsp �ȸ���� �����Ұ��̾�. ����Ʈ���� �ٷ� id �޾ƿ����ϱ�.
	@RequestMapping("delete.do")
	public String deleteBoard(int num) throws NamingException, IOException {
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.delete("board.deleteBoard", num);
		session.commit();
		session.close();
		return "redirect:list.do";
	}//deleteBoard()====================================================
	
}//class
