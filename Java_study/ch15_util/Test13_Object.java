//object

class Test{}

class Test13_Object
{
	public static void main( String [] args ) 
   {
      System.out.println("A��ü ����");
      
      Test A = new Test();
      
 
      System.out.println("AŬ���� �̸� : "+A.getClass());
      
      System.out.println("A�ؽ��ڵ� : "+A.hashCode());
      //�ؽ� �ڵ�� �˻��� �����ϰ� �ϱ� ���� ������ ������ �����̴�.
      
      
      System.out.println("A��ü ���ڿ� : "+A.toString());
      //toString() �޼���� ��ü�� ���ڿ��� ��ȯ �Ѵ�.
      //Ŭ�����̸�@�ؽ��ڵ� 16��.)
      
      Test B= new Test();
      Test C= new Test();
      
      System.out.println("BŬ���� �̸� : "+B.getClass());
      System.out.println("B�ؽ��ڵ� : "+B.hashCode());
      System.out.println("B��ü ���ڿ� : "+B.toString());
      
      System.out.println("CŬ���� �̸� : "+C.getClass());
      System.out.println("C�ؽ��ڵ� : "+C.hashCode());
      System.out.println("C��ü ���ڿ� : "+C.toString());
      
      Test13_Object D = new Test13_Object();
      System.out.println("DŬ���� �̸� : "+D.getClass());
      System.out.println("D�ؽ��ڵ� : "+D.hashCode());
      System.out.println("D��ü ���ڿ� : "+D.toString());
      
      
      
   }// end main

}//class end.
