package mypa;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class WelcomeTag extends TagSupport{
	public int doStartTag() throws JspException{
		try{
			JspWriter out=pageContext.getOut(); //out 객체 생성
			out.print("Welcome to My Custom Tag");
			
		}catch(Exception ex){
			throw new JspTagException("WelcomeTag.class 예외 :"+ex);
		}
		return SKIP_BODY;//해당 태그의 바디(몸체) 내용을 무시하라는 뜻
	}//doStarting
}//class
