package com.service.Imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.FlightDao;
import com.Dao.Imp.FlightDaoImp;

import com.entity.flight;
import com.service.FlightService;
import com.utils.JdbcUtils;

public class FlightServiceImp implements FlightService {

	@Override
	public void insert(flight f) {
		//flight f = null;
		Connection con = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			FlightDao fd = new FlightDaoImp();
			f = fd.insert(f);
			
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
	@Override
	public void update(int id) {
		//flight f = null;
		Connection con = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			FlightDao fd = new FlightDaoImp();
			fd.update(id);
			
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



	

	@Override
	public void delete(int id) {
		Connection con = null;
		flight f = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			FlightDao fd = new FlightDaoImp();
			fd.delete(id);;
			
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

	@Override
	public flight selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<flight> selectAll() {
		// TODO Auto-generated method stub
		List<flight> newlist = new ArrayList<>();
		Connection con = null;
		try {
			con = JdbcUtils.getConn();
			con.setAutoCommit(false);
			FlightDao u = new FlightDaoImp();
			newlist = u.selectAll();
			
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
		
		return newlist;
	}
	

}
