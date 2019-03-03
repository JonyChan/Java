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
 * ��װdao���еĹ�������
 * ע���������������ӡ�
 * �ͷ���Դ
 * @author Administrator
 *
 */
public class JdbcUtils {
	private static DataSource ds=null;
	//��̬��������������ֻ�������ʱ����һ�Ρ�
	static{
		try {
			//������Properties����
			Properties p=new Properties();
			//��ĳ���ļ�ת��Ϊ������
			InputStream is=JdbcUtils.class.getResourceAsStream("/druid.properties");
			//�øö�����������ļ��е����ݡ�
			p.load(is);
			//���������ݿ����ӳ�
			ds=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		Connection conn=null;
		try {
			//�����ݿ����ӳ��л�ȡһ�����е�����
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
			//�����ݿ����ӹ黹�����ݿ����ӳ�
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
