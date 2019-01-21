package mypa;
import java.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class PageTag extends TagSupport{

	private String from;
	private String to;
	
	//setter
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public int doStartTag() throws JspException{
		int start=Integer.parseInt(from);
		int end=Integer.parseInt(to);
	
		try{
			JspWriter out=pageContext.getOut();
			out.println("Page &nbsp;");
			for(int i=start;i<end; i++){
				out.println("<a href=PageTag.jsp?nowPage="+i+">");
				out.println("["+i+"]");
				out.println("</a>&nbsp;");			
			}//for
			
		}catch(Exception ex){throw new JspTagException("doStartTag ¿¹¿Ü: "+ex); }
		
		return SKIP_BODY;
	}// doStartTag end
	
	
	
}//class end
