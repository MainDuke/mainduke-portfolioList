/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 11:29:05
 * Modified: 2016�� 2�� 3�� ������ ���� 11:29:05
 */

//���� ó��.
class Test01_Exception 
{
	public static void main( String [] args ) 
   {
      try{
         int num = Integer.parseInt(args[0]);
         if(num % 0==0){
            System.out.println(num+" �� ¦��");
         }else{
            System.out.println(num+" �� Ȧ��");
         }
         
         
      }catch(ArrayIndexOutOfBoundsException e1){
         System.out.println("�迭���� ��Ȯ�� �����ÿ�.");
      }catch(NumberFormatException e2){
         System.out.println("���ڸ��Է��Ͻÿ�.");
         
      }
      catch(ArithmeticException e3){
         System.out.println("���� ���� : " +e3);
      }finally
      {
         System.out.println("finally�� ����. ���� �߻� ���� ����.");
      }
      
   }// end main

}
//1. ���� 88�ִ´�.
//2. �μ� ���� ���� �ʴ´�.
//3. �μ��� a�� �Է��ϰ� �����Ѵ�.
//4. �μ������� ���� �Է��ϰ�
// if(num % 0 ==0 ) �غ���.