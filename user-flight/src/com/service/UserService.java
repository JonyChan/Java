package com.service;

import com.entity.Users;

public interface UserService {

	public boolean login(String name,String pwd);
	public void regist(Users u);
}
