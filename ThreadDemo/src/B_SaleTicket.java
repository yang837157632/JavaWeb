public class B_SaleTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		SaleWindow window1 = new SaleWindow(ticket, "###Window");
		window1.start();

		SaleWindow window2 = new SaleWindow(ticket, "***Window");
		window2.start();

		SaleWindow window3 = new SaleWindow(ticket, "$$$Window");
		window3.start();

		SaleWindow window4 = new SaleWindow(ticket, "@@@Window");
		window4.start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		window3.flag=false;
	}
}

class Ticket {
	int ticketNo = 1000;
}

class SaleWindow extends Thread {
	Ticket ticket = null;
	boolean flag=true;

	public SaleWindow(Ticket ticket, String name) {
		this.ticket = ticket;
		this.setName(name);
	}

	@Override
	public void run(){
		while (flag){
			synchronized (ticket){
				if (ticket.ticketNo > 0){
					try{
						Thread.sleep(5);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "\t"+ ticket.ticketNo--);
				}else{
					break;
				}
			}
		}
	}
}
