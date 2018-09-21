package template;

public class DbTeacher extends Teacher implements Strat{
	public void startTeaching(){
		System.out.println("打开MySql数据库");
		System.out.println("打开SQL命令ppt");
		System.out.println("做select语句练习");
	}
}

