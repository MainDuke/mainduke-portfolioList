/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오전 11:29:05
 * Modified: 2016년 2월 3일 수요일 오전 11:29:05
 */

//직접 처리.
class Test01_Exception 
{
	public static void main( String [] args ) 
   {
      try{
         int num = Integer.parseInt(args[0]);
         if(num % 0==0){
            System.out.println(num+" 은 짝수");
         }else{
            System.out.println(num+" 은 홀수");
         }
         
         
      }catch(ArrayIndexOutOfBoundsException e1){
         System.out.println("배열값을 정확히 넣으시오.");
      }catch(NumberFormatException e2){
         System.out.println("숫자를입력하시오.");
         
      }
      catch(ArithmeticException e3){
         System.out.println("연산 예외 : " +e3);
      }finally
      {
         System.out.println("finally절 수행. 예외 발생 없이 수행.");
      }
      
   }// end main

}
//1. 실행 88넣는다.
//2. 인수 값을 넣지 않는다.
//3. 인수값 a를 입력하고 실행한다.
//4. 인수값ㄱ을 숫자 입력하고
// if(num % 0 ==0 ) 해본다.