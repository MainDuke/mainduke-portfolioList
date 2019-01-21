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
	private Validator loginValidator; //������Ƽ
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView(){
		System.out.println("���α���");
		return "login"; //login �� ����, �Է��� ����
	}
	
	//<form:form medelAttribute="user">
	@ModelAttribute
	public User setUpForm(){
		return new User(); //user �� ���� �����ؼ� ��ȯ.
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult){
		//BindingResult �ν��Ͻ��� ���� ����� ����� ���̴�.
		
		this.loginValidator.validate(user, bindingResult);
		//���� ����� User �ν��Ͻ���,
		//���� ����� ������ BindingResult �ν��Ͻ��� �ǳ��ݴϴ�.
		
		ModelAndView mv= new ModelAndView();
		
		if(bindingResult.hasErrors()){
			mv.getModel().putAll(bindingResult.getModel());
			return mv;
		}//������ ������ �α��� ȭ������ �ǵ��� ���ϴ�.
		//�α��� ȭ�鿡�� �Է°��� ������ �ʰ� ǥ���ϱ� ����
		//BindingResult �ν��Ͻ����� ���� ������
		//ModelAndView �ν��Ͻ��� �����մϴ�.
		//return modeAndViewl; �ϸ� �α��� ȭ������ �ǵ��� ���ϴ�. ������ ������.
		
		try{
			System.out.println();
			User loginUser=this.shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
			
			mv.setViewName("loginSucces"); //loginSucces.jsp
			mv.addObject("loginUser", loginUser);
			return mv; //���� ó��.
			
		}catch(EmptyResultDataAccessException e){
			bindingResult.reject("error.login.user");
			mv.getModel().putAll(bindingResult.getModel());
			return mv; //���� ó��.
		}//end catch
	
	}//onSubmit end	
		
		
	
	
}//class end
