/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 11:45:51
 * Modified: 2016�� 2�� 3�� ������ ���� 11:45:51
 */


class Test02_Exception
{
	public static void main( String [] args ) throws Exception
   {
      int num=Integer.parseInt(args[0]);
      
      if(num % 0 == 0){
         System.out.println(num + "¦���Դϴ�.");
      }else{
         System.out.println(num+ "Ȧ�� �Դϴ�.");
      }
 
   }// end main

}//class end

//1. ���� 88�ִ´�.
//2. �μ� ���� ���� �ʴ´�.
//3. �μ��� a�� �Է��ϰ� �����Ѵ�.
//4. �μ������� ���� �Է��ϰ�
// if(num % 0 ==0 ) �غ���.