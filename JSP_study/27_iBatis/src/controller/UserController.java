package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;




import model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import user.service.UserDaoImplService;


@Controller
@RequestMapping("/user")

public class UserController {

		private ApplicationContext ct = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
	
		private UserDaoImplService dao=(UserDaoImplService)ct.getBean("userService"); //빈 얻기

		//http://컨텍스트:port/user/list.do
		@RequestMapping("/list.do")
		public ModelAndView listUser(){
			//DAO 로 부터 모든 데이터 얻기 
			List<User> userList = this.dao.getList();
			return new ModelAndView("list","userList",userList);
			//모델 생성
			/*
			 * Map<String, Object> model = new HashMap<String, Object>();
			 * model.put("userList",userList);
			 * 
			 *반환값인 ModelAndView 인스턴스를 생성
			 *ModelAndView modelandView = new ModelAndView();
			 *modelandView.setViewName("list");
			 *modelandView.addAllObject(model); 
			 * return modelandView;
			 * 
			 * */
		
		}//----------------------
		
		
		//입력 폼, GET방식 요청 처리
		//insert
		@RequestMapping("/write.do")
		public String userWrite(){
			return "write";// 뷰
		}
		
		//insert
		@RequestMapping(value="/write.do", method=RequestMethod.POST)
		public String userWritePro(@ModelAttribute("User") User user){
			this.dao.writeUser(user);
			return "redirect:list.do";
			//redirect는 reponse.sendRedirect("list.jsp");
		}
		
		//글 내용 보기
		@RequestMapping(value="/content.do")
		public ModelAndView contentUser(String userId){
			
			User user=this.dao.getUser(userId);
			return new ModelAndView("content", "user", user);
			
		}
		
		//글 수정 폼
		@RequestMapping(value="/update.do", method=RequestMethod.GET)
		public ModelAndView updateUser(String userId){
			User user=this.dao.getUser(userId);
			return new ModelAndView("update", "user", user);
			
		}
		
		//글 수정
		@RequestMapping(value="/update.do", method=RequestMethod.POST)
		public String updatePro(User user){
			this.dao.modifyUser(user);
			return "redirect:list.do";
			//redirect 는 http://를 새로 연결한다.
			
		}
		
		//글 삭제 폼
		
		@RequestMapping(value="/delete.do", method=RequestMethod.GET)
		public ModelAndView deleteUser(){
			
			String id="아이디를 입력하시오.";
			String pwd="암호를 입력하시오";
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id",id);
			map.put("pwd",pwd);
			
			return new ModelAndView("delete", "map", map);//뷰
			//redirect 는 http://를 새로 연결한다.
		}
		
		//글 삭제
		@RequestMapping(value="/delete.do", method=RequestMethod.POST)
		public String deletePro(String userId){
			this.dao.deleteUser(userId);
			
			return "redirect:list.do";
			//redirect 는 http://를 새로 연결한다.
			
		}
		
}//class end










