package mypa;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class WelcomeTag extends TagSupport{
	public int doStartTag() throws JspException{
		try{
			JspWriter out=pageContext.getOut(); //out ��ü ����
			out.print("Welcome to My Custom Tag");
			
		}catch(Exception ex){
			throw new JspTagException("WelcomeTag.class ���� :"+ex);
		}
		return SKIP_BODY;//�ش� �±��� �ٵ�(��ü) ������ �����϶�� ��
	}//doStarting
}//class
