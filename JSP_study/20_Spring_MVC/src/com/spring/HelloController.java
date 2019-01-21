package com.spring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Action
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello(){
		String msg = "Hello, Spring 3.0!";
		return new ModelAndView("hello", "msg", msg);
		//						 view	 data	getAttribute
		//MVC ���Ͽ��� �ߴ� request.setAttribute("msg",msg)�� �����ž�.
	}//hello() end
	
}//class
