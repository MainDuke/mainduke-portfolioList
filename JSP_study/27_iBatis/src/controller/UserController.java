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
	
		private UserDaoImplService dao=(UserDaoImplService)ct.getBean("userService"); //�� ���

		//http://���ؽ�Ʈ:port/user/list.do
		@RequestMapping("/list.do")
		public ModelAndView listUser(){
			//DAO �� ���� ��� ������ ��� 
			List<User> userList = this.dao.getList();
			return new ModelAndView("list","userList",userList);
			//�� ����
			/*
			 * Map<String, Object> model = new HashMap<String, Object>();
			 * model.put("userList",userList);
			 * 
			 *��ȯ���� ModelAndView �ν��Ͻ��� ����
			 *ModelAndView modelandView = new ModelAndView();
			 *modelandView.setViewName("list");
			 *modelandView.addAllObject(model); 
			 * return modelandView;
			 * 
			 * */
		
		}//----------------------
		
		
		//�Է� ��, GET��� ��û ó��
		//insert
		@RequestMapping("/write.do")
		public String userWrite(){
			return "write";// ��
		}
		
		//insert
		@RequestMapping(value="/write.do", method=RequestMethod.POST)
		public String userWritePro(@ModelAttribute("User") User user){
			this.dao.writeUser(user);
			return "redirect:list.do";
			//redirect�� reponse.sendRedirect("list.jsp");
		}
		
		//�� ���� ����
		@RequestMapping(value="/content.do")
		public ModelAndView contentUser(String userId){
			
			User user=this.dao.getUser(userId);
			return new ModelAndView("content", "user", user);
			
		}
		
		//�� ���� ��
		@RequestMapping(value="/update.do", method=RequestMethod.GET)
		public ModelAndView updateUser(String userId){
			User user=this.dao.getUser(userId);
			return new ModelAndView("update", "user", user);
			
		}
		
		//�� ����
		@RequestMapping(value="/update.do", method=RequestMethod.POST)
		public String updatePro(User user){
			this.dao.modifyUser(user);
			return "redirect:list.do";
			//redirect �� http://�� ���� �����Ѵ�.
			
		}
		
		//�� ���� ��
		
		@RequestMapping(value="/delete.do", method=RequestMethod.GET)
		public ModelAndView deleteUser(){
			
			String id="���̵� �Է��Ͻÿ�.";
			String pwd="��ȣ�� �Է��Ͻÿ�";
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id",id);
			map.put("pwd",pwd);
			
			return new ModelAndView("delete", "map", map);//��
			//redirect �� http://�� ���� �����Ѵ�.
		}
		
		//�� ����
		@RequestMapping(value="/delete.do", method=RequestMethod.POST)
		public String deletePro(String userId){
			this.dao.deleteUser(userId);
			
			return "redirect:list.do";
			//redirect �� http://�� ���� �����Ѵ�.
			
		}
		
}//class end










