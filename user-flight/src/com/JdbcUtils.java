package com;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 封装dao类中的公共代码
 * 注册驱动，建立连接。
 * 释放资源
 * @author Administrator
 *
 */
public class JdbcUtils {
	private static DataSource ds=null;
	//静态代码块里面的内容只在类加载时运行一次。
	static{
		try {
			//创建出Properties对象
			Properties p=new Properties();
			//将某个文件转换为输入流
			InputStream is=JdbcUtils.class.getResourceAsStream("/druid.properties");
			//让该对象加载配置文件中的数据。
			p.load(is);
			//创建出数据库连接池
			ds=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		Connection conn=null;
		try {
			//从数据库连接池中获取一个空闲的链接
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//把数据库连接归还给数据库连接池
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
