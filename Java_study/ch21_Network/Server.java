/*
프로토콜
사용중인 닉네임이 있을때, 1000
대기실 입장 100
방만들기 200
방들어가기 210
방에서메시지 400
대화명 변경 420
귓속말 450
방퇴장 290
종료 900
 */

import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;


public class Server extends Frame implements Runnable
{
   
   //vari
   Vector globalvc = new Vector(); //입장하는 모든 클라이언트 넣은 공간.
   Vector roomvc = new Vector(); //방이름 넣을려고
   TextArea ta = new TextArea(); //서버 정보 출력하려고.
   
   //cons
   
   public Server(){
      ta.setFont(new Font("Dialog", Font.BOLD, 20));
      add("Center", ta);
      setSize(500,300);
      setVisible(true);
      
   }//cons end
   
   public static void main( String [] args ) 
   {
      new Thread(new Server()).start();//시작, run() 호출.
   }// end main
   
   public void run(){
      ServerSocket ss= null;
      try
      {
         ss = new ServerSocket(7788); //서버 구동. 0~65535
         
         System.out.println("서버 구동중.");
         
         
      }
      catch(Exception e)
      {
         ta.append("서버구동 실패.");
         System.exit(0);
         
      }
      
      ta.append(" 서버 실행되었음, 클라이언트 접속을 기다리는중.. \n");
      Socket s = null;
      
      while(true)
      {
         try
         {
            s = ss.accept(); // 클라이언트 요청 받고, 소켓 실행.
            ta.append("client 접속 : "+s+"\n");
            Service ser =new Service(s); //객체 생성.
            
         }
         catch(Exception e)
         {
            
         }
      }//while end
      
   }//run end---------------------------------------------------
   
   //inner class 
   class Service extends Thread{
      //vari
      
      BufferedReader in;
      OutputStream out;
      Room myroom = new Room(); //클라이언트 1명당 Room생성, 대기실.
      String name = "" ; //대화명 변수.
      
      //cons-----------------------------------------------------------------------
      public Service(Socket s){
         
         try{
            
            
            out = s.getOutputStream();
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           
            
            name = in.readLine();
            myroom.title = "대기실";
            
            //String s3 = s.getInetAddress().getHostAddress(); //ip얻기.
            
            /*
             */
         }catch(Exception ex){
            ta.append("client와 연결 불안전"+s+"\n");
         }//try 1 end
          
         
         //모든 클라이언트에게 , 현재 접속자를 보낸다.
            for(int i=0;i< globalvc.size();i++)
            {
               try
               {
                  Service ser = (Service)globalvc.get(i);
                  if(name.equals(ser.name))
                  {
                     putMsgTo("1000|"+name+"은 사용중인 대화명입니다.");
                     return;
                  }//if
                  //클라이언트 들에게 보낸다.
                  putMsgTo("100|"+ser.name+"|"+ser.myroom.title);
                  
               }catch(Exception ex2)
               {
                  globalvc.remove(i--);
               }
            }//for end
            
            //현재 같은 이름의 방이 있을때... 문제점 찾아야 함.
            //현재 접속자에게 개설된 방정보를 보낸다.
            for(int i=0;i<roomvc.size();i++)   
            {
               Room r = (Room)roomvc.get(i);
               try
               {
                  putMsgTo("200|"+r.title+"|"+r.inwon);
                  
               }catch(Exception e){}
               
            }//for end
            
            globalvc.add(this);
            putMsgAll("100|"+name+"|"+myroom.title); //접속자가 대기실에 들어왔음을 클라이언트에게 알린다.
            start(); // 시작. run 호출.
         
         
      }//Service cons end---------------------------------------
      
