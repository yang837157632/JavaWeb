package com.zr;

import java.sql.*;
import java.io.*;

public class G_image 
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/northwind";
		String user="root";
		String password="yang9264";
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection(url,user,password);
			String sql="select * from employees";
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
				InputStream is=rs.getBinaryStream("Photo");
				FileOutputStream fos=new FileOutputStream(new File("E:\\Download\\photo"+count+".jpg"));
				byte[] buffer=new byte[1024];
				int len=0;
				while((len=is.read(buffer))!=-1)
				{
					fos.write(buffer,0,len);				
				}
				is.close();
				fos.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{			
			try 
			{
				rs.close();
				ps.close();
				ct.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		System.out.println("Demo7 Over");
	}

}
