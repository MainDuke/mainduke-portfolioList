import java.util.*;


class Room
{
	Vector uservec = new Vector();
   String title,zzang; //방제목 방장이름.
   int inwon; //인원.
   
   
   //cons
   public Room(){}
   
   //인자 있는 생성자. : 채팅방에 들어왔을때.
   
   public Room(String t, String z, int i){
      
      title = t;
      zzang = z;
      inwon = i;
  
      
   }
   
}//class

//컴파일만.
