/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 9:30:10
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 9:30:10
 */

/*Stack�� �迭ó�� �� �� �̻��� �����͸� ������ �� �ִ� ��� ���� ������ 
������ �����ϰ� ������ ������ ������ �ִٴ� �鿡�� �迭�� �������� �ִ� 

������ LIFO ( Last-In , First-out) ����� ����̴� 

Stack �޼����
push(E item) : ���� �������� ��ü�� �߰��Ѵ� 
empty() : ���� ������ ����ִ°��� Ȯ�� ( isEmpty() �� ����)
pop()  : ���� �� ���� ��ü�� ������ ( ��ü ���� )
peek() :  ���� �� ���� ��ü�� ������ ( ��ü ���� ���� �ʴ´�  
*/


import java.util.*;

class Test14_stack
{
	public static void main( String [] args ) 
   {
      Stack<String> stack = new Stack<String>();
      stack.push("���");
      stack.push("��");
      stack.push("����");
      stack.push("����");
      stack.push("������");
      
      while(!stack.isEmpty())//���� �����̺�� ���� �ʴٸ�, �ݺ�����.
      {
         System.out.println(stack.pop());
      }//while
      
      
      }// end main

}//class end
