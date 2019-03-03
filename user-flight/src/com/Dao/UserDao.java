package com.Dao;

import com.entity.Users;

public interface UserDao {

	public Users selectByNameAndPwd(String name,String pwd);

	public Users insert(Users u);
}
