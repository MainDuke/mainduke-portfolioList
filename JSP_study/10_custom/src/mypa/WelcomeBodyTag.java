package mypa;
import java.io.*;

import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


public class WelcomeBodyTag extends TagSupport{
	int count;//변수
	
	public int doStartTag() throws JspTagException{
		try{
		pageContext.getOut().println("환영합니다.<br>");
		}catch(Exception ex){
			throw new JspTagException("WelcomeBodyTag.doStartTag() 예외 "+ex);
		}
		return EVAL_BODY_INCLUDE; //해당 태그의 바디내용을 해석하라는 뜻
	}// doStartTag end
	
	public int doAfterBody() throws JspException{
		if(count<5){
			count++;
			try{
				pageContext.getOut().println("환영합니다.<b>");
			}catch(Exception ex){
				throw new JspTagException("WelcomeBodyTag.doStartTag() 예외 "+ex);
			}
			return EVAL_BODY_AGAIN; //몸체 내용을 다시 해석 하라는 뜻 (몸체를 반복적으러 처리하기 위해서)
		}else{
			return SKIP_BODY; //몸체를 한번만 처리하는 경우
		}
	}//doAfterBody end
	
	
	
}//class end
