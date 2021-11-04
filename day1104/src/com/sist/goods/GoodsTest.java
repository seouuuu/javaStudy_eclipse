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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTest extends JFrame {
	
	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table;			//모든 상품목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames;		//테이블의 column이름을 위한 벡터 선언
	Vector<Vector> rowData;	//테이블의 데이터를 위한 벡터 선언
	
	
	public GoodsTest() {
		
		colNames = new Vector();
		colNames.add("상품번호");
		colNames.add("상품이름");
		colNames.add("상품수량");
		colNames.add("상품단가");
		
		//테이블에 들어갈 실제데이터를 담기 위한 벡터 생성, 자료 추가
		rowData = new Vector<Vector>();
		Vector v1 = new Vector();
		v1.add("1");
		v1.add("색종이");
		v1.add("10");
		v1.add("1500");
		Vector<String> v2 = new Vector();
		v2.add("2");
		v2.add("딱풀");
		v2.add("20");
		v2.add("700");
		
		rowData.add(v1);
		rowData.add(v2);

		//테이블생성
		table = new JTable(rowData, colNames);
		
		//테이블의 자료가 너무 많아서 한 화면에 보이지 않을때 자동으로 스크롤을 만들어 주는 스크롤팬 생성
		JScrollPane jsp = new JScrollPane(table);
		
		
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
		
		JButton btn_list = new JButton("목록");
		
		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
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
		new GoodsTest();
		

	}

}
