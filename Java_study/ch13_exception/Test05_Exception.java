/*
 * Author: Administrator
 * Created: 2016�� 2�� 3�� ������ ���� 2:14:43
 * Modified: 2016�� 2�� 3�� ������ ���� 2:14:43
 */


//�޼���� stack �� ����ȴ�.
//stack : Last in First Out (LIFO)
class Test05_Exception
{
   public static void main( String [] args )
   {
      try
      {
         System.out.println("aaȣ����.");
         aa();
         System.out.println("aaȣ�� ��");
      }
      catch(Exception e1)
         
      {
         //System.out.println("����"+e1);
         e1.printStackTrace();
      }finally{
         System.out.println("main().... finally");
      }
      
   }// end main
  
   
public static void aa(){
      try
      {
         System.out.println("bb(); ȣ����");
         bb();
         System.out.println("bb(); ȣ����");
      }
      catch(Exception e2)
      {
          e2.printStackTrace();
         //System.out.println("����2"+e2);
      }
      finally
      {
         System.out.println("bb().... finally");
      }
   }
   
   public static void bb(){
      try
      {
         System.out.println("cc(); ȣ����");
         cc();
         System.out.println("cc(); ȣ����");
      }
      catch(Exception e3)
      {
          e3.printStackTrace();
         //System.out.println("����3"+e3);
      }
      finally
      {
         System.out.println("cc().... finally");
      }
   }


public static void cc(){
   try
   {
      System.out.println("dd(); ȣ����");
      dd();
      System.out.println("dd(); ȣ����");
   }
   catch(Exception e4)
   {
      System.out.println("����4 "+e4);
   }
   finally
   {
      System.out.println("dd().... finally");
   }
}



public static void dd(){
   try
   {
      System.out.println("������ �ϱ���.");
      int x=3;
      int y=0;
      System.out.println(x/y); //Exception�߻�.
      
   }
   catch(Exception e)
   {
      e.printStackTrace();
   }
   finally
   {
      System.out.println("dd().... finally");
   }
}





}//class end