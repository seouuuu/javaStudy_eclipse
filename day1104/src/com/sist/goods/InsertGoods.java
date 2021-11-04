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
		
		p.add(new JLabel("상품번호:"));
		p.add(jtf_no);
		p.add(new JLabel("상품이름:"));
		p.add(jtf_item);
		p.add(new JLabel("상품수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가:"));
		p.add(jtf_price);
		
		JButton btn_add = new JButton("추가");
		
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
				
				//finally에서도 접근할수 있게 변수를 try문 밖에 선언
				Connection conn = null;
				Statement stmt = null;
				
				try {
					//jdbc driver를 메모리로 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//DB 서버에 연결
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					//데이터베이스 명령을 실행할 수 있는 Statement 객체를 생성
					stmt = conn.createStatement();
					//데이터베이스 명령 실행
					int re = stmt.executeUpdate(sql);
					
					if(re == 1) {
						System.out.println("상품등록에 성공하였습니다.");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
					}else {
						System.out.println("상품등록에 실패하였습니다.");
					}
					
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}finally {
					
					try {
						//사용했던 자원들을 닫기
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
