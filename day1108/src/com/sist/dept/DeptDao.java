package com.sist.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//DAO: Database Access Object. �����ͺ��̽� ���̺� �����Ͽ� �ڷ� �߰�,�б�,����,���� ����ϴ� ��ü
public class DeptDao {
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "c##sist";
	private String pwd = "sist";
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �߰��ϴ� �޼ҵ� ����
	public int insert(DeptVo d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, d.getDno());
			stmt.setString(2, d.getDname());
			stmt.setString(3, d.getDloc());
			re = stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch (Exception e) {
				
			}
		}
		return re;
	}
	
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ� ����
	public int update(DeptVo d) {
		int re = -1;
		String sql = "update dept set dname=?,dloc=? where dno=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, d.getDname());
			stmt.setString(2, d.getDloc());
			stmt.setInt(3, d.getDno());
			re = stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch (Exception e) {
				
			}
		}
		return re;
	}
	
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ� ����
	public int delete(int dno) {
		int re = -1;
		String sql = "delete dept where dno=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dno);
			re = stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch (Exception e) {
			}
		}
		return re;
	}
	
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �о���� �޼ҵ� ����
	public ArrayList<DeptVo> listAll(){
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		String sql = "select * from dept";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				//int dno = rs.getInt(1);
				//String dname = rs.getString(2);
				//String dloc = rs.getString(3);
				//list.add(new DeptVo(dno,dname,dloc));
				list.add(new DeptVo(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch (Exception e) {
				
			}
		}
		return list;
	}
	
	
	
}
