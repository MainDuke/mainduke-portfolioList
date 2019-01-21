/*
프로토콜
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
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import java.io.*;
import java.net.*;

class MainClient extends JFrame implements Runnable, ActionListener, MouseListener
{
   //vari
   Socket s;
   BufferedReader in;
   OutputStream out;
   
   String name, ip, title = "대기실"; //name>> 대화명, host >ip;
   
   String [][]data1 = new String[0][2];
   String []cols1 = {"방제목", "인원"};
   
   String [][]data2 = new String[0][1];
   String []cols2 = {"대화명"};
   
   String [][]data3 = new String[0][2];
   String []cols3 = {"대화명", "위치"};
   
   DefaultTableModel model1= new DefaultTableModel(data1, cols1){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };//DefaultTableModel end
   
   DefaultTableModel model2 = new DefaultTableModel(data2, cols2){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };//model 2 end  
   DefaultTableModel model3 = new DefaultTableModel(data3, cols3){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };
   
   JTable table1 = new JTable(model1);
   JTable table2 = new JTable(model2);
   JTable table3= new JTable(model3);
   
   JScrollPane waitroom = new JScrollPane(table1); //방제목 , 인원
   JScrollPane roominfo = new JScrollPane(table2);//대화명
   JScrollPane waitinfo = new JScrollPane(table3);//대화명, 위치.
   
   JButton creatB = new JButton("방 만들기");
   JButton roominB = new JButton("방 들어가기");
   JButton exitB = new JButton("종  료");
   
   //룸 클라이언트 디자인 생성자 호출.
   RoomClient client = new RoomClient(); // *** 객체 생성.
   
   //cons---------------------------------------------------------------------------------cons
   public MainClient(String ip){
      
      setTitle("chat_Main");
      this.ip=ip; //host ip;
      
      table1.getTableHeader().setReorderingAllowed(false); //열 순서 고정.
      table2.getTableHeader().setReorderingAllowed(false); 
      table3.getTableHeader().setReorderingAllowed(false); 
      
      //배경색 설정.
      table1.getTableHeader().setBackground(new Color(255,207,96));
      table2.getTableHeader().setBackground(new Color(255,207,96));
      table3.getTableHeader().setBackground(new Color(255,207,96));
      
      //버튼 글씨 설정.
      creatB.setFont(new Font("Dialog",Font.BOLD, 12));
      roominB.setFont(new Font("Dialog",Font.BOLD, 12));
      exitB.setFont(new Font("Dialog",Font.BOLD, 12));
      
      //프레임 배치.
      getContentPane().setLayout(null);
      getContentPane().add(waitroom).setBounds(10,10,400,250); //x,y,w,h
      getContentPane().add(roominfo).setBounds(415,10,168,250); 
      getContentPane().add(waitinfo).setBounds(10,270,400,197);
      
      getContentPane().add(creatB).setBounds(449,300,100,30);
      getContentPane().add(roominB).setBounds(449,340,100,30);
      getContentPane().add(exitB).setBounds(449,380,100,30);
      //table1.setSelectonMode(0);
      
      name = JOptionPane.showInputDialog(null, "대화명을입력하시오.","대화명입력",JOptionPane.YES_NO_OPTION);
      
      if(name == null || name.length() < 1)
      {
         return;
      }
      
      connectProcess(); // 사용자 정의 메서드 호출.
      setSize(600,550);
      setVisible(true);
      eventUp(); //사용자 정의 메서드 호출.
      
   }//MainClient cons end---------------------------------------------------cons
   
   //overriding=======================================================================
   //run()=======================================================================run
   public void run(){ //서버에서 보내준 정보를 출력.
      
      while(true)
      {
         try
         {
            String msg = in.readLine(); //서버에서 보내준 내용 받는다.
            if(msg == null)
            {
               return;
            }
            
            StringTokenizer token = new StringTokenizer(msg, "|");
            int protocol = Integer.parseInt(token.nextToken());
            
            switch(protocol)
            {
            case 1000: {
                  System.out.println(msg);
                  JOptionPane.showMessageDialog(this, msg);
                  System.exit(0);
               }//case 1000 end
               break;
               
            case 2000 : {
                  System.out.println("case 2000 : "+msg);
               JOptionPane.showMessageDialog(this, msg);
            }
            break;
               
            case 100: {
                  
                  String ob[]={token.nextToken(), token.nextToken()};//대화명,위치. 
                  model3.addRow(ob);
                  break;
                  
               }//case 100 end
               
            case 200:{ //방 만들기.
                  String ob[]={token.nextToken(), token.nextToken()};
                  model1.addRow(ob);;
                  break;
               }
            case 210:{
                  String n=token.nextToken(); //대화명.
                  String t=token.nextToken(); //방이름.
                  
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //대화명.
                     
                     if(temp.equals(n))//대화명을 찾았으면
                     {
                        model3.setValueAt(t,i,1);
                        break; //for 탈출.
                     }//if
                  }//for end
                  
                  if(n.equals(name)){//자신이 방 들어갈때.
                     roomInProcess();
                     //if end   
                  }else if(t.equals(title)){//다른 사람 들어올때.
                     Object ob[]={n};
                     client.model1.addRow(ob);
                     client.inwon.setText(client.model1.getRowCount()+""); //인원정리.
                     client.ta.append("*** ["+n+"] 님 이 들어왔습니다.. ***\n");
                     
                  }//else if end
               }//case210 end
               break;
               
            case 290 :{//방나가기.
                  String n = token.nextToken(); //대화명.
                  String t = token.nextToken(); //방제목.
                  
                  //인원정리.
                  for(int i=0;i < model1.getRowCount();i++)
                  {
                     String temp= (String)model1.getValueAt(i,0);
                     if(t.equals(temp))
                     {
                        int inwon = Integer.parseInt(model1.getValueAt(i,1)+"");
                        
                        if(inwon == 0)
                        {
                           model1.removeRow(i); //행 삭제.
                        }else{
                           model1.setValueAt(--inwon + "",i,1); //인원 정리.
                        }
                        break;//for 탈출.
                     }//if ed
                  }//for ed 인원정리.
                  
                  //model3 위치 갱신 (대화방 ==> 대기실)
                  for(int i=0;i < model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //대화명
                     
                     if(n.equals(temp))//대화명이 일치하면
                     {
                        model3.setValueAt("대기실",i,1);
                        break;
                     }//if ed
                  }//for end 위치 갱신.
                  
                  if(n.equals(name))//내가 대화방에서 나갈때.
                  {roomOutProcess(); //메서드 호출.
                  }//if name ed
                  
                  if(n.equals(title))//다른 사람이 나갈때.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++) 
                     {
                        String temp = (String) client.model1.getValueAt(i,0); //대화명 받기.
                        
                        if(temp.equals(n))
                        {
                           client.model1.removeRow(i); //나간사람 제거.
                           break; //탈출.
                        }//if
                        
                     }//for
                     
                     
                     client.inwon.setText(client.model1.getRowCount()+"");//인원정리.
                     client.ta.append("***[ "+n+"] 님이 퇴장하였습니다. ***\n");
                  }//if title ed
               }  //case 290 end 
               break;
               
            case 400 : //대화하기.
               {
                  client.ta.append(" "+token.nextToken()+"\n");
               }//case 400 end
               break;
               
            case 420 : //대화명 변경.
               {
                  String oldN = token.nextToken(); //이전이름.
                  String newN = token.nextToken(); //새 이름.
                  String t = token.nextToken(); //위치.
                  
                  //model3 에 새 이름으로 변경.
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String N=(String)model3.getValueAt(i,0);
                     if(oldN.equals(N))
                     {
                        model3.setValueAt(newN, i, 0); //새로운 대화명으로 변경.
                        break; //for 탈출.
                     }//if oldN end.
                     
                  }//for end.
                  
                  if(t.equals(title)) //대화방에서 대화명 변경.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++)
                     {
                        String N=(String)client.model1.getValueAt(i,0);//대화명 얻기.
                        if(oldN.equals(N))
                        {
                           client.model1.setValueAt(newN,i,0); //새이름으로 변경.
                           break;
                        }//if
                     }//for end
                     client.ta.append(" *** ["+oldN+"] 님의 대화명이 ["+newN+"]으로 바뀌었습니다.\n");
                  }//if t-title end
                  
                  if(oldN.equals(name))
                  {   name = newN;}//if ed
                  
               }//case 420 end
               break;
               
               
            case 450 : //귓속말.
               {
                  String n =token.nextToken();
                  String str=token.nextToken();
                  client.ta.append("귓속말(from)"+n+">>"+str+"\n");
                  
               }//case 450 end.
               break;
            
            case 900 : //종료.
               {                  
                  String n =token.nextToken();
                  String t=token.nextToken();
                  
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //대화명.
                     if(temp.equals(n))//대화명이 일치하면
                     {
                        model3.removeRow(i);
                        break;
                     }//if
                 }//for
               
                if(!t.equals("대기실")){//대화도중에 나갈때.
  
                  for(int i=0;i < model1.getRowCount();i++)
                  {
                     String temp=(String)model1.getValueAt(i,0); //방제목     
                     
                     if(temp.equals(t))//방을 찾아서 있으면 인원 정리.
                     {
                     int a = Integer.parseInt(model1.getValueAt(i,1).toString());//인원정리.
                        
                     
                     if(--a == 0)
                     {
                        model1.removeRow(i); //아무도 없으면 행 제거.
                        
                     }else{
                        model1.setValueAt(a+"",i,1);//인원 갱신
                     }
                     break;//for 탈출.
                      }//if
                  }//for end
                  }//if end
                  
                 if(t.equals(title))//대화방에서 다른 사람이 나간경우.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++)
                     {
                        String temp=(String)client.model1.getValueAt(i, 0); //대화명 얻기.
                        
                        if(temp.equals(n))
                        {
                           client.model1.removeRow(i);
                           break;//for 탈출.
                        }//if
                     }//for
                     client.inwon.setText(client.model1.getRowCount()+""); //인원 정리.
                     client.ta.append("*** ["+n+"] 님이 퇴장 하였습니다. ");
                  
                  }//if3 end
                  
                  
                  
               }//case 900 end
               
            
            
            
            
            }//switch end
            
         }catch(Exception ex)
         {
            System.out.println("서버 접속 실패.");
            return;
         }//try, catch End
         
      }//while
      
   }//run() end=======================================================================run end
   
   //mouse event
   public void mousePressed(MouseEvent me){
      
      model2.setRowCount(0); //테이블 내용 모두 제거.
      int r = table1.getSelectedRow();
      String temp = (String)model1.getValueAt(r,0); //model1 방제목을 얻고,
      
      for(int i=0;i<model3.getRowCount();i++)
      {
         String roomt=(String)model3.getValueAt(i,1); //model3 방제목 얻어서 오기.
         if(temp.equals(roomt))//방제목이 같으면.
         {
            Object ob[]={model3.getValueAt(i,0)}; //model3 에서 대화명은 얻어서.
            model2.addRow(ob);//model2에 넣어준다.
         }//if
      }//for
      
   }//mousePressed end
   
   public void mouseClicked(MouseEvent me){}
   public void mouseReleased(MouseEvent me){}
   public void mouseEntered(MouseEvent me){}
   public void mouseExited(MouseEvent me){}
   
   //actionPerformed
   public void actionPerformed(ActionEvent ae){//서버로 요청을 하는데.
      
      Object ob= ae.getSource();
      
      if(ob == creatB) //방만들기.
      {
         title = JOptionPane.showInputDialog(this, "방 제목 입력 하시오.");
         if(title == null || title.length()<1)
         {
            return;
         }//inner if end
         
         try
         {
            System.out.println("방만들기 요청 트라이");
            out.write(("200|"+title+"\r\n").getBytes()); //서버로 요청.  
         }catch(Exception ex){}
      }//if 1 end -------------------------------------------------------
      
      if(ob == roominB)//방들어가기.
      {
         int row=table1.getSelectedRow();
         if(row<0)
         {
            JOptionPane.showMessageDialog(this, "방을 먼저 선택하시오.");
            return;
         }//inner if end
         
         title=(model1.getValueAt(row, 0)).toString(); //방이름 얻기.
         
         try
         {
            out.write(("210|"+title+"\r\n").getBytes());//서버로 보낸다.  
         }catch(Exception ex){}
         
      }//if2 end---------------------------------------------------------
      
      if(ob == client.tf)//대화하기.
      {
         String msg= client.tf.getText().trim();
         System.out.println("client.tf");
         if(msg.length()<1)
         {
            return;
         }//if.
         
         try
         {
            out.write(("400|"+msg+"\n").getBytes());//서버로 보냄.
         }catch(Exception ex){}
         client.tf.setText("");
      }//if3 end.
      
      if(ob == client.outB)//방 나가기.
      {
         try
         {
            out.write(("290|\r\n").getBytes());//서버로 보낸다.  
         }catch(Exception ex){}
         title = "대기실"; 
      }//if4 end
      
      if(ob == client.nickB)//대화명 변경.
      {
         String n= JOptionPane.showInputDialog(client, "변경할 대화명을 입력하세요.","대화명 입력");
        
         
        for(int i = 0;i<client.model1.getRowCount();i++) 
         {
            String nn = (String)client.model1.getValueAt(i,0);
            if(n.equals(nn))
            {
               JOptionPane.showMessageDialog(this, "사용중인 대화명 입니다.");
               
               return;
            }//if ed
         }//for
         
         if(n == null ||n.length()<1)
         {
            return;
         }//inner if ed
         try
         {
            out.write(("420|"+n+"\r\n").getBytes());  
         }catch(Exception ex){}
      }//if5 end
      
      if(ob == client.sayB)
      {
         int row = client.table1.getSelectedRow(); //행 선택.
         if(row < 0)
         {
            JOptionPane.showMessageDialog(client,"귓속말을 보낼 상대를 선택하시오.");
            return;
         }//inner if ed
         
         //귓속말 보낼 대상자의 이름을 얻어서.
         String sayN=(client.model1.getValueAt(row,0)).toString();
         String say=JOptionPane.showInputDialog(client, "귓속말을 입력하시오.");
         if(say == null || say.length()<1)
         {  return;         }//if end
         try
         {
            //상대방에게 보내고,
            out.write(("450|"+sayN+"|"+"\r\n").getBytes());
            //자신의 대화창에 뿌리고.
            client.ta.append("[귓속말(to)]"+sayN+">> : "+say+"\n");
         }catch(Exception ex){}
      }//if6 end
      
      if(ob == exitB)
      {
         closeProcess();
      System.exit(0);
      
      }//if 7 end
      
      
   }//actionPerformed end=================================Over end
   
   //custom----------------------------------------------------------------------------
   public void eventUp(){
      creatB.addActionListener(this);
      roominB.addActionListener(this);
      exitB.addActionListener(this);
      
      table1.addMouseListener(this);
      
      client.tf.addActionListener(this);
      client.nickB.addActionListener(this);
      client.sayB.addActionListener(this);
      client.outB.addActionListener(this);
   }//eventUp() end
   
   
   //서버 접속
   public void connectProcess() //사용자 정의 메서드.
   {
      
      try{
         s= new Socket(ip, 7788);
         in = new BufferedReader(new InputStreamReader(s.getInputStream()));
         out = s.getOutputStream();
         
         out.write((name+"\r\n").getBytes()); //서버로 전송.
         new Thread(this).start(); //시작, run() 호출.
         
      }catch(Exception ex){
         System.out.println("서버 연결 실패!");     
         
      }  
   }// connetProcess end
   
   //custom ------------//종료 프로세스.
   public void closeProcess(){
      try
      {
         client.setVisible(false);
         client.dispose();
         out.write(("900|\r\n").getBytes()); //서버로 요청.
         
         s.close();
         in.close();
         out.close();
         
      }catch(Exception ex){}
      
   }//closeProcess end
   
   //custom //방에서 내가 나갈경우
   public void roomOutProcess(){
      
      client.ta.setText(""); //대화 삭제.
      client.inwon.setText(""); //인원 정리.
      
      
      //model1. getRowCount(); //전체 갯수를 얻는다.
      for(int i=0;i<client.model1.getRowCount();i++)
      {
         client.model1.removeRow(0); //대화명을 모두 제거.
      }//for
      
      client.model1.setRowCount(0); //대화명을 모두 제거.
      
      int a=client.model1.getRowCount();
      client.inwon.setText(a+"");
      client.setVisible(false); //대화창 안보이게.
      creatB.setEnabled(true);//버튼 활성화.
      roominB.setEnabled(true);// 버튼 활성화
      
   }//roomOutProcess end
   
   //custom //내가 방에 들어갈때.
   public void roomInProcess(){
      
      client.setVisible(true);
      client.ta.append("*** [" + title + "] 방에 입장하셨습니다. ***\n");
      
      for(int i=0;i<model3.getRowCount();i++)
      {
         String temp = (String)model3.getValueAt(i,1); //방위치 얻어서.
         
         if(temp.equals(title))
         {
            Object ob[]={model3.getValueAt(i,0)}; //대화명을 꺼내어.
            client.model1.addRow(ob); //대화명을 대화창에 출력.
         }//if
      }//for
      
      client.inwon.setText(client.model1.getRowCount()+"");
      roominB.setEnabled(false);
      creatB.setEnabled(false);
      
   }//roomInProcess end-------------------custom end---------------------------------------------------
   
   
   
   //Main-----------------------------------------------
   public static void main( String [] args ) 
   {
      new MainClient(args[0]); //접속할 서버 IP 
   }// end main
   
   
   
   
}//MainClient class end
