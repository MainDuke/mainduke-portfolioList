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

//컨트롤러. Action에 해당
@Controller
public class MemberController {

	@Autowired
	SqlSessionTemplate sst; //변수 이 부분을 @Autowired
	
	
	//회원가입폼
	@RequestMapping("/insertForm.do")
	public String userWrite(){
		return "mem_insert";
	}//userWrite() end=================================
	
	
	//아이디중복체크 1
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public ModelAndView idCheck(String id) throws NamingException, IOException {
		int check=-1;
		SqlSession session = sst.getSqlSessionFactory().openSession();
		MemberDto memberDto = session.selectOne("member.selectOne", id);
		session.close();
		if(memberDto==null){
			check=1; //사용가능한 id
		}
		return new ModelAndView("mem_idCheck", "check", check);
	}//idCheck() end=================================

	
	//회원가입
	@RequestMapping(value="/insertPro.do", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute("MemberDto") MemberDto memberDto, String num1, String num2, String address, String details) 
			throws NamingException, IOException { 
		//주소는 이렇게 따로 매개변수로 넣어줌. 
		
		memberDto.setAddr(address+details); //주소 합침
		memberDto.setZipcode(num1+num2); //우편번호 합침
		//주소를 하나로 묶어서 썼는데 외부 api 쓴건가?
		
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.insert("member.insertMember", memberDto);
		session.commit();
		session.close();

		return "mem_login";
	}//memberInsert() end=================================
	
	
	//로그인폼
	@RequestMapping("/login.do")
	public String userLogin(){
		return "mem_login";
	}//userLogin() end=================================
	
	
	//실질 로그인
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView memberLogin(String id, String passwd)
		throws NamingException, IOException
		{
		SqlSession session = sst.getSqlSessionFactory().openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); ///// member.xml 파라미터 타입이 맵. 이렇게 줄 수 있다
		map.put("passwd", passwd); /////
		//이부분 중요해.Dto 쓰는거랑 같은 방법으로 쓸 수 있음.
		MemberDto memberDto = session.selectOne("member.selectLogin", map);
		session.close();
		if(memberDto == null){ //로그인 실패
			return new ModelAndView("mem_login", "msg", "로그인 실패!");
		}
		
		return new ModelAndView("mem_loginSuccess", "memberDto", memberDto);
	}//userLogin() end=================================
	
	
	//로그아웃
	@RequestMapping("/logOut.do")
	public String userOut(){
		return "mem_logOut";
	}//userOut() end=================================
		
	
	//회원정보 수정폼
	@RequestMapping(value="/editForm.do", method=RequestMethod.POST)
	public ModelAndView editForm(String id){
		SqlSession session = sst.getSqlSessionFactory().openSession();
		MemberDto memberDto = session.selectOne("member.selectOne", id);
		session.close();
		
		return new ModelAndView("mem_editForm", "memberDto", memberDto);
	}//userOut() end=================================
	
	
	//회원수정 DB
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
		
		return "mem_loginSuccess"; //뷰 이름
	}//editPro() end=================================
	
	
	//회원탈퇴
	@RequestMapping("memDelete.do")
	public String userDelete(String id) throws NamingException, IOException {
		SqlSession session = sst.getSqlSessionFactory().openSession();
		session.delete("member.userDelete", id);
		session.commit();
		session.close();
		
		return "mem_insert";
	}//userDelete() end=================================
	
	
	
	
	
}//class
