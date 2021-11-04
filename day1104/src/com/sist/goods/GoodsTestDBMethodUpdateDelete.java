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
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseListener;

public class GoodsTestDBMethodUpdateDelete extends JFrame {
	
	JTextField jtf_no;
	JTextField jtf_item;
	JTextField jtf_qty;
	JTextField jtf_price;
	
	JTable table;			//모든 상품목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames;		//테이블의 column이름을 위한 벡터 선언
	Vector<Vector> rowData;	//테이블의 데이터를 위한 벡터 선언
	
	//데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서 검색/조회하여 테이블에 출력하는 메소드 정의
	public void printGoods() {
		
		//새로운 상품을 등록하면 계속하여 호출될 수 있으니 rowData를 먼저 깨끗이 비우기
		rowData.clear();
		
		String sql = "select * from goods order by no";
		
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
				
				//바뀐내용으로 테이블 다시 그리기
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
	
	public void insertGoods() {
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
				
				//상품등록을 성공하면 테이블의 내용을 다시 읽어오기
				printGoods();
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
				
			}
		
		}
	}
	
	public void deleteGoods(int no) {
		
		String sql = "delete goods where no ="+no;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("상품삭제에 성공하였습니다.");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");
				
				printGoods();
			}else {
				System.out.println("상품삭제에 실패하였습니다.");
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
	
	public void updateGoods(int no, String item, int qty, int price) {
		String sql = "update goods set item='"+item+"',qty="+qty+",price="+price+"where no="+no;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("상품수정에 성공하였습니다.");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");
				
				printGoods();
			}else {
				System.out.println("상품수정에 실패하였습니다.");
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
	
	public GoodsTestDBMethodUpdateDelete() {
		
		colNames = new Vector();
		colNames.add("상품번호");
		colNames.add("상품이름");
		colNames.add("상품수량");
		colNames.add("상품단가");
		
		//테이블에 들어갈 실제데이터를 담기 위한 벡터 생성, 자료 추가
		rowData = new Vector<Vector>();

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
				insertGoods();
			}});
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int no = Integer.parseInt(jtf_no.getText());
				deleteGoods(no);
			}	
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText()); 
				updateGoods(no,item,qty,price);
			}
			
		});
			
		//테이블에 마우스 이벤트를 등록하여 선택한 행의 상품의 정보를 각각의 입력상자에 출력
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
				
				//rowData의 index번째의 벡터를 가져오기
				Vector vr = rowData.get(index);
				
				//벡터의 요소를 차례로 입력상자에 출력
				jtf_no.setText(vr.get(0)+"");
				jtf_item.setText(vr.get(1)+"");
				jtf_qty.setText(vr.get(2)+"");
				jtf_price.setText(vr.get(3)+"");
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
		new GoodsTestDBMethodUpdateDelete();
		
	}
}
