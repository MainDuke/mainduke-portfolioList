package sample2;

public class MessageBeanImpl implements MessageBean{
	
	private String name;//����
	
	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
				
		try{
			Thread.sleep(3000);//3��
		}catch(InterruptedException e){}
		
		System.out.println("Hello ~ "+name+"!");
		
	}//sayHello()

}//class
