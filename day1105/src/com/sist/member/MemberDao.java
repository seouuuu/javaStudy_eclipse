package com.sist.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	public int insertMember( BookVo g ) {
		
		int re = -1;
		String sql = "insert into member values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setString(3, g.getAddr());
			pstmt.setInt(4, g.getAge());
			pstmt.setString(5, g.getPhone());
			
			re = pstmt.executeUpdate();
				
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}finally {
			
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception ex) {
				
			}
		}
		return re;
	}
	
	public int updateMember(BookVo m) {
		int re = -1;
		String sql = "update member set name=?,addr=?,age=?,phone=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getAddr());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getPhone());
			pstmt.setInt(5,m.getNo());
			
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	
	public int deleteMember(int no) {
		int re = -1;
		String sql = "delete member where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally{
			try {
				if(pstmt != null ) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	
	public ArrayList<BookVo> listMember(){
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from member order by no";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				
				list.add(new BookVo(no,name,addr,age,phone));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try{
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;		
	}
}
