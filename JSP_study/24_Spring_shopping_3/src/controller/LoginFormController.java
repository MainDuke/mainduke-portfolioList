package controller;

import logic.Shop;
import logic.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginFormController {
	
	//action
	private Shop shopService;
	private Validator loginValidator; //프로퍼티
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView(){
		System.out.println("투로그인");
		return "login"; //login 뷰 리턴, 입력폼 리턴
	}
	
	//<form:form medelAttribute="user">
	@ModelAttribute
	public User setUpForm(){
		return new User(); //user 모델 빈을 생성해서 반환.
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult){
		//BindingResult 인스턴스는 검증 결과가 저장된 것이다.
		
		this.loginValidator.validate(user, bindingResult);
		//검증 대상은 User 인스턴스와,
		//검증 결과를 저장한 BindingResult 인스턴스를 건네줍니다.
		
		ModelAndView mv= new ModelAndView();
		
		if(bindingResult.hasErrors()){
			mv.getModel().putAll(bindingResult.getModel());
			return mv;
		}//에러가 있으면 로그인 화면으로 되돌아 갑니다.
		//로그인 화면에서 입력값을 지우지 않고 표시하기 위해
		//BindingResult 인스턴스에서 모델을 꺼내어
		//ModelAndView 인스턴스에 저장합니다.
		//return modeAndViewl; 하면 로그인 화면으로 되돌아 갑니다. 에러가 있으면.
		
		try{
			System.out.println();
			User loginUser=this.shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
			
			mv.setViewName("loginSucces"); //loginSucces.jsp
			mv.addObject("loginUser", loginUser);
			return mv; //정상 처리.
			
		}catch(EmptyResultDataAccessException e){
			bindingResult.reject("error.login.user");
			mv.getModel().putAll(bindingResult.getModel());
			return mv; //에러 처리.
		}//end catch
	
	}//onSubmit end	
		
		
	
	
}//class end
