/*
create table guest(
   name varchar(16) not null, 
   id varchar(20),	
   email varchar(30), 	
   title varchar(30),	
   content text
   );

show tables
   desc guest
   
   
   insert into guest values('��ȿ��','lee123','lee1@han.net','ȿ����','�ȳ��ϼ��� ȫ�浿�Դϴ�.');
select * from board;

insert into guest values('kim','kim123','kim@han.net','kim��','�达 �۳����Դϴ�.');

insert into guest values('han','han123','han@han.net','han��','�Ѿ� �� �����Դϴ�.');

insert into guest values('ooo','ooo123','ooo@han.net','oooo��','���� �� �����Դϴ�.');
*/

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;


class Tset04_db extends JFrame implements ActionLister
{
	JTextField tf_name, tf_id,tf_email,tf_title
   JTextArea ta_content;
   JButton bu_insert, bu_update, bu_list, bu_exit;
   JTable table;
   JLabel la_name,la_id,la_email,_tf_title;
   
   
   
   
      

}
