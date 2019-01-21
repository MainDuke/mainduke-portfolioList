//awt = vc++
//인터페이스 사용.
import java.awt.*;
import java.awt.event.*;

class Test01_Window extends Frame implements WindowListener
{
	//변수
	//생성자
	public Test01_Window(){
	super("창종료");
	addWindowListener(this);//이벤트 등록.
	
	setSize(300, 300);//창크기.
	setVisible(true);//창표시
	}
	//오버라이딩
	public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);//프로그램 창 종료.
	}
	public void windowClosed(WindowEvent w){} //창 닫은 후
	public void windowOpened(WindowEvent w){} // 창 오픈 했을때
	public void windowIconified(WindowEvent w){} // 아이콘화
	public void windowDeiconified(WindowEvent w){} //비 아이콘화
	public void windowActivated(WindowEvent w){} //활성화
	public void windowDeactivated(WindowEvent w){} // 비활성화.
	
	//main
	public static void main( String [] args ) 
	{
		new Test01_Window(); //객체 생성.
		
	}// end main
}
