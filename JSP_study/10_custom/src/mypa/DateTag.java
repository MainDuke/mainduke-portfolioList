package mypa;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


public class DateTag extends TagSupport {
	
	/*
	 public int doStartTag() throws JspTagException{
	 	return EVAL_BODY_INCLUDE; //해당 태그의 바디 부분을 해석 하라는 뜻
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
			return EVAL_PAGE; //해당 커스텀 태그 아래 있느 jsp 페이지를 마저 수행하라는 뜻
			// 				<jsp:include page=""/> 과 같은 기능 
			//return SKIP_PAGE; 해당 커스텀 태그 아래에 JSP페이지를 무시하라는 뜻
			//				<jsp:forward page=""/> 과 같은 기능이다. 
		}//finally end 
		
	}//end
	//HaHaHa
}//class end
