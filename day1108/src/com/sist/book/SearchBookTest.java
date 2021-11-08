package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class SearchBookTest extends JFrame {
	
	JTextField jtf_bookid;
	JTextField jtf_bookname;
	JTextField jtf_publisher;
	JTextField jtf_price;
	
	JTable table;
	Vector col;
	Vector<Vector> row;
	
	BookDAO dao;
	public void printBook(String publisher) {
		row.clear();
		ArrayList<BookVO> list = dao.searchBook(publisher);
		for(BookVO b : list) {
			Vector v = new Vector();
			v.add(b.getBookid());
			v.add(b.getBookname());
			v.add(b.getPublisher());
			v.add(b.getPrice());
			row.add(v);
		}
		table.updateUI();
	}
	public SearchBookTest() {
		dao = new BookDAO();
		col = new Vector();
		col.add("도서번호");
		col.add("도서이름");
		col.add("출판사명");
		col.add("도서가격");
		
		row = new Vector<Vector>();
		table = new JTable(row,col);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_bookid = new JTextField();
		jtf_bookname = new JTextField();
		jtf_publisher = new JTextField();
		jtf_price = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		
		p.add(new JLabel("출판사명:"));
		p.add(jtf_publisher);
		
		
		JButton btn_search = new JButton("검색");
		JButton btn_list = new JButton("목록");
		
		JPanel p2 = new JPanel();
		p2.add(btn_search);
		p2.add(btn_list);
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(p,BorderLayout.NORTH);
		main.add(p2,BorderLayout.CENTER);
		
		add(main,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(400,600);
		setVisible(true);
		setTitle("도서검색 - 출판사");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String publisher = jtf_publisher.getText();
				printBook(publisher);
				
			}});
	}
	
	public static void main(String[] args) {
		new SearchBookTest();
	}
}
