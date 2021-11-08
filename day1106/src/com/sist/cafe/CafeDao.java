package com.sist.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CafeDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	public int insertCafe(CafeVo c) {
		int re = -1;
		String sql = "insert cafe into values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			ps = conn.prepareStatement(sql);
			ps.setInt(1,c.getNo());
			ps.setString(2, c.getName());
			ps.setInt(3,c.getAmount());
			ps.setInt(4,c.getPrice());
			
			re = ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	
	public int updateCafe(CafeVo c) {
		int re = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update Cafe set no=?,name='?',amount=?,price=? where no=? ";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			ps =conn.prepareStatement(sql);
			ps.setInt(1,c.getNo());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getAmount());
			ps.setInt(4, c.getPrice());
			re = ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	
	public int deleteCafe(int no) {
		int re = -1;
		Connection conn = null;
		Statement st = null;
		String sql = "delete Cafe where no";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			st = conn.createStatement();
			re = st.executeUpdate(sql);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn != null){
					conn.close();
				}
				if(st != null) {
					st.close();
				}
			}catch (Exception e) {
				
			}
		}
		return re;
	}
	
	public ArrayList<CafeVo> listCafe(){
		ArrayList<CafeVo> list = new ArrayList<CafeVo>();
		String sql = "select * from cafe order by no";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int amount = rs.getInt(3);
				int price = rs.getInt(4);
				list.add(new CafeVo(no,name,amount,price));
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}
}
