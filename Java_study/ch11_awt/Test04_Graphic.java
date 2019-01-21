/*
 * Author: Administrator
 * Created: 2016년 1월 29일 금요일 오전 11:19:52
 * Modified: 2016년 1월 29일 금요일 오전 11:19:52
 */

import java.awt.*;
import java.awt.event.*;

//inner 클래스 창종료 사용.

class Test04_Graphic extends Frame
{
	public Test04_Graphic(){
		super("마우스 예제1");
		addWindowListener(new MyWin()); //이벤트 종료.
		setBounds(200, 200, 600, 600); // x/y/w/h 
		setVisible(true); //창표시.
	}//cons end
	
	//inner class
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}//windowclosing end
	}//end Mywin
	
	//메서드
	//paint 글씨 출력하기~
	
	public void paint (Graphics g){
	/*g.drawString("문자열출력", 10, 50); //(" ", x 좌표,y좌표)단위는 픽셀.	
	
	Font font= new Font("Dialog", Font.BOLD, 30);
	//					글꼴 이름, 굵게, 크기
	g.setFont(font);//font 설정.
	g.drawString("문자열 출력 " , 10, 80);
	g.setFont(new Font("dialog", Font.BOLD+Font.ITALIC, 50));
	g.drawString("문자열 출력", 10, 130);
	
	//선 그리기.
	g.drawLine(10, 30, 400, 300); //x1,y1 ~ x2 y2 선 긋기.
	
	//사각형.
	g.setColor(Color.red);
	g.drawRect(10, 50, 100,100); //x, y, w, h;
	
	//둥근 사각형.
	g.setColor(Color.blue);
	g.drawRoundRect(10, 100, 100, 100, 30, 50); // x,y,w,h, x각도?,y곡률.
	
	//채워진 사각형.
	g.setColor(Color.red);
	g.fillRect(100, 50, 100,100); //x, y, w, h;
	
	//채워진 둥근사각형.
	g.setColor(Color.blue);
	g.fillRoundRect(150, 90, 100, 100, 30, 50); // x,y,w,h, x각도?,y곡률.
	 
	
	//원 그리기
	g.setColor(Color.blue);
	g.drawOval(200,140,50,50);
	
	//채워진 원 그리기.
	g.setColor(Color.blue);
	g.fillOval(80,30,50,50);

	//타원 그리기
	g.drawOval(80, 30, 50,100); //원은 W , H 의 길이에 따라서 원이 달라진다.
	
	
	//호 그리기.
	g.drawArc(200, 140, 250, 250, 30 , 240);
	
	g.fillArc(220, 160, 250, 250, 30 , 240);
	*/
	
	//다각형은 배열로 해야한다.
	
	int x[]={30,200,250, 400, 450, 30};
	int y[]={140, 50, 70,10,140,140};
	
	g.drawPolygon(x, y, x.length); //다각형 그리기.
	
	for(int i=0;i<y.length;i++)
	{
		y[i]+=100;
	}
	g.drawPolygon(x, y, x.length); //다각형 그리기.
	
	
	
}//paint end
	
	
	
	public static void main( String [] args ) 
	{
		new Test04_Graphic();
	}// end main
}//class end
