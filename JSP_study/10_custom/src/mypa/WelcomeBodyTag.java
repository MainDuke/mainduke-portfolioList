package mypa;
import java.io.*;

import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


public class WelcomeBodyTag extends TagSupport{
	int count;//����
	
	public int doStartTag() throws JspTagException{
		try{
		pageContext.getOut().println("ȯ���մϴ�.<br>");
		}catch(Exception ex){
			throw new JspTagException("WelcomeBodyTag.doStartTag() ���� "+ex);
		}
		return EVAL_BODY_INCLUDE; //�ش� �±��� �ٵ𳻿��� �ؼ��϶�� ��
	}// doStartTag end
	
	public int doAfterBody() throws JspException{
		if(count<5){
			count++;
			try{
				pageContext.getOut().println("ȯ���մϴ�.<b>");
			}catch(Exception ex){
				throw new JspTagException("WelcomeBodyTag.doStartTag() ���� "+ex);
			}
			return EVAL_BODY_AGAIN; //��ü ������ �ٽ� �ؼ� �϶�� �� (��ü�� �ݺ������� ó���ϱ� ���ؼ�)
		}else{
			return SKIP_BODY; //��ü�� �ѹ��� ó���ϴ� ���
		}
	}//doAfterBody end
	
	
	
}//class end