      public void run(){
         
         while(true)
         {
            try
            {
               //vari
               String msg = in.readLine();
               if(msg == null)
               {
                  return;
               }//if
               
               StringTokenizer token = new StringTokenizer(msg,"|");
               int protocol = Integer.parseInt(token.nextToken());
               
               switch(protocol)
               {
               case 200:	{
                     
                     String t = token.nextToken(); //방제목.
                     String flag = "";
                     
                     for(int i=0;i<roomvc.size();i++)
                     {
                        Room r = (Room)roomvc.get(i); //방이름 꺼낸다.
                        
                        if(t.equals(r.title))
                        {
                           putMsgTo("2000|"+t+" 는 사용중인 대화방 입니다.");
                           flag= t;
                           break; //for 탈출.
                        }//if
                       }//for
                     if(!flag.equals(t)){
                     
                     //방 만들기
                     myroom = new Room(t, name,1);
                     myroom.uservec.add(this); //대화방에 저장.
                     roomvc.add(myroom);//방이름 저장.
                     putMsgAll("200|"+myroom.title+"|"+0);// 방이 개설 되었음.
                     putMsgAll("210|"+name+"|"+myroom.title); //방에 들어왔다는
                 
                  }//if 
                  
                  
                  }//case 200 end
                  break;
                  
               case 210:{//방들어가기
                     String t= token.nextToken(); //방제목
                     
                     for(int i=0; i<roomvc.size();i++)
                     {
                        Room r= (Room)roomvc.get(i); //방이름을 꺼낸다.
                        if(t.equals(r.title))//방을 찾았으면
                        {
                           myroom=r;
                           myroom.uservec.add(this);
                           myroom.inwon++; //인원증가
                           putMsgAll("210|"+name+"|"+myroom.title);
                           break;
                        }//if
                        
                     }//for
                  }//case 210 end
                  break;
               case 400: //방에서 대화하기
                  {
                     putMsgRoom("400|"+name+" 님의 말>>"+token.nextToken());
                     //
                  }//case 400 end
                  break;
                  
               case 290:
                  {
                     myroom.uservec.remove(this);
                     myroom.inwon=myroom.uservec.size();
                     
                     if(myroom.inwon==0)
                     {
                        roomvc.remove(myroom); //방제거.
                     }//if
                     
                     putMsgAll("290|"+name+"|"+myroom.title);
                     myroom= new Room();                     
                     myroom.title= "대기실"; 
                  }//case 290 end
                  break; 
               
               case 420: //대화명 변경.
                  {
                     String newName = token.nextToken(); //새로운 대화명을 읽어온다.
                     putMsgAll("420|"+name+"|"+newName+"|"+myroom.title);
                     //모든 클라이언트에게 날린다.
                     name=newName;
                  }//case 420 end
                  break;
                  
               case 450: //귓속말.
                  {
                     String sayName = token.nextToken();
                     String sayC = token.nextToken();
                     
                     //대화방에서 귓속말 보낼 상대를 찾아낸다.
                     for(int i=0;i<myroom.uservec.size();i++)
                     {
                        Service ser = (Service)myroom.uservec.get(i);
                        
                        if(sayName.equals(ser.name))
                        {
                           try
                           {
                            ser.putMsgTo("450|"+name+"|"+sayC);  
                           }
                           catch(Exception ex)
                           {
                              myroom.uservec.remove(ser);
                           }
                           break;//for 탈출.
                        }//if
                     }//for
                  }//case 450 end
                  break;
                  
               case 900 : {//종료. // 지금 채팅방 사이트에서 나간 클라이언트.
                        globalvc.remove(this); //대기실에서 제거.
                        putMsgAll("900|"+name+"|"+myroom.title); //모두에게 알린다.
                     
                        if(!myroom.title.equals("대기실"))
                        {
                           //대화방에서 나갔으면
                           myroom.uservec.remove(this);
                           if(--myroom.inwon==0)
                           {
                              roomvc.remove(myroom); //방제거.
                           }//inner if
                        }//if
                        try
                        {
                         in.close();
                           out.close();
                        }
                        catch(Exception ex)
                        {
                           
                        }
                        return; //서버는 계속 작업을 해주게 된다.
                  }//case 900 end
                  //break;
                  
                  
               }//switch end
               
               
            }catch(Exception ex)
            {
            return;
         }//catch end // 예외가 발생해도 리턴해야된다. 서버는 계속 돌아야하니깐.
            
         }//while
         
      }//run end------------------------------------------------------
      
         
         //custom//
      public void putMsgAll(String msg){
         synchronized(this){
            
            for(int i=0; i < globalvc.size(); i++)
            {
               try{
                  Service ser = (Service)globalvc.get(i);
                  ser.putMsgTo(msg); //메서드 호출.
               }catch(Exception ex){
                 System.out.println(ex);
                  globalvc.remove(i--);
               }//TC end
            }//for
        }//synchronized end
      }//putMsgALL end

     public void putMsgRoom(String msg){
         
         synchronized (this){
            for(int i=0;i<myroom.uservec.size();i++)
            {
            
            try{
               Service ser=(Service)myroom.uservec.get(i);
               ser.putMsgTo(msg); //메세드 호출.
               
            }catch(Exception ex){}//TC end
         }//for
           
         }//synchronized end
         
      }//putMsgRoom end

      
      public void putMsgTo(String msg) throws Exception{
         synchronized (this){
            out.write((msg+"\r\n").getBytes()); //클라이언트로 msg 전송
            //getByte()는 인코딩 처리하는 메서드.        
            
         }//synchronized end
      }//putMsgTo end
         
         
   }//=========Service end=======
   
   
}//Server class end-------><
