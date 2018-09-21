
public class E_1d {
	public static void main(String[] args) {
		Five a=new Five();
		Thread b=new Thread(new One());
		a.start();
		b.start();
	}
}

class Five extends Thread{
	public void run(){
		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("AAA");
		}
	}		
}

class One implements Runnable{
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("B");
		}
	}
}