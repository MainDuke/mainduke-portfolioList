class Test2
{

   public static void main(String args[])
   {
     System.out.print("자바");
     System.out.print("안녕");
     System.out.print("반갑다");

     System.out.println();
    //==============================
     System.out.print("자바\n");// \n : line skip ( 줄바꿈 )
     System.out.print("안녕\n");
     System.out.print("반갑다\n");
     System.out.println();
    //==============================

     System.out.print("자바\t");//\t 는 일정 간격을 띄운다(8칸 정도)
     System.out.print("안녕\t");
     System.out.print("반갑다\t");
   }
}

//"Test2.java" 로 저장 
// javac Test2.java    컴파일 
// java  Test2    실행 
