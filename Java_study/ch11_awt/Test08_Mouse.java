/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오후 4:28:40
 * Modified: 2016년 1월 29일 금요일 오후 4:28:40
 */

//MouseMotionListener 사용.
//1. 상속을 받는다.
//2. 이벤트 등록을 한다.
//3. 해당 메서드 오버라이딩 한다.
//마우스 이벤트 처리를 하려면?
import java.awt.*;
import java.awt.event.*;

class Test08_Mouse extends Frame
{
	//변수
	//생성자
	public Test08_Mouse(){
		super("마우스");
		addWindowListener(new MyWin());
		addMouseListener(new MyMouse());
		setBounds(10,10,500,500);
		setVisible(true);
		
		
	}
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner1
	
	//메서드 밖으로 전역 변수.
	int x,y;
	String name="";
	
	public class MyMouse extends MouseAdapter{
		public void mousePressed(MouseEvent me){//오버라이딩
			if(me.getButton() == me.BUTTON1){//왼쪽버튼
				x= me.getX();
				y= me.getY();	
				name="박문수";
				repaint(); //update()>clearRect()> paint()
		}else if(me.getButton()== me.BUTTON3){//오른쪽버튼	
			x= me.getX();
			y= me.getY();	
			name="홍길동.";
			repaint(); 	
			
		}else if(me.getButton() == me.BUTTON2){
				System.exit(0);
			}
		}//end
	}//inner2
	
	
	//paint
	public void paint(Graphics g){
	g.drawString(name,x,y);//마우스 버튼이 눌러진 곳에 문자 출력.
	}
	
	//메서드
	public static void main( String [] args )
	{
		new Test08_Mouse();
	}// end main
	
}
