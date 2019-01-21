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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDto;
import board.model.MemberDto;

//��Ʈ�ѷ�. Action�� �ش�
@Controller
public class MemberController {

	@Autowired
	SqlSessionTemplate sst; //���� �� �κ��� @Autowired
	
	
	//ȸ��������
	@RequestMapping("/insertForm.do")
	public String userWrite(){
		return "mem_insert";
	}//userWrite() end=================================
	
	
	//���̵��ߺ�üũ 1
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public ModelAndView idCheck(String id) throws NamingException, IOException {
		int check=-1;
		SqlSession session = sst.getSqlSessionFactory().openSession();
		MemberDto memberDto = session.selectOne("member.selectOne", id);
		session.close();
		if(memberDto==null){
			check=1; //��밡���� id
		}
		return new ModelAndView("mem_idCheck", "check", check);
	}//idCheck() end=================================

	
	//ȸ������
	@RequestMapping(value="/insertPro.do", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute("MemberDto") MemberDto memberDto, String num1, String num2, String address, String details) 
			throws NamingException, IOException { 
		//�ּҴ� �̷��� ���� �Ű������� �־���. 
		
		memberDto.setAddr(address+details); //�ּ� ��ħ
		memberDto.setZipcode(num1+num2); //�����ȣ ��ħ
		//�ּҸ� �ϳ��� ��� ��µ� �ܺ� api ���ǰ�?
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.insert("member.insertMember", memberDto);
		session.commit();
		session.close();

		return "mem_login";
	}//memberInsert() end=================================
	
	
	//�α�����
	@RequestMapping("/login.do")
	public String userLogin(){
		return "mem_login";
	}//userLogin() end=================================
	
	
	//���� �α���
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView memberLogin(String id, String passwd)
		throws NamingException, IOException
		{
		SqlSession session = sst.getSqlSessionFactory().openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); ///// member.xml �Ķ���� Ÿ���� ��. �̷��� �� �� �ִ�
		map.put("passwd", passwd); /////
		//�̺κ� �߿���.Dto ���°Ŷ� ���� ������� �� �� ����.
		MemberDto memberDto = session.selectOne("member.selectLogin", map);
		session.close();
		if(memberDto == null){ //�α��� ����
			return new ModelAndView("mem_login", "msg", "�α��� ����!");
		}
		
		return new ModelAndView("mem_loginSuccess", "memberDto", memberDto);
	}//userLogin() end=================================
	
	
	//�α׾ƿ�
	@RequestMapping("/logOut.do")
	public String userOut(){
		return "mem_logOut";
	}//userOut() end=================================
		
	
	//ȸ������ ������
	@RequestMapping(value="/editForm.do", method=RequestMethod.POST)
	public ModelAndView editForm(String id){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		MemberDto memberDto = session.selectOne("member.selectOne", id);
		session.close();
		
		return new ModelAndView("mem_editForm", "memberDto", memberDto);
	}//userOut() end=================================
	
	
	//ȸ������ DB
	@RequestMapping(value="/editPro.do", method=RequestMethod.POST)
	public String editPro(@ModelAttribute("memberDto") MemberDto memberDto,
			String num1, String num2, String address, String details)
		throws NamingException, IOException {
		
		memberDto.setAddr(address+details);
		memberDto.setZipcode(num1+num2);
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.update("member.memberUpdate", memberDto);
		session.commit();
		session.close();
		
		return "mem_loginSuccess"; //�� �̸�
	}//editPro() end=================================
	
	
	//ȸ��Ż��
	@RequestMapping("memDelete.do")
	public String userDelete(String id) throws NamingException, IOException {
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.delete("member.userDelete", id);
		session.commit();
		session.close();
		
		return "mem_insert";
	}//userDelete() end=================================
	
	
	
	
	
}//class
