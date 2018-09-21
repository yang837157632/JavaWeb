package Insert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.DBConnectionUtil;

import Shuju.Mydata;

public class DepartmentTools implements Runnable{
    
	Connection con=DBConnectionUtil.getConnection();
	static int No=1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始执行。。。");
		int i = 0;
		try {
			Statement s = con.createStatement();
			for (i = 0; i < 20; i++) {
				insertXy(s);
				con.commit();
			}
			System.out.println(Thread.currentThread().getName() + "提交了第20次");
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
			String xymc =Mydata.getXymc();
			String xyyz = Mydata.getName();
			String xysj = Mydata.getName();
			int xyrs = r.nextInt(62) + 3000;
			String xyjs="本学校师资力量强大，综合素质过高";
			
			String sql = "insert into s_department(id,xymc,xyyz,xysj,xyrs,xyjs) values('"+ id +"','" + xymc
					+ "','" + xyyz + "','" + xysj + "'," + xyrs + ",'"+ xyjs +"')";
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
