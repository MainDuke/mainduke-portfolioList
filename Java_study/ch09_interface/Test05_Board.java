/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 10:30:03
 * Modified: 2016�� 1�� 28�� ����� ���� 10:30:03
 */

//BoardDao �������̽�
//BoardDaoImpl ���� Ŭ���� ���.

/*public void insertBoard(); //�߻� �޼���.
public void listBoard();
public void contentVoard();
public void editBoard();
public void delBoard();
*/

class Test05_Board
{
	public static void main(String args[])
	{
		//Static �޼����  Static�޼���, ������ ȣ�� �����ϴ�.
		//�Ϲ� �޼���� ��ü �����Ͽ� ȣ���ؾ��Ѵ�.
		
		BoardDao b = new BoardDaoImpl(); //���� Ŭ���� ������ ���� ��ü ó��.
		
		b.insertBoard();
		b.listBoard();
		b.contentBoard();
		b.editBoard();
		b.delBoard();
		
	}

}
