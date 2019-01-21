import java.awt.*;
import java.awt.Toolkit;
import java.awt.Dimension;

class testself{
	
	/*
	import java.awt.Toolkit;
	import java.awt.Dimension;
	
	public class test {
	public static void main(String[] agrs){
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	System.out.println("해상도 : " + res.width + " x " + res.height);  
	}
	}
	
	 */
	//cons
	public testself(){
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("해상도 : " + res.width + " x " + res.height);  
		
	}//cons
	
	public static void main( String [] args ) 
	{
		new testself();
	}// end main
	
}//class end