package utils;

import logic.User;


import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
	
		return User.class.isAssignableFrom(clazz);
	}
	//msg.properties
	//키 = 커맨드
	@Override
	public void validate(Object command, Errors errors) {
		User user=(User)command;
		
		//id가 공백이면 필드 오류 정보를 설정한다.
		if(!StringUtils.hasLength(user.getUserId())){
			errors.rejectValue("userId", "error.required" );
			//					User의 변수, msg.properties 키
			
		}
		
		//password 가 공백이면 필드 오류 정보들을 설정한다.
		if(!StringUtils.hasLength(user.getPassword())){
			errors.rejectValue("password", "error.required" );
			//					User의 변수, msg.properties 키
			
		}
		
		//검증 대상인 클래스 자체에 대한 오류이면
		if(errors.hasErrors()){
			errors.reject("error.input.user" );//msg.properties 의 키
			
		}
		
		
	}
}//class end
