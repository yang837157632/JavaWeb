
package factorys;

import factorys.BlackInk;
import factorys.Ink;
import factorys.InkFactory;

public class TestA {

	public static void main(String[] args) {
		
		Ink ink = InkFactory.getInk("black");
//		Ink ink = InkFactory.getInk("green");
		
		if(ink!=null){
			String color = ink.color();
			System.out.println(color);
			ink.use();
		}else{
			System.out.println("Over");
		}
	}

}
