/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오전 9:44:01
 * Modified: 2016년 2월 11일 목요일 오전 9:44:01
 */

//clone() 객체 복사.

class Test14_Object_clone implements Cloneable
{
	String name; //전역 변수

   //cons
   public Test14_Object_clone(String name){
      this.name=name;
   }//cons end
   
   //over.
   public String toString(){
      return name+" 입니다.";
   }
   
   //main
   public static void main( String [] args ) 
   {
      try{
      Test14_Object_clone A = new Test14_Object_clone("첫번째");
      System.out.println("A :"+A);
      System.out.println("A :"+A.toString()); //두문장은 같다.
      //
      
      //객체 복사.
      Test14_Object_clone B =(Test14_Object_clone)A.clone();
      System.out.println("B : "+B);
      System.out.println("B : "+B.toString());
      
      //
      System.out.println(A.equals(B)); //레퍼런스 비교. false 
      System.out.println(A==B); //레퍼런스 비교. false
      System.out.println((A.toString()).equals(B.toString())); //문자열 비교.
       }catch(Exception ex){
      System.out.println(ex);}
      
   }// end main
   
}//class end
