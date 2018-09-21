package Insert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import com.OracleUtil;

import Shuju.Mydata;

public class WorkTools implements Runnable{
    
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
			String xsid=Integer.toString(No);
			String gsid=Integer.toString(r.nextInt(20)+1);
			String gszw=Mydata.getJob();
			int xz=r.nextInt(10000)+10000;
			String rzsj =Mydata.getTime2();

			String sql = "insert into s_work(id,xsid,gsid,gszw,xz,rzsj) values('"
					+ id +"','" + xsid + "','" + gsid + "','" + gszw + "'," + xz 
					+ ", '" + rzsj + "')";
			
			System.out.println(sql);

			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
