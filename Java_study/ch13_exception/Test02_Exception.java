/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오전 11:45:51
 * Modified: 2016년 2월 3일 수요일 오전 11:45:51
 */


class Test02_Exception
{
	public static void main( String [] args ) throws Exception
   {
      int num=Integer.parseInt(args[0]);
      
      if(num % 0 == 0){
         System.out.println(num + "짝수입니다.");
      }else{
         System.out.println(num+ "홀수 입니다.");
      }
 
   }// end main

}//class end

//1. 실행 88넣는다.
//2. 인수 값을 넣지 않는다.
//3. 인수값 a를 입력하고 실행한다.
//4. 인수값ㄱ을 숫자 입력하고
// if(num % 0 ==0 ) 해본다.