package com.greathiit.boot.cm.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.greathiit.boot.cm.bean.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(Integer id);
	User findById(Integer id);
	User findByUserName(String userName);
	List<User> findAll();
	PreparedStatement stat=null;
}
