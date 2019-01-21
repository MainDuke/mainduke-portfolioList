/*
 * Author: Administrator
 * Created: 2016년 2월 1일 월요일 오후 4:21:10
 * Modified: 2016년 2월 1일 월요일 오후 4:21:10
 */
import java.awt.*;
import java.awt.event.*;

class Test06_event extends Frame implements ActionListener
{
	//vari
	Button bu_FileOpen, bu_FileSave, bu_Print, bu_Exit;
	Panel pn,ps;
	
	//cons
	public Test06_event(){
		super("액션.");
		
		bu_FileOpen = new Button("파일열기");
		bu_FileSave = new Button("파일세이브");
		bu_Print = new Button("인쇄");
		bu_Exit = new Button("종료");
		
		pn=new Panel();
		ps=new Panel();
		
		
		pn.setBackground(Color.blue);
		ps.setBackground(Color.red);
		
		
		pn.add(bu_FileOpen);
		pn.add(bu_FileSave);
		pn.add(bu_Print);
		
		ps.add(bu_Exit);
		
		this.add(pn,"North");
		this.add(ps,"South");
		
		
		
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,350,350);
		
		//actionListener...
		
		bu_FileOpen.addActionListener(this);
		bu_FileSave.addActionListener(this);
		bu_Print.addActionListener(this);
		bu_Exit.addActionListener(this);
		
		
		
	}//end cons
	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
	}//inner end
	
	FileDialog open,save;
	//overiding
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==bu_FileOpen){
			open=new FileDialog(this,"파일열기",FileDialog.LOAD);
			//					뷰모객체, 창제목, Mode
			open.setVisible(true);
		}else if(e.getSource()==bu_FileSave){
			save=new FileDialog(this,"파일쩌장",FileDialog.SAVE);
			//					뷰모객체, 창제목, Mode
			save.setVisible(true);
		}else if(e.getSource()==bu_Print){
			PrintJob pj=getToolkit().getPrintJob(this, "인쇄",null);
		}else if(e.getSource()==bu_Exit){
			System.exit(0);
		}		
	}
	
	
	//main
	public static void main( String [] args )
	{
		new Test06_event();
	}// end main
	
	
}//class end
