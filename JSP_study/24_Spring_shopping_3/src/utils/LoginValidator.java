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
	//Ű = Ŀ�ǵ�
	@Override
	public void validate(Object command, Errors errors) {
		User user=(User)command;
		
		//id�� �����̸� �ʵ� ���� ������ �����Ѵ�.
		if(!StringUtils.hasLength(user.getUserId())){
			errors.rejectValue("userId", "error.required" );
			//					User�� ����, msg.properties Ű
			
		}
		
		//password �� �����̸� �ʵ� ���� �������� �����Ѵ�.
		if(!StringUtils.hasLength(user.getPassword())){
			errors.rejectValue("password", "error.required" );
			//					User�� ����, msg.properties Ű
			
		}
		
		//���� ����� Ŭ���� ��ü�� ���� �����̸�
		if(errors.hasErrors()){
			errors.reject("error.input.user" );//msg.properties �� Ű
			
		}
		
		
	}
}//class end
