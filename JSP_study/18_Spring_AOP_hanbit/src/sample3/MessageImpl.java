package sample3;

public class MessageImpl implements MessageBean {

	private String name;//����
	
	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
				
		try{
			Thread.sleep(3000);//3��
		}catch(InterruptedException e){}
		
		System.out.println("Hello3 ~ "+name+"!");
		
	}//sayHello()
}
