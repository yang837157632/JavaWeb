package com.login;

//这是一个处理类(处理users表)<--->操作UserBean
//业务逻辑在这里

import java.sql.*;

import java.util.*;

public class UserBeanCl {

	//业务逻辑 
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;//共有几页(计算)

	//修改用户
	public boolean updateUser(String id,String email,String passwd,String grade){

		boolean b=false;

		try {

			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();

			String sql="update user set passwd='"+passwd+"' ,email='"+email+"' ,grade='"+grade+"'  where userid='"+id+"'";

			ps=ct.prepareStatement(sql);

			int num=ps.executeUpdate();

			if(num==1){

				//删除成功!
				b=true;
			}

		}catch (Exception ex) {

			ex.printStackTrace();

		}finally{

			this.close();
		}

		return b;
	}

	//删除用户

	public boolean delUser(String id){

		boolean b=false;

		try {

			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();

			String sql="delete from user where userid='"+id+"'";

			ps=ct.prepareStatement(sql);

			int num=ps.executeUpdate();

			if(num==1){

				//删除成功!
				b=true;
			}

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}finally{

			this.close();
		}

		return b;
	}


	//返回pageCount;
	public int getPageCount(){
		return this.pageCount;
	}

	//分页显示
	public ArrayList getResultByPage(int pageNow,int pageSize){

		ArrayList al=new ArrayList();

		try {

			int rowCount=0;//共有几条记录(查表)

			//得到rowCount
			ConnDB cd=new ConnDB();
			ct=cd.getConn();

			ps=ct.prepareStatement("select count(*) from user");

			rs=ps.executeQuery();

			if(rs.next()){

				rowCount=rs.getInt(1);
			}

			//计算pageCount
			if(rowCount%pageSize==0){

				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}

			ps=ct.prepareStatement("select * from user limit "+pageSize*(pageNow-1)+" , "+pageSize);

			rs=ps.executeQuery();

			while(rs.next()){

				//将rs中的 每条记录封装到UserBean ub
				UserBean ub=new UserBean();
				ub.setUserId(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setMail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				ub.setMyPic(rs.getString(6));

				//将ub ,放入到ArrayList 中
				al.add(ub);
			}
		}
		catch (Exception ex) {

			ex.printStackTrace();
		}finally{

			this.close();
		}

		return al;

	}

	//验证用户
	public boolean checkUser(String u,String p){

		boolean b=false;
		
		try {

			//得到连接
			ConnDB cd=new ConnDB();
			ct=cd.getConn();

			ps=ct.prepareStatement("select passwd from user where username=? limit 1");

			ps.setString(1,u);
			rs=ps.executeQuery();

			if(rs.next()){
				String dbPasswd=rs.getString(1);

				if(dbPasswd.equals(p)){

					b=true;
				}
			}

		}catch (Exception ex) {

			ex.printStackTrace();
		}finally{

			this.close();
		}

		return b;
	}

	//关闭资源
	public void close(){

		try {

			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(ct!=null){
				ct.close();
				ct=null;
			}
		}catch (Exception ex) {

			ex.printStackTrace();
		}
	}
}
