package upload;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;



public class FileUploadBean {
	public String upload(HttpServletRequest request){
	
		String reply="";
		try{
			//MultipartRequest multi=new MultipartRequest(request, "c:\\_java\\aa\\");
			MultipartRequest multi=new MultipartRequest(request, "c:\\_java\\aa\\", 2014*1024*5, "utf-8" , new DefaultFileRenamePolicy());
			reply="파일 업로드 성공";
			
			
		}catch(Exception ex){
			reply="파일 업로드 실패 : "+ex;
		}
		
		return reply;
		
	}//end


}//class end
