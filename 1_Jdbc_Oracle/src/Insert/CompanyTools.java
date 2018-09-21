package Insert;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.DBConnectionUtil;

import Shuju.Mydata;

public class CompanyTools implements Runnable{
    
	Statement s=null;
	static int No=1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始执行。。。");
		int i = 0;
		try {
			s = DBConnectionUtil.getConnection().createStatement();

			for (i = 0; i < 20; i++) {
				insertXy(s);
			}
			System.out.println(Thread.currentThread().getName() + "提交了第20次");
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
			String gsmc =Mydata.getCom();
			String gsdz =Mydata.getAdd();
			int gsrs = r.nextInt(3000) + 1000;
			
			String sql = "insert into s_company(id,gsmc,gsdz,gsrs) values('"
					+ id +"','" + gsmc + "','" + gsdz + "'," + gsrs + ")";
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}	
} 
