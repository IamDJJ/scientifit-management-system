package com.scientific.manage.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.activation.DataSource;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBO {
	private Connection conn;
	private Statement stmt;
//  	private DataSource ds;
	
	public DBO()
	{ 
		open();
	}

	/**
		�����ݿ�
	*/
	public void open() 
	{
	

		   
		    String url = "";

		    // MySQL����ʱ���û���
		    String user = ""; 

		    // MySQL����ʱ������
		    String password = ""; 
			 ApplicationContext ac = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
		    try {
		    	// Class.forName(driver); 
		    	
		    	DriverManagerDataSource ds=(DriverManagerDataSource)ac.getBean("dataSource");
		    	
		    	
		    	conn=ds.getConnection();
		    	// conn = DataSourceUtils.getConnection((DataSource)ac.getBean("dataSource"));
;//DriverManager.getConnection(url, user, password); 
	
			stmt=conn.createStatement();
			System.out.println("�����ݿ�����");
		} 
		catch (Exception ex) 
		{
		System.err.println("�����ݿ�ʱ����: " + ex.getMessage());
		}
	}

	/**
		�ر����ݿ⣬�����ӷ��������ӳ�
	*/
	public void close() 
	{
		try 
		{
		
				
		//	connMgr.freeConnection("java", conn);
			conn.close();
			System.out.println ("�ͷ�����");
		} 
		catch (SQLException ex) 
		{ 
			System.err.println("�������ӳس���: " + ex.getMessage());
		}
	}

	/**
		ִ�в�ѯ
	*/
	public ResultSet executeQuery(String sql) throws SQLException
	{
		ResultSet rs = null;
		

		rs = stmt.executeQuery(sql);
		System.out.println ("ִ�в�ѯ");
		return rs;
	}
	public ResultSet query(String sql) throws SQLException
	{
		ResultSet rs = null;
		System.out.println(sql);

		rs = stmt.executeQuery(sql);
		System.out.println ("ִ�в�ѯ");
		return rs;
	}
    

	/**
		ִ����ɾ��
	*/
	
	public int executeUpdate(String sql) throws SQLException
	{
		int ret = 0;
		
	
		ret = stmt.executeUpdate(sql);
	
		System.out.println ("ִ����ɾ��");
		return ret;
	}
	public int update(String sql) throws SQLException
	{
		int ret = 0;
		
	
		ret = stmt.executeUpdate(sql);
	
		System.out.println ("ִ����ɾ��");
		return ret;
	}
	/**
		��SQL�����뵽������
	*/
	public void addBatch(String sql) throws SQLException 
	{
		stmt.addBatch(sql);
	}

	/**
		ִ��������
	*/
	public int [] executeBatch() throws SQLException 
	{
		boolean isAuto=conn.getAutoCommit();
		
		conn.setAutoCommit(false);
		int [] updateCounts = stmt.executeBatch();
		
//		conn.commit();
		
//		conn.setAutoCommit(isAuto);
		//conn.setAutoCommit(true);
		return updateCounts;
	}
	public boolean getAutoCommit() throws SQLException
	{
		return conn.getAutoCommit();
	}
	public void setAutoCommit(boolean auto)  throws SQLException 
	{
		conn.setAutoCommit(auto);
	}
	
	public void commit() throws SQLException 
	{
		conn.commit();
//		this.close();
	}
	public void rollBack() throws SQLException 
	{
		conn.rollback();
//		this.close();
	}
	public static void main(String[] args) {
		DBO con= new DBO();
		//con.open();
//		ResultSet rs=null;
//		String sql="select id dd from didian";
//		List list=new  ArrayList();
//		//ResultSet rs=null;
//	
//		
//		try{
//			rs=con.executeQuery(sql);
//		}catch(Exception e){
//			System.out.println(e.toString());
//			
//		}
		con.close();
	}
}
