/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 12:46:57
 * Modified: 2016�� 2�� 11�� ����� ���� 12:46:57
 */


class Test04_AUTO_UN_BOX
{
public static void main( String [] args ) 
{
   int a = 10;
   Integer A=a; //�̶� stack ������ �ִ� ���� heap ������ ����.
   
   Integer B = new Integer(20);
   
   int b = B; //heap ������ ������ ���۷����� ��ü�� ��������
   //stack ������ ���� �Ǵµ� �̸� Unbocing �̶� �Ѵ�.
   
   System.out.println("a : "+a);
   System.out.println("A : "+A);
   System.out.println("B : "+B);
   System.out.println("b : "+b);

   
   
}// end main

}
