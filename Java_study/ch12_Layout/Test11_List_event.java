/*
 * Author: Administrator
 * Created: 2016�� 2�� 2�� ȭ���� ���� 12:37:56
 * Modified: 2016�� 2�� 2�� ȭ���� ���� 12:37:56
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Test11_List_event extends Frame implements ItemListener, ActionListener
{
	//vari
	List list1, list2;
	TextArea ta1, ta2;
	TextField tf;
	Button b1,b2,b3,b4,b5;
	
	//cons
	public Test11_List_event(){
		super("");
		this.setFont(new Font("Dialog", Font.BOLD,16));
		
		setDesign(); //�޼��� ȣ��.
		
		setVisible(true);
		setBounds(200,200,400,350);
		
		//�̺�Ʈ ���.
		tf.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		list1.addActionListener(this);
		list2.addActionListener(this);
		
		addWindowListener(new MyWin());
		
    
      
	}//con end
	
	public void setDesign(){
		
		list1 = new List(10, true); // true ���߼���,/ 10���� �������� �ϰ�, 
		list1.add("�Ｚ����"); //list �� �׸� �߰�.
		list1.add("abc ��Ʈ");
		list1.add("�Ｚ����");
		list1.add("���");
		list1.add("������");
		list1.add("�ް����͵�");
		list1.add("�������");
		list1.add("�ѹ̾�ǰ");
		list1.add("��������");
		
		Panel p1 = new Panel(new BorderLayout());
		p1.add(list1);
		
		list2= new List(10, true);
		Panel p2 = new Panel(new BorderLayout());
		p2.add(list2);
		
		b1=new Button(">");
		b2=new Button(">>");
		b3=new Button("<");
		b4=new Button("<<");
		b5=new Button("����");	
		
		Panel p3 = new Panel(new GridLayout(5,10,10,5));
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		
		//
		tf=new TextField(20); // 20����
		Panel p4= new Panel(new FlowLayout(FlowLayout.RIGHT));
		p4.setBackground(Color.orange);
      p4.add(new Label("�߰�",Label.LEFT));
		p4.add(tf);
		//
		
		Panel p= new Panel(new FlowLayout());
		p.setBackground(Color.yellow);
      p.add(p1);
		p.add(p3);
		p.add(p2);
		//
		
		this.add("Center", p );
		this.add("South", p4);
		
	}//setDesign end
	
	
	//overriding
	public void itemStateChanged(ItemEvent ie){}
	
	public void actionPerformed(ActionEvent ae){
		Object ob = ae.getSource();
		String str="";
		if(ob == tf)	
		{
			if(tf.getText().equals(""))//�ƹ����뵵 ������.
			{
				JOptionPane.showMessageDialog(this, "�߰��� ������ �Է��Ͻÿ�.");
				tf.requestFocus();
				return; // ���̻� ���� �ȵǰ� ���.
			}//inner if end
			
			//�ߺ� üũ.
			for(int i=0;i<list1.getItemCount(); i++)
			{
				if(list1.getItem(i).equals(tf.getText()))
				{
					JOptionPane.showMessageDialog(this, "List1�� �̹� �����մϴ�.");
					tf.setText("");
					return; //���� ���·� �ǵ��ư�.
				}//if end 
				
			}//for end
			for(int i=0;i<list2.getItemCount(); i++)
			{
				if(list2.getItem(i).equals(tf.getText()))
				{
					JOptionPane.showMessageDialog(this, "List2�� �̹� �����մϴ�.");
					tf.setText("");
					return; //���� ���·� �ǵ��ư�.
				}//if end 
				
			}//for end
			
			//�׸� �߰�.
			list1.add(tf.getText().trim());
			tf.setText("");
			tf.requestFocus();
			
		}//if1 end
		
		if(ob==b1)
		{//������ �ڷḦ list2 �� �ȱ��.
	
			String items[]=list1.getSelectedItems();
			for(int i = 0;i<items.length;i++)
			{
				list2.add(items[i]);
				list1.remove(items[i]);
			}//for end
		}//if2 end
		
		
		if(ob==b3)
		{//������ �ڷḦ list1�� �ȱ��.
			
			String items[]=list2.getSelectedItems();
			for(int i = 0;i<items.length;i++)
			{
				list1.add(items[i]);
				list2.remove(items[i]);
			}//for end
		}//if3 end
		
		
		if(ob==b2)
		{//��� �ڷḦ list2�� �ȱ��.
			String items[]=list1.getItems();
			for(int i = 0;i<items.length;i++)
			{
				list2.add(items[i]);
			}//for end
			list1.removeAll();
		}//if4 end
		
		if(ob==b4)
		{//��� �ڷḦ list2�� �ȱ��.
			String items[]=list2.getItems();
			for(int i = 0;i<items.length;i++)
			{
				list1.add(items[i]);
			}//for end
			list2.removeAll();
		}//if5 end
		
		//���� Ŭ�� �Ҷ� �����ϰ� ����.
		if(ob == list1)
		{
			str = ae.getActionCommand();
			list1.remove(str);
			list2.add(str);
		}
		if(ob == list2)
		{
			str = ae.getActionCommand();
			list2.remove(str);
			list1.add(str);
		}
	
		
		
	}//list�� ���� Ŭ�� �Ҷ� ���� �Ǵ� �޼���.
	
	//inner
	public class MyWin extends WindowAdapter{
		
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}
		
	}//inner end
	
	//method
	public static void main( String [] args ) 
	{
		new Test11_List_event();
	}// end main
	
}//class end
