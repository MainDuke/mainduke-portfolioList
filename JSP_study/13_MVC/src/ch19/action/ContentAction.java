
package ch19.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardmysql.*;

public class ContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		int num=Integer.parseInt(request.getParameter("num")); //해당 글 번호
		String pageNum=request.getParameter("pageNum"); //해당 페이지 번호
		
		BoardDao dbPro=BoardDao.getInstance(); //DB처리
		BoardDto article= dbPro.getArticle(num); //해당 글번호에 대한 해당 레코드
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/ch19/content.jsp"; //해당 뷰를 리턴
	}//requestPro() end

}//class end
