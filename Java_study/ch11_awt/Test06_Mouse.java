/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오후 2:18:55
 * Modified: 2016년 1월 29일 금요일 오후 2:18:55
 */
import java.awt.*;
import java.awt.event.*;

//인터페이스의 메서드는 모두 오버라이딩 해줘야한다!!!
//상위 클래스의 메서드는 오버라이딩 불 필요.
class Test06_Mouse extends Frame implements MouseListener, MouseMotionListener
{
	//변수
	private int xpos, ypos;
	private String msg;
	//생성자
	public Test06_Mouse(){  //생성자에서 이벤트를 등록해줘야한다.
		super("마우스 이벤트");
		addWindowListener(new MyWin()); //윈도우 이벤트 등록.
		setBounds(500,350,400,500);
		setVisible(true);
		addMouseListener(this);//이벤트 등록.
		addMouseMotionListener(this); //이벤트 등록.
	}//cons end
	
	//inneerclass
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//MyWin end

	//오버라이딩. Mouse인터페이스 7개를 각각 오버라이딩. 
	public void mousePressed(MouseEvent m){
	setVal("mousePressed",m.getX(),m.getY());}//메서드 호출.}//Mouse
	

	public void mouseClicked(MouseEvent m){
      System.out.println("trd");
	setVal("mouseClicked",m.getX(),m.getY());}//Mouse
	public void mouseReleased(MouseEvent m){
	setVal("mouseReleased",m.getX(),m.getY());
			
			}//Mouse
	
	public void mouseEntered(MouseEvent m){
	System.out.println("마우스커서가 창안으로 들어왔습니다.");
	}//Mouse
	public void mouseExited(MouseEvent m){
	System.out.println("마우스 커서가 창 밖으로 나갔습니다.");
	
	}//
	
	
	public void mouseDragged(MouseEvent m){//
	setVal("mouseReleased",m.getX(),m.getY());}//MouseMotion
	public void mouseMoved(MouseEvent m){
	setVal("mouseReleased",m.getX(),m.getY());}//MouseMotion
	
	//사용자 정의 메서드.
	private void setVal(String msg, int x, int y){
		this.xpos=x;
		this.ypos=y;
		this.msg=msg;
		repaint(); //다시 그리기, paint()메서드 호출.
	}
	//paint 메서드
	public void paint(Graphics g){
		g.drawString(msg+" @["+xpos+","+ypos+"]", xpos, ypos);
	}
	
	//메서드
	public static void main( String [] args ) 
	{
		new Test06_Mouse();
	}// end main
	


}//class end
