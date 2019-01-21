/*
 * Author: Administrator
 * Created: 2016년 1월 26일 화요일 오전 9:39:55
 * Modified: 2016년 1월 26일 화요일 오전 9:39:55
 */


//super : 상위 클래스 객체를 뜻한다.
//super() : 상위 클래스 생성자를 호출한다.

import java.awt.*; //Frame
import java.awt.event.*; //이벤트 처리 할때 사용. 마우스 클릭.

class Test06_super extends Frame{
	//생성자 : 객체 초기화.
	public Test06_super(){
	super("연습 1"); //상위 클래스 생성자 호출
						//첫줄에 기재해야 해야한다.
	
	setTitle("홍길동 연습");
	setBackground(Color.yellow);//배경색.
						
	//setSize(300,300); //창크기 300픽셀.
	//setVisible(true); //창 표시.
	
	//this.setSize(300,300);  
	//this.setVisible(true);
	
	super.setSize(300,300);  
	super.setVisible(true);
	//생성자 안에서는 자기자신을 선언하지 않아도 된다.
	//3개의 호출법이 다 된다.
	
	}
	//JVM이 main()호출.
	public static void main( String [] args ) 
	{
		new Test06_super();// 객체 생성.
		
		//t : 클래스 변수, 인스턴스, 객체, 레퍼런스.
		
		//Test06_super t
		//int a=10;
		//자료형  변수.
					
	}// end main

}//end class
