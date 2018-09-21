
public class D_Money {
	public static void main(String[] args) {
		Bank bank=new Bank();
		
		Thread t1=new Thread(new customer(bank));
		t1.start();
		
		Thread t2=new Thread(new customer(bank));
		t2.start();
	}
}

class Bank{
	int money=1500;

	public synchronized int fetch(int cash){
		if(cash>money){
			return -1;
		}else{
			money-=cash;
			return cash;
		}
	}
}

class customer implements Runnable{
	Bank bank=null;

	public customer(Bank bank){
		this.bank=bank;
	}

	public void run(){
		while(bank.money>0){
			int cash=bank.fetch(400);
			if(cash>=0)			{
				System.out.println(Thread.currentThread().getName()+"\t"+cash);
			}else			{
				System.out.println(Thread.currentThread().getName()+"\t余额不足");
				break;
			}
		}
	}
}
