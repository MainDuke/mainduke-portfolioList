package sample1;

public class MessageBeanImpl implements MessageBean{
	private String name;
	
	
	
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void sayHello() {
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			
		}
		
		System.out.println("Hello, "+name+"!");
	}//sayHello end
	
}//class end
