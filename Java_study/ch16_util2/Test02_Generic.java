/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 12:24:56
 * Modified: 2016년 2월 11일 목요일 오후 12:24:56
 */


//Generic 사용 컴파일시 에러 발견 할수 있다.
//Iterator을 상속받은 클래스들 : Collection , List , Set


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Test02_Generic
{
   
   //사용자 정의 메서드.
   public void testCollection(){
      List <String>list= new ArrayList<String>();//상위 클래스 변로 하위 객체 처리.
      list.add(new String("Hello World"));
      list.add(new String("Very Good"));
      list.add(new Integer(100));//실행 에러. 
      
      printCollection(list);
      
   }//testCollection end
   
   //사용자 정의 메서드.
   public void printCollection(Collection c){
      Iterator iter=c.iterator();//많이 사용.
      while(iter.hasNext())//자료가 있는 동안 반복,
      {
         String item=(String)iter.next();
         System.out.println("item : "+item);
         
      }
   }//printCollection() end
   
	public static void main( String [] args )
   {
      Test02_Generic A = new Test02_Generic();
      A.testCollection();
      
      
   }// end main

}//class end
