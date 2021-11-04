package com.sist.member;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseListener;

public class MemberExam extends JFrame {
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_addr;
	JTextField jtf_age;
	JTextField jtf_phone;
	
	JTable table;			
	Vector colNames;		
	Vector<Vector> rowData;	
	
	
	public void printMember() {
		
		rowData.clear();
		
		String sql = "select * from member order by no";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(addr);
				v.add(age);
				v.add(phone);
				
				rowData.add(v);
				
				table.updateUI();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public void insertMember() {
		int no = Integer.parseInt(jtf_no.getText());
		int age = Integer.parseInt(jtf_age.getText());
		String name = jtf_name.getText();
		String addr = jtf_addr.getText();
		String phone = jtf_phone.getText();
		
		
		String sql = "insert into member values("+no+",'"+name+"','"+addr+"',"+age+",'"+phone+"')";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("회원등록에 성공하였습니다.");
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_addr.setText("");
				jtf_age.setText("");
				jtf_phone.setText("");
	
				printMember();
			}else {
				System.out.println("회원등록에 실패하였습니다.");
			}
			
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}finally {
			
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception ex) {
				
			}
		}
	}
	
	public void deleteMember(int no) {
		
		String sql = "delete member where no ="+no;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("회원삭제에 성공하였습니다.");
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_addr.setText("");
				jtf_age.setText("");
				jtf_phone.setText("");
				
				printMember();
			}else {
				System.out.println("회원삭제에 실패하였습니다.");
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception ex) {
				
			}
		}
	}
	
	public void updateMember(int no, String name, String addr,int age, String phone) {
		String sql = "update member set name='"+name+"',address='"+addr+"',age="+age+",phonenumber='"+phone+"' where no="+no;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("회원수정에 성공하였습니다.");
				jtf_no.setText("");
				jtf_name.setText("");
				jtf_addr.setText("");
				jtf_age.setText("");
				jtf_phone.setText("");
				
				printMember();
			}else {
				System.out.println("회원수정에 실패하였습니다.");
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public MemberExam() {
		
		colNames = new Vector();
		colNames.add("회원번호");
		colNames.add("회원이름");
		colNames.add("회원주소");
		colNames.add("회원나이");
		colNames.add("전화번호");
		
		rowData = new Vector<Vector>();
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_addr = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,2));
		
		p.add(new JLabel("회원번호:"));
		p.add(jtf_no);
		p.add(new JLabel("회원이름:"));
		p.add(jtf_name);
		p.add(new JLabel("회원주소:"));
		p.add(jtf_addr);
		p.add(new JLabel("회원나이:"));
		p.add(jtf_age);
		p.add(new JLabel("전화번호:"));
		p.add(jtf_phone);
		
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(500,600);
		setVisible(true);
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMember();
			}
			
		});
		
		btn_add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				insertMember();
			}});
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int no = Integer.parseInt(jtf_no.getText());
				deleteMember(no);
			}	
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				int age = Integer.parseInt(jtf_age.getText());
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				String phone = jtf_phone.getText();
				
				updateMember(no,name,addr,age,phone);
			}
			
		});
			
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				int index = table.getSelectedRow();
	
				Vector vr = rowData.get(index);
				
				jtf_no.setText(vr.get(0)+"");
				jtf_name.setText(vr.get(1)+"");
				jtf_addr.setText(vr.get(2)+"");
				jtf_age.setText(vr.get(3)+"");
				jtf_phone.setText(vr.get(4)+"");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}

	public static void main(String[] args) {
		new MemberExam();
		
	}
}
