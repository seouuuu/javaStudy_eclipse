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
	System.out.println("버튼이 눌려졌습니다.");
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
		colNames.add("주문번호");
		colNames.add("고객번호");
		colNames.add("도서번호");
		colNames.add("구매금액");
		colNames.add("구매일자");
		
		rowData = new Vector<Vector>();
		table = new JTable(rowData,colNames);
		
		JScrollPane jsp = new JScrollPane(table);
		
		JButton btn = new JButton("검색");
		JPanel p = new JPanel();
		p.add(new JLabel("검색할 고객번호를 입력하세요==>"));
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
