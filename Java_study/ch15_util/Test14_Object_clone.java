/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 9:44:01
 * Modified: 2016�� 2�� 11�� ����� ���� 9:44:01
 */

//clone() ��ü ����.

class Test14_Object_clone implements Cloneable
{
	String name; //���� ����

   //cons
   public Test14_Object_clone(String name){
      this.name=name;
   }//cons end
   
   //over.
   public String toString(){
      return name+" �Դϴ�.";
   }
   
   //main
   public static void main( String [] args ) 
   {
      try{
      Test14_Object_clone A = new Test14_Object_clone("ù��°");
      System.out.println("A :"+A);
      System.out.println("A :"+A.toString()); //�ι����� ����.
      //
      
      //��ü ����.
      Test14_Object_clone B =(Test14_Object_clone)A.clone();
      System.out.println("B : "+B);
      System.out.println("B : "+B.toString());
      
      //
      System.out.println(A.equals(B)); //���۷��� ��. false 
      System.out.println(A==B); //���۷��� ��. false
      System.out.println((A.toString()).equals(B.toString())); //���ڿ� ��.
       }catch(Exception ex){
      System.out.println(ex);}
      
   }// end main
   
}//class end
