package Insert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.OracleUtil;

import Shuju.Mydata;

public class ClassTools implements Runnable{
    
	//测试数据库基本连接
	Connection con=OracleUtil.getConnection();
	static int No=1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始执行。。。");
		int i = 0;
		try {
			Statement s = con.createStatement();

			for (i = 0; i < 100; i++) {
				insertXy(s);
				con.commit();
			}
			System.out.println(Thread.currentThread().getName() + "提交了第100次");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "提交了第" + i
					+ "次,出现异常。。。");
			e.printStackTrace();
		} finally {
			try {
				con.close();
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
			String bjmc =Mydata.getBjmc();
			String zyid=Integer.toString(r.nextInt(100)+1);
			String bzid=Integer.toString(r.nextInt(1000)+1);
			String xywy = Integer.toString(r.nextInt(1000)+1);
			String jsid=Integer.toString(r.nextInt(100)+1);
			int bjrs = r.nextInt(20)+11;

			String sql = "insert into s_class(id,bjmc,zyid,bzid,xxwy,jsid,bjrs) values('"
					+ id +"','" + bjmc	+ "','" + zyid + "','"+ bzid + "','"
					+ xywy + "','" + jsid + "',"+ bjrs +")";
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
