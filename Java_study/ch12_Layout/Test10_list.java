/*
 * Author: Administrator
 * Created: 2016�� 2�� 2�� ȭ���� ���� 11:43:33
 * Modified: 2016�� 2�� 2�� ȭ���� ���� 11:43:33
 */

import java.awt.*;
import java.awt.event.*;

class Test10_list extends Frame implements ItemListener , ActionListener
{
	//vair
	
	TextArea ta1, ta2;
	List list;
	Label label;
	
	//cons
	public Test10_list(){
		super("aaa");
	
		this.setBackground(Color.yellow);
			
		label = new Label("����Ʈ�ڽ�");
		list = new List(3); //�׸��� 3���� �����ֱ�.
		list.add("�̸�"); //list�� �׸� �߰�.
		list.add("����"); 
		list.add("����"); 
		list.add("����"); 
		list.add("����");
		
		ta1=new TextArea("", 7 , 30, TextArea.SCROLLBARS_VERTICAL_ONLY); //���� ��ũ��
		ta2=new TextArea("", 7 , 30, TextArea.SCROLLBARS_HORIZONTAL_ONLY); //���� ��ũ��.
		
		list.addActionListener(this);
		list.addItemListener(this);
		addWindowListener(new MyWin());
		setVisible(true);
		setBounds(200,200,300,400);
	
		
		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(list);
		this.add(ta1);
		this.add(ta2);
	
	}//cons end

	
	//inner
	public class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
			
		}
	}//inner end
	
	//overRiding
	public void itemStateChanged(ItemEvent ie){
	ta1.append("Item Event �߻� : "+list.getSelectedItem()+"\n");
}//list�� Ŭ���Ҷ�!
	
	
	public void actionPerformed(ActionEvent ae){
	ta2.append("Action Event �߻� : "+ae.getActionCommand()+"\n");
	}//list�� ���� Ŭ�� �Ҷ� ���� �Ǵ� �޼���.
	
	//main
	public static void main( String [] args ) 
	{
		new Test10_list();
	}// end main


}//class end

