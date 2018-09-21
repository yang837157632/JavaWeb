//非用线程方法
public class G_33d {
	public static void main(String[] args) {
		new Nums().start();
		new Thread(new Alphs()).start();
	}
}

class Nums extends Thread{
	static boolean flag=true;
	
	public void run(){		
		int i=1;
		while(true){
			while(flag){
				synchronized("52"){
					if(i<=52){
						System.out.println(i);
						System.out.println(i+1);
						i+=2;
						Nums.flag=false;
						Alphs.flag=true;
					}else{
						break;
					}
				}
			}
			if(i>52){
				break;
			}
		}
	}
}

class Alphs implements Runnable{
	static boolean flag=false;
	
	public void run(){
		char j='a';
		while(true){
			while(flag){
				synchronized("z"){
					if(j<='z'){
						System.out.println(j);
						j++;
						Alphs.flag=false;
						Nums.flag=true;
					}else{
						break;
					}
				}
			}
			if(j>'z'){
				break;
			}
		}
	}
}

