/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 10:20:58
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 10:20:58
 */

class Go extends Thread{
   public void run(){//�������̵�
      int i=1;
      while(i<=50)
      {
         System.out.print("go ");
         i++;
      }//while
   }//run
}

class Come extends Thread{
   public void run(){//�������̵�
      int i=1;
      while(i<=50)
      {
         System.out.print("come ");
         i++;
         }//while
   }//run
   
}
/*


5. �����带 ����Ͽ� ���α׷��� �ۼ��ϴ� ���

(1)  Thread �� Runnable�� ��� �޾� 

(2)  run()�޼��忡 ������ȿ��� ������ ������ �������̵� �ϰ�

(3)  �� Thread Ŭ������ ��ü��  �����ϰ� start()�޼��带 �̿��Ͽ� run() �޼��带

ȣ���ϸ� �ȴ�



 */

class Test01_GoCome
{
   public static void main( String [] args ) 
   {
      
  Go go = new Go();
   Come come = new Come();
   go.start(); //run() call
   come.start(); //run() call

}//end main
}
