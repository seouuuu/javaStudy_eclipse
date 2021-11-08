package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	//���ǻ���� �Ű������� ���޹޾� �ش����ǻ��� ��� ��������� �˻��Ͽ� ArrayList�� ��ȯ�ϴ� �޼ҵ� ����
	public ArrayList<BookVO> searchBook(String publisher){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where publisher = ? order by price desc";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##madang";
		String pwd = "madang";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			rs = pstmt.executeQuery();
			int bookid = 0;
			String bookname = "";
			int price = 0;
			String publisher2 = "";
			
			while(rs.next()) {
				bookid = rs.getInt(1);
				bookname = rs.getString(2);
				publisher2 = rs.getString(3);
				price = rs.getInt(4);
				list.add(new BookVO(bookid,bookname,publisher2,price));
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
		return list;
	}
}
