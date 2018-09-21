package StudentManagement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *学生数据访问类，主要用来做对数据库的增删改查操作
 * 
 */
public class StudentDao {
    /**
     * 添加学生信息
     * @param student 学生信息
     * @return 0 添加失败 1 添加成功
     */
	public int addStudent(Student student){
		int i = 0;
		Connection con = null;
		PreparedStatement pstmt= null;
		String sql = "insert into stu values(?,?,?,?,?,?)";
		try {
			//得到数据库链接对象。调用DBConn里面的getCon方法  加载驱动 和 建立数据库链接
			con = DBConn.getCon();
			//创建预处理对象 PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			//替换SQL语句中的？设置参数
			pstmt.setInt(1, student.getSid());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3,student.getAge());
			pstmt.setString(4, student.getSex());
			pstmt.setString(5, student.getProvince());
			pstmt.setInt(6, student.getTitution());
			//执行SQL语句，并返回执行结果  
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭资源 先打开的后关闭
				if(pstmt!=null){
					pstmt.close();
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
    /**
     * 修改学生信息
     * @param student 学生信息
     * @return 0 修改失败 1 修改成功
     */
	public int editStudent(Student student){
		int i = 0;
		Connection con = null;
		PreparedStatement pstmt= null;
		String sql = "update stu set sname=?,age=?,gander=?,province=?,tuition=? where sid=?";
		try {
			con = DBConn.getCon();
			pstmt = con.prepareStatement(sql);
			//替换SQL语句中的？设置参数
			pstmt.setString(1, student.getName());
			pstmt.setInt(2,student.getAge());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getProvince());
			pstmt.setInt(5, student.getTitution());
			pstmt.setInt(6, student.getSid());
			//执行SQL语句，并返回执行结果  
			i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
    /**
     * 删除学生信息
     * @param student 学生信息
     * @return 0 删除失败 1 删除成功
     */
	public int delStudent(int sid){
		int i = 0;
		Connection con = null;
		PreparedStatement pstmt= null;
		String sql = "delete from  stu where sid=?";
		try {
			con = DBConn.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	//遍历查询学生id
	public Student getStudentById(int sid){
		Student student = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from stu where sid=?";
		try {
			con = DBConn.getCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				student = new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setSex(rs.getString(4));
				student.setProvince(rs.getString(5));
				student.setTitution(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
    /**
     * 获得所有学生信息
     * @return 学生信息集合
     */
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> students = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from stu";
		try {
			con = DBConn.getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setSex(rs.getString(4));
				student.setProvince(rs.getString(5));
				student.setTitution(rs.getInt(6));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
	
	
}

