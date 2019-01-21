/*
 * Author: Administrator
 * Created: 2016년 1월 28일 목요일 오전 11:37:56
 * Modified: 2016년 1월 28일 목요일 오전 11:37:56
 */

abstract class MessageSender
{
	String title;
	String senderName;
	
	public MessageSender(String title, String senderName){
	this.title = title;
	this.senderName=senderName;
	}
	
	abstract void sendMessage(String recipient); //추상
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
		System.out.println("제목"+title);
		System.out.println("보내는 사람"+senderName+" "+senderAddr);
		System.out.println("받는사람"+ ricipient);
		System.out.println("내용"+emailBody);
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
		System.out.println("제목"+title);
		System.out.println("보내는 사람"+senderName);
		System.out.println("전화번호"+recipient);
		System.out.println("회신 전화번호"+ returnPhoneNo);
		System.out.println("내용"+message);
	}
}
		

class Test08_284p
{
	public static void main( String [] args ) 
	{
		//MessageSender ob = new MessageSender("하하하", "너")
		//추상 클래스 MessageSender 는, new 로 객체 생성 할 수 없다.
		
		EMailSender ob1= new EMailSender("생일을 축하합니다.", "고객센터", "admad@hanmail.net","10% 쿠폰드림");
		
		SMSSender ob2= new SMSSender("생일을 축하합니다.", "고객센터", "02-2323-2323","10% 쿠폰드림");
		
		ob1.sendMessage("han@hanmail.net");
		ob1.sendMessage("san@naver.com"); //call by value >> 자료값을 전달 하는것.
		ob2.sendMessage("010-232-3233");
		
		System.out.println();
		System.out.println("------------");
		ob2.sendMessage("Test");
		
	}// end main

}
