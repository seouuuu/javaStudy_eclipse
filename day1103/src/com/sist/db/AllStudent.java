package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllStudent {

	public static void main(String[] args) {
		
		try {
			String sql = "select * from student";
			
			//jdbc ����̹��� �޸𸮷� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//db������ ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");

			//Statement ��ü ����
			Statement stmt = conn.createStatement();
			
			//�����ͺ��̽� ��� ����
			ResultSet rs = stmt.executeQuery(sql);
			
			//���ڵ尡 �ִ¸�ŭ Ŀ���� �� �྿ �ű��
			while(rs.next()) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				int eng = rs.getInt(3);
				int math = rs.getInt(4);
				System.out.println(name+","+kor+","+eng+","+math);
			}
			
			//����ߴ� �ڿ��� �ݱ�
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}

	}

}
