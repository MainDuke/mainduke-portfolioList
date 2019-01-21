
package ch19.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//제목글과 답변글의 구분
		int num=0, ref=1, re_step=0, re_level=0;
		
		try{
			if(request.getParameter("num")!=null){ //답글이면
				num=Integer.parseInt(request.getParameter("num"));
				ref=Integer.parseInt(request.getParameter("ref"));
				re_step=Integer.parseInt(request.getParameter("re_step"));
				re_level=Integer.parseInt(request.getParameter("re_level"));
			}//if
		}catch(Exception e){e.printStackTrace();}
		
		
		//해당 뷰에서 사용할 속성
		//request.setAttribute("Object", Object); <- 이런 구조
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("re_level", new Integer(re_level));
		
		return "/ch19/writeForm.jsp"; //해당 뷰를 리턴한다.
		//요청을 하면 action이 먼저 받고 컨트롤러에서 이 부분으로 포워딩 하는거지. 
		//ch19 폴더 만들고 저 jsp 만들어야 함.
	}

}//class
