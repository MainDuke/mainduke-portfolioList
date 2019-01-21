/*
 * Author: Administrator
 * Created: 2016�� 1�� 28�� ����� ���� 11:37:56
 * Modified: 2016�� 1�� 28�� ����� ���� 11:37:56
 */

abstract class MessageSender
{
	String title;
	String senderName;
	
	public MessageSender(String title, String senderName){
	this.title = title;
	this.senderName=senderName;
	}
	
	abstract void sendMessage(String recipient); //�߻�
}//class end

class EMailSender extends MessageSender
{
	String senderAddr;
	String emailBody;
	
	public EMailSender(String title, String senderName, String senderAddr, String emailBody)
	{
		super(title, senderName);
		this.senderAddr=senderAddr;
		this.emailBody=emailBody;
	}
	
	public void sendMessage(String ricipient){
		System.out.println("---------------");
		System.out.println("����"+title);
		System.out.println("������ ���"+senderName+" "+senderAddr);
		System.out.println("�޴»��"+ ricipient);
		System.out.println("����"+emailBody);
	}
}

class SMSSender extends MessageSender{
	String returnPhoneNo;
	String message;
	public SMSSender(String title, String senderName, String returnPhoneNo, String message){
		super(title, senderName);
		this.returnPhoneNo=returnPhoneNo;
		this.message=message;
	}
	public void sendMessage(String recipient){
		System.out.println("---------------");
		System.out.println("����"+title);
		System.out.println("������ ���"+senderName);
		System.out.println("��ȭ��ȣ"+recipient);
		System.out.println("ȸ�� ��ȭ��ȣ"+ returnPhoneNo);
		System.out.println("����"+message);
	}
}
		

class Test08_284p
{
	public static void main( String [] args ) 
	{
		//MessageSender ob = new MessageSender("������", "��")
		//�߻� Ŭ���� MessageSender ��, new �� ��ü ���� �� �� ����.
		
		EMailSender ob1= new EMailSender("������ �����մϴ�.", "������", "admad@hanmail.net","10% �����帲");
		
		SMSSender ob2= new SMSSender("������ �����մϴ�.", "������", "02-2323-2323","10% �����帲");
		
		ob1.sendMessage("han@hanmail.net");
		ob1.sendMessage("san@naver.com"); //call by value >> �ڷᰪ�� ���� �ϴ°�.
		ob2.sendMessage("010-232-3233");
		
		System.out.println();
		System.out.println("------------");
		ob2.sendMessage("Test");
		
	}// end main

}
