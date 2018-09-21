package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *数据库连接类
 * 
 */
public class DBConn {
	//定义数据库链接名字变量URL	主要用来定位于哪台计算机上的什么数据库管理系统中的哪个数据库
	private final static String URL ="jdbc:mysql://localhost:3306/exam";
	//定义数据库用户名变量USERNAME
	private final static String USERNAME="root";
	//定义数据库用户名变量PASSWORD
	private final static String PASSWORD="yang9264";
	
	   /**-------------------------------------------------------------------
     * 获得数据库连接方法
     * @return 数据库连接对象 
     */
	public static Connection getCon(){
		Connection con = null;
		try {
			//第1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			////第2.建立数据库链接，通过DriverManager获得数据库连接对象，把定义的变量名放进去
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}

	
