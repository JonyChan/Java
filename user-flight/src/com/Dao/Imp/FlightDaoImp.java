package com.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.FlightDao;
import com.entity.flight;
import com.utils.JdbcUtils;

public class FlightDaoImp implements FlightDao {

	@Override
	public flight insert(flight f) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConn();
			String sql ="insert into flight values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, f.getId());
			ps.setString(2, f.getLaunch());
			ps.setString(3, f.getLand());
			ps.setString(4, f.getName());
			ps.setString(5, f.getLength());
			ps.setInt(6, f.getPrice());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeAll(null, ps, null);
		}
		return f;
	}
		
	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConn();
			String sql ="delete from flight where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			/*ps.setString(2, f.getLaunch());
			ps.setString(3, f.getLand());
			ps.setString(4, f.getName());
			ps.setString(5, f.getLength());
			ps.setInt(6, f.getPrice());*/
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeAll(null, ps, null);
		}
	}

	@Override
	public flight selectOne(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		flight f = null;
		
		try {
			conn = JdbcUtils.getConn();
			String sql ="select * from flight where id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			rs = ps.executeQuery();
			if(rs.next()){
				f=new flight();
				f.setId(rs.getInt("id"));
				f.setLaunch(rs.getString("launch"));
				f.setLand(rs.getString("land"));
				f.setName(rs.getString("name"));
				f.setLength(rs.getString("length"));
				f.setPrice(rs.getInt("price"));
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
		return f;
	}

	@Override
	public List<flight> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		flight f = null;
		List<flight>list = new ArrayList<>();
		try {
			conn = JdbcUtils.getConn();
			String sql ="select * from flight";
			ps = conn.prepareStatement(sql);
			
			//ps.setInt(1, id);
			
			
			rs = ps.executeQuery();
			while(rs.next()){
				f=new flight();
				f.setId(rs.getInt("id"));
				f.setLaunch(rs.getString("launch"));
				f.setLand(rs.getString("land"));
				f.setName(rs.getString("name"));
				f.setLength(rs.getString("length"));
				f.setPrice(rs.getInt("price"));
				list.add(f);
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
		return list;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		flight f = null;
		
		try {
			conn = JdbcUtils.getConn();
			String sql ="update flight set launch=?,land=?,name=?,length=?,price=? where id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, f.getLaunch());
			ps.setString(2, f.getLand());
			ps.setString(3, f.getName());
			ps.setString(4, f.getLength());
			ps.setInt(5, f.getPrice());
			ps.setInt(6, id);
			
			ps.executeUpdate();
			if(rs.next()){
				f=new flight();
				f.setId(rs.getInt("id"));
				f.setLaunch(rs.getString("launch"));
				f.setLand(rs.getString("land"));
				f.setName(rs.getString("name"));
				f.setLength(rs.getString("length"));
				f.setPrice(rs.getInt("price"));
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
		//return f;
	}


}
