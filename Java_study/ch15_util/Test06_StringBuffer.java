/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 10:50:13
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 10:50:13
 */


class Test06_StringBuffer
{
	public static void main(String args[]){
      StringBuffer sb = new StringBuffer();
      
      sb.append("hello");
      sb.append("Good");
      
      System.out.println(sb.toString());
      
      sb.reverse();
      System.out.println(sb.toString());
      
      sb.delete(0,5);
      System.out.println(sb.toString());
      
      sb.reverse();
      System.out.println(sb.toString());

  
      StringBuffer sb1 = new StringBuffer();
      StringBuffer sb2 = new StringBuffer(10); //�ʱ� �뷮�� 10 ����.
      StringBuffer sb3 = new StringBuffer("java");
      
      System.out.println("sb1 capacity ���� ũ�� :"+sb1.capacity());
      System.out.println("sb2 capacity ���� ũ�� :"+sb2.capacity());
      System.out.println("sb3 capacity ���� ũ�� :"+sb3.capacity());
      
      System.out.println("sb1 ���� ����Ÿ ���� : "+sb1.length());
      System.out.println("sb2 ���� ����Ÿ ���� : "+sb2.length());
      System.out.println("sb3 ���� ����Ÿ ���� : "+sb3.length());
      
      
   }//main end

}//class end
