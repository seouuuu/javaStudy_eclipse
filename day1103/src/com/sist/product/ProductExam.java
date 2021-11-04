package com.sist.product;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductExam extends JFrame {

	JTextArea jta;
	JTextField jtf_num;
	JTextField jtf_name;
	JTextField jtf_amount;
	JTextField jtf_price;

	public ProductExam() {
		jta = new JTextArea();
		jtf_num = new JTextField();
		jtf_name = new JTextField();
		jtf_amount = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		p.add(new JLabel("상품번호:"));
		p.add(jtf_num);
		p.add(new JLabel("상품명:"));
		p.add(jtf_name);
		p.add(new JLabel("수량:"));
		p.add(jtf_amount);
		p.add(new JLabel("단가:"));
		p.add(jtf_price);
		
		JPanel p2 = new JPanel();
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("출력");
		p2.add(btn1);
		p2.add(btn2);
		add(p,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(jta,BorderLayout.CENTER);
		
		setSize(300,300);
		setTitle("PRODUCT");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String num = jtf_num.getText();
				String name = jtf_name.getText();
				String amount = jtf_amount.getText();
				String price = jtf_price.getText();
				
				String sql = "insert into product values("+num+",'"+name+"',"+amount+","+price+")";
				//System.out.println(sql);
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					Statement st = conn.createStatement();
					int re = st.executeUpdate(sql);
					st.close();
					conn.close();
					
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
				jtf_num.setText("");
				jtf_name.setText("");
				jtf_amount.setText("");
				jtf_price.setText("");
				jta.setText("");
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {
			
			String result = "";
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "select * from product";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					while(rs.next()) {
						String num = rs.getString(1);
						String name = rs.getString(2);
						String amount = rs.getString(3);
						String price = rs.getString(4);
						result += num +","+ name +","+ amount +","+price+"\n";
					}
					
					jta.setText(result);
					
					st.close();
					conn.close();
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		new ProductExam();

	}

}
