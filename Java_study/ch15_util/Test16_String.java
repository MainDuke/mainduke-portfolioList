/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 10:47:44
 * Modified: 2016�� 2�� 11�� ����� ���� 10:47:44
 */


class Test16_String
{
	public static void main( String [] args ) 
   {
      String s1 = "hello";
      String s2 = "good";
      System.out.println(s1.length());
      System.out.println(s1.concat(s2)); //���ڿ� ��ħ
      System.out.println(s1.replace('e','a')); //���ڿ� ġȯ. ���� ġȯ.
      System.out.println(s1.replaceAll("hello", "�ȳ�")); //
      System.out.println(s1.toUpperCase());
      String s3 = "GOODMORNING";
      System.out.println(s3.toLowerCase());//�ҹ��� ġȯ.
      System.out.println(s3.charAt(4));
      
      String name= "ȫ�浿";
      System.out.println(name.replace("ȫ�浿", "�տ���"));
      
      
      //�ý��� �����ڵ� �˼� ���� �̰�~~
      
      StringBuffer jumin=new StringBuffer("881219-1055910");

      jumin.replace(0,6,"*******");
      System.out.println(jumin.toString());
      
      
   }// end main

}//class end
