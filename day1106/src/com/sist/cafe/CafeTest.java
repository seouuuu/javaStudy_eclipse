package com.sist.cafe;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CafeTest extends JFrame{

	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_amount;
	JTextField jtf_price;
	JTable table;
	Vector col;
	Vector<Vector> row;
	CafeDao dao;
	
	public void printCafe() {
		row.clear();
		ArrayList<CafeVo> list = dao.listCafe();
		for(CafeVo c : list) {
			Vector v = new Vector();
			v.add(c.getNo());
			v.add(c.getName());
			v.add(c.getAmount());
			v.add(c.getPrice());
			row.add(v);
		}
		table.updateUI();
	}
	
	public CafeTest() {
		col = new Vector();
		row = new Vector<Vector>();
		col.add("품목번호");
		col.add("품목이름");
		col.add("품목수량");
		col.add("품목가격");
		
		table = new JTable(row,col);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_amount = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,4));
		p.add(new JLabel("품목번호:"));
		p.add(jtf_no);
		p.add(new JLabel("품목이름:"));
		p.add(jtf_name);
		p.add(new JLabel("품목수량:"));
		p.add(jtf_amount);
		p.add(new JLabel("품목가격:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		JPanel btn = new JPanel();
		btn.add(btn_add);
		btn.add(btn_list);
		btn.add(btn_update);
		btn.add(btn_delete);
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(p,BorderLayout.CENTER);
		main.add(btn,BorderLayout.SOUTH);
		
		add(main,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		setTitle("Cafe Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dao = new CafeDao();
		
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				int amount = Integer.parseInt(jtf_amount.getText());
				int price = Integer.parseInt(jtf_price.getText());
				CafeVo c = new CafeVo(no,name,amount,price);
				dao.insertCafe(c);
			}
			
		});
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printCafe();
			}
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				int amount = Integer.parseInt(jtf_amount.getText());
				int price = Integer.parseInt(jtf_price.getText());
				CafeVo c = new CafeVo(no,name,amount,price);
				dao.updateCafe(c);	
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				 dao.deleteCafe(no);
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
				int re =table.getSelectedRow();
				Vector vr = row.get(re);
				jtf_no.setText(vr.get(0)+"");
				jtf_name.setText(vr.get(1)+"");
				jtf_amount.setText(vr.get(2)+"");
				jtf_price.setText(vr.get(3)+"");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		new CafeTest();
	}

}
