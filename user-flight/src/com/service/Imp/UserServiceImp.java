package com.service.Imp;

import java.sql.Connection;
import java.sql.SQLException;

import com.Dao.UserDao;
import com.Dao.Imp.UserDaoImp;
import com.entity.Users;
import com.service.UserService;
import com.utils.JdbcUtils;

public class UserServiceImp implements UserService {

	@Override
	public boolean login(String name, String pwd) {
		boolean result = false;
		Users us = null;
		Connection con = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			UserDao user = new UserDaoImp();
			us = user.selectByNameAndPwd(name,pwd);
			if(us != null){
				result = true;
			}
			con.commit();
			//System.out.println("service IMpl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("sss");
			//return false;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JdbcUtils.closeAll(con,null, null);
		}
		
		return result;
	}

	@Override
	public void regist(Users u) {
		Users us = null;
		Connection con = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			UserDao user = new UserDaoImp();
			us = user.insert(u);
			
			con.commit();
			//System.out.println("service IMpl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("sss");
			//return false;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JdbcUtils.closeAll(con,null, null);
		}
	}

}
