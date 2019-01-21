/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오후 3:45:09
 * Modified: 2016년 2월 3일 수요일 오후 3:45:09
 */


import java.io.*;


class BuffR
{
	public static void main( String [] args ) throws Exception
   {
      //FileReader fr = new FileReader("a2.txt");
     // BufferedReader br = new BufferedReader(fr);
      BufferedReader br = new BufferedReader(new FileReader("a2.txt"));
      
      
      String str="";
      
      while((str=br.readLine()) != null) // 파일끝이 아닌동안 반복 수행.
      {
         System.out.println(str);
         
      }//while
      
      br.close();
      
   }// end main

}//class end.
