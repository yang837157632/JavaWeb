package template;

public abstract class Teacher implements Strat{

	public void teaching(){
		this.prepareTeaching();
		this.startTeaching();
		this.endTeaching();
	}
	
	//准备上课
	public void prepareTeaching(){
		System.out.println("打开投影仪，。。。");
	}
	
	//开始授课
	public abstract void startTeaching();
	
	//结束授课
	public void endTeaching(){
		System.out.println("关闭投影仪。。。");
	}
}
