/*

throw
throw new TestException(); //객체생성 (예외 생성)

 */


class Test04_Exception
{
   public static void main( String [] args )	
   {
      int jum[]={55, 66, 76, 55}; //배열개수가 5가 아니면 clac 에서 예외 발생.
      
      try
      {
         double avg= Jumsu.clacAvg(jum); //메서드 호출.
         System.out.println("평균 "+avg);
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
         throw new JumsuException("배열 예외 입니다.");
      }
      //정상처리
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
