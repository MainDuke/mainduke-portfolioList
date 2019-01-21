package ch19.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; //리스트
import boardmysql.*;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String pageNum= request.getParameter("pageNum"); //페이지 번호
		if(pageNum==null){
			pageNum="1";
		}
		
		int pageSize=10; //한 페이지의 글의 개수
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1; //한 페이지의 시작글 번호
		int endRow=currentPage * pageSize; //한 페이지의 마지막 글번호
		int count=0;
		int number=0;
		
		List articleList=null;
		BoardDao dbPro=BoardDao.getInstance(); //개체 얻기, DB 연동
		count=dbPro.getArticleCount(); //메소드 호출, 전체 글의 수
		
		//
		if(count>0){ //글이 존재하면
			//mysql
			articleList = dbPro.getList(startRow, pageSize); //현재 페이지에 해당하는 글 목록

			//oracle
			//articleList = dbPro.getList(startRow, endRow); //현재 페이지에 해당하는 글 목록
		}else{ //글이 없으면
			articleList = Collections.EMPTY_LIST;
			//EMPTY_LIST=null;
		}//else
		
		////////////////////////////
		number=count-(currentPage-1)*pageSize; //글 목록에 표시할 글 번호
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
			
		return "/ch19/list.jsp"; //해당 뷰를 리턴
	}//requestPro() end

}//class end
