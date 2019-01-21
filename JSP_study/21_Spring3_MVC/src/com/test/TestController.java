package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Action
@Controller
public class TestController {
	
	@RequestMapping("resultPage")
	public ModelAndView helloWorld(){
		String msg="Beyond the door, There is peace I am sure";
		return new ModelAndView("resultPage", "msg", msg);
	}
}
