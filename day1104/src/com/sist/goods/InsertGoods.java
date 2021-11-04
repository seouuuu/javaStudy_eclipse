package com.sist.goods;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertGoods extends JFrame {
	
	JTextField jtf_no;		
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	public InsertGoods() {
		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		p.add(new JLabel("��ǰ��ȣ:"));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�:"));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����:"));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("�߰�");
		
		add(p,BorderLayout.CENTER);
		add(btn_add,BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				String sql = "insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
				
				//finally������ �����Ҽ� �ְ� ������ try�� �ۿ� ����
				Connection conn = null;
				Statement stmt = null;
				
				try {
					//jdbc driver�� �޸𸮷� �ε�
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//DB ������ ����
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					//�����ͺ��̽� ����� ������ �� �ִ� Statement ��ü�� ����
					stmt = conn.createStatement();
					//�����ͺ��̽� ��� ����
					int re = stmt.executeUpdate(sql);
					
					if(re == 1) {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
					}else {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
					}
					
				}catch (Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}finally {
					
					try {
						//����ߴ� �ڿ����� �ݱ�
						if(stmt != null) {
							stmt.close();
						}
						if(conn != null) {
							conn.close();
						}
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}
			}});
	}

	public static void main(String[] args) {
		new InsertGoods();
		

	}

}
