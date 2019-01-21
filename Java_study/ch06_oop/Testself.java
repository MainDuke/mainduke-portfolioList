/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오전 11:46:31
 * Modified: 2016년 2월 11일 목요일 오전 11:46:31
 */

import java.util.*;
class Testself
{
   public static void main(String[] args) {
      
      /*
       * Random클래스
       * -생성자
       * Random():현재의 시간을 초기값으로 하는 난수발생
       * Random(long seed) : seed값을 초기값으로하는 난수발생
       */
      
      System.out.println("== Random 함수 생성시 seed값을 100으로 줬을경우");
      Random random = new Random(100);
      for (int i=0;i<10;i++){
         System.out.print(random.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random 함수 생성시 seed값을 100으로 줬을경우");
      Random random2 = new Random(100);
      for (int i=0;i<10;i++){
         System.out.print(random2.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random 함수 생성시 seed값을 50으로 줬을경우");
      Random random3 = new Random(50); //seed값을 초기값으로 하는 난수발생
      for (int i=0;i<10;i++){
         System.out.print(random3.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random 함수 생성시 기본생성자로 생성했을경우");
      Random random4 = new Random();
      for (int i=0;i<10;i++){
         System.out.print(random4.nextInt(3)+" ");
      }
      System.out.println();
      System.out.println("== Random 함수 생성시 기본생성자로 생성했을경우");
      Random random5 = new Random(); //현재의 시간을 초기값으로 하는 난수발생.
      for (int i=0;i<10;i++){
         System.out.print(random5.nextInt(3)+" ");
      }
      
   } 
}