package com.sist.goods;

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
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTestDB extends JFrame {
	
	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table;			//��� ��ǰ����� ������ ���� ������� �����ֱ� ���� ���̺��� ����
	Vector colNames;		//���̺��� column�̸��� ���� ���� ����
	Vector<Vector> rowData;	//���̺��� �����͸� ���� ���� ����
	
	//�����ͺ��̽��� �����Ͽ� goods���̺��� ��� ��ǰ�� �о�ͼ� �˻�/��ȸ�Ͽ� ���̺� ����ϴ� �޼ҵ� ����
	public void printGoods() {
		
		//���ο� ��ǰ�� ����ϸ� ����Ͽ� ȣ��� �� ������ rowData�� ���� ������ ����
		rowData.clear();
		
		String sql = "select * from goods";
		
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
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				Vector v = new Vector();
				v.add(no);
				v.add(item);
				v.add(qty);
				v.add(price);
				
				rowData.add(v);
				
				//�ٲﳻ������ ���̺� �ٽ� �׸���
				table.updateUI();
			}
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
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
	
	public GoodsTestDB() {
		
		colNames = new Vector();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ�̸�");
		colNames.add("��ǰ����");
		colNames.add("��ǰ�ܰ�");
		
		//���̺� �� ���������͸� ��� ���� ���� ����, �ڷ� �߰�
		rowData = new Vector<Vector>();

		//���̺����
		table = new JTable(rowData, colNames);
		
		//���̺��� �ڷᰡ �ʹ� ���Ƽ� �� ȭ�鿡 ������ ������ �ڵ����� ��ũ���� ����� �ִ� ��ũ���� ����
		JScrollPane jsp = new JScrollPane(table);
		
		
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
		JButton btn_list = new JButton("���");
		
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printGoods();
			}
			
		});
		
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
						
						//��ǰ����� �����ϸ� ���̺��� ������ �ٽ� �о����
						printGoods();
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
		new GoodsTestDB();
		

	}

}
