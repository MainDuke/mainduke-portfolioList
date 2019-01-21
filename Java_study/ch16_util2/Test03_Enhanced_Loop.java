/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 12:37:09
 * Modified: 2016년 2월 11일 목요일 오후 12:37:09
 */
/*Enhanced Loop Enhanced Loop ( for 문) 는 Collection 이나 배열 과 군집 데이터를 보유하는 객체이서

데이터를 꺼낼때 간단하기 위해서 사용한다 



형식---------------------------

for(파리미터:콜렉션변수명)

{       

}

-----------------------------
*/

class Test03_Enhanced_Loop
{
	public static void main( String [] args ) 
   {
      String arr1[]={"kim","lee","park"};
      
      for(String a:arr1)
      {
         System.out.println(a);
      }
      
      
      int arr2[]={10,20,30,40,50};
      
      for(int i:arr2)
      {
         System.out.println(i);
      }
      
      
   }// end main

} //class end.
