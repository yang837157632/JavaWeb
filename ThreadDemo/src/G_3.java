//有错误，待改正
public class G_3 {
	public static void main(String[] args) {
		Print print=new Print();
		new Num(print).start();
		new Thread(new Alph(print)).start();
	}
}

class Print{
	public synchronized void num(){
		for(int i=1;i<=52;i+=2){
			this.notify();
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			System.out.println(i+1);
			try {
				Thread.sleep(100);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}				
		}
	}

	public synchronized void alph(){
		for(char j='a';j<='z';j++)
		{
			this.notify();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(j);
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Num extends Thread{
	private Print print;
	Num(Print print){
		this.print=print;
	}

	public void run(){
		print.num();
	}
}

class Alph implements Runnable
{
	private Print print;
	Alph(Print print){
		this.print=print;
	}

	public void run()
	{
		print.alph();
	}
}