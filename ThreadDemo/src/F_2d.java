
public class F_2d {
	public static void main(String[] args){
		new Train("1").start();
		new Train("2").start();
		new Train("3").start();
		new Train("4").start();
		new Train("5").start();
	}
}

class Train extends Thread{
	String name;
	static int i=0;

	public Train(String name){
		this.name=name;
	}

	public synchronized void run(){
		i++;
		try {
			Thread.sleep(2000*i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("火车"+this.name+"通过");
	}
}