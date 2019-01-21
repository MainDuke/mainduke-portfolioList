package mypa;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


public class DateTag extends TagSupport {
	
	/*
	 public int doStartTag() throws JspTagException{
	 	return EVAL_BODY_INCLUDE; //�ش� �±��� �ٵ� �κ��� �ؼ� �϶�� ��
	 }//
	 * */

	public int doStartTag() throws JspTagException{
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspTagException{
		JspWriter out=pageContext.getOut();
		
		try{
			out.println(new Date());
			
		}catch(Exception e){
			throw new JspTagException(e.getMessage());
		}finally{
			return EVAL_PAGE; //�ش� Ŀ���� �±� �Ʒ� �ִ� jsp �������� ���� �����϶�� ��
			// 				<jsp:include page=""/> �� ���� ��� 
			//return SKIP_PAGE; �ش� Ŀ���� �±� �Ʒ��� JSP�������� �����϶�� ��
			//				<jsp:forward page=""/> �� ���� ����̴�. 
		}//finally end 
		
	}//end
	//HaHaHa
}//class end
