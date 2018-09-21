package Insert;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.DBConnectionUtil;

import Shuju.Mydata;

public class StudentTools implements Runnable{
    
	Statement s=null;
	static int No=1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始执行。。。");
		int i = 0;
		try {
			s = DBConnectionUtil.getConnection().createStatement();

			for (i = 0; i < 1000; i++) {
				insertXy(s);
			}
			System.out.println(Thread.currentThread().getName() + "提交了第1000次");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "提交了第" + i
					+ "次,出现异常。。。");
			e.printStackTrace();
		} finally {
			try {
				if (s!=null)
					s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
     
		public void insertXy(Statement s) throws Exception {
			// 循环插入
			Random r = new Random();
			String id=No+"";
			No++;
			String xm=Mydata.getName();
			String xb=Mydata.getSex();
			String xyid=Integer.toString(r.nextInt(20)+1);
			String zyid=Integer.toString(r.nextInt(100)+1);
			String bjid=Integer.toString(r.nextInt(100)+1);
			String zt=Mydata.getZT();
			String sfzh=Mydata.getSfzh();
			String jg=Mydata.getAdd();
			String rxsj=Mydata.getTime();
			int nl=Mydata.getAge();

			String sql = "insert into s_student(id,xm,xb,xyid,zyid,bjid,zt,sfzh,jg,rxsj,nl) values('"
					+ id +"','" + xm + "','" + xb + "','"+ xyid + "','" 
					+ zyid + "','" + bjid + "','" + zt +"','" + sfzh +"','" + jg 
					+"', TO_DATE('" + rxsj + "','yyyy-mm-dd-hh24:mi:ss')" +"," + nl +")";
			
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
