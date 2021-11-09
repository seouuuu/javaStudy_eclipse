package com.sist.book;

import java.util.ArrayList;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.SQLOutput;

/*
class MyEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	System.out.println("��ư�� ���������ϴ�.");
}
*/

public class OrderTestGUI extends JFrame {

	JTextField jtf_custid;
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	public OrderTestGUI() {
		jtf_custid = new JTextField(10);
		colNames = new Vector();
		colNames.add("�ֹ���ȣ");
		colNames.add("����ȣ");
		colNames.add("������ȣ");
		colNames.add("���űݾ�");
		colNames.add("��������");
		
		rowData = new Vector<Vector>();
		table = new JTable(rowData,colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		JButton btn = new JButton("�˻�");
		JPanel p = new JPanel();
		p.add(new JLabel("�˻��� ����ȣ�� �Է��ϼ���==>"));
		p.add(jtf_custid);
		p.add(btn);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MyEvent me = new MyEvent();
		//btn.addActionListener(me);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rowData.clear();
				int custid = Integer.parseInt(jtf_custid.getText());
				OrdersDAO dao = new OrdersDAO();
				ArrayList<OrdersVO> list = dao.searchOrders(custid);
				for(OrdersVO o : list) {
					Vector v = new Vector();
					v.add(o.getOrderid());
					v.add(o.getCustid());
					v.add(o.getBookid());
					v.add(o.getSaleprice());
					v.add(o.getOrderdate());
					rowData.add(v);
				}
				table.updateUI();
			}});
	}
	
	public static void main(String[] args) {
		new OrderTestGUI();

	}

}
