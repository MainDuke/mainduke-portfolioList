//object

class Test{}

class Test13_Object
{
	public static void main( String [] args ) 
   {
      System.out.println("A객체 정보");
      
      Test A = new Test();
      
 
      System.out.println("A클래스 이름 : "+A.getClass());
      
      System.out.println("A해쉬코드 : "+A.hashCode());
      //해쉬 코드는 검색이 용이하게 하기 위해 ㅁ나들어낸 고유의 정수이다.
      
      
      System.out.println("A객체 문자열 : "+A.toString());
      //toString() 메서드는 객체를 문자열로 반환 한다.
      //클래스이름@해쉬코드 16진.)
      
      Test B= new Test();
      Test C= new Test();
      
      System.out.println("B클래스 이름 : "+B.getClass());
      System.out.println("B해쉬코드 : "+B.hashCode());
      System.out.println("B객체 문자열 : "+B.toString());
      
      System.out.println("C클래스 이름 : "+C.getClass());
      System.out.println("C해쉬코드 : "+C.hashCode());
      System.out.println("C객체 문자열 : "+C.toString());
      
      Test13_Object D = new Test13_Object();
      System.out.println("D클래스 이름 : "+D.getClass());
      System.out.println("D해쉬코드 : "+D.hashCode());
      System.out.println("D객체 문자열 : "+D.toString());
      
      
      
   }// end main

}//class end.
