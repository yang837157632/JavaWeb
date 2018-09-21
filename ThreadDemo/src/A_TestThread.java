
public class A_TestThread {
	public static void main(String[] args) 	{
		HelloThread t1=new HelloThread();
		t1.start();
//		t1.run();
		
		HelloRunnable t2 = new HelloRunnable();
		Thread t=new Thread(t2);
		t.start();
		
		System.out.println("over");
	}
}

class HelloThread extends Thread{

	@Override
	public void run() {
		for(int i=0;i<1000;i++)	{
			System.out.println(i);
		}
	}
}

class HelloRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++)	{
			System.out.println("    "+i);
		}		
	}	
}