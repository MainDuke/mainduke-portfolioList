/*

throw
throw new TestException(); //��ü���� (���� ����)

 */


class Test04_Exception
{
   public static void main( String [] args )	
   {
      int jum[]={55, 66, 76, 55}; //�迭������ 5�� �ƴϸ� clac ���� ���� �߻�.
      
      try
      {
         double avg= Jumsu.clacAvg(jum); //�޼��� ȣ��.
         System.out.println("��� "+avg);
      }
      catch(JumsuException e)
      {
                 System.out.println("test  "+e); 
      }
      finally
      {
      }
      
   }// end main

}//class

//------------------------
class Jumsu{
   public static double clacAvg(int score[]) throws JumsuException {
      if(score.length != 5)
      {
         throw new JumsuException("�迭 ���� �Դϴ�.");
      }
      //����ó��
      int sum=0;
      for(int i =0;i<score.length;i++)
      {
         sum+=score[i];
      }
      return ((double)sum/score.length);
      
   }//clacAvg end
}//Jumsu end

class JumsuException extends Exception{
   public JumsuException(String msg){
   super(msg);
   }
}
