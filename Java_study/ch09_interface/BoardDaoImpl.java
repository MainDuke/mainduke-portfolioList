/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 10:23:23
 * Modified: 2016년 1월 28일 목요일 오전 10:23:23
 */


class BoardDaoImpl implements BoardDao
{
	
	//상위 메서드 오버라이딩.
	public void insertBoard(){
		System.out.println("inesertBoard()....글쓰기");
	} //추상 메서드.
	public void listBoard(){
		System.out.println("listBoard()....목록");
	}
	public void contentBoard(){
		System.out.println("contentBoard()....글 내용보기.");
	}
	public void editBoard(){
		System.out.println("editBoard()....수정하기.");
	}
	public void delBoard(){
		System.out.println("delBoard()....삭제하기.");
	}
	

	
}
