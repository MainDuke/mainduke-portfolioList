/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 9:10:27
 * Modified: 2016�� 2�� 4�� ����� ���� 9:10:27
 */

/*System.in �� InputStream��ü �̱� ������ InputStreamReader ������ �μ��� ���޵ȴ�.
�׷����� InputStreamReader ��ü�� BufferReader ������ �μ��� ���޵ȴ�.*/

import java.io.*;

class ReadConsole
{
	public static void main (String args[]) throws Exception 
   {
    InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader be= new BufferedReader(isr);
      
      String strKor, strEng; 
      int kor, eng, tot;
      
      System.out.print("���������� �Է��Ͻÿ� >>");
      strKor=be.readLine();
      
      System.out.print("���������� �Է��Ͻÿ� >>");
      strEng=be.readLine();

  
      kor=Integer.parseInt(strKor);
      eng=Integer.parseInt(strEng);

      tot= kor+eng;
       System.out.printf("���� ���� : %d ���� ���� : %d ���� %d", kor, eng, tot);

  
      
   }//end main

}//class end
