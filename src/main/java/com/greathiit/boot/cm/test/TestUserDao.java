package com.greathiit.boot.cm.test;

import com.greathiit.boot.cm.bean.User;
import com.greathiit.boot.cm.dao.UserDao;
import com.greathiit.boot.cm.dao.impl.UserDaoImpl;

public class TestUserDao {
	public static void main(String[] args) {
		UserDao userDao=new UserDaoImpl();
		User user=new User();
		user.setUserName("wangwu");
		user.setRealName("ÍõÎå");
		user.setPassword("wangwu");
		userDao.add(user);
	}
}
