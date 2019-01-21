/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오전 11:24:39
 * Modified: 2016년 2월 4일 목요일 오전 11:24:39
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MemoTest extends Frame implements ActionListener{
 
   //vari
   
   
 
   MenuItem newItem, openItem, saveItem,exitItem, printItem, cardItem;
   TextArea ta;
   String lastLoad;
   
   
   //cons
   public MemoTest(){
           
      super("MemoTest");
      
      MenuBar mb = new MenuBar();
      
      Menu fileMenu = new Menu("파일");
      Menu printMenu = new Menu("인쇄");
      Menu gameMenu = new Menu("게임");
      
      mb.add(fileMenu);
      mb.add(printMenu);
      mb.add(gameMenu);
      
      //새글 항목 메뉴.
      newItem = new MenuItem("새글", new MenuShortcut('N'));//단축키
      fileMenu.add(newItem); //메뉴// 항목메뉴.
 
      newItem.addActionListener(this);
      newItem.setActionCommand("new");
      
      //파일열기 항목메뉴.
      openItem = new MenuItem("파일 열기", new MenuShortcut('O'));
      fileMenu.add(openItem);
      openItem.addActionListener(this);
      openItem.setActionCommand("open");
      
      //파일저장 항목메뉴.
      saveItem= new MenuItem("파일 저장", new MenuShortcut('S'));
      fileMenu.add(saveItem);
      saveItem.addActionListener(this);
      saveItem.setActionCommand("save");
      
      //분리선(구분선)
      fileMenu.addSeparator();
      
      //종료 항목메뉴
      exitItem = new MenuItem("종료", new MenuShortcut('X'));
      fileMenu.add(exitItem);
      exitItem.addActionListener(this);
      exitItem.setActionCommand("exit");
      
      //인쇄 항목 메뉴.
      printItem= new MenuItem("인쇄", new MenuShortcut('P'));
      printMenu.add(printItem);
      printItem.addActionListener(this);
      printItem.setActionCommand("print");
      
      //카드게임항목.
      cardItem = new MenuItem("카드게임");
      gameMenu.add(cardItem);
      cardItem.addActionListener(this);
      cardItem.setActionCommand("card");
      
      
     ta = new TextArea();
      this.add(ta, "Center");
      this.setMenuBar(mb);
      
      //무명 inner Class(창종료.)
      addWindowListener(new WindowAdapter()
         {
            
               public void windowClosing(WindowEvent w){
                  System.exit(0);
               }
            
         }   
         );
      setVisible(true);
      setBounds(200,200,500,500);
   
   }//cons end
   
  
   
   //overriding
      public void actionPerformed(ActionEvent e){
      FileDialog fd=null;
      String str= e.getActionCommand();
      
      if(str.equals("new"))//새글쓰기.
      {
         ta.setText(" ");//메모장 내용을 지운다.
                  
      }else if(str.equals("open")){//파일열기.
         
         System.out.println("test");
         fd=new FileDialog(this, "파일열기", FileDialog.LOAD);
         fd.setVisible(true);
         
         String fn = fd.getDirectory()+fd.getFile();
               
         if(fd.getFile() == null )
         {
            return;
         }else{
             loadFile(fn); //메서드 호출.
         }//if end
         
         
      }else if(str.equals("save")){//저장하기.
         fd=new FileDialog(this, "파일저장", FileDialog.SAVE);
         fd.setVisible(true);
         String fn= fd.getDirectory()+fd.getFile();
         if(fd.getFile() == null)
         {
         return;
         }else
         {
            saveFile(fn);//메서드 호출.
         }
         
         //if end
         
      }else if(str.equals("print") || str.equals("printMenu")){//인쇄하기.
         
         PrintJob pj = getToolkit().getPrintJob(this,"인쇄",null);
         
      }else if(str.equals("card") || str.equals("gameMenu") ){//카드게임.
         
         try{
            Runtime r = Runtime.getRuntime();
            r.exec("c:\\Windows\\System32\\calc.exe");
         }catch(Exception e1){
         System.out.println(e1);
         }
         
      }else if(str.equals("exit")){
         dispose();
         System.exit(0);
      }
      
   }//end actionPerfomaned
   
   //custom method Load, Save......
  //vari
   FileDialog open,save;
    
   //Save Method
   public void saveFile(String fn){
      PrintWriter pp = null;
      try{
         pp =new PrintWriter(new BufferedWriter(new FileWriter(fn)));
         String msg = ta.getText();
         pp.println(msg);
         pp.close();
         
         setTitle("파일 이름:"+fn);
      }catch(Exception ex){
         System.out.println(ex);
      }
        
            
  
   }   
   
   //Load Method 
   public void loadFile(String fn){
      
      BufferedReader in =null;
      ta.setText(""); //메모장 지우기.
      String s="";
     
     
      try{
         
         in = new BufferedReader(new FileReader(fn) , 1024);
         while((s=in.readLine())!= null)
      {
         ta.append(s+"\n");
      }
         in.close();
         setTitle("파일이름:"+fn);
           lastLoad = fn;
      }catch(Exception ex){
         System.out.println(ex);         
      
      }
   
    
   
   }
   
      
   //method
	public static void main( String [] args ) 
   {
      new MemoTest();
   }// end main

   }//class end
