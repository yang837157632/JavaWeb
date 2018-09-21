
public class F_22 {
	public static void main(String[] args){
		new Trains("1").start();
		new Trains("2").start();
		new Trains("3").start();
		new Trains("4").start();
		new Trains("5").start();
	}
}

class Trains extends Thread{
	String name;

	public Trains(String name){
		this.name=name;
	}

	public void run(){
		synchronized("8"){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("火车"+this.name+"通过");
		}		
	}
}