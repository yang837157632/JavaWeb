package Insert;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.DBConnectionUtil;

import Shuju.Mydata;

public class MajorTools implements Runnable{
    
	Statement s=null;
	static int No=1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始执行。。。");
		int i = 0;
		try {
			s = DBConnectionUtil.getConnection().createStatement();

			for (i = 0; i < 100; i++) {
				insertXy(s);
			}
			System.out.println(Thread.currentThread().getName() + "提交了第100次");
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
			String zymc =Mydata.getZymc();
			String xyid = Integer.toString(r.nextInt(20)+1);
			int zyrs = r.nextInt(32) + 20;
			String zyjs="本专业师资力量强大，综合素质过高";
			
			String sql = "insert into s_major(id,zymc,xyid,zyrs,zyjs) values('"
					+ id +"','" + zymc
					+ "','" + xyid +"'," + zyrs + ",'"+ zyjs +"')";
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
