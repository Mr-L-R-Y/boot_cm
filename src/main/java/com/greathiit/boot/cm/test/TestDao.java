package com.greathiit.boot.cm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.greathiit.boot.cm.bean.User;


public class TestDao {
	public static void main(String[] args) {
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/2004_w?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="root";
		String password="root";
		String sql="select * from cm_user";

		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			//1、加载驱动
			Class.forName(driverClass);
			//2、获取连接
			conn=DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			//3、获取声明
			stat=conn.createStatement();
			//4、执行SQL语句
			rs = stat.executeQuery(sql);
			//5、遍历结果集
			List<User> users=new ArrayList<User>();
			while(rs.next()) {
				User userBean=new User();
				userBean.setId(rs.getInt("user_Id"));
				userBean.setUserName(rs.getString("user_name"));
				userBean.setRealName(rs.getString("user_real_name"));
				userBean.setPassword(rs.getString("user_password"));
				users.add(userBean);
			}
			System.out.println(users);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//6、关闭资源
				if(rs!=null) {
				rs.close();
				}
				if(stat!=null) {
					stat.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
