package com.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Dao.UserDao;
import com.entity.Users;
import com.utils.JdbcUtils;

public class UserDaoImp implements UserDao {

	@Override
	public Users selectByNameAndPwd(String name, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users u = null;
		
		try {
			conn = JdbcUtils.getConn();
			String sql ="select * from users where name=? and password=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if(rs.next()){
				u=new Users();
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
			}	
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeAll(conn, ps, rs);
		}
		return u;
	}

	@Override
	public Users insert(Users u) {
		
		PreparedStatement ps = null;
		try {
			Connection conn = JdbcUtils.getConn();
			String sql ="insert into users values(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeAll(null, ps, null);
		}
		return u;
	}
}
