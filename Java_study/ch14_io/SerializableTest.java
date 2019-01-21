/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오후 4:07:18
 * Modified: 2016년 2월 4일 목요일 오후 4:07:18
 */

import java.io.*;
class SerializableTest
{
	public static void main( String [] args ) throws IOException,ClassNotFoundException 

   {
      HandPhone hp1 = new HandPhone("갤럭시6", 800000);
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ob.txt"));
      
      oos.writeObject(hp1);
      oos.close();
      
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ob.txt"));
      HandPhone hp2=(HandPhone)ois.readObject();   
      
      System.out.println("핸드폰 이름"+hp2.getHpName());
      System.out.println("핸드폰 가격"+hp2.getPrice());
      
      ois.close();
      
      
   }// end main

}
