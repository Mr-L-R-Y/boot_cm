package com.greathiit.boot.cm.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.greathiit.boot.cm.bean.User;
import com.greathiit.boot.cm.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(User user) {
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/2004_w?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username="root";
		String password="root";
		String sql="insert into cm_user(user_name,user_real_name,user_password) "
				+" values(?,?,?)";

		Connection conn=null;
		PreparedStatement stat=null;
		try {
			//1����������
			Class.forName(driverClass);
			//2����ȡ����
			conn=DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//3����ȡ����
			stat=conn.prepareStatement(sql);
			stat.setString(1, user.getUserName());
			stat.setString(2, user.getRealName());
			stat.setString(3, user.getPassword());
			//4��ִ��SQL���
			stat.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5���ر���Դ
			try {
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

	@Override
	public void update(User user) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void delete(Integer id) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public User findById(Integer id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public List<User> findAll() {
		String driverClass="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/2004_w?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="root";
		String sql="select * from cm_user";

		List<User> users=new ArrayList<User>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			//1����������
			Class.forName(driverClass);
			//2����ȡ����
			conn=DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			//3����ȡ����
			stat=conn.createStatement();
			//4��ִ��SQL���
			rs = stat.executeQuery(sql);
			//5�����������
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
				//6���ر���Դ
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
		return users;
	}
	
}
