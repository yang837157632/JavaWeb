
public class C_SaleFare {
	public static void main(String[] args) {
		Fare fare=new Fare();
		SaleDoor door1=new SaleDoor(fare,"####window1");
		Thread t1=new Thread(door1);
		t1.start();

		SaleDoor door2=new SaleDoor(fare,"***window2");
		Thread t2=new Thread(door2);
		t2.start();
		
		SaleDoor door3=new SaleDoor(fare,"$$$window3");
		Thread t3=new Thread(door3);
		t3.start();

		SaleDoor door4=new SaleDoor(fare,"%%%window4");
		Thread t4=new Thread(door4);
		t4.start();		
	}
}

class Fare{
	int fareNo=100;
	public synchronized int getFare(){
		if(fareNo>0){
			return fareNo--;
		}else{
			return -100;
		}
	}
}

class SaleDoor implements Runnable{
	Fare fare=null;
	String name;

	public SaleDoor(Fare fare,String name){
		this.fare=fare;
		this.name=name;
	}

	public void run() {
		while(fare.fareNo>0){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name+"\t"+fare.getFare());
		}
	}
}
