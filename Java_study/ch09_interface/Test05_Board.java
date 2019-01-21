/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 10:30:03
 * Modified: 2016년 1월 28일 목요일 오전 10:30:03
 */

//BoardDao 인터페이스
//BoardDaoImpl 구현 클래스 사용.

/*public void insertBoard(); //추상 메서드.
public void listBoard();
public void contentVoard();
public void editBoard();
public void delBoard();
*/

class Test05_Board
{
	public static void main(String args[])
	{
		//Static 메서드는  Static메서드, 변수만 호출 가능하다.
		//일반 메서드는 객체 생성하여 호출해야한다.
		
		BoardDao b = new BoardDaoImpl(); //상위 클래스 변수로 하위 객체 처리.
		
		b.insertBoard();
		b.listBoard();
		b.contentBoard();
		b.editBoard();
		b.delBoard();
		
	}

}
