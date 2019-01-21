/*
 * Author: Administrator
 * Created: 2016년 1월 27일 수요일 오후 12:23:24
 * Modified: 2016년 1월 27일 수요일 오후 12:23:24
 */

/*
★상위 클래스 변수로 하위 객체 처리하는 p.g
	상위클래스 변수=new 하위 클래스(); //upcasting
cf) double d =77; //자동 형변환
*/

import java.awt.*;
import java.awt.event.*;

class Test11_extends extends Frame
{
	
	//변수
	//생성자
	public Test11_extends(){
		super("upcasting");
		addWindowListener(new Mywin());//이벤트
	}
	//inner class
	class Mywin extends WindowAdapter{
		//오버 라이딩
		public void windowClosing(WindowEvent we){
		 System.exit(0); // 창종료, 프로그램 종료.
		}//windowClosing
	}//inner end
	
	
	public static void main( String [] args ) 
	{
		Frame f = new Test11_extends();// 객체 생성. 생성자 호출.
		
		f.setSize(300,300);
		f.setVisible(true);
		
		
	}// end main

}//class end
