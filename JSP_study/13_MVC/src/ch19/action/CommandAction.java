package ch19.action;

import javax.servlet.http.*;

//인터페이스
//요청 파라미터로 명령어를 전달하는 방식의 슈퍼(super) 인터페이스
public interface CommandAction {
	
	//메소드 딱 하나만 넣어놓음
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable;

}//
